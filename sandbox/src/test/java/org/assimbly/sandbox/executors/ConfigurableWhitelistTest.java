package org.assimbly.sandbox.executors;

import org.apache.camel.support.DefaultExchange;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Runs against src/test/resources/home/.assimbly/groovy/whitelist.conf (user.home is set by surefire).
 */
public class ConfigurableWhitelistTest {

    @Test
    public void packageRuleDoesNotIncludeSubPackages() throws Exception {
        assertTrue(ConfigurableWhitelist.isClassAllowed(ArrayList.class));
        assertFalse(ConfigurableWhitelist.isClassAllowed(java.util.concurrent.Executors.class));
        assertFalse(ConfigurableWhitelist.isClassAllowed(java.util.logging.LogManager.class));
        assertFalse(ConfigurableWhitelist.isMethodAllowed(java.util.concurrent.Executors.class, "newSingleThreadExecutor"));
    }

    @Test
    public void doubleStarPackageRuleIncludesSubPackages() throws Exception {
        assertTrue(ConfigurableWhitelist.isClassAllowed(groovy.xml.XmlSlurper.class));
        assertTrue(ConfigurableWhitelist.isClassAllowed(Class.forName("groovy.xml.slurpersupport.NodeChild")));
    }

    @Test
    public void classRuleOverridesPackageRule() {
        assertFalse(ConfigurableWhitelist.isMethodAllowed(TimeZone.class, "setDefault"));
        assertFalse(ConfigurableWhitelist.isMethodAllowed(SimpleTimeZone.class, "setDefault"));
        assertFalse(ConfigurableWhitelist.isMethodAllowed(Locale.class, "setDefault"));

        assertTrue(ConfigurableWhitelist.isMethodAllowed(TimeZone.class, "getDefault"));
        assertTrue(ConfigurableWhitelist.isMethodAllowed(TimeZone.class, "getTimeZone"));
        assertTrue(ConfigurableWhitelist.isMethodAllowed(Locale.class, "getDefault"));
    }

    @Test
    public void deniedMethodStaysDeniedOnSubclass() {
        // TimeZone.getTimeZone returns a sun.util.calendar.ZoneInfo, which has no rule of its own
        Class<?> zoneInfo = TimeZone.getTimeZone("CET").getClass();

        assertFalse(ConfigurableWhitelist.isMethodAllowed(zoneInfo, "setDefault"));
        assertTrue(ConfigurableWhitelist.isMethodAllowed(zoneInfo, "getID"));
    }

    @Test
    public void interfaceRuleAppliesToImplementation() {
        assertTrue(ConfigurableWhitelist.isMethodAllowed(DefaultExchange.class, "getMessage"));
        assertTrue(ConfigurableWhitelist.isMethodAllowed(DefaultExchange.class, "getIn"));
    }

    @Test
    public void ancestorRuleOnlyCoversItsOwnMethods() {
        // java.lang.Comparable#* must not allow every method of every Comparable class
        assertTrue(ConfigurableWhitelist.isMethodAllowed(File.class, "compareTo"));
        assertFalse(ConfigurableWhitelist.isMethodAllowed(File.class, "delete"));
    }

    @Test
    public void ancestorRuleIncludesGdkMethods() {
        // GDK methods such as each are available on a subclass through its whitelisted superclass
        assertTrue(ConfigurableWhitelist.isMethodAllowed(org.apache.groovy.json.internal.LazyMap.class, "each"));
    }

    @Test
    public void explicitDenialOnAncestorAppliesToSubclasses() {
        // java.lang.Throwable#*,-initCause, while Exception#* and RuntimeException#* allow everything
        assertFalse(ConfigurableWhitelist.isMethodAllowed(RuntimeException.class, "initCause"));
        assertFalse(ConfigurableWhitelist.isMethodAllowed(NumberFormatException.class, "initCause"));
        assertTrue(ConfigurableWhitelist.isMethodAllowed(NumberFormatException.class, "getMessage"));
    }

