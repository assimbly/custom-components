package org.assimbly.aleris;

import org.assimbly.aleris.certificate.Certificates;
import org.assimbly.aleris.converter.AlerisCertificateConverter;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class AlerisTxtToXmlProcessor implements Processor {
    private static final AlerisCertificateConverter converter = new AlerisCertificateConverter();
    private static final CertificatesMarshaller marshaller = new CertificatesMarshaller();

    public void process(Exchange exchange) {
        String input = exchange.getIn().getBody(String.class);
        Certificates certificates = converter.convert(input);

        String marshalledCertificates = marshaller.marshall(certificates);
        exchange.getIn().setBody(marshalledCertificates);
    }
}
