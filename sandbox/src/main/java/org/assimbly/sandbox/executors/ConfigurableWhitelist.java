package org.assimbly.sandbox.executors;

import groovy.lang.MetaMethod;
import org.codehaus.groovy.runtime.InvokerHelper;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class ConfigurableWhitelist {

    private static final Logger LOG = Logger.getLogger(ConfigurableWhitelist.class.getName());
    private static final String BASE_PATH = System.getProperty("user.home");
    private static final String ASSIMBLY_PATH = "/.assimbly";
    private static final String GROOVY_PATH = "/groovy/";

    private static final Map<String, PackageRule> PACKAGE_RULES = new ConcurrentHashMap<>();
    private static final Map<String, MethodRule> METHOD_RULES = new ConcurrentHashMap<>();
    private static final Map<String, MethodRule> LOOKUP_CACHE = new ConcurrentHashMap<>();

    private static final MethodRule DENIED_RULE = MethodRule.allowOnly(Set.of());

    // path can itself be overridden by env var at startup, that part's fine to be static
    private static final Path CONFIG_PATH = Paths.get(BASE_PATH + ASSIMBLY_PATH + GROOVY_PATH + "whitelist.conf");

    private static final Set<String> REFLECTION_METHODS = Set.of(
            "setAccessible",
            "getDeclaredMethods",
            "getDeclaredFields",
            "getClassLoader",
            "getClass",
            "getProtectionDomain"
    );
    private static final Set<String> JVM_METHODS = Set.of(
            "exit",
            "halt",
            "addShutdownHook"
    );
    private static final Set<String> GROOVY_META_METHODS = Set.of(
            "invokeMethod",
            "invokeStaticMethod",
            "getMetaClass",
            "setMetaClass",
            "getProperty",
            "setProperty"
    );
    private static final Set<String> EXECUTION_METHODS = Set.of(
            "execute",
            "executeAsync"
    );
    private static final Set<String> CLASS_LOADING_METHODS = Set.of(
            "forName",
            "newInstance"
    );
    // these hand closures to the ForkJoin common pool, whose threads were not started by the script
    // and therefore don't inherit the sandbox interceptor: the closure would run unchecked
    private static final Set<String> PARALLEL_METHODS = Set.of(
            "parallel",
            "parallelStream",
            "parallelSetAll",
            "parallelPrefix",
            "parallelSort"
    );
    // classes that compile and run Groovy code without the sandbox transformer
    private static final Set<Class<?>> UNSANDBOXED_COMPILERS = Set.of(
            groovy.lang.GroovyShell.class,
            groovy.lang.GroovyClassLoader.class,
            groovy.util.Eval.class,
            groovy.util.ConfigSlurper.class,
            groovy.util.GroovyScriptEngine.class
    );
    private static final Set<Class<?>> DENIED_CLASSES = Set.of(
            Runtime.class,
            ProcessBuilder.class
    );

    // public method names of a type, including GDK methods (each, collect, ...)
    private static final ClassValue<Set<String>> METHOD_NAMES = new ClassValue<>() {
        @Override
        protected Set<String> computeValue(Class<?> type) {
            Set<String> names = new HashSet<>();
            for (Method m : type.getMethods()) {
                names.add(m.getName());
            }
            for (MetaMethod m : InvokerHelper.getMetaClass(type).getMetaMethods()) {
                names.add(m.getName());
            }
            return names;
        }
    };

    static {
        loadFromFile();
        startWatcher();
    }

    /**
     * Represents the method-access rule for a single class.
     * Either:
     *   - allowAll == true: every method is allowed EXCEPT those in `exceptions`
     *   - allowAll == false: ONLY methods in `allowed` are permitted
     */
    private static final class MethodRule {
        final boolean allowAll;
        final Set<String> exceptions; // used when allowAll == true
        final Set<String> allowed;    // used when allowAll == false

        private MethodRule(boolean allowAll, Set<String> exceptions, Set<String> allowed) {
            this.allowAll = allowAll;
            this.exceptions = exceptions;
            this.allowed = allowed;
        }

        static MethodRule allowAllExcept(Set<String> exceptions) {
            return new MethodRule(true, Set.copyOf(exceptions), Set.of());
        }

        static MethodRule allowOnly(Set<String> allowed) {
            return new MethodRule(false, Set.of(), Set.copyOf(allowed));
        }

        boolean permits(String method) {
            return allowAll ? !exceptions.contains(method) : allowed.contains(method);
        }
    }

    private static synchronized void loadFromFile() {
        if (!Files.exists(CONFIG_PATH)) {
            LOG.warning("Whitelist file not found at " + CONFIG_PATH);
            return;
        }
        try {
            Map<String, MethodRule> newRules = new ConcurrentHashMap<>();
            Map<String, PackageRule> newPackageRules = new ConcurrentHashMap<>();

            for (String raw : Files.readAllLines(CONFIG_PATH)) {
                String line = raw.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;

                // strip trailing whitespace-separated comments
                line = line.split("\\s")[0];
                if (line.isEmpty()) continue;

                int hashIdx = line.indexOf('#');
                if (hashIdx > 0) {
                    String className = line.substring(0, hashIdx);
                    String rulePart = line.substring(hashIdx + 1);
                    parseMethodRule(className, rulePart, newRules, newPackageRules, raw);
                } else {
                    LOG.warning("Ignoring whitelist line with no '#Class#method' rule: " + raw);
                }
            }

            METHOD_RULES.clear();
            METHOD_RULES.putAll(newRules);
            PACKAGE_RULES.clear();
            PACKAGE_RULES.putAll(newPackageRules);
            LOOKUP_CACHE.clear();

            LOG.info("Whitelist reloaded: "
                    + METHOD_RULES.size() + " class rules, "
                    + PACKAGE_RULES.size() + " package rules.");
        } catch (IOException e) {
            LOG.severe("Failed to reload whitelist file, keeping previous config: " + e.getMessage());
        }
    }

    /**
     * Parses the portion of a line after "ClassName#" and merges it into newRules.
     * Supported forms:
     *   ClassName#*                  -> allow all methods
     *   ClassName#*,-foo,-bar        -> allow all methods except foo, bar
     *   ClassName#foo,bar            -> allow only foo, bar
     */
    private static void parseMethodRule(
            String className,
            String rulePart,
            Map<String, MethodRule> newRules,
            Map<String, PackageRule> newPackageRules,
            String originalLine
    ) {

        if (className.endsWith("*")) {
            parsePackageRule(className, rulePart, newPackageRules, originalLine);
            return;
        }

        String[] tokens = rulePart.split(",");
        if (tokens.length == 0) {
            LOG.warning("Ignoring malformed whitelist line (no methods specified): " + originalLine);
            return;
        }

        boolean wildcard = tokens[0].trim().equals("*");
        MethodRule existing = newRules.get(className);

        if (wildcard) {
            if (existing != null && !existing.allowAll) {
                LOG.warning("Class '" + className + "' has conflicting rules (both an explicit allow-list and a "
                        + "wildcard '*' rule). The wildcard rule takes precedence: " + originalLine);
            }
            Set<String> exceptions = new HashSet<>();
            for (int i = 1; i < tokens.length; i++) {
                String t = tokens[i].trim();
                if (t.startsWith("-")) {
                    exceptions.add(t.substring(1));
                } else if (!t.isEmpty()) {
                    LOG.warning("Ignoring malformed exception token '" + t + "' in line: " + originalLine);
                }
            }
            // if an earlier wildcard rule already exists for this class, merge exceptions (union)
            if (existing != null && existing.allowAll) {
                exceptions.addAll(existing.exceptions);
            }
            MethodRule rule = MethodRule.allowAllExcept(exceptions);
            newRules.put(className, rule);
            LOG.info("Registered class whitelist: " + className + " -> * except " + exceptions);
        } else {
            if (existing != null && existing.allowAll) {
                LOG.warning("Class '" + className + "' has conflicting rules (both a wildcard '*' rule and an "
                        + "explicit allow-list). The wildcard rule takes precedence, ignoring: " + originalLine);
                return;
            }
            Set<String> allowed = new HashSet<>();
            for (String t : tokens) {
                t = t.trim();
                if (!t.isEmpty()) allowed.add(t);
            }
            if (existing != null) {
                allowed.addAll(existing.allowed);
            }
            MethodRule rule = MethodRule.allowOnly(allowed);
            newRules.put(className, rule);
            LOG.info("Registered class whitelist: " + className + " -> " + allowed);
        }
    }

    private static void parsePackageRule(
            String packagePattern,
            String rulePart,
            Map<String, PackageRule> packageRules,
            String originalLine
    ) {

        // "a.b.*" covers classes in a.b only, "a.b.**" also covers its sub-packages
        boolean includeSubPackages = packagePattern.endsWith(".**");
        String packageName = packagePattern.substring(0, packagePattern.length() - (includeSubPackages ? 2 : 1));
        if (!packageName.endsWith(".")) {
            packageName += ".";
        }
        String key = packageName + (includeSubPackages ? "**" : "*");

        String[] tokens = rulePart.split(",");
        boolean wildcard = tokens[0].trim().equals("*");
        MethodRule rule;

        if (wildcard) {
            Set<String> exceptions = new HashSet<>();
            for (int i = 1; i < tokens.length; i++) {
                String t = tokens[i].trim();
                if (t.startsWith("-")) {
                    exceptions.add(t.substring(1));
                }
            }
            rule = MethodRule.allowAllExcept(exceptions);
        } else {
            Set<String> allowed = new HashSet<>();
            for (String token : tokens) {
                token = token.trim();
                if (!token.isEmpty()) {
                    allowed.add(token);
                }
            }
            rule = MethodRule.allowOnly(allowed);
        }

        PackageRule existing = packageRules.get(key);
        if (existing != null) {
            LOG.warning("Duplicate package rule for '" + key
                    + "', replacing previous rule: " + originalLine);
        }

        packageRules.put(key, new PackageRule(packageName, includeSubPackages, rule));

        LOG.info("Registered package whitelist: " + key);
    }

    private static void startWatcher() {
        Path dir = CONFIG_PATH.getParent();
        if (dir == null || !Files.exists(dir)) {
            LOG.warning("Whitelist directory does not exist, skipping hot-reload watcher.");
            return;
        }
        Executors.newSingleThreadExecutor(r -> {
            Thread t = new Thread(r, "sandbox-whitelist-watcher");
            t.setDaemon(true);
            return t;
        }).submit(() -> {
            try (WatchService watcher = FileSystems.getDefault().newWatchService()) {
                dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE);
                while (true) {
                    WatchKey key = watcher.take(); // blocks
                    for (WatchEvent<?> event : key.pollEvents()) {
                        Path changed = dir.resolve((Path) event.context());
                        if (changed.equals(CONFIG_PATH)) {
                            LOG.info("Detected whitelist file change, reloading...");
                            loadFromFile();
                        }
                    }
                    if (!key.reset()) break;
                }
            } catch (IOException | InterruptedException e) {
                LOG.severe("Whitelist watcher stopped: " + e.getMessage());
            }
        });
    }

    /**
     * A class is constructible via `new` iff it matches either:
     * - an explicit class rule
     * - a package wildcard rule
     */
    public static boolean isClassAllowed(Class<?> clazz) {
        if (isUnsandboxedCompiler(clazz)) {
            return false;
        }
        MethodRule rule = findRule(clazz);
        return rule != null && rule != DENIED_RULE;
    }

    public static boolean isMethodAllowed(Class<?> clazz, String method) {
        if (isHardDenied(clazz, method)) {
            return false;
        }

        // the class's own rule decides when it denies, ancestors can't overrule it
        MethodRule own = findRule(clazz);
        if (own != DENIED_RULE && !own.permits(method)) {
            return false;
        }
        Set<Class<?>> ancestors = ancestors(clazz);
        // an explicit class rule denying a method also applies to subclasses and implementations,
        // e.g. java.lang.Throwable#*,-initCause denies initCause on every exception
        for (Class<?> ancestor : ancestors) {
            MethodRule rule = METHOD_RULES.get(ruleName(ancestor));
            if (rule != null && !rule.permits(method) && METHOD_NAMES.get(ancestor).contains(method)) {
                return false;
            }
        }
        if (own.permits(method)) {
            return true;
        }
        // a rule on a superclass or interface only covers the methods that type has itself,
        // otherwise e.g. java.lang.Comparable#* would allow every method of every Comparable class
        for (Class<?> ancestor : ancestors) {
            MethodRule rule = findRule(ancestor);
            if (rule != DENIED_RULE && rule.permits(method) && METHOD_NAMES.get(ancestor).contains(method)) {
                return true;
            }
        }
        return false;
    }

    /**
     * All superclasses and interfaces of clazz, nearest first.
     */
    private static Set<Class<?>> ancestors(Class<?> clazz) {
        Set<Class<?>> result = new LinkedHashSet<>();
        Deque<Class<?>> queue = new ArrayDeque<>();
        queue.add(clazz);
        while (!queue.isEmpty()) {
            Class<?> current = queue.poll();
            if (current.getSuperclass() != null && result.add(current.getSuperclass())) {
                queue.add(current.getSuperclass());
            }
            for (Class<?> iface : current.getInterfaces()) {
                if (result.add(iface)) {
                    queue.add(iface);
                }
            }
        }
        return result;
    }

    private static MethodRule findRule(Class<?> clazz) {
        String name = ruleName(clazz);
        MethodRule cached = LOOKUP_CACHE.get(name);
        if (cached != null) {
            return cached;
        }
        // not computeIfAbsent: array lookups recurse into findRule for the component type,
        // and a recursive update inside computeIfAbsent is not allowed on ConcurrentHashMap
        MethodRule rule = resolveRule(clazz, name);
        MethodRule previous = LOOKUP_CACHE.putIfAbsent(name, rule);
        return previous != null ? previous : rule;
    }

    private static MethodRule resolveRule(Class<?> clazz, String name) {
        MethodRule rule = METHOD_RULES.get(name);
        if (rule != null) {
            return rule;
        }
        if (clazz.isArray()) {
            // e.g. "a,b".split(',') returns String[]; GDK methods such as toList(), each(), join()
            // are called with the array as receiver. Without an explicit rule like
            // "java.lang.String[]#..." an array inherits the rule of its component type.
            // Primitive arrays (byte[], int[], ...) have no class rule to inherit and need an explicit one.
            Class<?> component = clazz.getComponentType();
            return component.isPrimitive() ? DENIED_RULE : findRule(component);
        }
        return PACKAGE_RULES.values()
                .stream()
                .filter(e -> e.matches(name))
                // most specific package wins; on equal depth "a.b.*" wins over "a.b.**"
                .max(Comparator.<PackageRule>comparingInt(e -> e.depth).thenComparing(e -> !e.includeSubPackages))
                .map(e -> e.rule)
                .orElse(DENIED_RULE);
    }

    /**
     * Name used to match whitelist rules: the binary name for classes (java.lang.String)
     * and the source-style name for arrays (java.lang.String[], byte[]) instead of [Ljava.lang.String; / [B.
     */
    private static String ruleName(Class<?> clazz) {
        if (clazz.isArray()) {
            String canonical = clazz.getCanonicalName();
            if (canonical != null) {
                return canonical;
            }
        }
        return clazz.getName();
    }

    private static final class PackageRule {
        final String packageName;
        final boolean includeSubPackages;
        final MethodRule rule;
        final int depth;

        PackageRule(String packageName, boolean includeSubPackages, MethodRule rule) {
            this.packageName = packageName;
            this.includeSubPackages = includeSubPackages;
            this.rule = rule;
            this.depth = packageName.split("\\.").length;
        }

        boolean matches(String className) {
            return className.startsWith(packageName)
                    && (includeSubPackages || className.indexOf('.', packageName.length()) < 0);
        }
    }

    private static boolean isUnsandboxedCompiler(Class<?> clazz) {
        for (Class<?> denied : UNSANDBOXED_COMPILERS) {
            if (denied.isAssignableFrom(clazz)) {
                return true;
            }
        }
        return false;
    }

    static boolean isHardDenied(Class<?> clazz, String method) {
        return REFLECTION_METHODS.contains(method)
                || JVM_METHODS.contains(method)
                || GROOVY_META_METHODS.contains(method)
                || EXECUTION_METHODS.contains(method)
                || PARALLEL_METHODS.contains(method)
                || (clazz == Class.class && CLASS_LOADING_METHODS.contains(method))
                || DENIED_CLASSES.contains(clazz)
                || isUnsandboxedCompiler(clazz);
    }

}