    @Test
    public void allowOnlyRule() {
        assertTrue(ConfigurableWhitelist.isMethodAllowed(MessageDigest.class, "getInstance"));
        assertFalse(ConfigurableWhitelist.isMethodAllowed(MessageDigest.class, "getProvider"));
    }

    @Test
    public void hardDeniedMethods() {
        assertFalse(ConfigurableWhitelist.isMethodAllowed(String.class, "getClass"));
        assertFalse(ConfigurableWhitelist.isMethodAllowed(String.class, "invokeMethod"));
        assertFalse(ConfigurableWhitelist.isMethodAllowed(Arrays.class, "parallelSetAll"));
        assertFalse(ConfigurableWhitelist.isMethodAllowed(Arrays.class, "parallelSort"));
        assertFalse(ConfigurableWhitelist.isMethodAllowed(ArrayList.class, "parallelStream"));
        assertFalse(ConfigurableWhitelist.isMethodAllowed(Runtime.class, "getRuntime"));
    }

    @Test
    public void unsandboxedCompilersAreDenied() {
        // groovy.util.*#* is whitelisted, but these compile and run code without the sandbox
        assertFalse(ConfigurableWhitelist.isMethodAllowed(groovy.util.Eval.class, "me"));
        assertFalse(ConfigurableWhitelist.isClassAllowed(groovy.util.ConfigSlurper.class));
        assertFalse(ConfigurableWhitelist.isClassAllowed(groovy.util.GroovyScriptEngine.class));
        assertTrue(ConfigurableWhitelist.isClassAllowed(groovy.util.Node.class));
    }

    // loads a class only where it is on the classpath (commons-lang3 is present on develop, not on next)
    private static Class<?> classOrSkip(String name) {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            org.junit.jupiter.api.Assumptions.abort("not on classpath: " + name);
            return null; // unreachable
        }
    }

    @Test
    public void reflectionHelpersAreDenied() {
        // the whitelist may allow a whole library (e.g. org.apache.commons.lang3.**), but its reflection
        // helpers call any method, constructor or field by name and must stay denied regardless
        assertFalse(ConfigurableWhitelist.isMethodAllowed(classOrSkip("org.apache.commons.lang3.reflect.MethodUtils"), "invokeExactStaticMethod"));
        assertFalse(ConfigurableWhitelist.isClassAllowed(classOrSkip("org.apache.commons.lang3.reflect.ConstructorUtils")));
        assertFalse(ConfigurableWhitelist.isMethodAllowed(classOrSkip("org.apache.commons.lang3.reflect.FieldUtils"), "writeStaticField"));
        assertFalse(ConfigurableWhitelist.isClassAllowed(classOrSkip("org.apache.commons.lang3.builder.ReflectionToStringBuilder")));
        // non-reflection lang3 classes stay allowed
        assertTrue(ConfigurableWhitelist.isMethodAllowed(classOrSkip("org.apache.commons.lang3.StringUtils"), "isBlank"));
    }

    @Test
    public void unsafeDeserializationIsDenied() {
        Class<?> serializationUtils = classOrSkip("org.apache.commons.lang3.SerializationUtils");
        assertFalse(ConfigurableWhitelist.isMethodAllowed(serializationUtils, "deserialize"));
        assertTrue(ConfigurableWhitelist.isMethodAllowed(serializationUtils, "serialize"));
        assertTrue(ConfigurableWhitelist.isMethodAllowed(serializationUtils, "clone"));
    }

    @Test
    public void unlistedClassIsDenied() {
        assertFalse(ConfigurableWhitelist.isClassAllowed(File.class));
        assertFalse(ConfigurableWhitelist.isMethodAllowed(System.class, "getProperties"));
        assertFalse(ConfigurableWhitelist.isMethodAllowed(Class.class, "getMethods"));
    }

}
