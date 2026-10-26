package org.assimbly.sandbox.executors;

import groovy.lang.Binding;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyObjectSupport;
import groovy.lang.GroovyShell;
import groovy.lang.MetaBeanProperty;
import groovy.lang.MetaMethod;
import groovy.lang.MetaProperty;
import groovy.lang.Script;
import org.apache.camel.Exchange;
import org.apache.camel.RuntimeCamelException;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.reflection.CachedField;
import org.codehaus.groovy.runtime.DefaultGroovyMethods;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.kohsuke.groovy.sandbox.GroovyInterceptor;
import org.kohsuke.groovy.sandbox.SandboxTransformer;

import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GroovySandboxExecutor {

    private GroovySandboxExecutor() {
        // utility class
    }

    // cache: script source - compiled Class (parse once, run many times)
    private static final ConcurrentHashMap<String, Class<Script>> SCRIPT_CACHE = new ConcurrentHashMap<>();

    private static final ThreadLocal<ClassLoader> SCRIPT_CLASS_LOADER = new ThreadLocal<>();

    private static final CompilerConfiguration CONFIG;
    private static final ThreadLocal<GroovyShell> SHELL;

    static {
        CONFIG = new CompilerConfiguration();
        CONFIG.addCompilationCustomizers(new SandboxTransformer());
        SHELL = ThreadLocal.withInitial(() -> new GroovyShell(CONFIG));
    }

    // interceptor
    private static final GroovyInterceptor INTERCEPTOR = new GroovyInterceptor() {

        @Override
        public Object onMethodCall(Invoker invoker, Object receiver, String method, Object[] args) throws Throwable {
            if (receiver == null) {
                throw new SecurityException("Sandbox Denial: null receiver.");
            }
            ClassLoader scriptLoader = SCRIPT_CLASS_LOADER.get();
            // Allow methods defined inside the current Groovy script
            if (scriptLoader != null && receiver.getClass().getClassLoader() == scriptLoader) {
                return invoker.call(receiver, method, args);
            }
            Class<?> receiverClass = receiver.getClass();
            if (!ConfigurableWhitelist.isMethodAllowed(receiverClass, method)) {
                throw new SecurityException("Sandbox Denial: " + receiverClass.getName() + "#" + method + " not whitelisted.");
            }
            checkPropertySubscriptCall(receiver, method, args);
            return invoker.call(receiver, method, args);
        }

        @Override
        public Object onStaticCall(Invoker invoker, Class receiver, String method, Object[] args) throws Throwable {
            ClassLoader scriptLoader = SCRIPT_CLASS_LOADER.get();
            // Allow static methods defined inside this Groovy script
            if (scriptLoader != null && receiver.getClassLoader() == scriptLoader) {
                return invoker.call(receiver, method, args);
            }
            if (!ConfigurableWhitelist.isMethodAllowed(receiver, method)) {
                throw new SecurityException("Sandbox Denial: static " + receiver.getName() + "#" + method + " not whitelisted.");
            }
            checkPropertySubscriptCall(receiver, method, args);
            return invoker.call(receiver, method, args);
        }

        @Override
        public Object onNewInstance(Invoker invoker, Class receiver, Object[] args) throws Throwable {
            ClassLoader scriptLoader = SCRIPT_CLASS_LOADER.get();
            // Allow classes declared inside this Groovy script
            if (scriptLoader != null && receiver.getClassLoader() == scriptLoader) {
                return invoker.call(receiver, null, args);
            }
            if (!ConfigurableWhitelist.isClassAllowed(receiver)) {
                throw new SecurityException("Sandbox Denial: cannot construct " + receiver.getName());
            }
            return invoker.call(receiver, null, args);
        }

        // obj.prop and Clazz.prop end up calling getters/setters, so they need the same checks as method calls
        @Override
        public Object onGetProperty(Invoker invoker, Object receiver, String property) throws Throwable {
            checkPropertyAccess(receiver, property, false);
            return invoker.call(receiver, property);
        }

        @Override
        public Object onSetProperty(Invoker invoker, Object receiver, String property, Object value) throws Throwable {
            checkPropertyAccess(receiver, property, true);
            return invoker.call(receiver, property, value);
        }

        // obj.@field reads/writes fields directly, private ones included
        @Override
        public Object onGetAttribute(Invoker invoker, Object receiver, String attribute) throws Throwable {
            checkAttributeAccess(receiver, attribute, false);
            return invoker.call(receiver, attribute);
        }

        @Override
        public Object onSetAttribute(Invoker invoker, Object receiver, String attribute, Object value) throws Throwable {
            checkAttributeAccess(receiver, attribute, true);
            return invoker.call(receiver, attribute, value);
        }

        @Override
        public Object onGetArray(Invoker invoker, Object receiver, Object index) throws Throwable {
            checkSubscript(receiver, index, false);
            return invoker.call(receiver, null, index);
        }

        @Override
        public Object onSetArray(Invoker invoker, Object receiver, Object index, Object value) throws Throwable {
            checkSubscript(receiver, index, true);
            return invoker.call(receiver, null, index, value);
        }
    };

    private static boolean isScriptClass(Class<?> clazz) {
        ClassLoader scriptLoader = SCRIPT_CLASS_LOADER.get();
        return scriptLoader != null && clazz.getClassLoader() == scriptLoader;
    }

    private static void checkMethod(Class<?> clazz, String method) {
        if (!ConfigurableWhitelist.isMethodAllowed(clazz, method)) {
            throw new SecurityException("Sandbox Denial: " + clazz.getName() + "#" + method + " not whitelisted.");
        }
    }

    /**
     * obj[i] / obj[i] = v. On anything but a Map, a String index is a property access
     * (TimeZone['default'] = tz is TimeZone.setDefault(tz)).
     */
    private static void checkSubscript(Object receiver, Object index, boolean write) {
        if (receiver == null) {
            throw new SecurityException("Sandbox Denial: null receiver.");
        }
        if (index instanceof String property && !(receiver instanceof Map)) {
            checkPropertyAccess(receiver, property, write);
        } else if (!receiver.getClass().isArray() && !isScriptClass(receiver.getClass())) {
            checkMethod(receiver.getClass(), write ? "putAt" : "getAt");
        }
    }

    /**
     * Explicit obj.getAt('prop') / obj.putAt('prop', v) calls, which are property accesses as well.
     */
    private static void checkPropertySubscriptCall(Object receiver, String method, Object[] args) {
        if (("getAt".equals(method) || "putAt".equals(method))
                && args.length > 0 && args[0] instanceof String property && !(receiver instanceof Map)) {
            checkPropertyAccess(receiver, property, "putAt".equals(method));
        }
    }

    private static void checkAttributeAccess(Object receiver, String attribute, boolean write) {
        if (receiver == null) {
            throw new SecurityException("Sandbox Denial: null receiver.");
        }
        Class<?> clazz = receiver instanceof Class<?> c ? c : receiver.getClass();
        if (isScriptClass(clazz)) {
            return;
        }
        if (!write && hasCustomPropertyHandling(clazz, false) && ConfigurableWhitelist.isClassAllowed(clazz)) {
            // XmlSlurper's node.@attr
            return;
        }
        throw new SecurityException("Sandbox Denial: direct field access .@" + attribute + " not allowed.");
    }

    /**
     * Resolves which getter, setter or field Groovy will use for the property and checks that against the whitelist.
     */
    private static void checkPropertyAccess(Object receiver, String property, boolean write) {
        if (receiver == null) {
            throw new SecurityException("Sandbox Denial: null receiver.");
        }
        boolean isStatic = receiver instanceof Class;
        Class<?> clazz = isStatic ? (Class<?>) receiver : receiver.getClass();
        if (isScriptClass(clazz)) {
            return;
        }
        if (receiver instanceof Map) {
            // map.key is map.get(key) / map.put(key, value)
            checkMethod(clazz, write ? "put" : "get");
            return;
        }
        if (!write && clazz.isArray() && "length".equals(property)) {
            return;
        }

        MetaProperty metaProperty = InvokerHelper.getMetaClass(clazz).getMetaProperty(property);
        if (metaProperty != null && (!isStatic || Modifier.isStatic(metaProperty.getModifiers()))) {
            checkMetaProperty(clazz, metaProperty, property, write);
        } else if (isStatic) {
            // not a static property of the class, so a property of java.lang.Class itself (name, methods, classLoader, ...)
            checkMethod(Class.class, write ? MetaProperty.getSetterName(property) : MetaProperty.getGetterName(property, Object.class));
        } else if (hasCustomPropertyHandling(clazz, write)) {
            // GroovyObjects such as GPathResult resolve properties themselves
            if (!ConfigurableWhitelist.isClassAllowed(clazz)) {
                throw new SecurityException("Sandbox Denial: property " + clazz.getName() + "." + property + " not whitelisted.");
            }
        } else if (!write && (receiver instanceof Iterable<?> || clazz.isArray())) {
            // list.prop reads prop of every element
            Iterable<?> elements = receiver instanceof Iterable<?> it ? it : DefaultGroovyMethods.toList((Object[]) receiver);
            for (Object element : elements) {
                if (element != null) {
                    checkPropertyAccess(element, property, false);
                }
            }
        } else {
            // falls back to a generic get(String) / set(String, Object) method, e.g. on JsonNode
            checkMethod(clazz, write ? "set" : "get");
        }
    }

    private static void checkMetaProperty(Class<?> clazz, MetaProperty metaProperty, String property, boolean write) {
        if (metaProperty instanceof MetaBeanProperty beanProperty) {
            MetaMethod accessor = write ? beanProperty.getSetter() : beanProperty.getGetter();
            if (accessor != null) {
                checkMethod(clazz, accessor.getName());
                return;
            }
            metaProperty = beanProperty.getField();
        }
        if (metaProperty instanceof CachedField && !write) {
            // reading a public field, e.g. Locale.JAPAN
            if (!ConfigurableWhitelist.isClassAllowed(clazz)) {
                throw new SecurityException("Sandbox Denial: field " + clazz.getName() + "." + property + " not whitelisted.");
            }
            return;
        }
        checkMethod(clazz, write ? MetaProperty.getSetterName(property) : MetaProperty.getGetterName(property, metaProperty == null ? Object.class : metaProperty.getType()));
    }

    private static boolean hasCustomPropertyHandling(Class<?> clazz, boolean write) {
        if (!GroovyObject.class.isAssignableFrom(clazz)) {
            return false;
        }
        try {
            Class<?> declaringClass = write
                    ? clazz.getMethod("setProperty", String.class, Object.class).getDeclaringClass()
                    : clazz.getMethod("getProperty", String.class).getDeclaringClass();
            return declaringClass != GroovyObject.class && declaringClass != GroovyObjectSupport.class;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    public static void execute(String scriptSource, Exchange exchange) {

        // compile once, reuse on subsequent calls with the same source
        Class<Script> scriptClass = getOrCompile(scriptSource);

        // instantiate a fresh Script object — cheap, no classloading
        Script script;

        try {
            script = scriptClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeCamelException("Failed to instantiate Groovy script", e);
        }

        // bind exchange variables to this specific execution
        Binding binding = new Binding();
        binding.setVariable("exchange", exchange);
        binding.setVariable("body",     exchange.getIn().getBody());
        binding.setVariable("headers",  exchange.getIn().getHeaders());
        binding.setVariable("request",  exchange.getIn());
        binding.setVariable("message",  exchange.getIn());
        script.setBinding(binding);

        SCRIPT_CLASS_LOADER.set(scriptClass.getClassLoader());

        try {
            // run with sandbox interceptor active for this thread
            INTERCEPTOR.register();

            Object result = script.run();
            if (result != null) {
                exchange.getIn().setBody(result);
            }
        } catch (SecurityException e) {
            throw new RuntimeCamelException(
                    "Groovy Sandbox violation: " + e.getMessage(), e);

        } catch (Throwable e) {
            throw new RuntimeCamelException(
                    "Groovy execution failed: " + e.getMessage(), e);
        } finally {
            SCRIPT_CLASS_LOADER.remove();
            INTERCEPTOR.unregister();        // always clean up thread-local registration
        }
    }

    @SuppressWarnings("unchecked")
    private static Class<Script> getOrCompile(String source) {

        String scriptKey = hashScript(source);

        return SCRIPT_CACHE.computeIfAbsent(scriptKey, key -> {
            try {
                return (Class<Script>) SHELL.get()
                        .getClassLoader()
                        .parseClass(source);

            } catch (Exception e) {
                throw new RuntimeCamelException(
                        "Failed to compile Groovy script", e);
            }
        });
    }

    private static String hashScript(String source) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(source.getBytes(StandardCharsets.UTF_8));
            // Encode to Base64 to get a clean, short String key
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            // SHA-256 is a standard algorithm, this should never happen
            throw new RuntimeCamelException("SHA-256 algorithm not found", e);
        }
    }
}