package org.assimbly.pdf;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.assimbly.util.helper.Base64Helper;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PdfProcessor implements Processor {

    private PdfEndpoint endpoint;

    public PdfProcessor(PdfEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        byte[] template = endpoint.requestPdfTemplate();

        try(PDDocument document = PDDocument.load(template)) {

            PDDocumentCatalog docCatalog = document.getDocumentCatalog();
            PDAcroForm acroForm = docCatalog.getAcroForm();

            Message in = exchange.getIn();

            acroForm.getFields().stream()
                    .filter(pdField -> in.getHeaders().containsKey(pdField.getFullyQualifiedName()))
                    .forEach(pdField -> {
                        try {
                            pdField.setValue(in.getHeader(pdField.getFullyQualifiedName(), String.class));
                            pdField.setReadOnly(true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });

            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 BufferedOutputStream bos = new BufferedOutputStream(baos)) {
                document.save(bos);

                exchange.getIn().setBody(baos.toByteArray());
            }

            exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/pdf");
        }
    }
}
