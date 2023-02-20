package org.assimbly.xmltocsv;

import org.apache.camel.CamelExecutionException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class XmlToCsvSecurityTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
                from("direct:in")
                        .to("xmltocsv://?includeHeader=true&includeIndexColumn=false&indexColumnName=line&delimiter=(LA==)&lineSeparator=RAW(XG4=)&orderHeaders=UNORDERED&quoteFields=ALL_FIELDS")
                        .to("mock:out");
            }
        };
    }

    private void testAttack(String attack) throws Exception {
        String attackPath = "src/test/resources/input/security/" + attack;
        String input = new String(Files.readAllBytes(Paths.get(attackPath)));

        template.sendBody("direct:in", input);
    }

    @Test
    public void testVanillaXXE() throws Exception {
        Executable executable = () -> testAttack("vanilla-xxe-attack.xml");
        assertThrows(CamelExecutionException.class,executable);
    }

    @Test
    public void testBillionLaughsAttack() throws Exception {
        Executable executable = () -> testAttack("billion-laughs-attack.xml");
        assertThrows(CamelExecutionException.class,executable);

    }

    @Test
    public void testQuadraticBlowupAttack() throws Exception {

        Executable executable = () -> testAttack("quadratic-blowup-attack.xml");
        assertThrows(CamelExecutionException.class,executable);
    }

}
