package org.assimbly.amazon.api;

import org.apache.commons.codec.CharEncoding;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.assimbly.amazon.domain.Marketplace;
import org.assimbly.util.Pair;
import org.assimbly.util.helper.Base64Helper;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class AmazonMarketplaceApi {

    private String methodUrl = "/";

    private Marketplace marketplace;
    private List<NameValuePair> form;
    private String secretKey;

    private static final String CONTENT_TYPE = "text/xml";
    private static final String MAC_TYPE = "HmacSHA256";

    public AmazonMarketplaceApi(List<NameValuePair> form, Marketplace marketplace, String secretKey) {
        this.form = form;
        this.secretKey = secretKey;
        this.marketplace = marketplace;
    }

    void sign() throws Exception {
        getForm().removeIf(pair -> pair.getName().equals("Signature"));

        String signature = "POST\n" +
                getMarketPlace().getEndpoint().replace("https://", "") + "\n" +
                getMethodUrl() + "\n" +
                getUrlEncodedForm();

        signature = Base64Helper.marshal(
                signSignature(signature, getSecretKey())
        );

        getForm().add(new BasicNameValuePair("Signature", signature));
    }

    /**
     * This method is responsible for actual executing the API Call.
     *
     * @param form The x-www-form-urlencoded parameters as NameValuePair list.
     * @param body The body of the post operation that should be send. Can be null when no body should be sent.
     * @return Pair<StatusLine, String> with the Key being the HTTP Status line of the response, and as value the
     * response body as String.
     */
    Pair<StatusLine, String> post(List<NameValuePair> form, String body) throws Exception {
        URIBuilder builder = new URIBuilder(getMarketPlace().getEndpoint() + getMethodUrl());
        builder.addParameters(form);

        HttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost(builder.build());

        request.setHeader("x-amazon-user-agent", "Assimbly/4.0.0");

        if(body != null) {
            StringEntity entity = new StringEntity(body, "UTF-8");
            entity.setContentType(CONTENT_TYPE);

            request.setEntity(entity);
        }

        HttpResponse response = httpClient.execute(request);

        BufferedReader br = new BufferedReader(
                new InputStreamReader((response.getEntity().getContent())));

        StringBuilder result = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            result.append(line);
        }

        return new Pair<>(response.getStatusLine(), result.toString());
    }

    private byte[] signSignature(String signature, String secretKey) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac sha256_HMAC = Mac.getInstance(MAC_TYPE);
        SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), MAC_TYPE);

        sha256_HMAC.init(secret_key);

        return sha256_HMAC.doFinal(signature.getBytes("UTF-8"));
    }

    public void setMarketplace(Marketplace marketplace) {
        this.marketplace = marketplace;
    }

    public Marketplace getMarketPlace() {
        return marketplace;
    }

    public String getMethodUrl() {
        return methodUrl;
    }

    public List<NameValuePair> getForm() {
        return form;
    }

    public String getUrlEncodedForm(){
        return URLEncodedUtils.format(form, CharEncoding.UTF_8);
    }

    public String getSecretKey(){
        return this.secretKey;
    }
}
