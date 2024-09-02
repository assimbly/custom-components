package org.assimbly.soap.util.helpers;

import org.apache.camel.Exchange;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
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
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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

        Files.createDirectories(Paths.get(file.getParent()));

        Definition definition;

        try {
            fetchWSDL(file, url, httpHeaders);

            definition = reader.readWSDL(file.getAbsolutePath());
            LOG.info("WSDL has been fetched and cached successfully.");

        } catch(Exception e) {
            WSDLCache.INSTANCE.remove(url);

            WSDLException exp = new WSDLException("500", "Invalid WSDL or WSDL not found at: "+url);
            throw exp;
        }

        return definition;
    }

    private static String prepareUrl(String params, String wsdl) {
        if (params == null || params.isEmpty())
            return wsdl;

        return String.format("%s?%s", wsdl, params);
    }

    protected static void fetchWSDL(File file, String location, List<SoapHttpHeader> httpHeaders) throws URISyntaxException, IOException {
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(20000)
                .setSocketTimeout(20000)
                .build();

        HttpClient client = HttpClientBuilder.create()
                .setDefaultRequestConfig(config)
                .build();

        HttpGet request = new HttpGet(new URI(location));

        httpHeaders.forEach(httpHeader -> request.setHeader(httpHeader.getName(), httpHeader.getValue()));

        HttpResponse response = client.execute(request);

        BufferedInputStream wsdl = new BufferedInputStream(response.getEntity().getContent());

        FileUtils.copyInputStreamToFile(wsdl, file);
    }

    public static Map<String, Object> execute(String destination, SOAPMessage request, Exchange exchange) throws SOAPException, IOException {
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

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
        SOAPMessage soapResponse = soapConnection.call(request, endpoint);

        soapConnection.close();

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
        } finally {
            return properties;
        }
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