package org.assimbly.pdftotext;

import org.apache.camel.Component;
import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.support.ProcessorEndpoint;

@UriEndpoint(
        firstVersion = "",
        scheme = "pdftotext",
        title = "PDF To Text Component",
        syntax = "pdftotext:"
)
public class PdfToTextEndpoint extends ProcessorEndpoint {
    public PdfToTextEndpoint(String uri, Component component) {
        super(uri, component);
    }

    @Override
    protected Processor createProcessor() {
        return new PdfToTextProcessor();
    }
}
