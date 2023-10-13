import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.commons.io.IOUtils;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.TimeZone;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;

public class OriflameComponentTest extends CamelTestSupport {

    private static TimeZone originalDefaultTimeZone;

    @EndpointInject("mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce
    protected ProducerTemplate template;

    @BeforeAll
    public static void setDefaultTimeZone() {
        originalDefaultTimeZone = TimeZone.getDefault();
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @AfterAll
    public static void restoreDefaultTimeZone() {
        TimeZone.setDefault(originalDefaultTimeZone);
    }

    @Test
    public void convertsPostItemInformation() throws Exception {
        runGenericTest("pii", "pii");
    }

    @Test
    public void convertsPostInventoryTransactions() throws Exception {
        runGenericTest("pit", "pit");
    }

    @Test
    @Disabled("Sample files are outdated")
    public void convertsPostInboundOrderReceipt() throws Exception {
        runGenericTest("pior", "pior");
    }

    @Test
    public void convertsPiorRealFile() throws Exception {
        runGenericTest("pior", "real_files/pior_com_7610996_16102015_133030");
    }

    @Test
    public void convertsPostInboundOrderReceiptCross() throws Exception {
        runGenericTest("pior_cross", "pior_cross");
    }

    @Test
    @Disabled("Sample files are outdated")
    public void convertsPostOutboundOrderIssue() throws Exception {
        runGenericTest("pooi", "pooi");
    }

    @Test
    public void convertsPooiRealFile() throws Exception {
        runGenericTest("pooi", "real_files/pooi_valtrip_8870115_12102015_145628");
    }

    @Test
    public void convertsPostPalletOutboundOrder() throws Exception {
        runGenericTest("ppoo", "ppoo");
    }

    private void runGenericTest(String type, String filename) throws Exception {
        String expectedXml = retrieveFileContent(filename + ".xml");

        // one exchange is expected
        resultEndpoint.expectedMessageCount(1);

        // trigger exchange
        String ori = retrieveFileContent(filename + ".edi");
        String endpoint = "direct:" + type;
        template.sendBody(endpoint, ori);

        // wait for the expected exchange to conclude
        resultEndpoint.assertIsSatisfied();

        // verify exchange contents
        String exchangeBody = resultEndpoint.getExchanges().get(0).getIn().getBody(String.class);

        XMLUnit.setIgnoreWhitespace(true);
        assertXMLEqual(expectedXml, exchangeBody);
    }

    private String retrieveFileContent(String filename) throws IOException {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(filename);
        return IOUtils.toString(stream, Charset.forName("UTF-8"));
    }

    @Override
    protected RouteBuilder[] createRouteBuilders() {
        return new RouteBuilder[] {
                new RouteBuilder() {
                    public void configure() {
                        from("direct:pii").to("oriflame:pii?ediType=PII").to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:pior").to("oriflame:pior?ediType=PIOR").to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:pior_cross").to("oriflame:pior_cross?ediType=PIOR_CROSS").to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:pit").to("oriflame:pit?ediType=PIT").to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:pooi").to("oriflame:pooi?ediType=POOI").to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:ppoo").to("oriflame:ppoo?ediType=PPOO").to("mock:result");
                    }
                }
        };
    }
}
