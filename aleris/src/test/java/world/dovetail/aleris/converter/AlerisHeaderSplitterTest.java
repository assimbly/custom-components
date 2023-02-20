package world.dovetail.aleris.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlerisHeaderSplitterTest {
    private AlerisHeaderSplitter splitter;

    @Before
    public void setUp() {
        splitter = new AlerisHeaderSplitter();
    }

    @Test
    public void getDutchCustomerName() {
        String customerName = splitter.getCustomerName("line1\nline2\n   KLANT : BEDRIJFSNAAM B.V. \nline4\nline5");
        Assert.assertEquals("BEDRIJFSNAAM B.V.", customerName);
    }

    @Test
    public void getEnglishCustomerName() {
        String customerName = splitter.getCustomerName("line1\nline2\n   CUSTOMER : BEDRIJFSNAAM B.V. \nline4\nline5");
        Assert.assertEquals("BEDRIJFSNAAM B.V.", customerName);
    }

    @Test(expected = IllegalAlerisCertificateException.class)
    public void getNonExistingCustomerName() {
        splitter.getCustomerName("");
    }

    @Test
    public void getDutchCustomerOrderNumber() {
        String customerOrderNumber = splitter.getCustomerOrderNumber("line1\nline2\n  UW ORDERNUMMER : 12345 ABCD KLANT : KLANTNAAM\nline4\nline5");
        Assert.assertEquals("12345 ABCD", customerOrderNumber);
    }

    @Test
    public void getEnglishCustomerOrderNumber() {
        String customerOrderNumber = splitter.getCustomerOrderNumber("line1\nline2\n  YOUR ORDER NUMBER : 12345 ABCD CUSTOMER : KLANTNAAM\nline4\nline5");
        Assert.assertEquals("12345 ABCD", customerOrderNumber);
    }

    @Test(expected = IllegalAlerisCertificateException.class)
    public void getNonExistingCustomerOrderNumber() {
        splitter.getCustomerOrderNumber("");
    }

    @Test
    public void getDutchIssuerOrderNumber() {
        String issuerOrderNumber = splitter.getIssuerOrderNumber("line1\nline2\n  ONS ORDERNUMMER : 88429/10   STRAATNAAM\nline4\nline5");
        Assert.assertEquals("88429/10", issuerOrderNumber);
    }

    @Test
    public void getEnglishIssuerOrderNumber() {
        String issuerOrderNumber = splitter.getIssuerOrderNumber("line1\nline2\n  OUR ORDER NUMBER : 88429/10   STRAATNAAM\nline4\nline5");
        Assert.assertEquals("88429/10", issuerOrderNumber);
    }

    @Test(expected = IllegalAlerisCertificateException.class)
    public void getNonExistingIssuerOrderNumber() {
        splitter.getIssuerOrderNumber("");
    }

    @Test
    public void getDutchIssuerOrderNumberPartOne() {
        String issuerOrderNumber = splitter.getIssuerOrderNumberPartOne("line1\nline2\n  ONS ORDERNUMMER : 88429/10   STRAATNAAM\nline4\nline5");
        Assert.assertEquals("88429", issuerOrderNumber);
    }

    @Test
    public void getEnglishIssuerOrderNumberPartOne() {
        String issuerOrderNumber = splitter.getIssuerOrderNumberPartOne("line1\nline2\n  OUR ORDER NUMBER : 88429/10   STRAATNAAM\nline4\nline5");
        Assert.assertEquals("88429", issuerOrderNumber);
    }

    @Test(expected = IllegalAlerisCertificateException.class)
    public void getNonExistingIssuerOrderNumberPartOne() {
        splitter.getIssuerOrderNumberPartOne("");
    }

    @Test
    public void getDutchDocumentNumber() {
        String documentNumber = splitter.getDocumentNumber("line1\nline2\n  DOC : V/0080519536    DATUM : 2016\nline4\nline5");
        Assert.assertEquals("V/0080519536", documentNumber);
    }


    @Test
    public void getEnglishDocumentNumber() {
        String documentNumber = splitter.getDocumentNumber("line1\nline2\n  DOC : V/0080519536    DATE : 2016\nline4\nline5");
        Assert.assertEquals("V/0080519536", documentNumber);
    }

    @Test(expected = IllegalAlerisCertificateException.class)
    public void getNonExistingDocumentNumber() {
        splitter.getDocumentNumber("");
    }

    @Test
    public void getDutchDate() {
        String date = splitter.getDate("line1\nline2\n  DATUM : 2016-03-24    PROD. REF.\nline4\nline5");
        Assert.assertEquals("2016-03-24", date);
    }

    @Test
    public void getEnglishDate() {
        String date = splitter.getDate("line1\nline2\n  DATE  : 2016-03-24    PROD. REF.\nline4\nline5");
        Assert.assertEquals("2016-03-24", date);
    }

    @Test(expected = IllegalAlerisCertificateException.class)
    public void getNonExistingDate() {
        splitter.getDate("");
    }
}
