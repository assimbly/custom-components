package org.assimbly.sandbox.executors;

import org.apache.camel.Exchange;
import org.apache.camel.RuntimeCamelException;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Locale;
import java.util.TimeZone;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Runs against src/test/resources/home/.assimbly/groovy/whitelist.conf (user.home is set by surefire).
 */
public class GroovySandboxExecutorTest extends CamelTestSupport {

    private TimeZone originalTimeZone;
    private Locale originalLocale;

    @BeforeEach
    public void setDefaults() {
        originalTimeZone = TimeZone.getDefault();
        originalLocale = Locale.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Locale.setDefault(Locale.US);
    }

    @AfterEach
    public void restoreDefaults() {
        TimeZone.setDefault(originalTimeZone);
        Locale.setDefault(originalLocale);
    }

    static Stream<Arguments> deniedScripts() {
        return Stream.of(
                // changing JVM-wide defaults, in every syntax Groovy offers
                Arguments.of("static call", "TimeZone.setDefault(TimeZone.getTimeZone('CET'))"),
                Arguments.of("static property", "TimeZone.default = TimeZone.getTimeZone('CET')"),
                Arguments.of("locale property", "Locale.default = Locale.JAPAN"),
                Arguments.of("instance property", "def tz = TimeZone.getTimeZone('CET'); tz.default = tz"),
                Arguments.of("spread property", "def tz = TimeZone.getTimeZone('CET'); [tz]*.default = tz"),
                Arguments.of("subscript", "TimeZone['default'] = TimeZone.getTimeZone('CET')"),
                Arguments.of("explicit putAt", "def tz = TimeZone.getTimeZone('CET'); tz.putAt('default', tz)"),
                Arguments.of("static putAt", "TimeZone.putAt('default', TimeZone.getTimeZone('CET'))"),
                // a GString index is coerced to String by Groovy, so it's a property access too
                Arguments.of("GString subscript", "def tz = TimeZone.getTimeZone('CET'); tz[\"${'default'}\"] = tz"),
                Arguments.of("GString static putAt", "TimeZone.putAt(\"${'default'}\", TimeZone.getTimeZone('CET'))"),
                Arguments.of("GString class", "'x'[\"${'class'}\"]"),
                Arguments.of("GString metaClass", "'x'[\"${'metaClass'}\"]"),
                // an explicit denial on a superclass applies to subclasses: java.lang.Throwable#*,-initCause
                Arguments.of("initCause on subclass", "new RuntimeException('a').initCause(new RuntimeException('b'))"),
                // reading things that are not whitelisted
                Arguments.of("System.properties", "System.properties"),
                Arguments.of("System['properties']", "System['properties']"),
                Arguments.of("Class.methods", "TimeZone.methods"),
                Arguments.of("Class.classLoader", "TimeZone.classLoader"),
                Arguments.of("metaClass", "'x'.metaClass"),
                Arguments.of("field access", "def tz = TimeZone.getTimeZone('CET'); tz.@ID"),
                Arguments.of("xml slurper attribute write", "def x = new groovy.xml.XmlSlurper().parseText(\"<r a='1'/>\"); x.@a = 2"),
                // evaluate is compiled with the sandbox as well, and every way to reach it is covered
                Arguments.of("evaluate", "evaluate(\"TimeZone.setDefault(TimeZone.getTimeZone('CET'))\")"),
                Arguments.of("evaluate in closure", "[1].each { evaluate(\"TimeZone.setDefault(TimeZone.getTimeZone('CET'))\") }"),
                Arguments.of("evaluate in method", "def f(s) { evaluate(s) }; f(\"TimeZone.setDefault(TimeZone.getTimeZone('CET'))\")"),
                Arguments.of("evaluate via invokeMethod", "this.invokeMethod('evaluate', \"TimeZone.setDefault(TimeZone.getTimeZone('CET'))\")"),
                Arguments.of("evaluate via super", "class S extends Script { def run() { super.evaluate(\"TimeZone.setDefault(TimeZone.getTimeZone('CET'))\") } }; new S().run()"),
                Arguments.of("evaluate file", "evaluate((File) null)"),
                Arguments.of("run file", "run((File) null, (String[]) null)"),
                // groovy.util.*#* must not open up classes that compile code without the sandbox
                Arguments.of("Eval.me", "groovy.util.Eval.me(\"TimeZone.setDefault(TimeZone.getTimeZone('CET'))\")"),
                Arguments.of("ConfigSlurper", "new groovy.util.ConfigSlurper().parse(\"TimeZone.setDefault(TimeZone.getTimeZone('CET'))\")"),
                Arguments.of("GroovyScriptEngine", "new groovy.util.GroovyScriptEngine('.')"),
                // sub-packages are not covered by java.util.*
                Arguments.of("java.util.concurrent", "java.util.concurrent.Executors.newSingleThreadExecutor()"),
                Arguments.of("java.util.logging", "java.util.logging.LogManager.getLogManager().reset()"),
                // closures on common pool threads would run without the sandbox interceptor
                Arguments.of("Arrays.parallelSetAll", "def tz = TimeZone.getTimeZone('CET'); def a = new Integer[5000]; "
                        + "Arrays.parallelSetAll(a, { i -> TimeZone.setDefault(tz); i } as java.util.function.IntFunction)"),
                Arguments.of("parallelStream", "[1, 2, 3].parallelStream().count()"),
                // a rule on an interface (Comparable) does not open up the implementing class
                Arguments.of("File via Comparable", "new File('/tmp').exists()"),
                Arguments.of("Runtime", "Runtime.getRuntime().availableProcessors()")
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("deniedScripts")
    public void deniedScript(String name, String script) throws Exception {
        RuntimeCamelException e = assertThrows(RuntimeCamelException.class, () -> run(script));
        assertTrue(e.getMessage().contains("Sandbox Denial"), e.getMessage());

        // give anything the script may have started on another thread time to run
        Thread.sleep(100);
        assertEquals("UTC", TimeZone.getDefault().getID());
        assertEquals(Locale.US, Locale.getDefault());
    }

    // commons-lang3 is on the classpath on develop but not on next; where it is, its reflection helpers
    // must be denied even though the whitelist allows the lang3 package
    @Test
    public void reflectionHelpersStayDenied() {
        try {
            Class.forName("org.apache.commons.lang3.reflect.MethodUtils");
        } catch (ClassNotFoundException e) {
            org.junit.jupiter.api.Assumptions.abort("commons-lang3 not on classpath");
        }
        String[] scripts = {
                // reflection helpers reach any method/constructor by name, bypassing per-method checks
                "org.apache.commons.lang3.reflect.MethodUtils.invokeExactStaticMethod("
                        + "TimeZone, 'setDefault', [TimeZone.getTimeZone('CET')] as Object[], [TimeZone] as Class[])",
                "org.apache.commons.lang3.reflect.ConstructorUtils.invokeConstructor("
                        + "ProcessBuilder, [['x'] as String[]] as Object[])",
                "org.apache.commons.lang3.reflect.FieldUtils.readStaticField("
                        + "org.assimbly.sandbox.executors.ConfigurableWhitelist, 'METHOD_RULES', true)",
                "org.apache.commons.lang3.SerializationUtils.deserialize(new byte[0])"
        };
        for (String script : scripts) {
            RuntimeCamelException e = assertThrows(RuntimeCamelException.class, () -> run(script), script);
            assertTrue(e.getMessage().contains("Sandbox Denial"), script + " -> " + e.getMessage());
        }
        assertEquals("UTC", TimeZone.getDefault().getID());
    }

    static Stream<Arguments> backgroundScripts() {
        return Stream.of(
                Arguments.of("Thread", "new Thread({ Thread.sleep(50); TimeZone.setDefault(TimeZone.getTimeZone('CET')) }).start()"),
                Arguments.of("Timer", "new Timer(true).schedule({ TimeZone.setDefault(TimeZone.getTimeZone('CET')) } as TimerTask, 50L)")
        );
    }

    // work a script leaves running on another thread must still be checked after the script has returned
    @ParameterizedTest(name = "{0}")
    @MethodSource("backgroundScripts")
    public void backgroundThreadStaysSandboxed(String name, String script) throws Exception {
        try {
            run(script);
        } catch (RuntimeCamelException e) {
            // denying the thread itself is fine as well
            assertTrue(e.getMessage().contains("Sandbox Denial"), e.getMessage());
        }

        Thread.sleep(300);
        assertEquals("UTC", TimeZone.getDefault().getID());
    }

    static Stream<Arguments> allowedScripts() {
        return Stream.of(
                Arguments.of("exchange.getMessage().getBody()", "exchange.getMessage().getBody()", "B"),
                Arguments.of("exchange.message.body", "exchange.message.body", "B"),
                Arguments.of("exchange.in.headers.foo", "exchange.in.headers.foo", "F"),
                Arguments.of("body variable", "body", "B"),
                Arguments.of("headers property", "headers.foo", "F"),
                Arguments.of("headers each", "def keys = []; headers.each { k, v -> keys << k }; keys", "[foo]"),
                Arguments.of("headers assignment", "headers.bar = 'x'; headers.bar", "x"),
                Arguments.of("message.setHeader", "message.setHeader('z', 1); message.getHeader('z')", "1"),
                Arguments.of("script variables", "def x = [a: 1]; x.a + 1", "2"),
                Arguments.of("script method", "def f(n) { n * 2 }; f(21)", "42"),
                Arguments.of("static field", "Locale.JAPAN.toString()", "ja_JP"),
                Arguments.of("getter as property", "def tz = TimeZone.getTimeZone('CET'); tz.ID + tz.getID()", "CETCET"),
                Arguments.of("static getter as property", "TimeZone.default.ID", "UTC"),
                Arguments.of("json slurper", "def j = new groovy.json.JsonSlurper().parseText('{\"a\":{\"b\":[1,2]}}'); j.a.b[1]", "2"),
                Arguments.of("json slurper each", "def j = new groovy.json.JsonSlurper().parseText('{\"a\":1}'); def keys = []; j.each { k, v -> keys << k }; keys", "[a]"),
                Arguments.of("xml parser attributes", "def n = new groovy.xml.XmlParser().parseText(\"<r a='1' value='v'/>\"); '' + n.@a + n.@value + n.@parent", "1vnull"),
                // .@attr writes on an XmlParser node go to the XML attribute map, so they're allowed (XmlSlurper writes are not)
                Arguments.of("xml parser attribute write", "def n = new groovy.xml.XmlParser().parseText(\"<r a='1'/>\"); n.@a = '2'; n.@added = 'x'; n.@a + n.@added", "2x"),
                Arguments.of("xml parser read modify serialize", "def n = new groovy.xml.XmlParser().parseText(\"<r/>\"); n.@tag = 'done'; groovy.xml.XmlUtil.serialize(n).contains('tag=\"done\"')", "true"),
                Arguments.of("evaluate", "evaluate('1 == 1') && !evaluate('false')", "true"),
                Arguments.of("evaluate with binding", "evaluate('body + headers.foo')", "BF"),
                Arguments.of("xml slurper", "def x = new groovy.xml.XmlSlurper().parseText(\"<r><a id='7'>hi</a></r>\"); x.a.text() + x.a.@id + x.a['@id']", "hi77"),
                Arguments.of("list spread property", "[[n: 1], [n: 2]].n", "[1, 2]"),
                Arguments.of("list and map subscripts", "def l = [5]; def m = [k: 2]; l[0] = 6; m['k'] = 3; l[0] + m['k']", "9"),
                Arguments.of("byte array", "def b = 'abc'.bytes; b[0] + b.length", "100"),
                Arguments.of("java.time", "java.time.LocalDate.of(2026, 1, 1).plusDays(1).dayOfMonth", "2"),
                Arguments.of("exception message", "try { Integer.parseInt('x') } catch (NumberFormatException e) { e.message }", "For input string: \"x\""),
                Arguments.of("StringBuilder", "new StringBuilder().append('a').append(1).toString()", "a1"),
                Arguments.of("closures", "[1, 2, 3].collect { it * 2 }.findAll { it > 2 }.sum()", "10"),
                Arguments.of("sort with closure", "[3, 1, 2].sort { a, b -> a <=> b }", "[1, 2, 3]")
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("allowedScripts")
    public void allowedScript(String name, String script, String expected) {
        assertEquals(expected, String.valueOf(run(script)));
    }

    // removes the nodes whose exclude attribute evaluates to true
    private static final String EXCLUDE_SCRIPT = String.join("\n",
            "import groovy.xml.*",
            "def currentBody = request.getBody(String.class)",
            "def bodyInXml = new XmlParser().parseText(currentBody)",
            "def TargetNodes = bodyInXml.'**'.findAll{ node -> node.@exclude }",
            "def groovyEvaluate(executeExpr)",
            "{",
            "    try { return evaluate(executeExpr)}",
            "    catch(Exception) {return \"runtime_error\"}",
            "}",
            "if (!TargetNodes.isEmpty()) {",
            "    for (item in TargetNodes) {",
            "        if (groovyEvaluate(item.@exclude)) {",
            "            def parent = item.parent()",
            "            parent.remove(item)",
            "        }",
            "    }",
            "    result  = XmlUtil.serialize(bodyInXml)",
            "}",
            "else",
            "{",
            "    result = currentBody",
            "}");

    @Test
    public void excludeNodesScript() {
        String body = "<root><a exclude='1 == 1'>a</a><b exclude='false'>b</b><c>c</c>"
                + "<d exclude=\"TimeZone.setDefault(TimeZone.getTimeZone('CET'))\">d</d></root>";
        String result = String.valueOf(run(EXCLUDE_SCRIPT, body));

        assertFalse(result.contains("<a"), result);
        assertTrue(result.contains("<b exclude=\"false\">b</b>"), result);
        assertTrue(result.contains("<c>c</c>"), result);
        // the denied expression is caught by the script and counts as true
        assertFalse(result.contains("<d"), result);
        assertEquals("UTC", TimeZone.getDefault().getID());

        assertEquals("<root><c>c</c></root>", run(EXCLUDE_SCRIPT, "<root><c>c</c></root>"));
    }

    private Object run(String script) {
        return run(script, "B");
    }

    private Object run(String script, String body) {
        Exchange exchange = new DefaultExchange(context);
        exchange.getIn().setBody(body);
        exchange.getIn().setHeader("foo", "F");
        GroovySandboxExecutor.execute(script, exchange);
        return exchange.getIn().getBody();
    }

}
