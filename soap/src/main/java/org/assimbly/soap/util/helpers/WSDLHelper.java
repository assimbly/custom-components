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
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import org.apache.hc.core5.util.Timeout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.assimbly.soap.cache.WSDLCache;
import org.assimbly.soap.domain.SoapHttpHeader;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import jakarta.xml.soap.SOAPConnection;
import jakarta.xml.soap.SOAPConnectionFactory;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPMessage;


public final class WSDLHelper {

    private static final Logger LOG = LoggerFactory.getLogger(WSDLHelper.class);
    private static final String CACHE_EXPIRATION_PROPERTY = "soap.cacheExpirationInHours";
    private static final Properties prop = loadProperties("org.assimbly.soap.cfg");

    public static Definition retrieve(String params, String wsdl, List<SoapHttpHeader> httpHeaders) throws WSDLException, IOException, URISyntaxException {
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

    protected static void fetchWSDL(File file, String location, List<SoapHttpHeader> httpHeaders) throws URISyntaxException, IOException {

        // 1. Use Timeout.ofMilliseconds for configuration
        RequestConfig config = RequestConfig.custom()
                .setConnectionRequestTimeout(Timeout.ofMilliseconds(20000))
                .setResponseTimeout(Timeout.ofMilliseconds(20000))
                .build();

        // 2. Use HttpClients.custom() or .createDefault()
        // It is best practice to use try-with-resources for the client
        try (CloseableHttpClient client = HttpClients.custom()
                .setDefaultRequestConfig(config)
                .build()) {

            HttpGet request = new HttpGet(new URI(location));

            if (httpHeaders != null) {
                httpHeaders.forEach(httpHeader -> request.setHeader(httpHeader.getName(), httpHeader.getValue()));
            }

            // 3. execute() now requires a ResponseHandler or careful handling.
            // For a direct migration of your logic:
            client.execute(request, response -> {
                // This lambda handles the ClassicHttpResponse safely
                try (BufferedInputStream wsdl = new BufferedInputStream(response.getEntity().getContent())) {
                    FileUtils.copyInputStreamToFile(wsdl, file);
                }
                return null; // The handler requires a return value
            });
        }
    }

    public static Map<String, Object> execute(String destination, SOAPMessage request, Exchange exchange) throws SOAPException, IOException {
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPMessage soapResponse;
        try (SOAPConnection soapConnection = soapConnectionFactory.createConnection()) {

            /*
             * Write the request message to a string so we can put in the header.
             * The header "Generated-Request" will have the generated request which
             * can be use as a debug.
             */

            ByteArrayOutputStream requestStream = new ByteArrayOutputStream();
            request.writeTo(requestStream);
            String requestMessage = new String(requestStream.toByteArray(), StandardCharsets.UTF_8);

            URL endpoint = new URL(null, destination, new URLTimeoutHandler());

            exchange.getIn().setHeader("Generated-Request", requestMessage);

            // Call the webservice with the specified URL in the WSDL.
            soapResponse = soapConnection.call(request, endpoint);

        }

        // Write the SOAP Response to the out body.

        ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
        soapResponse.writeTo(responseStream);

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(responseStream.toByteArray());

        Map<String, Object> result = new HashMap<>();
        result.put("ResponseBody", inputStream);
        result.put("ResponseMessage", soapResponse);

        return result;
    }

    private static Properties loadProperties(String filename){
        Properties properties = new Properties();
        try {
            InputStream inputStream = WSDLHelper.class.getClassLoader().getResourceAsStream(filename);
            properties.load(inputStream);
        } catch (Exception e) {
            LOG.error("Error to load properties file", e);
        }

        return properties;
    }

    public static class URLTimeoutHandler extends URLStreamHandler {

        @Override
        protected URLConnection openConnection(URL url) throws IOException {
            URL target = new URL(url.toString());

            URLConnection connection = target.openConnection();

            // Connection settings
            connection.setConnectTimeout(10000); // 10 sec
            connection.setReadTimeout(30000); // 1 min

            return(connection);
        }
    }
}