package org.assimbly.aleris.converter;

import org.apache.commons.io.IOUtils;
import org.assimbly.aleris.CertificatesCreator;
import org.assimbly.aleris.certificate.Certificates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AlerisCertificateConverterTest {
    private static final CertificatesCreator creator = new CertificatesCreator();
    private AlerisCertificateConverter converter;

    @BeforeEach
    public void setUp() {
        this.converter = new AlerisCertificateConverter();
    }

    /**
     * Tests whether a certificate for Euramax Roermond is parsed correctly.
     * @throws IOException
     */
    @Test
    public void roermondTest() throws IOException {
        List<String> elementNames = Arrays.asList("Si", "Fe", "Cu", "Mn", "Mg", "Cr", "Ti", "Zn");

        final Certificates actualCertificates = converter.convert(readCertificateFromResources("/converter/roermond.cert"));
        final Certificates expectedCertificates = createCertificates(false, elementNames, 1, 1, 1);

        Assertions.assertEquals(expectedCertificates, actualCertificates);
    }

    /**
     * Tests whether a certificate for Euramax Corby is parsed correctly.
     * @throws IOException
     */
    @Test
    public void corbyTest() throws IOException {
        List<String> elementNames = Arrays.asList("Si", "Fe", "Cu", "Mn", "Mg", "Cr", "Ti", "Zn");

        final Certificates actualCertificates = converter.convert(readCertificateFromResources("/converter/corby.cert"));
        final Certificates expectedCertificates = createCertificates(true, elementNames, 2, 1, 1);

        Assertions.assertEquals(expectedCertificates, actualCertificates);
    }

    /**
     * Tests whether a certificate with multiple "Geuts" and tests is parsed correctly.
     * @throws IOException
     */
    @Test
    public void multipleTest() throws IOException {
        List<String> elementNames = Arrays.asList("Si", "Fe", "Cu", "Mn", "Mg", "Cr", "Ti", "Zn");

        final Certificates actualCertificates = converter.convert(readCertificateFromResources("/converter/multiple.cert"));
        final Certificates expectedCertificates = createCertificates(false, elementNames, 3, 2, 1);

        Assertions.assertEquals(expectedCertificates, actualCertificates);
    }

    /**
     * Tests whether a certificate with few elements in the chemical analysis is parsed correctly.
     * @throws IOException
     */
    @Test
    public void fewElementsTest() throws IOException {
        List<String> elementNames = Arrays.asList("Si", "Fe", "Cu", "Mn", "Mg", "Cr", "Zn");

        final Certificates actualCertificates = converter.convert(readCertificateFromResources("/converter/few-elements.cert"));
        final Certificates expectedCertificates = createCertificates(false, elementNames, 4, 1, 1);

        Assertions.assertEquals(expectedCertificates, actualCertificates);
    }

    /**
     * Tests whether a certificate with additional constraints in the chemical analysis is parsed correctly.
     * @throws IOException
     */
    @Test
    public void additionalConstraintsTest() throws IOException {
        List<String> elementNames = Arrays.asList("Si", "Fe", "Cu", "Mn", "Mg", "Cr", "Ti", "Zn");

        final Certificates actualCertificates = converter.convert(readCertificateFromResources("/converter/additional-constraints.cert"));
        final Certificates expectedCertificates = createCertificates(false, elementNames, 5, 1, 1);

        Assertions.assertEquals(expectedCertificates, actualCertificates);
    }

    /**
     * Tests whether an English certificate is parsed correctly.
     * @throws IOException
     */
    @Test
    public void englishTest() throws IOException {
        List<String> elementNames = Arrays.asList("Si", "Fe", "Cu", "Mn", "Mg", "Cr", "Ti", "Zn");

        final Certificates actualCertificates = converter.convert(readCertificateFromResources("/converter/english.cert"));
        final Certificates expectedCertificates = createCertificates(true, elementNames, 1, 1, 1);

        Assertions.assertEquals(expectedCertificates, actualCertificates);
    }

    /**
     * Tests whether a certificate that spans two pages is parsed correctly.
     * @throws IOException
     */
    @Test
    public void twoPagesTest() throws IOException {
        List<String> elementNames = Arrays.asList("Si", "Fe", "Cu", "Mn", "Mg", "Ti", "Zn", "Al");

        final Certificates actualCertificates = converter.convert(readCertificateFromResources("/converter/two-pages.cert"));
        final Certificates expectedCertificates = createCertificates(false, elementNames, 2, 1, 2);

        Assertions.assertEquals(expectedCertificates, actualCertificates);
    }

    /**
     * Tests whether a certificate that contains a sub coil is parsed correctly.
     * @throws IOException
     */
    @Test
    public void subCoilTest() throws IOException {
        List<String> elementNames = Arrays.asList("Si", "Fe", "Cu", "Mn", "Mg", "Cr", "Ti", "Zn");

        final Certificates actualCertificates = converter.convert(readCertificateFromResources("/converter/sub-coil.cert"));
        final Certificates expectedCertificates = createCertificates(false, elementNames, 6, 1, 1);

        Assertions.assertEquals(expectedCertificates, actualCertificates);
    }

    /**
     * Tests whether a certificate that contains multiple mechanical properties per
     * coil is parsed correctly.
     * @throws IOException
     */
    @Test
    public void propertiesPerSubCoilTest() throws IOException {
        List<String> elementNames = Arrays.asList("Si", "Fe", "Cu", "Mn", "Mg", "Ti", "Zn", "Al");

        final Certificates actualCertificates = converter.convert(readCertificateFromResources("/converter/properties-per-sub-coil.cert"));
        final Certificates expectedCertificates = createCertificates(true, elementNames, 6, 1, 2);

        Assertions.assertEquals(expectedCertificates, actualCertificates);
    }

    private String readCertificateFromResources(String resourceName) throws IOException {
        return IOUtils.toString(this.getClass().getResourceAsStream(resourceName),"UTF-8");
    }

    private Certificates createCertificates(boolean corbyCertificate, List<String> elementNames, int i, int numberOfStockUnits, int numberOfPropertyRowsPerStockUnit) {
        if (corbyCertificate) {
            return creator.create(i, "Aleris", "C0870", "EURAMAX COATED PRODUCTS LTD", "C",
                    elementNames, numberOfStockUnits, numberOfPropertyRowsPerStockUnit);
        } else {
            return creator.create(i, "Aleris", "07410", "EURAMAX COATED PRODUCTS B.V.", "R",
                    elementNames, numberOfStockUnits, numberOfPropertyRowsPerStockUnit);
        }
    }
}