package org.assimbly.mail.component.mail;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.attachment.AttachmentMessage;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.camel.test.junit5.TestSupport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AttachmentAttacherTest extends CamelTestSupport  {

    private final static CamelContext ctx = new DefaultCamelContext();
    private final static AttachmentAttacher attacher = new AttachmentAttacher();
    private Exchange exchange;

    @BeforeEach
    public void before() throws Exception {
        exchange = new DefaultExchange(ctx);
    }

    @Test
    public void detects_mime_type_based_on_content() throws Exception {
        exchange.getIn().setBody("this is my body");
        exchange.getIn().setHeader(Exchange.FILE_NAME, "juca.txt");
        attacher.process(exchange);

        Assertions.assertEquals("text/plain", exchange.getIn().getHeader(Exchange.CONTENT_TYPE));
    }

    @Test
    public void generates_file_name_based_on_timestamp_and_mime_type() throws Exception {
        exchange.getIn().setBody("this is my body");
        attacher.process(exchange);

        String partialTimestamp = new SimpleDateFormat("-yyyy-MM-dd-HH-").format(new Date());
        String fileName = exchange.getIn().getHeader(Exchange.FILE_NAME, String.class);

        TestSupport.assertStringContains(fileName, partialTimestamp);
        assertTrue(fileName.startsWith("Assimbly-"));
        assertTrue(fileName.endsWith(".txt"));
    }

    @Test
    public void attaches_exchange_body_as_file() throws Exception {
        exchange.getIn().setBody("this is my body");
        exchange.getIn().setHeader(Exchange.FILE_NAME, "juca.txt");
        attacher.process(exchange);

        Assertions.assertTrue(exchange.getIn(AttachmentMessage.class).getAttachmentObjects().containsKey("juca.txt"));
        Assertions.assertEquals("this is my body", exchange.getIn(AttachmentMessage.class).getAttachment("juca.txt").getContent());
    }

    @Test
    public void leaves_exchange_body_empty_if_email_body_header_not_set() throws Exception {
        exchange.getIn().setBody("this is my body");
        exchange.getIn().setHeader(Exchange.FILE_NAME, "juca.txt");
        attacher.process(exchange);

        Assertions.assertEquals("", exchange.getIn().getBody(String.class));
    }

    @Test
    public void sets_new_exchange_body_based_on_email_body_header() throws Exception {
        exchange.getIn().setHeader("EmailBody", "my new body");
        exchange.getIn().setBody("this is my body");
        exchange.getIn().setHeader(Exchange.FILE_NAME, "juca.txt");
        attacher.process(exchange);

        Assertions.assertEquals("my new body", exchange.getIn().getBody(String.class));
    }
}
