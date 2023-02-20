package org.assimbly.mail.component.mail;

import org.apache.camel.EndpointInject;
import org.apache.camel.Message;
import org.apache.camel.attachment.AttachmentMessage;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.language.ConstantExpression;
import org.apache.camel.model.language.SimpleExpression;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.assimbly.enrich.EnrichStrategy;

public class AttachmentEnrichStrategyTest extends CamelTestSupport {

    @EndpointInject(ref = "mock:result-marshal")
    private MockEndpoint marshalResult;

    @EndpointInject(ref = "mock:result-unmarshal")
    private MockEndpoint unmarshalResult;

    private static String xmlFirstInput =
            "<TestNode>\n" +
            "\t<Node>Content 1</Node>\n" +
            "\t<Node>Content 2</Node>\n" +
            "\t<Node>Content 3</Node>\n" +
            "</TestNode>";

    private static String xmlSecondInput =
            "<TestNode>\n" +
            "\t<Node>Content 4</Node>\n" +
            "\t<Node>Content 5</Node>\n" +
            "\t<Node>Content 6</Node>\n" +
            "</TestNode>";

    @Test
    public void enrichAsAttachment() throws Exception {
        marshalResult.expectedMessageCount(1);
        unmarshalResult.expectedMessageCount(1);

        template.sendBody("direct:start", xmlFirstInput);

        marshalResult.assertIsSatisfied();
        unmarshalResult.assertIsSatisfied();

        Message out = marshalResult.getExchanges().get(0).getIn();
        boolean attachFlag = marshalResult.getExchanges().get(0).getIn(AttachmentMessage.class).hasAttachments();

        Assert.assertFalse(attachFlag);
        Assert.assertTrue(out.getHeader("Content-Type", String.class).contains("multipart/mixed"));
        //Assert.assertTrue(out.getBody(String.class).contains(xmlFirstInput));
        //Assert.assertTrue(out.getBody(String.class).contains(xmlSecondInput));

        out = unmarshalResult.getExchanges().get(0).getIn();
        attachFlag = unmarshalResult.getExchanges().get(0).getIn(AttachmentMessage.class).hasAttachments();

        Assert.assertTrue(attachFlag);
        Assert.assertTrue(out.getHeader("Content-Type", String.class).contains("text/xml"));
        Assert.assertEquals(xmlFirstInput, out.getBody(String.class));
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        System.out.println(" > createRouteBuilder ");
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                // enable async in only mode on the consumer
                from("direct:start")
                        .setHeader("Content-Type", new ConstantExpression("text/xml"))
                        .setProperty("Enrich-Type", new SimpleExpression("application/attachment"))
                        .enrich("direct:enrich-constant-xml-resource", (AggregationStrategy) new EnrichStrategy())
                        .marshal().mimeMultipart()
                        .to("mock:result-marshal")
                        .unmarshal().mimeMultipart()
                        .to("mock:result-unmarshal");

                from("direct:enrich-constant-xml-resource")
                        .setHeader("CamelFileName", new ConstantExpression("file.xml"))
                        .setHeader("CamelVelocityTemplate").constant(xmlSecondInput)
                        .to("velocity:dummy?allowTemplateFromHeader=true");
            }
        };
    }

}
