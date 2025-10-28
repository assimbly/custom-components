package org.assimbly.pdf;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.component.ResourceEndpoint;
import org.apache.camel.spi.UriEndpoint;
import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.assimbly.util.helper.Base64Helper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@UriEndpoint(
        firstVersion = "4.2.0",
        scheme = "pdf-transform",
        title = "PDF Transform Component",
        syntax = "pdf-transform:uri"
)
public class PdfEndpoint extends ResourceEndpoint {

    private String uri;
    public PdfEndpoint() {
    }

    public PdfEndpoint(String uri, PdfComponent component, String resourceUri) {
        super(uri, component, resourceUri);

        this.uri = uri;
    }

    public byte[] getPdfTemplate() throws IOException {

        String resourceUri = getResourceUri();

        InputStream data = getResourceAsInputStream();

        if(resourceUri.startsWith("ref")){
            String base64String = convertStreamToString(data);
            return Base64Helper.unmarshal(base64String);
        }

        return IOUtils.toByteArray(data);

    }

    private String convertStreamToString(InputStream inputStream) {
        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8).useDelimiter("\\A")) {
            return scanner.hasNext() ? scanner.next() : "";
        }
    }

    @Override
    protected void onExchange(Exchange exchange) throws Exception {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] template = getPdfTemplate();

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

            exchange.getIn().setBody(baos.toByteArray());
            exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/pdf");

        }

    }

}
