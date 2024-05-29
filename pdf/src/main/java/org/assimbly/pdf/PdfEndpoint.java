package org.assimbly.pdf;

import org.apache.camel.Processor;

import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.support.ProcessorEndpoint;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

@UriEndpoint(
        firstVersion = "4.2.0",
        scheme = "pdf-transform",
        title = "PDF Component",
        syntax = "pdf-transform:url"
)
public class PdfEndpoint extends ProcessorEndpoint {
    private PdfComponent component;
    private PdfConfiguration configuration;

    public PdfEndpoint(String uri, PdfComponent component, PdfConfiguration configuration) {
        super(uri, component);

        this.component = component;
        this.configuration = configuration;
    }

    public byte[] requestPdfTemplate() throws URISyntaxException, IOException {

        URI url = new URI(configuration.getUrl());

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);

        HttpResponse response = client.execute(get);

        InputStream data = response.getEntity().getContent();

        return IOUtils.toByteArray(data);
    }

    @Override
    protected Processor createProcessor() {
        return new PdfProcessor(this);
    }

    public PdfConfiguration getConfiguration() {
        return configuration;
    }

    @Override
    public PdfComponent getComponent() {
        return component;
    }
}
