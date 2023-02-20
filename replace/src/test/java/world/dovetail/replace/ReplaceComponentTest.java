package world.dovetail.replace;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.language.ConstantExpression;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import org.assimbly.util.helper.Base64Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class ReplaceComponentTest extends CamelTestSupport {

    private final String regex = "#\\{(.*?)\\}";
    private final String endOfLineRegex = "EOL";
    private final String whiteSpaceRegex = "\\s";
    private final String multipleGroupRegex = "#\\{(Joe).(.*?)\\}";
    private final String multipleGroupRegex2 = "#\\{(Joe)\\}";
    private final String dotallRegex = "(?<=Pedro).*$";
    private final String replaceWith = "Kabisa";
    private final String replaceWithHeader = "${header.replace}";
    private final String replaceWithExceptionalCharacters = "\n";

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:executeSingleGroup")
                        .to("replace://?regex=RAW(" + Base64Helper.marshal(regex) + ")" + "&replaceWith=RAW(" + Base64Helper.marshal(replaceWith) + ")" + "&group=0")
                        .to("mock:out");

                from("direct:executeMultipleGroupsWithFlag")
                        .to("replace://?regex=RAW(" + Base64Helper.marshal(multipleGroupRegex2) + ")" + "&replaceWith=RAW(" + Base64Helper.marshal(replaceWith) + ")" + "&group=0&flags=i")
                        .to("mock:out");

                from("direct:executeWithDotall")
                        .to("replace://?regex=RAW(" + Base64Helper.marshal(dotallRegex) + ")" + "&replaceWith=RAW(" + Base64Helper.marshal(" * ") + ")" + "&group=0&flags=s")
                        .to("mock:out");

                from("direct:executeWithoutDotall")
                        .to("replace://?regex=RAW(" + Base64Helper.marshal(dotallRegex) + ")" + "&replaceWith=RAW(" + Base64Helper.marshal(" * ") + ")" + "&group=0")
                        .to("mock:out");

                from("direct:executeMultipleGroups")
                        .to("replace://?regex=RAW(" + Base64Helper.marshal(multipleGroupRegex) + ")" + "&replaceWith=RAW(" + Base64Helper.marshal(replaceWith) + ")" + "&group=2")
                        .to("mock:out");

                from("direct:executeWithHeader")
                        .setHeader("replace", new ConstantExpression("kabisa"))
                        .to("replace://?regex=RAW(" + Base64Helper.marshal(multipleGroupRegex) + ")" + "&replaceWith=RAW(" + Base64Helper.marshal(replaceWithHeader) + ")" + "&group=0")
                        .to("mock:out");

                from("direct:executeWithExceptionalCharacters")
                        .to("replace://?regex=RAW(" + Base64Helper.marshal(endOfLineRegex) + ")" + "&replaceWith=RAW(" + Base64Helper.marshal(replaceWithExceptionalCharacters) + ")" + "&group=0")
                        .to("mock:out");

                from("direct:executeWithExceptionalCharacterInHeader")
                        .setHeader("replace", new ConstantExpression("\\n"))
                        .to("replace://?regex=RAW(" + Base64Helper.marshal(endOfLineRegex) + ")" + "&replaceWith=RAW(" + Base64Helper.marshal(replaceWithHeader) + ")" + "&group=0")
                        .to("mock:out");

                from("direct:executeWithWhiteSpaceCharacter")
                        .to("replace://?regex=RAW(" + Base64Helper.marshal(whiteSpaceRegex) + ")" + "&replaceWith=RAW(" + Base64Helper.marshal(" ") + ")" + "&group=0")
                        .to("mock:out");

                from("direct:executeWithMultiTypeLineEndings")
                        .to("replace://?regex=RAW(" + Base64Helper.marshal(replaceWith) + ")" + "&replaceWith=RAW(" + Base64Helper.marshal("Dovetail") + ")" + "&group=0")
                        .to("mock:out");
            }
        };
    }

    @Test
    public void testReplace() {
        template.sendBody("direct:executeSingleGroup", "Hello #{Joe}!");

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);


        String expected = "Hello " + replaceWith + "!";
        assertEquals(expected, actual);
    }

    @Test
    public void testMultipleReplace() {
        template.sendBody("direct:executeSingleGroup", "Hello #{Joe} and #{Bob}!");

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);

        String expected = "Hello " + replaceWith + " and " + replaceWith + "!";
        assertEquals(expected, actual);
    }

    @Test
    public void testMultipleGroupReplaceWithFlag() {
        template.sendBody("direct:executeMultipleGroupsWithFlag", "Hello #{joe} and #{joe}!");

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);

        String expected = "Hello " + replaceWith + " and " + replaceWith + "!";
        assertEquals(expected, actual);
    }

    @Test
    public void testMultipleGroupReplace() {
        template.sendBody("direct:executeMultipleGroups", "Hello #{Joe.Gmail} and #{Joe.Hotmail}!");

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);

        String expected = "Hello #{Joe." + replaceWith + "} and #{Joe." + replaceWith + "}!";
        assertEquals(expected, actual);
    }

    @Test
    public void testHeaderReplace() {
        template.sendBody("direct:executeWithHeader", "Hello #{Joe.Gmail} and #{Joe.Hotmail}!");

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);

        String header = result.getIn().getHeader("replace", String.class);

        String expected = "Hello " + header + " and " + header + "!";
        assertEquals(expected, actual);
    }

    @Test
    public void testUnescapingOfExceptionalCharacters() { //We want to unescape \n \r \t
        template.sendBody("direct:executeWithExceptionalCharacters", "This is a line EOL This is another line");

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);

        String expected = "This is a line " + replaceWithExceptionalCharacters + " This is another line";
        assertEquals(expected, actual);
    }

    @Test
    public void testUnescapingOfExceptionalCharactersInHeader() {
        template.sendBody("direct:executeWithExceptionalCharacterInHeader", "This is a line EOL This is another line");

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);


        String expected = "This is a line " + replaceWithExceptionalCharacters + " This is another line";
        assertEquals(expected, actual);
    }

    @Test
    public void testReplaceWhiteSpaceChar() {
        template.sendBody("direct:executeWithWhiteSpaceCharacter", "This is a\nmultiline body\tfor testing\fpurposes");

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);


        String expected = "This is a multiline body for testing purposes";
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiTypeLineEndings() {
        template.sendBody("direct:executeWithMultiTypeLineEndings", "Welcome\n This is Kabisa\r\n This is another line\r Yet another line!");

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);

        String expected = "Welcome\n" +
                " This is Dovetail\r\n" +
                " This is another line\r" +
                " Yet another line!";
        assertEquals(expected, actual);
    }

    @Test
    public void testReplaceWithDotall() {
        template.sendBody("direct:executeWithDotall", "My name is Pedro\nThank you");

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);

        String expected = "My name is Pedro * Thank you";
        assertEquals(expected, actual);
    }

    @Test
    public void testReplaceWithoutDotall() {
        template.sendBody("direct:executeWithoutDotall", "My name is Pedro\nThank you");

        Exchange result = getMockEndpoint("mock:out").getExchanges().get(0);

        String actual = result.getIn().getBody(String.class);


        String expected = "My name is Pedro * \nThank you";
        assertEquals(expected, actual);
    }

    @Test
    public void testBitwiseReductionForRegexMagicConstant() {
        List<Integer> flags = new ArrayList<>();

        flags.add(Pattern.CASE_INSENSITIVE);
        flags.add(Pattern.MULTILINE);
        flags.add(Pattern.DOTALL);

        int expected = Pattern.DOTALL| Pattern.CASE_INSENSITIVE | Pattern.MULTILINE;

        int actual = flags.stream().reduce(0, (a, b) -> a | b);

        assertEquals(expected, actual);
    }
}
