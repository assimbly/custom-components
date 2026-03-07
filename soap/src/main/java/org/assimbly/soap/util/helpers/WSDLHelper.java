package org.assimbly.soap.util.helpers;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.camel.Exchange;
import org.apache.commons.io.FileUtils;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
import org.apache.hc.core5.util.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.assimbly.soap.cache.WSDLCache;
import org.assimbly.soap.domain.SoapHttpHeader;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import jakarta.xml.soap.MessageFactory;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPMessage;


public final class WSDLHelper {

    private static final Logger LOG = LoggerFactory.getLogger(WSDLHelper.class);
    private static final String CACHE_EXPIRATION_PROPERTY = "soap.cacheExpirationInHours";
    private static final Properties prop = loadProperties();

    public static Definition retrieve(String params, String wsdl, List<SoapHttpHeader> httpHeaders) throws WSDLException, IOException {
        WSDLFactory factory = WSDLFactory.newInstance();
        WSDLReader reader = factory.newWSDLReader();
        reader.setFeature("javax.wsdl.verbose", false);

        File file;
        String url = prepareUrl(params, wsdl);

        if (WSDLCache.INSTANCE.contains(url)) {
            file = WSDLCache.INSTANCE.getPath(url);

            if (file.exists()) {
                LocalDateTime threshold = LocalDateTime.now().minusHours(Long.parseLong(prop.getProperty(CACHE_EXPIRATION_PROPERTY, "24")));

                LocalDateTime lastModified = LocalDateTime.ofInstant(
                        Instant.ofEpochMilli(file.lastModified()), ZoneId.systemDefault());

                if (lastModified.isAfter(threshold))
                    return reader.readWSDL(file.getAbsolutePath());
                else
                    WSDLCache.INSTANCE.remove(url);
            }
        }

        file = WSDLCache.INSTANCE.register(url);

        Files.createDirectories(Path.of(file.getParent()));

        Definition definition;

        try {
            fetchWSDL(file, url, httpHeaders);

            definition = reader.readWSDL(file.getAbsolutePath());
            LOG.info("WSDL has been fetched and cached successfully.");

        } catch(Exception _) {
            WSDLCache.INSTANCE.remove(url);
            throw new WSDLException("500", "Invalid WSDL or WSDL not found at: "+url);
        }

        return definition;
    }

    private static String prepareUrl(String params, String wsdl) {
        if (params == null || params.isEmpty())
            return wsdl;

        return "%s?%s".formatted(wsdl, params);
    }

    private static void fetchWSDL(File file, String location, List<SoapHttpHeader> httpHeaders) throws URISyntaxException, IOException {

        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(Timeout.ofMilliseconds(20000))
                .setResponseTimeout(Timeout.ofMilliseconds(20000))
                .build();

        try (CloseableHttpClient client = HttpClients.custom()
                .setDefaultRequestConfig(config)
                .build()) {

            HttpGet request = new HttpGet(new URI(location));

            if (httpHeaders != null) {
                httpHeaders.forEach(httpHeader -> request.setHeader(httpHeader.getName(), httpHeader.getValue()));
            }

            client.execute(request, response -> {
                try (BufferedInputStream wsdl = new BufferedInputStream(response.getEntity().getContent())) {
                    FileUtils.copyInputStreamToFile(wsdl, file);
                }
                return null;
            });
        }
    }

    public static Map<String, Object> execute(String destination, SOAPMessage request, Exchange exchange) throws SOAPException, IOException {

        // Serialize the SOAP request to bytes once — used for both the HTTP body and the debug header.
        ByteArrayOutputStream requestStream = new ByteArrayOutputStream();
        request.writeTo(requestStream);
        byte[] requestBytes = requestStream.toByteArray();
        String requestMessage = new String(requestBytes, StandardCharsets.UTF_8);

        exchange.getIn().setHeader("Generated-Request", requestMessage);

        // Resolve the SOAPAction header (may be blank but must be present for SOAP 1.1).
        String soapAction = "";
        String[] soapActionHeader = request.getMimeHeaders().getHeader("SOAPAction");
        if (soapActionHeader != null && soapActionHeader.length > 0) {
            soapAction = soapActionHeader[0];
        }

        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(Timeout.ofMilliseconds(10000))
                .setResponseTimeout(Timeout.ofMilliseconds(30000))
                .build();

        try (CloseableHttpClient client = HttpClients.custom()
                .setDefaultRequestConfig(config)
                .build()) {

            HttpPost httpPost = new HttpPost(new URI(destination));
            httpPost.setHeader("Content-Type", "text/xml; charset=UTF-8");
            httpPost.setHeader("SOAPAction", soapAction);
            httpPost.setEntity(new ByteArrayEntity(requestBytes, ContentType.TEXT_XML));

            byte[] responseBytes = client.execute(httpPost, response -> {
                try (InputStream content = response.getEntity().getContent()) {
                    return content.readAllBytes();
                }
            });

            // Parse the raw HTTP response body back into a SOAPMessage.
            SOAPMessage soapResponse = MessageFactory.newInstance()
                    .createMessage(null, new ByteArrayInputStream(responseBytes));

            Map<String, Object> result = new HashMap<>();
            result.put("ResponseBody", new ByteArrayInputStream(responseBytes));
            result.put("ResponseMessage", soapResponse);

            return result;

        } catch (URISyntaxException e) {
            throw new IOException("Invalid SOAP endpoint URI: " + destination, e);
        } catch (SOAPException e) {
            throw new SOAPException("Failed to parse SOAP response from: " + destination, e);
        }
    }

    private static Properties loadProperties(){
        Properties properties = new Properties();
        try {
            InputStream inputStream = WSDLHelper.class.getClassLoader().getResourceAsStream("org.assimbly.soap.cfg");
            properties.load(inputStream);
        } catch (Exception e) {
            LOG.error("Error to load properties file", e);
        }

        return properties;
    }
}