package org.assimbly.xmltocsv;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertThrows;

class XmlToCsvSecurityTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
                from("direct:in")
                        .to("xmltocsv://?includeHeader=true&includeIndexColumn=false&indexColumnName=line&delimiter=,&lineSeparator=linefeed&orderHeaders=UNORDERED&quoteFields=ALL_FIELDS")
                        .to("mock:out");
            }
        };
    }

    private void testAttack(String attack) throws Exception {
        String attackPath = "src/test/resources/input/security/" + attack;
        String input = new String(Files.readAllBytes(Path.of(attackPath)));

        template.sendBody("direct:in", input);
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {
            "vanilla-xxe-attack.xml",
            "billion-laughs-attack.xml",
            "quadratic-blowup-attack.xml"
    })
    void testAttackIsRejected(String attack) {
        Executable executable = () -> testAttack(attack);
        assertThrows(CamelExecutionException.class, executable);
    }

}
