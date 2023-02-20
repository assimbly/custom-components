package org.assimbly.pdftotext;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

import java.util.Map;

/**
 * This component is meant as a temporary replacement for Camel's PDF component.
 * At the moment, the official Camel component cannot read PDFs from files.
 *
 * http://camel.465427.n5.nabble.com/Failing-to-extract-text-with-Camel-PDF-component-td5783483.html
 *
 * Once this functionality is added to the official component, this replacement
 * can be removed.
 */

public class PdfToTextComponent extends DefaultComponent {

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) {
        return new PdfToTextEndpoint(uri, this);
    }
}
