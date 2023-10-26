package org.assimbly.aleris.converter;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlerisCertificateSplitterTest {
    private AlerisCertificateSplitter splitter;

    @BeforeEach
    public void setUp() {
        this.splitter = new AlerisCertificateSplitter();
    }

    @Test
    public void getDutchHeader() {
        String header = splitter.getHeader("line1\nline2\nSPECIFICATIES:");
        assertEquals("line1\nline2", header);
    }

    @Test
    public void getEnglishHeader() {
        String header = splitter.getHeader("line1\nline2\nDESCRIPTION:");
        assertEquals("line1\nline2", header);
    }

    @Test
    public void getNonExistingHeader() {
        Assertions.assertThrows(IllegalAlerisCertificateException.class, () -> {
            splitter.getHeader("");
        });
    }

    @Test
    public void getChemicalAnalysis() {
        String chemicalAnalysis = splitter.getChemicalAnalysis("==\nline1\n==\nline2\nline3\n==\nline4\n==\n");
        assertEquals("line2\nline3", chemicalAnalysis);
    }

    @Test
    public void getNonExistingChemicalAnalysis() {
        Assertions.assertThrows(IllegalAlerisCertificateException.class, () -> {
            splitter.getChemicalAnalysis("");
        });
    }

    @Test
    public void getDutchMechanicalProperties() {
        String certificate = "==\n==\n==\n==\nline1\nline2\nKISTINHOUD : ROL DEELROL KISTNUMMER AANTAL";
        String mechanicalProperties = splitter.getMechanicalProperties(certificate);
        assertEquals("line1\nline2", mechanicalProperties);
    }

    @Test
    public void getEnglishMechanicalProperties() {
        String certificate = "==\n==\n==\n==\nline1\nline2\nCONT.PALLET : COIL SUBCOIL PALLETNUMBER QUANTITY";
        String mechanicalProperties = splitter.getMechanicalProperties(certificate);
        assertEquals("line1\nline2", mechanicalProperties);
    }

    @Test
    public void getNonExistingMechanicalProperties(){
        Assertions.assertThrows(IllegalAlerisCertificateException.class, () -> {
            splitter.getMechanicalProperties("");
        });
    }

    @Test
    public void getDutchCrateContent() {
        String certificate = "KISTINHOUD : ROL DEELROL KISTNUMMER AANTAL\nline1\nline2\n";
        String crateContent = splitter.getCrateContent(certificate);
        assertEquals("line1\nline2", crateContent);
    }

    @Test
    public void getEnglishCrateContent() {
        String certificate = "CONT.PALLET : COIL SUBCOIL PALLETNUMBER QUANTITY\nline1\nline2\n";
        String crateContent = splitter.getCrateContent(certificate);
        assertEquals("line1\nline2", crateContent);
    }

    @Test
    public void getNonExistingCrateContent() {
        Assertions.assertThrows(IllegalAlerisCertificateException.class, () -> {
            splitter.getCrateContent("");
        });
    }
}
