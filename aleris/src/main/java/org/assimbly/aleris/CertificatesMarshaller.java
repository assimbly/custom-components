package org.assimbly.aleris;

import org.assimbly.aleris.certificate.Certificates;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.StringWriter;

public class CertificatesMarshaller {
    public String marshall(Certificates certificates) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Certificates.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(certificates, stringWriter);

            return stringWriter.toString();
        } catch (JAXBException jaxbException) {
            throw new RuntimeException("Unable to marshall certificates", jaxbException);
        }
    }
}
