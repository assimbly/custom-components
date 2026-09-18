package org.assimbly.multipart.processor;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MultipartProcessorTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:multipart")
                        .process(new MultipartProcessor())
                        .to("mock:result");
            }
        };
    }

    @Test
    void addsBinaryPartOnlyWhenFormFieldsHeaderMissing() {
        Exchange exchange = new DefaultExchange(context);
        exchange.getIn().setBody("file-bytes".getBytes(StandardCharsets.UTF_8));
        exchange.getIn().setHeader(Exchange.FILE_NAME, "doc.pdf");
        exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/pdf");
        exchange.getIn().setHeader(MultipartProcessor.MULTIPART_FIELD_NAME, "files");

        template.send("direct:multipart", exchange);

        String body = new String(exchange.getIn().getBody(byte[].class), StandardCharsets.UTF_8);
        assertTrue(body.contains("name=\"files\""));
        assertTrue(body.contains("filename=\"doc.pdf\""));
        assertFalse(body.contains("name=\"options\""));
        assertFalse(exchange.getIn().getHeaders().containsKey(MultipartProcessor.MULTIPART_FIELD_NAME));
        assertFalse(exchange.getIn().getHeaders().containsKey(MultipartProcessor.MULTIPART_FORM_FIELDS));
    }

    @Test
    void addsTextFormFieldsFromJsonHeader() {
        Exchange exchange = new DefaultExchange(context);
        exchange.getIn().setBody("file-bytes".getBytes(StandardCharsets.UTF_8));
        exchange.getIn().setHeader(Exchange.FILE_NAME, "doc.pdf");
        exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/pdf");
        exchange.getIn().setHeader(MultipartProcessor.MULTIPART_FIELD_NAME, "files");
        exchange.getIn().setHeader(
                MultipartProcessor.MULTIPART_FORM_FIELDS,
                "{\"options\":{\"to_formats\":[\"md\"],\"force_ocr\":true},\"lang\":\"en\"}");

        template.send("direct:multipart", exchange);

        String body = new String(exchange.getIn().getBody(byte[].class), StandardCharsets.UTF_8);
        assertTrue(body.contains("name=\"files\""));
        assertTrue(body.contains("name=\"options\""));
        assertTrue(body.contains("\"to_formats\":[\"md\"]"));
        assertTrue(body.contains("\"force_ocr\":true"));
        assertTrue(body.contains("name=\"lang\""));
        assertTrue(body.contains("en"));
    }
}
