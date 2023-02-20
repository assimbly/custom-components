package world.dovetail.amazon.service;

import com.google.common.base.CaseFormat;
import org.apache.camel.Exchange;
import org.apache.camel.support.EndpointHelper;
import org.apache.commons.codec.CharEncoding;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;
import world.dovetail.amazon.AmazonConfiguration;
import world.dovetail.amazon.api.FeedsApi;
import world.dovetail.amazon.api.OrdersApi;
import world.dovetail.amazon.api.ReportsApi;
import world.dovetail.amazon.api.SellersApi;
import world.dovetail.amazon.comparator.ParameterComperator;
import world.dovetail.amazon.domain.Amazon;
import world.dovetail.amazon.domain.Marketplace;
import world.dovetail.amazon.domain.Region;
import world.dovetail.amazon.exception.MarketplaceNotFoundException;
import org.assimbly.util.helper.Base64Helper;
import org.assimbly.util.helper.ExchangeHelper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AmazonServiceImpl implements AmazonService {

    private static final String MARKETPLACE_OVERRIDE_HEADER = "DovetailAmazonMarketPlaceId";

    private Map<String, String> parameters;
    private List<NameValuePair> form;

    private Marketplace marketplace;
    private String secretKey;

    public AmazonServiceImpl(){
        parameters = new HashMap<>();
        form = new ArrayList<>();
    }

    public void configure(Marketplace marketplace, Map<String, String> parameters,
                          String secretKey, Exchange exchange, boolean useBody) throws MarketplaceNotFoundException {
        this.secretKey = secretKey;
        this.marketplace = marketplace;

        if(exchange.getIn().getHeaders().containsKey(MARKETPLACE_OVERRIDE_HEADER)) {
            this.marketplace = Amazon.INSTANCE.findMarketPlace(
                    exchange.getIn().getHeader(MARKETPLACE_OVERRIDE_HEADER, String.class)
            );
        }

        if(!parameters.isEmpty()) {
            this.parameters = interpolate(parameters, exchange);
            this.parameters = applyOverrideHeaders(this.parameters, exchange.getIn().getHeaders());
        }

        if(useBody) {
            String body = exchange.getIn().getBody(String.class);
            this.parameters.put("ContentMD5Value", computeContentMD5Value(body));
        }

        this.form = toForm(this.parameters);
    }

    Map<String, String> interpolate(Map<String, String> parameters, Exchange exchange) {
        return parameters.entrySet().stream()
                .map(entry -> {
                    String value = ExchangeHelper.interpolate(entry.getValue(), exchange);
                    return new AbstractMap.SimpleEntry<>(entry.getKey(), value);
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    String computeContentMD5Value(String content) {
        // Consume the stream to compute the MD5 as a side effect.
        DigestInputStream s;
        try {
            s = new DigestInputStream(new ByteArrayInputStream(content.getBytes()),
                    MessageDigest.getInstance("MD5"));
            // drain the buffer, as the digest is computed as a side-effect
            byte[] buffer = new byte[8192];
            while(s.read(buffer) > 0);
            return new String(Base64Helper.marshal(s.getMessageDigest().digest()).getBytes(),"UTF-8");
        } catch (NoSuchAlgorithmException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    Map<String, String> applyOverrideHeaders(Map<String, String> parameters, Map<String, Object> headers) {
        Map<String, Object> overrideHeaders =
                headers.entrySet().stream()
                        .filter(header -> Pattern.matches(header.getKey(), "DovetailAmazon*"))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        if(overrideHeaders.size() == 0)
            return parameters;

        parameters.entrySet().stream()
                .filter(entry -> overrideHeaders.containsKey(
                        String.format("DovetailAmazon%s", CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, entry.getKey()))
                ))
                .forEach(entry -> {
                            entry.setValue(overrideHeaders.get(
                                    String.format("DovetailAmazon%s", CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL, entry.getKey()))
                            ).toString());
                        }
                );

        return parameters;
    }

    List<NameValuePair> toForm(Map<String, String> parameters){
        List<NameValuePair> params = new ArrayList<>();

        // Add all parameters to the return list
        parameters.forEach((k, v) -> params.add(new BasicNameValuePair(k, v)));

        // Alphabetically sort the parameters
        params.sort(new ParameterComperator());

        return params;
    }

    public SellersApi getSellersApi() {
        return new SellersApi(form, marketplace, secretKey);
    }

    public FeedsApi getFeedsApi(){
        return new FeedsApi(form, marketplace, secretKey);
    }

    public ReportsApi getReportsApi() {
        return new ReportsApi(form, marketplace, secretKey);
    }

    public OrdersApi getOrdersApi() {
        return new OrdersApi(form, marketplace, secretKey);
    }
}
