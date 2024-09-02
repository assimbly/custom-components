package org.assimbly.amazon.service;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;

import org.apache.camel.support.DefaultExchange;
import org.apache.commons.io.IOUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.assimbly.util.helper.Base64Helper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.assimbly.amazon.AmazonConfiguration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmazonServiceTest {

    private static final String SELLER_ID = "A286R55XIM629C";
    private static final String ACCESS_KEY = "AKIAIDCWU7SMT3765MSQ";
    private static final String SECRET_KEY = "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";

    private static AmazonConfiguration configuration;
    private static AmazonServiceImpl service;


    @BeforeEach
    public void init() {
        service = new AmazonServiceImpl();
        configuration = new AmazonConfiguration();

        configuration.setSellerId(SELLER_ID);
        configuration.setAccessKey(ACCESS_KEY);
        configuration.setSecretKey(SECRET_KEY);

        configuration.setOperation("SUBMIT_FEED");

        String json = "{\n" +
                        "\"FeedType\": \"_POST_PRODUCT_DATA_\", " +
                        "\"PurgeAndReplace\": \"false\" " +
                      "}";

        configuration.setParameters(
                Base64Helper.marshal(json)
        );
    }

    @Test
    public void parametersInterpolationTest() throws IOException {
        Exchange exchange = new DefaultExchange(new DefaultCamelContext());
        exchange.getIn().setHeader("FeedTypeHeader", "_POST_INVENTORY_AVAILABILITY_DATA_");

        String json = "{\n" +
                         "\"FeedType\": \"${header.FeedTypeHeader}\", " +
                         "\"PurgeAndReplace\": \"false\" " +
                      "}";

        configuration.setParameters(
                Base64Helper.marshal(json)
        );

        Map<String, String> result = service.interpolate(configuration.getParameters(), exchange);

        assertEquals("_POST_INVENTORY_AVAILABILITY_DATA_", result.get("FeedType"));
    }

    @Test
    public void computeMd5HashTest() throws IOException {
        String input = IOUtils.toString(
                getClass().getClassLoader().getResourceAsStream("SubmitFeedInput.xml"),
                StandardCharsets.UTF_8
        );

        input = input.replaceAll("\\r\\n", "\n");

        String actual = service.computeContentMD5Value(input);

        assertEquals("LhKDa4uDxuzBekZWGaSrNA==", actual);
    }

    @Test
    public void applyOverrideHeadersTest() throws IOException {
        Exchange exchange = new DefaultExchange(new DefaultCamelContext());

        String expected = "_POST_PRODUCT_DATA_";

        Map<String, String> result = service.applyOverrideHeaders(configuration.getParameters(), exchange.getIn().getHeaders());
        String actual = result.get("FeedType");

        assertEquals(expected, actual);

        exchange.getIn().setHeader("AssimblyAmazonFeedType", "_POST_INVENTORY_AVAILABILITY_DATA_");

        result = service.applyOverrideHeaders(configuration.getParameters(), exchange.getIn().getHeaders());
        actual = result.get("FeedType");

        assertEquals(expected, actual);
    }

    @Test
    public void alphabeticallySortedFormTest() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("C", "Value");
        parameters.put("B", "Value");
        parameters.put("A", "Value");
        parameters.put("b", "Value");
        parameters.put("c", "Value");
        parameters.put("a", "Value");

        List<NameValuePair> expected = new ArrayList<>();
        expected.add(new BasicNameValuePair("A", "Value"));
        expected.add(new BasicNameValuePair("B", "Value"));
        expected.add(new BasicNameValuePair("C", "Value"));
        expected.add(new BasicNameValuePair("a", "Value"));
        expected.add(new BasicNameValuePair("b", "Value"));
        expected.add(new BasicNameValuePair("c", "Value"));

        List<NameValuePair> actual = service.toForm(parameters);

        assertEquals(expected, actual);
    }

}
