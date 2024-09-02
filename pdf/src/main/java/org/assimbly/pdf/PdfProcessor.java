package org.assimbly.pdf;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessReadBuffer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.assimbly.util.helper.Base64Helper;

import java.io.*;

public class PdfProcessor implements Processor {

    private PdfEndpoint endpoint;

    public PdfProcessor(PdfEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] template = endpoint.requestPdfTemplate();

        try(PDDocument document = Loader.loadPDF(template)) {

            PDDocumentCatalog docCatalog = document.getDocumentCatalog();
            PDAcroForm acroForm = docCatalog.getAcroForm();

            Message in = exchange.getIn();

            acroForm.getFields().stream()
                    .filter(pdfField -> in.getHeaders().containsKey(pdfField.getFullyQualifiedName()))
                    .forEach(pdfField -> {
                        try {
                            pdfField.setValue(in.getHeader(pdfField.getFullyQualifiedName(), String.class));
                            pdfField.setReadOnly(true);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });


            document.save(baos);
            document.close();

            exchange.getIn().setBody(baos.toByteArray());
            exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/pdf");

        }
    }
}
