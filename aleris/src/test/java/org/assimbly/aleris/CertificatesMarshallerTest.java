package org.assimbly.aleris;

import org.apache.commons.io.IOUtils;

import org.junit.jupiter.api.Test;

import org.assimbly.aleris.certificate.*;


import jakarta.xml.bind.JAXBException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CertificatesMarshallerTest {

    /**
     * Tests whether instances of Certificates are marshalled to the XML format specified by Euramax.
     * It ensures that the correct JAXB annotations are used.
     * @throws jakarta.xml.bind.JAXBException
     * @throws IOException
     */
    @Test
    public void test() throws JAXBException, IOException {
        final Certificates certificates = createTestCertificates();
        CertificatesMarshaller marshaller = new CertificatesMarshaller();
        final String marshalledCertificates = marshaller.marshall(certificates);
        final String expectedResult = readMarshalledCertificateFromFile();

        assertEquals(expectedResult, marshalledCertificates);
    }

    private Certificates createTestCertificates() {
        Company issuer = new Company("issuer", "123", "456");
        Company customer = new Company("customer", "789", "012");
        Certificate certificate = new Certificate("123", "2016-02-01", issuer, customer);
        Component baseMetal = new Component("Al", "Aluminium", "1");
        Component component = new Component("Fe", "Iron", "0.01");
        ChemicalComposition chemicalComposition = new ChemicalComposition("%", baseMetal);
        chemicalComposition.addComponent(component);
        StockUnit stockUnit = new StockUnit("stockUnitId", "ingotCase", chemicalComposition);
        MechanicalProperty mechanicalProperty = new MechanicalProperty("code", "description", "value", "unit");
        stockUnit.addMechanicalProperty(mechanicalProperty);
        certificate.addStockUnit(stockUnit);
        Certificates certificates = new Certificates();
        certificates.addCertificate(certificate);

        return certificates;
    }

    private String readMarshalledCertificateFromFile() throws IOException {
        return IOUtils.toString(this.getClass().getResourceAsStream("/marshall/certificates.xml"),"UTF-8");
    }
}
