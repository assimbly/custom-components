package org.assimbly.flv;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.commons.io.IOUtils;
import org.custommonkey.xmlunit.XMLUnit;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;

public class FLVComponentTest extends CamelTestSupport {

    @EndpointInject("mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce("direct:start")
    protected ProducerTemplate template;

    @Test
    public void convertsFixedLengthValuesToXmlWithinCamelRoute() throws Exception {
        String expectedXml = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("flv.xml"), Charset.forName("UTF-8"));

        // one exchange is expected
        resultEndpoint.expectedMessageCount(1);

        // trigger exchange
        String flv = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream("flv.txt"), Charset.forName("UTF-8"));
        template.sendBody(flv);

        // wait for the expected exchange to conclude
        resultEndpoint.assertIsSatisfied();

        // verify exchange contents
        String exchangeBody = resultEndpoint.getExchanges().get(0).getIn().getBody(String.class);

        XMLUnit.setIgnoreWhitespace(true);
        assertXMLEqual(expectedXml, exchangeBody);
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
                from("direct:start").to("flv:test" +
                        "?_group_HDR=segmentTag[3]" +
                            "customerNumber[10]" +
                            "customerReference[10]" +
                            "extraReference[10]" +
                            "date[8]" +
                            "time[4]" +
                            "searchNameDeliveryAdress[10]" +
                            "name[30]" +
                            "address1[30]" +
                            "address2[30]" +
                            "address3[30]" +
                            "address4[30]" +
                            "zipcode[9]" +
                            "town[30]" +
                            "countryCode[2]" +
                            "phone[20]" +
                            "instructions[50]" +
                            "searchName[10]" +
                            "name[30]" +
                            "address1[30]" +
                            "address2[30]" +
                            "address3[30]" +
                            "address4[30]" +
                            "zipcode[9]" +
                            "town[30]" +
                            "countryCode[2]" +
                            "phone[20]" +
                            "instructions[50]" +
                            "deliverynoteNr[15]" +
                            "transactiedate[8]" +
                            "batchnumber[15]" +
                            "branchPlant[12]" +
                            "hdrAttachment[1]" +
                            "latestDelDate[30]" +
                            "transport[30]" +
                            "freightHandlCode[30]" +
                            "faxCustomer[30]" +
                            "paymentTerms[30]" +
                            "dateBatch[30]" +
                            "timeBatch[30]" +
                        "&ART=segmentTag[3]" +
                            "linenumber[6]" +
                            "sku[16]" +
                            "skuExtra[25]" +
                            "quantity[10]" +
                            "uom[5]" +
                            "eanKode[30]" +
                            "price[15]" +
                        "&TXT=segmentTag[3]" +
                            "textLineNumber[3]" +
                            "text[70]").to("mock:result");
            }
        };
    }
}
