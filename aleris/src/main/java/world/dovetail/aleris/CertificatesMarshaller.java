package world.dovetail.aleris;

import world.dovetail.aleris.certificate.Certificates;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
