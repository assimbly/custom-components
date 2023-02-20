package world.dovetail.amazon;

import com.google.common.collect.ImmutableMap;

import org.apache.http.StatusLine;
import org.xml.sax.InputSource;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import world.dovetail.amazon.domain.Operation;
import world.dovetail.amazon.service.AmazonService;
import world.dovetail.amazon.service.AmazonServiceImpl;
import org.assimbly.util.Pair;
import org.assimbly.util.helper.XmlHelper;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class AmazonProcessor implements Processor {

    private AmazonEndpoint endpoint;

    private static final String MAC_TYPE = "HmacSHA256";

    AmazonProcessor(AmazonEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        Pair<StatusLine, String> result;

        AmazonConfiguration config = endpoint.getConfiguration();

        AmazonService service = new AmazonServiceImpl();

        Map<String, String> parameters = config.getParameters();
        parameters.putAll(getMandatory(config));

        switch(config.getOperation()) {
            case LIST_MARKETPLACE_PARTICIPATIONS:
                service.configure(config.getMarketplace(), parameters, config.getSecretKey(), exchange, false);
                result = service.getSellersApi().listMarketplaceParticipations();
                break;
            case LIST_ORDERS:
                service.configure(config.getMarketplace(), parameters, config.getSecretKey(), exchange, false);
                result = service.getOrdersApi().listOrderItems();
                break;
            case LIST_ORDER_ITEMS:
                service.configure(config.getMarketplace(), parameters, config.getSecretKey(), exchange, false);
                result = service.getOrdersApi().listOrders();
                break;
            case SUBMIT_FEED:
                service.configure(config.getMarketplace(), parameters, config.getSecretKey(), exchange, true);

                String body = exchange.getIn().getBody(String.class);

                result = service.getFeedsApi().submitFeed(body);

                if(!config.getSettings().containsKey("WaitForSubmissionResult") ||
                        config.getSettings().get("WaitForSubmissionResult").equals("false")) {
                    break;
                }

                parameters = new HashMap<>(getMandatory(config));

                parameters.put("Action", actions().get(Operation.GET_FEED_SUBMISSION_RESULT));
                parameters.put("FeedSubmissionId", getSubmissionId(result.getValue()));

                service.configure(config.getMarketplace(), parameters, config.getSecretKey(), exchange, false);

                result = pollSubmissionResult(service, result);
                break;
            case GET_FEED_SUBMISSION_RESULT:
                service.configure(config.getMarketplace(), parameters, config.getSecretKey(), exchange, false);
                result = service.getFeedsApi().getFeedSubmissionResult();
                break;
            case GET_REPORT_LIST:
                service.configure(config.getMarketplace(), parameters, config.getSecretKey(), exchange, false);
                result = service.getReportsApi().getReportList();
                break;
            case GET_REPORT:
                service.configure(config.getMarketplace(), parameters, config.getSecretKey(), exchange, false);
                result = service.getReportsApi().getReport();
                break;
            case UPDATE_REPORT_ACKNOWLEDGEMENTS:
                service.configure(config.getMarketplace(), parameters, config.getSecretKey(), exchange, false);
                result = service.getReportsApi().updateReportAcknowledgements();
                break;
            default:
                throw new UnsupportedOperationException();
        }

        /*
         *  Throw an exception whenever the full response couldn't be loaded.
         */
        if(result == null || result.getKey() == null || result.getValue() == null)
            throw new Exception("The Amazon Component could not load the response from the Amazon MWS API.");

        exchange.getIn().setHeader("Amazon-ResponseCode",
                String.format("%s - %s", result.getKey().getStatusCode(), result.getKey().getReasonPhrase())
        )
        ;
        exchange.getIn().setHeader("Content-Type", "text/xml");

        exchange.getIn().setBody(
                XmlHelper.prettyPrint(result.getValue())
        );
    }

    private Map<String, String> getMandatory(AmazonConfiguration config){
        Map<String, String> parameters = new HashMap<>();

        parameters.put("AWSAccessKeyId", config.getAccessKey());
        parameters.put("Action", actions().get(config.getOperation()));

        if(config.getAuthToken() != null && !config.getAuthToken().isEmpty()) {
            parameters.put("MWSAuthToken", config.getAuthToken());
        }

        parameters.put("Merchant", config.getSellerId());
        parameters.put("SellerId", config.getSellerId());
        parameters.put("SignatureMethod", MAC_TYPE);
        parameters.put("SignatureVersion", "2");
        parameters.put("Timestamp", formatDate(new Date()));
        parameters.put("Version", versions().get(config.getOperation()));

        return parameters;
    }

    public String formatDate(Date date){
        DateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");

        isoFormat.setTimeZone(
                TimeZone.getTimeZone("UTC")
        );

        return isoFormat.format(date);
    }

    private String getSubmissionId(String response) throws XPathExpressionException {
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        InputSource source = new InputSource(new StringReader(response));

        return xpath.evaluate("//*[local-name()='FeedSubmissionId']/text()", source);
    }

    private Pair<StatusLine, String> pollSubmissionResult(AmazonService service, Pair<StatusLine, String> result) throws Exception {
        // Timeout after 10 * 15 Seconds (2,5 minutes)
        int timeout = 10;
        int currentTry = 1;

        boolean pending = true;

        // The actual "polling" of the submission result
        while(pending && currentTry < timeout){
            // Block the thread
            Thread.sleep(15000);

            result = service.getFeedsApi().getFeedSubmissionResult();

            if(result.getKey().getStatusCode() >= 200 && result.getKey().getStatusCode() < 300)
                pending = false;

            currentTry++;
        }

        return result;
    }

    private static Map<Operation, String> versions() {
        return new ImmutableMap.Builder<Operation, String>()
                .put(Operation.LIST_MARKETPLACE_PARTICIPATIONS, "2011-07-01")
                .put(Operation.LIST_ORDERS, "2013-09-01")
                .put(Operation.LIST_ORDER_ITEMS, "2013-09-01")
                .put(Operation.SUBMIT_FEED, "2009-01-01")
                .put(Operation.GET_FEED_SUBMISSION_RESULT, "2009-01-01")
                .put(Operation.GET_REPORT_LIST, "2009-01-01")
                .put(Operation.GET_REPORT, "2009-01-01")
                .put(Operation.UPDATE_REPORT_ACKNOWLEDGEMENTS, "2009-01-01")
                .build();
    }

    private static Map<Operation, String> actions(){
        return new ImmutableMap.Builder<Operation, String>()
                .put(Operation.LIST_MARKETPLACE_PARTICIPATIONS, "ListMarketplaceParticipations")
                .put(Operation.LIST_ORDERS, "ListOrders")
                .put(Operation.LIST_ORDER_ITEMS, "ListOrderItems")
                .put(Operation.SUBMIT_FEED, "SubmitFeed")
                .put(Operation.GET_FEED_SUBMISSION_RESULT, "GetFeedSubmissionResult")
                .put(Operation.GET_REPORT_LIST, "GetReportList")
                .put(Operation.GET_REPORT, "GetReport")
                .put(Operation.UPDATE_REPORT_ACKNOWLEDGEMENTS, "UpdateReportAcknowledgements")
                .build();
    }
}
