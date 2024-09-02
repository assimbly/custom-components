package org.assimbly.pdftotext;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.http.MediaType;

import java.io.InputStream;

public class PdfToTextProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {

        byte[] input = exchange.getIn().getBody(byte[].class);

        PDDocument document = Loader.loadPDF(input);

        PDFTextStripper stripper = new PDFTextStripper();

        // So the order is guaranteed in output txt (in order for regex's to match properly)
        // When false the stripper extracts the text in the order it appears in the PDF page content stream.
        // This order can be totally mangled (because in the content stream you use operators which can position the next printed text anywhere on the page)
        stripper.setSortByPosition(true);

        String output = stripper.getText(document);
        document.close();

        exchange.getIn().setHeader(Exchange.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
        exchange.getIn().setBody(output);
    }
}
