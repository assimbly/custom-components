package org.assimbly.aleris.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlerisCertificateSplitterTest {
    private AlerisCertificateSplitter splitter;

    @Before
    public void setUp() {
        this.splitter = new AlerisCertificateSplitter();
    }

    @Test
    public void getDutchHeader() {
        String header = splitter.getHeader("line1\nline2\nSPECIFICATIES:");
        Assert.assertEquals("line1\nline2", header);
    }

    @Test
    public void getEnglishHeader() {
        String header = splitter.getHeader("line1\nline2\nDESCRIPTION:");
        Assert.assertEquals("line1\nline2", header);
    }

    @Test(expected = IllegalAlerisCertificateException.class)
    public void getNonExistingHeader() {
        splitter.getHeader("");
    }

    @Test
    public void getChemicalAnalysis() {
        String chemicalAnalysis = splitter.getChemicalAnalysis("==\nline1\n==\nline2\nline3\n==\nline4\n==\n");
        Assert.assertEquals("line2\nline3", chemicalAnalysis);
    }

    @Test(expected = IllegalAlerisCertificateException.class)
    public void getNonExistingChemicalAnalysis() {
        splitter.getChemicalAnalysis("");
    }

    @Test
    public void getDutchMechanicalProperties() {
        String certificate = "==\n==\n==\n==\nline1\nline2\nKISTINHOUD : ROL DEELROL KISTNUMMER AANTAL";
        String mechanicalProperties = splitter.getMechanicalProperties(certificate);
        Assert.assertEquals("line1\nline2", mechanicalProperties);
    }

    @Test
    public void getEnglishMechanicalProperties() {
        String certificate = "==\n==\n==\n==\nline1\nline2\nCONT.PALLET : COIL SUBCOIL PALLETNUMBER QUANTITY";
        String mechanicalProperties = splitter.getMechanicalProperties(certificate);
        Assert.assertEquals("line1\nline2", mechanicalProperties);
    }

    @Test(expected = IllegalAlerisCertificateException.class)
    public void getNonExistingMechanicalProperties() {
        splitter.getMechanicalProperties("");
    }

    @Test
    public void getDutchCrateContent() {
        String certificate = "KISTINHOUD : ROL DEELROL KISTNUMMER AANTAL\nline1\nline2\n";
        String crateContent = splitter.getCrateContent(certificate);
        Assert.assertEquals("line1\nline2", crateContent);
    }

    @Test
    public void getEnglishCrateContent() {
        String certificate = "CONT.PALLET : COIL SUBCOIL PALLETNUMBER QUANTITY\nline1\nline2\n";
        String crateContent = splitter.getCrateContent(certificate);
        Assert.assertEquals("line1\nline2", crateContent);
    }

    @Test(expected = IllegalAlerisCertificateException.class)
    public void getNonExistingCrateContent() {
        splitter.getCrateContent("");
    }
}
