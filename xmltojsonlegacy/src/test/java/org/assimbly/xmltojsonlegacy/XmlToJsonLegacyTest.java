package org.assimbly.xmltojsonlegacy;

import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

class XmlToJsonLegacyTest extends CamelTestSupport {

    private final ClassLoader classLoader = getClass().getClassLoader();

    @EndpointInject("mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce
    protected ProducerTemplate template;

    /*****************************************
    ** Example 1
    *****************************************/

    @Test
    void testXmlJson_1_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_1_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_1_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_1_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_1_FTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FTFFTF.json"
        );
    }

    @Test
    void testXmlJson_1_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_1_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_1_FTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FTFTTF.json"
        );
    }

    @Test
    void testXmlJson_1_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_1_FTTTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TrimSpaces_SkipNamespaces",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FTTTFF.json"
        );
    }

    @Test
    void testXmlJson_1_FTTTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TrimSpaces_SkipNamespaces_TypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FTTTFT.json"
        );
    }

    @Test
    void testXmlJson_1_FTTTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TrimSpaces_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FTTTTT.json"
        );
    }

    @Test
    void testXmlJson_1_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_1_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_1_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_1_TTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TTFFTF.json"
        );
    }

    @Test
    void testXmlJson_1_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_1_TTFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TTFTFF.json"
        );
    }

    @Test
    void testXmlJson_1_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_1_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_1_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TTTFFT.json"
        );
    }

    @Test
    void testXmlJson_1_TTTTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_SkipNamespaces",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TTTTFF.json"
        );
    }

    @Test
    void testXmlJson_1_TTTTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_SkipNamespaces_TypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TTTTFT.json"
        );
    }

    @Test
    void testXmlJson_1_TTTTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TTTTTF.json"
        );
    }

    /*****************************************
     ** Example 2
     *****************************************/

    @Test
    void testXmlJson_2_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_2_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_2_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_2_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_2_FTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_FTFFTF.json"
        );
    }

    @Test
    void testXmlJson_2_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_2_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_2_FTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_FTFTTF.json"
        );
    }

    @Test
    void testXmlJson_2_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_2_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_2_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_2_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_2_TTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_TTFFTF.json"
        );
    }

    @Test
    void testXmlJson_2_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_2_TTFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_TTFTFF.json"
        );
    }

    @Test
    void testXmlJson_2_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_2_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_2_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 3
     *****************************************/

    @Test
    void testXmlJson_3_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_3_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_3_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_3_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_3_FTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_FTFFTF.json"
        );
    }

    @Test
    void testXmlJson_3_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_3_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_3_FTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_FTFTTF.json"
        );
    }

    @Test
    void testXmlJson_3_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_3_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_3_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_3_TTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_TTFFTF.json"
        );
    }

    @Test
    void testXmlJson_3_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_3_TTFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_TTFTFF.json"
        );
    }

    @Test
    void testXmlJson_3_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_3_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_3_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 4
     *****************************************/

    @Test
    void testXmlJson_4_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_4_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_4_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_4_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_4_FTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_FTFFTF.json"
        );
    }

    @Test
    void testXmlJson_4_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_4_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_4_FTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_FTFTTF.json"
        );
    }

    @Test
    void testXmlJson_4_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_4_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_4_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_4_TTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_TTFFTF.json"
        );
    }

    @Test
    void testXmlJson_4_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_4_TTFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_TTFTFF.json"
        );
    }

    @Test
    void testXmlJson_4_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_4_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_4_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 5
     *****************************************/

    @Test
    void testXmlJson_5_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_5_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_5_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_5_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_5_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_5_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_5_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 6
     *****************************************/

    @Test
    void testXmlJson_6_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_6_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_6_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_6_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_6_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_6_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_6_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 7
     *****************************************/

    @Test
    void testXmlJson_7_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_7_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_7_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_7_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_7_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_7_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_7_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 8
     *****************************************/

    @Test
    void testXmlJson_8_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_8_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_8_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_8_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_8_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_8_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_8_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 9
     *****************************************/

    @Test
    void testXmlJson_9_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_9_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_9_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_9_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_9_FTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_FTFFTF.json"
        );
    }

    @Test
    void testXmlJson_9_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_9_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_9_FTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_FTFTTF.json"
        );
    }

    @Test
    void testXmlJson_9_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_9_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_9_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_9_TTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_TTFFTF.json"
        );
    }

    @Test
    void testXmlJson_9_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_9_TTFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_TTFTFF.json"
        );
    }

    @Test
    void testXmlJson_9_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_9_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_9_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 10
     *****************************************/

    @Test
    void testXmlJson_10_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_10_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_10_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_10_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_10_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_10_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_10_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 11
     *****************************************/

    @Test
    void testXmlJson_11_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_11_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_FFFFFT.json"
        );
    }


    @Test
    void testXmlJson_11_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_11_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_11_FTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_FTFFTF.json"
        );
    }

    @Test
    void testXmlJson_11_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_11_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_11_FTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_FTFTTF.json"
        );
    }

    @Test
    void testXmlJson_11_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_11_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_11_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_11_TTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_TTFFTF.json"
        );
    }

    @Test
    void testXmlJson_11_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_11_TTFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_TTFTFF.json"
        );
    }

    @Test
    void testXmlJson_11_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_11_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_11_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 12
     *****************************************/

    @Test
    void testXmlJson_12_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_12.xml",
                "xml-to-json/example_12_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_12_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_12.xml",
                "xml-to-json/example_12_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_12_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_12.xml",
                "xml-to-json/example_12_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_12_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_12.xml",
                "xml-to-json/example_12_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_12_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_12.xml",
                "xml-to-json/example_12_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_12_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_12.xml",
                "xml-to-json/example_12_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_12_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_12.xml",
                "xml-to-json/example_12_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 13
     *****************************************/

    @Test
    void testXmlJson_13_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_13_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_13_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_13_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_13_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_13_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_13_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_13_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_13_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_13_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 14
     *****************************************/

    @Test
    void testXmlJson_14_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_14_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_14_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_14_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_14_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_14_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_14_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_14_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_14_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_14_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 15
     *****************************************/

    @Test
    void testXmlJson_15_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_15_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_15_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_15_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_15_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_15_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_15_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_15_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_15_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_15_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_15_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 16
     *****************************************/

    @Test
    void testXmlJson_16_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_16_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_16_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_16_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_16_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_16_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_16_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_16_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_16_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_16_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_16_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 17
     *****************************************/

    @Test
    void testXmlJson_17_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_17_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_17_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_17_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_17_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_17_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_17_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_17_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_17_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_17_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_17_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 18
     *****************************************/

    @Test
    void testXmlJson_18_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_18_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_18_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_18_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_18_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_18_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_18_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_18_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_18_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_18_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_18_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 19
     *****************************************/

    @Test
    void testXmlJson_19_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_19_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_19_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_19_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_19_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_19_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_19_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_19_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_19_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_19_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_19_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_19_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 20
     *****************************************/

    @Test
    void testXmlJson_20_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_20_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_20_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_20_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_20_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_20_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_20_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_20_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_20_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_20_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_20_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_20_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 21
     *****************************************/

    @Test
    void testXmlJson_21_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_21_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_21_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_21_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_21_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_21_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_21_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_21_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_21_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_21_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_21_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_21_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 22
     *****************************************/

    @Test
    void testXmlJson_22_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_22_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_22_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_22_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_22_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_22_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_22_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_22_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_22_FTTTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TrimSpaces_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FTTTTF.json"
        );
    }

    @Test
    void testXmlJson_22_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_22_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_22_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_22_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 23
     *****************************************/

    @Test
    void testXmlJson_23_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_23_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_23_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_23_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_23_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_23_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_23_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_23_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_23_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_23_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_23_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_23_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 24
     *****************************************/

    @Test
    void testXmlJson_24_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_24_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_24_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_24_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_24_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_24_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_24_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_24_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_24_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_24_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_24_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_24_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_24_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 25
     *****************************************/

    @Test
    void testXmlJson_25_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_25_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_25_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_25_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_25_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_25_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_25_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_25_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_25_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_25_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_25_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_25_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_25_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_25_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 26
     *****************************************/

    @Test
    void testXmlJson_26_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_26_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_26_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_26_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_26_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_26_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_26_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_26_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_26_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_26_FTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FTFTTF.json"
        );
    }

    @Test
    void testXmlJson_26_FTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FTFFTF.json"
        );
    }

    @Test
    void testXmlJson_26_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_26_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_26_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_26_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_26_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_26_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_26_TTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_TTFFTF.json"
        );
    }

    @Test
    void testXmlJson_26_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_26_TTFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_TTFTFF.json"
        );
    }

    @Test
    void testXmlJson_26_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_26_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_26_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 27
     *****************************************/

    @Test
    void testXmlJson_27_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_27_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_27_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_27_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_27_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_27_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_27_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_27_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_27_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_27_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_27_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_27_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_27_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 28
     *****************************************/

    @Test
    void testXmlJson_28_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_28.xml",
                "xml-to-json/example_28_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_28_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_28.xml",
                "xml-to-json/example_28_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_28_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_28.xml",
                "xml-to-json/example_28_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_28_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_28.xml",
                "xml-to-json/example_28_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_28_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_28.xml",
                "xml-to-json/example_28_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_28_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_28.xml",
                "xml-to-json/example_28_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_28_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_28.xml",
                "xml-to-json/example_28_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_28_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_28.xml",
                "xml-to-json/example_28_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_28_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_28.xml",
                "xml-to-json/example_28_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_28_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_28.xml",
                "xml-to-json/example_28_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_28_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_28.xml",
                "xml-to-json/example_28_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_28_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_28.xml",
                "xml-to-json/example_28_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_28_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_28.xml",
                "xml-to-json/example_28_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 29
     *****************************************/

    @Test
    void testXmlJson_29_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_29_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_29_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_29_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_29_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_29_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_29_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_29_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_29_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_29_FTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_FTFFTF.json"
        );
    }

    @Test
    void testXmlJson_29_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_29_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_29_FTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_FTFTTF.json"
        );
    }

    @Test
    void testXmlJson_29_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_29_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_29_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_29_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_29_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_29_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_29_TTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_TTFFTF.json"
        );
    }

    @Test
    void testXmlJson_29_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_29_TTFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_TTFTFF.json"
        );
    }

    @Test
    void testXmlJson_29_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_29_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_29_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_29.xml",
                "xml-to-json/example_29_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 30
     *****************************************/

    @Test
    void testXmlJson_30_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_30_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_30_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_30_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_30_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_30_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_30_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_30_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_30_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_30_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_30_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_30_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_30_FTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FTFFTF.json"
        );
    }

    @Test
    void testXmlJson_30_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_30_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_30_FTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FTFTTF.json"
        );
    }

    @Test
    void testXmlJson_30_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_30_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_30_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_30_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_30_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_30_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_30_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_30_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_30_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_30_TTFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_TTFFTF.json"
        );
    }

    @Test
    void testXmlJson_30_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_30_TTFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_TTFTFF.json"
        );
    }

    @Test
    void testXmlJson_30_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_30_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_30_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_30.xml",
                "xml-to-json/example_30_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 31
     *****************************************/

    @Test
    void testXmlJson_31_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_31_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_31_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_31_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_31_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_31_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_31_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_31_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_31_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_31_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_31_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_31_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_31_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_31_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_31_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_31_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_31_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_31_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_31_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_31_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_31_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_31.xml",
                "xml-to-json/example_31_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 32
     *****************************************/

    @Test
    void testXmlJson_32_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_32_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_32_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_32_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_32_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_32_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_32_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_32_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_32_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_32_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_32_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_32_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_32_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_32_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_32_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_32_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_32_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_32_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_32_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_32_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_32_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_32.xml",
                "xml-to-json/example_32_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 33
     *****************************************/

    @Test
    void testXmlJson_33_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_33_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_33_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_33_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_33_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_33_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_33_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_33_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_33_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_33_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_33_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_33_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_33_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_33_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_33_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_33_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_33_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_33_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_33_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_33_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_33_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_33.xml",
                "xml-to-json/example_33_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 34
     *****************************************/

    @Test
    void testXmlJson_34_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_34_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_34_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_34_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_34_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_34_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_34_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_34_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_34_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_34_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_34_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_34_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_34_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_34_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_34_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_34_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_34_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_34_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_34_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_34_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_34_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_34.xml",
                "xml-to-json/example_34_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 35
     *****************************************/

    @Test
    void testXmlJson_35_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_35_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_35_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_35_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_35_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_35_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_35_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_35_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_35_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_35_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_35_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_35_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_35_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_35_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_35_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_35_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_35_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_35_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_35_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_35_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_35_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_35.xml",
                "xml-to-json/example_35_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 36
     *****************************************/

    @Test
    void testXmlJson_36_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_36_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_36_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_36_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_36_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_36_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_36_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_36_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_36_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_36_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_36_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_36_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_36_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_36_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_36_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_36_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_36_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_36_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_36_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_36_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_36_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_36.xml",
                "xml-to-json/example_36_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 37
     *****************************************/

    @Test
    void testXmlJson_37_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_37_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_37_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_37_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_37_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_37_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_37_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_37_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_37_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_37_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_37_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_37_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_37_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_37_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_37_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_37_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_37_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_37_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_37_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_37_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_37_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_37.xml",
                "xml-to-json/example_37_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 38
     *****************************************/

    @Test
    void testXmlJson_38_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_38_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_38_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_38_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_38_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_38_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_38_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_38_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_38_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_38_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_38_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_38_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_38_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_38_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_38_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_38_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_38_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_38_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_38_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_38_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_38_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_38.xml",
                "xml-to-json/example_38_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 39
     *****************************************/

    @Test
    void testXmlJson_39_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_39_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_39_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_39_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_39_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_39_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_39_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_39_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_39_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_39_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_39_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_39_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_39_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_39_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_39_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_39_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_39_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_39_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_39_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_39_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_39_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_39.xml",
                "xml-to-json/example_39_TTFTTF.json"
        );
    }

    /*****************************************
     ** Example 40
     *****************************************/

    @Test
    void testXmlJson_40_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_40.xml",
                "xml-to-json/example_40_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_40_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_40.xml",
                "xml-to-json/example_40_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_40_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_40.xml",
                "xml-to-json/example_40_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_40_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_40.xml",
                "xml-to-json/example_40_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_40_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_40.xml",
                "xml-to-json/example_40_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_40_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_40.xml",
                "xml-to-json/example_40_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_40_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_40.xml",
                "xml-to-json/example_40_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_40_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_40.xml",
                "xml-to-json/example_40_FFFTTT.json"
        );
    }

    /*****************************************
     ** Example 41
     *****************************************/

    @Test
    void testXmlJson_41_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_41.xml",
                "xml-to-json/example_41_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_41_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_41.xml",
                "xml-to-json/example_41_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_41_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_41.xml",
                "xml-to-json/example_41_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_41_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_41.xml",
                "xml-to-json/example_41_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_41_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_41.xml",
                "xml-to-json/example_41_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_41_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_41.xml",
                "xml-to-json/example_41_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_41_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_41.xml",
                "xml-to-json/example_41_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_41_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_41.xml",
                "xml-to-json/example_41_FFFTTT.json"
        );
    }

    /*****************************************
     ** Example 42
     *****************************************/

    @Test
    void testXmlJson_42_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_42.xml",
                "xml-to-json/example_42_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_42_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_42.xml",
                "xml-to-json/example_42_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_42_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_42.xml",
                "xml-to-json/example_42_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_42_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_42.xml",
                "xml-to-json/example_42_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_42_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_42.xml",
                "xml-to-json/example_42_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_42_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_42.xml",
                "xml-to-json/example_42_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_42_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_42.xml",
                "xml-to-json/example_42_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_42_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_42.xml",
                "xml-to-json/example_42_FFFTTT.json"
        );
    }

    /*****************************************
     ** Example 43
     *****************************************/

    @Test
    void testXmlJson_43_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_43.xml",
                "xml-to-json/example_43_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_43_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_43.xml",
                "xml-to-json/example_43_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_43_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_43.xml",
                "xml-to-json/example_43_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_43_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_43.xml",
                "xml-to-json/example_43_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_43_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_43.xml",
                "xml-to-json/example_43_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_43_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_43.xml",
                "xml-to-json/example_43_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_43_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_43.xml",
                "xml-to-json/example_43_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_43_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_43.xml",
                "xml-to-json/example_43_FFFTTT.json"
        );
    }

    /*****************************************
     ** Example 44
     *****************************************/

    @Test
    void testXmlJson_44_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_44.xml",
                "xml-to-json/example_44_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_44_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_44.xml",
                "xml-to-json/example_44_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_44_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_44.xml",
                "xml-to-json/example_44_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_44_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_44.xml",
                "xml-to-json/example_44_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_44_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_44.xml",
                "xml-to-json/example_44_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_44_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_44.xml",
                "xml-to-json/example_44_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_44_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_44.xml",
                "xml-to-json/example_44_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_44_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_44.xml",
                "xml-to-json/example_44_FFFTTT.json"
        );
    }

    /*****************************************
     ** Example 45
     *****************************************/

    @Test
    void testXmlJson_45_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_45_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_45_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_45_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_45_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_45_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_45_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_45_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_45_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_45_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_45_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_45_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_45_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_45_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_45_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_45_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_45_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_45_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_45_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_45_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_45_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_45_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_45_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_45_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_45_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_45_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_45_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_45.xml",
                "xml-to-json/example_45_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 46
     *****************************************/

    @Test
    void testXmlJson_46_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_46_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_46_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_46_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_46_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_46_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_46_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_46_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_46_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_46_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_46_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_46_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_46_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_46_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_46_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_46_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_46_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_46_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_46_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_46_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_46_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_46_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_46_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_46_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_46_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_46_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_46_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_46.xml",
                "xml-to-json/example_46_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 47
     *****************************************/

    @Test
    void testXmlJson_47_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_47_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_47_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_47_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_47_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_47_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_47_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_47_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_47_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_47_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_47_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_47_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_47_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_47_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_47_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_47_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_47_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_47_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_47_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_47_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_47_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_47_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_47_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_47_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_47_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_47_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_47_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_47.xml",
                "xml-to-json/example_47_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 48
     *****************************************/

    @Test
    void testXmlJson_48_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_48_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_48_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_48_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_48_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_48_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_48_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_48_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_48_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_48_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_48_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_48_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_48_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_48_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_48_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_48_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_48_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_48_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_48_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_48_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_48_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_48_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_48_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_48_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_48_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_48_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_48_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_48.xml",
                "xml-to-json/example_48_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 49
     *****************************************/

    @Test
    void testXmlJson_49_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_49_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_49_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_49_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_49_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_49_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_49_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_49_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_49_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_49_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_49_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_49_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_49_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_49_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_49_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_49_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_49_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_49_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_49_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_49_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_49_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_49_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_49_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_49_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_49_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_49_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_49_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_49.xml",
                "xml-to-json/example_49_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 50
     *****************************************/

    @Test
    void testXmlJson_50_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_50_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_50_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_50_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_50_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_50_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_50_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_50_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_50_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_50_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_50_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_50_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_50_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_50_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_50_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_50_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_50_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_50_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_50_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_50_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_50_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_50_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_50_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_50_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_50_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_50_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_50_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_50.xml",
                "xml-to-json/example_50_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 51
     *****************************************/

    @Test
    void testXmlJson_51_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_51_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_51_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_51_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_51_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_51_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_51_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_51_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_51_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_51_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_51_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_51_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_51_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_51_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_51_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_51_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_51_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_51_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_51_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_51_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_51_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_51_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_51_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_51_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_51_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_51_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_51_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_51.xml",
                "xml-to-json/example_51_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 52
     *****************************************/

    @Test
    void testXmlJson_52_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_52_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_52_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_52_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_52_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_52_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_52_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_52_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_52_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_52_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_52_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_52_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_52_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_52_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_52_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_52_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_52_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_52_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_52_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_52_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_52_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_52_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_52_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_52_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_52_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_52_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_52_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_52.xml",
                "xml-to-json/example_52_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 53
     *****************************************/

    @Test
    void testXmlJson_53_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_53_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_53_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_53_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_53_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_53_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_53_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_53_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_53_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_53_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_53_FTFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FTFFFF.json"
        );
    }

    @Test
    void testXmlJson_53_FTFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FTFFFT.json"
        );
    }

    @Test
    void testXmlJson_53_FTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FTFFTT.json"
        );
    }

    @Test
    void testXmlJson_53_FTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FTFTFT.json"
        );
    }

    @Test
    void testXmlJson_53_FTFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_FTFTTT.json"
        );
    }

    @Test
    void testXmlJson_53_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_53_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_53_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_53_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_53_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_53_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_53_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_53_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_TFFTTT.json"
        );
    }

    @Test
    void testXmlJson_53_TTFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_TTFFTT.json"
        );
    }

    @Test
    void testXmlJson_53_TTFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_TTFTFT.json"
        );
    }

    @Test
    void testXmlJson_53_TTFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_TTFTTF.json"
        );
    }

    @Test
    void testXmlJson_53_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_53.xml",
                "xml-to-json/example_53_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 54
     *****************************************/

    @Test
    void testXmlJson_54_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_54_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_54_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_54_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_54_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_54_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_54_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_54_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_54_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_54_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_54_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_54_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_54_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_54_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_54_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_54_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_54_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_54_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_54.xml",
                "xml-to-json/example_54_TFFTTT.json"
        );
    }

    /*****************************************
     ** Example 55
     *****************************************/

    @Test
    void testXmlJson_55_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_55_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_55_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_55_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_55_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_55_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_55_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_55_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_55_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_55_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_55_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_55_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_55_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_55_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_55_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_55_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_55_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_55_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_55.xml",
                "xml-to-json/example_55_TFFTTT.json"
        );
    }

    /*****************************************
     ** Example 56
     *****************************************/

    @Test
    void testXmlJson_56_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_56_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_56_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_56_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_56_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_56_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_56_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_56_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_56_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_56_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_56_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_56_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_56_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_56_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_56_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_56_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_56_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_56_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_56.xml",
                "xml-to-json/example_56_TFFTTT.json"
        );
    }

    /*****************************************
     ** Example 57
     *****************************************/

    @Test
    void testXmlJson_57_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_57_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_57_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_57_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_57_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_57_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_57_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_57_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_57_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_57_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_57_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_57_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_57_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_57_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_57_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_57_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_57_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_57_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_57.xml",
                "xml-to-json/example_57_TFFTTT.json"
        );
    }

    /*****************************************
     ** Example 58
     *****************************************/

    @Test
    void testXmlJson_58_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_FFFFFF.json"
        );
    }

    @Test
    void testXmlJson_58_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TypeHints",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_FFFFFT.json"
        );
    }

    @Test
    void testXmlJson_58_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_FFFFTF.json"
        );
    }

    @Test
    void testXmlJson_58_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_FFFFTT.json"
        );
    }

    @Test
    void testXmlJson_58_FFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_FFFTFF.json"
        );
    }

    @Test
    void testXmlJson_58_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_TypeHints",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_FFFTFT.json"
        );
    }

    @Test
    void testXmlJson_58_FFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_FFFTTF.json"
        );
    }

    @Test
    void testXmlJson_58_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_FFFTTT.json"
        );
    }

    @Test
    void testXmlJson_58_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_FFTFFF.json"
        );
    }

    @Test
    void testXmlJson_58_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_TrimSpaces_TypeHints",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_FFTFFT.json"
        );
    }

    @Test
    void testXmlJson_58_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_TFFFFF.json"
        );
    }

    @Test
    void testXmlJson_58_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_TypeHints",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_TFFFFT.json"
        );
    }

    @Test
    void testXmlJson_58_TFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_TFFFTF.json"
        );
    }

    @Test
    void testXmlJson_58_TFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_TFFFTT.json"
        );
    }

    @Test
    void testXmlJson_58_TFFTFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_TFFTFF.json"
        );
    }

    @Test
    void testXmlJson_58_TFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_TFFTFT.json"
        );
    }

    @Test
    void testXmlJson_58_TFFTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_TFFTTF.json"
        );
    }

    @Test
    void testXmlJson_58_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_58.xml",
                "xml-to-json/example_58_TFFTTT.json"
        );
    }

    private void compareInputXmlFileWithOutputJsonFile(String routeName, String inputXmlFile, String outputJsonFile)
            throws IOException, InterruptedException {
        String defaultXml = IOUtils.toString(classLoader.getResourceAsStream(inputXmlFile), StandardCharsets.UTF_8);
        String defaultJson = IOUtils.toString(classLoader.getResourceAsStream(outputJsonFile), StandardCharsets.UTF_8);

        resultEndpoint.expectedMessageCount(1);
        template.sendBody("direct:"+routeName, defaultXml);
        String exchangeBody = getLastExchange(resultEndpoint).getIn().getBody(String.class);

        System.out.println("exchangeBody >>> "+exchangeBody);

        JSONAssert.assertEquals(
                "Expected the exchange body to equal the given json", defaultJson, exchangeBody, true
        );

        resultEndpoint.assertIsSatisfied();
    }

    private Exchange getLastExchange(MockEndpoint endpoint) {
        int size = endpoint.getReceivedExchanges().size();
        return endpoint.getReceivedExchanges().get(size -1);
    }

    @Override
    protected RouteBuilder[] createRouteBuilders() {
        return new RouteBuilder[] {
                new RouteBuilder() {
                    public void configure() {
                        // FFFFFF
                        from("direct:xmltojsonlegacy")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFFFFT
                        from("direct:xmltojsonlegacy_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFFFTF
                        from("direct:xmltojsonlegacy_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFFFTT
                        from("direct:xmltojsonlegacy_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFFTFF
                        from("direct:xmltojsonlegacy_SkipNamespaces")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFFTFT
                        from("direct:xmltojsonlegacy_SkipNamespaces_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFFTTF
                        from("direct:xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFFTTT
                        from("direct:xmltojsonlegacy_SkipNamespaces_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFTFFF
                        from("direct:xmltojsonlegacy_TrimSpaces")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFTFFT
                        from("direct:xmltojsonlegacy_TrimSpaces_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFTFTF
                        from("direct:xmltojsonlegacy_TrimSpaces_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFTFTT
                        from("direct:xmltojsonlegacy_TrimSpaces_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFTTFF
                        from("direct:xmltojsonlegacy_TrimSpaces_SkipNamespaces")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFTTFT
                        from("direct:xmltojsonlegacy_TrimSpaces_SkipNamespaces_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFTTTF
                        from("direct:xmltojsonlegacy_TrimSpaces_SkipNamespaces_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FFTTTT
                        from("direct:xmltojsonlegacy_TrimSpaces_SkipNamespaces_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=false&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTFFFF
                        from("direct:xmltojsonlegacy_SkipWhitespace")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTFFFT
                        from("direct:xmltojsonlegacy_SkipWhitespace_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTFFTF
                        from("direct:xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTFFTT
                        from("direct:xmltojsonlegacy_SkipWhitespace_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTFTFF
                        from("direct:xmltojsonlegacy_SkipWhitespace_SkipNamespaces")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTFTFT
                        from("direct:xmltojsonlegacy_SkipWhitespace_SkipNamespaces_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTFTTF
                        from("direct:xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTFTTT
                        from("direct:xmltojsonlegacy_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTTFFF
                        from("direct:xmltojsonlegacy_SkipWhitespace_TrimSpaces")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTTFFT
                        from("direct:xmltojsonlegacy_SkipWhitespace_TrimSpaces_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTTFTF
                        from("direct:xmltojsonlegacy_SkipWhitespace_TrimSpaces_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTTFTT
                        from("direct:xmltojsonlegacy_SkipWhitespace_TrimSpaces_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTTTFF
                        from("direct:xmltojsonlegacy_SkipWhitespace_TrimSpaces_SkipNamespaces")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTTTFT
                        from("direct:xmltojsonlegacy_SkipWhitespace_TrimSpaces_SkipNamespaces_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTTTTF
                        from("direct:xmltojsonlegacy_SkipWhitespace_TrimSpaces_SkipNamespaces_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // FTTTTT
                        from("direct:xmltojsonlegacy_SkipWhitespace_TrimSpaces_SkipNamespaces_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=false&skipWhitespace=true&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFFFFF
                        from("direct:xmltojsonlegacy_ForceTop")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFFFFT
                        from("direct:xmltojsonlegacy_ForceTop_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFFFTF
                        from("direct:xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFFFTT
                        from("direct:xmltojsonlegacy_ForceTop_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFFTFF
                        from("direct:xmltojsonlegacy_ForceTop_SkipNamespaces")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFFTFT
                        from("direct:xmltojsonlegacy_ForceTop_SkipNamespaces_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFFTTF
                        from("direct:xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFFTTT
                        from("direct:xmltojsonlegacy_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFTFFF
                        from("direct:xmltojsonlegacy_ForceTop_TrimSpaces")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFTFFT
                        from("direct:xmltojsonlegacy_ForceTop_TrimSpaces_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFTFTF
                        from("direct:xmltojsonlegacy_ForceTop_TrimSpaces_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFTFTT
                        from("direct:xmltojsonlegacy_ForceTop_TrimSpaces_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFTTFF
                        from("direct:xmltojsonlegacy_ForceTop_TrimSpaces_SkipNamespaces")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFTTFT
                        from("direct:xmltojsonlegacy_ForceTop_TrimSpaces_SkipNamespaces_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFTTTF
                        from("direct:xmltojsonlegacy_ForceTop_TrimSpaces_SkipNamespaces_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TFTTTT
                        from("direct:xmltojsonlegacy_ForceTop_TrimSpaces_SkipNamespaces_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=false&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTFFFF
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTFFFT
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTFFTF
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTFFTT
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=false&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTFTFF
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTFTFT
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTFTTF
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTFTTT
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_SkipNamespaces_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=false&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTTFFF
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTTFFT
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTTFTF
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTTFTT
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=true&skipNamespaces=false&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTTTFF
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_SkipNamespaces")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTTTFT
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_SkipNamespaces_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=false&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTTTTF
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_SkipNamespaces_RemoveNamespacePrefixes")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=false")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        // TTTTTT
                        from("direct:xmltojsonlegacy_ForceTop_SkipWhitespace_TrimSpaces_SkipNamespaces_RemoveNamespacePrefixes_TypeHints")
                                .to("xmltojsonlegacy://?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
        };
    }

}
