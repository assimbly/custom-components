package org.assimbly.xmltojsonlegacy;

import org.apache.camel.*;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class XmlToJsonTest extends CamelTestSupport {

    private final ClassLoader classLoader = getClass().getClassLoader();

    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce
    protected ProducerTemplate template;

    /*****************************************
    ** Example 1
    *****************************************/

    @Test
    public void testXmlJson_1_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_1_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_1_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_1_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_1.xml",
                "xml-to-json/example_1_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 2
     *****************************************/

    @Test
    public void testXmlJson_2_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_2_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_2_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_2_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_2.xml",
                "xml-to-json/example_2_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 3
     *****************************************/

    @Test
    public void testXmlJson_3_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_3_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_3_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_3_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_3.xml",
                "xml-to-json/example_3_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 4
     *****************************************/

    @Test
    public void testXmlJson_4_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_4_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_4_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_4_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_4.xml",
                "xml-to-json/example_4_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 5
     *****************************************/

    @Test
    public void testXmlJson_5_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_5_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_5_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_5_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_5.xml",
                "xml-to-json/example_5_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 6
     *****************************************/

    @Test
    public void testXmlJson_6_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_6_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_6_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_6_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_6.xml",
                "xml-to-json/example_6_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 7
     *****************************************/

    @Test
    public void testXmlJson_7_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_7_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_7_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_7_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_7.xml",
                "xml-to-json/example_7_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 8
     *****************************************/

    @Test
    public void testXmlJson_8_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_8_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_8_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_8_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_8.xml",
                "xml-to-json/example_8_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 9
     *****************************************/

    @Test
    public void testXmlJson_9_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_9_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_9_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_9_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_9.xml",
                "xml-to-json/example_9_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 10
     *****************************************/

    @Test
    public void testXmlJson_10_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_10_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_10_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_10_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_10.xml",
                "xml-to-json/example_10_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 11
     *****************************************/

    @Test
    public void testXmlJson_11_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_11_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_11_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_11_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_11.xml",
                "xml-to-json/example_11_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 12
     *****************************************/

    @Test
    public void testXmlJson_12_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_12.xml",
                "xml-to-json/example_12_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_12_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_12.xml",
                "xml-to-json/example_12_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_12_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_12.xml",
                "xml-to-json/example_12_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_12_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_12.xml",
                "xml-to-json/example_12_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 13
     *****************************************/

    @Test
    public void testXmlJson_13_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_13_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_13_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_13_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_TFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_13_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_13_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_13_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_13.xml",
                "xml-to-json/example_13_FFFTFT.json"
        );
    }

    /*****************************************
     ** Example 14
     *****************************************/

    @Test
    public void testXmlJson_14_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_14_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_14_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_14_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_14_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_FFFTFT.json"
        );
    }

    @Test
    public void testXmlJson_14_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_14_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_14.xml",
                "xml-to-json/example_14_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 15
     *****************************************/

    @Test
    public void testXmlJson_15_FFTFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TrimSpaces",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_FFTFFF.json"
        );
    }

    @Test
    public void testXmlJson_15_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_15_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_15_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_15_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_15_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_FFFTFT.json"
        );
    }

    @Test
    public void testXmlJson_15_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_15_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_15.xml",
                "xml-to-json/example_15_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 16
     *****************************************/

    @Test
    public void testXmlJson_16_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_16_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TrimSpaces_TypeHints",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_FFTFFT.json"
        );
    }

    @Test
    public void testXmlJson_16_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_16_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_16_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_16_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_FFFTFT.json"
        );
    }

    @Test
    public void testXmlJson_16_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_16_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_16.xml",
                "xml-to-json/example_16_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 17
     *****************************************/

    @Test
    public void testXmlJson_17_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_17_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_17_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TrimSpaces_TypeHints",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_FFTFFT.json"
        );
    }

    @Test
    public void testXmlJson_17_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_17_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_17_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_FFFTFT.json"
        );
    }

    @Test
    public void testXmlJson_17_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_17_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_17.xml",
                "xml-to-json/example_17_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 18
     *****************************************/

    @Test
    public void testXmlJson_18_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_18_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_18_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TrimSpaces_TypeHints",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_FFTFFT.json"
        );
    }

    @Test
    public void testXmlJson_18_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_18_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_18_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_FFFTFT.json"
        );
    }

    @Test
    public void testXmlJson_18_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_18_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_18.xml",
                "xml-to-json/example_18_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 19
     *****************************************/

    @Test
    public void testXmlJson_19_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_19_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_19_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_19_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_19_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_FFFTFT.json"
        );
    }

    @Test
    public void testXmlJson_19_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TrimSpaces_TypeHints",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_FFTFFT.json"
        );
    }

    @Test
    public void testXmlJson_19_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_19_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_19.xml",
                "xml-to-json/example_19_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 20
     *****************************************/

    @Test
    public void testXmlJson_20_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_20_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_20_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_20_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_20_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FFFTFT.json"
        );
    }

    @Test
    public void testXmlJson_20_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FFFTTT.json"
        );
    }

    @Test
    public void testXmlJson_20_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TrimSpaces_TypeHints",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_FFTFFT.json"
        );
    }

    @Test
    public void testXmlJson_20_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_20_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_20.xml",
                "xml-to-json/example_20_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 21
     *****************************************/

    @Test
    public void testXmlJson_21_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_21_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_21_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_21_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_21_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FFFTFT.json"
        );
    }

    @Test
    public void testXmlJson_21_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FFFTTT.json"
        );
    }

    @Test
    public void testXmlJson_21_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TrimSpaces_TypeHints",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_FFTFFT.json"
        );
    }

    @Test
    public void testXmlJson_21_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_21_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_21.xml",
                "xml-to-json/example_21_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 22
     *****************************************/

    @Test
    public void testXmlJson_22_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_22_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_22_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_22_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_22_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FFFTFT.json"
        );
    }

    @Test
    public void testXmlJson_22_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FFFTTT.json"
        );
    }

    @Test
    public void testXmlJson_22_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TrimSpaces_TypeHints",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FFTFFT.json"
        );
    }

    @Test
    public void testXmlJson_22_FTTTTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipWhitespace_TrimSpaces_SkipNamespaces_RemoveNamespacePrefixes",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_FTTTTF.json"
        );
    }

    @Test
    public void testXmlJson_22_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_22_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_22.xml",
                "xml-to-json/example_22_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 23
     *****************************************/

    @Test
    public void testXmlJson_23_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_23_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_23_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_23_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_23_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FFFTFT.json"
        );
    }

    @Test
    public void testXmlJson_23_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FFFTTT.json"
        );
    }

    @Test
    public void testXmlJson_23_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TrimSpaces_TypeHints",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_FFTFFT.json"
        );
    }

    @Test
    public void testXmlJson_23_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_23_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_23.xml",
                "xml-to-json/example_23_TFFFFT.json"
        );
    }

    /*****************************************
     ** Example 24
     *****************************************/

    @Test
    public void testXmlJson_24_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_24_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_24_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_24_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_24_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FFFTFT.json"
        );
    }

    @Test
    public void testXmlJson_24_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FFFTTT.json"
        );
    }

    @Test
    public void testXmlJson_24_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TrimSpaces_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_FFTFFT.json"
        );
    }

    @Test
    public void testXmlJson_24_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_24_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_TFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_24_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_24.xml",
                "xml-to-json/example_24_TFFTTT.json"
        );
    }

    /*****************************************
     ** Example 25
     *****************************************/

    @Test
    public void testXmlJson_25_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_25_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_25_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_25_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_25_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FFFTFT.json"
        );
    }

    @Test
    public void testXmlJson_25_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FFFTTT.json"
        );
    }

    @Test
    public void testXmlJson_25_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TrimSpaces_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_FFTFFT.json"
        );
    }

    @Test
    public void testXmlJson_25_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_25_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_TFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_25_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_TFFTTT.json"
        );
    }

    @Test
    public void testXmlJson_25_TTTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_SkipWhitespace_TrimSpaces_TypeHints",
                "xml-to-json/example_25.xml",
                "xml-to-json/example_25_TTTFFT.json"
        );
    }

    /*****************************************
     ** Example 26
     *****************************************/

    @Test
    public void testXmlJson_26_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_26_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_26_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_26_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_26_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FFFTFT.json"
        );
    }

    @Test
    public void testXmlJson_26_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FFFTTT.json"
        );
    }

    @Test
    public void testXmlJson_26_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TrimSpaces_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_FFTFFT.json"
        );
    }

    @Test
    public void testXmlJson_26_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_26_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_TFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_26_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_26.xml",
                "xml-to-json/example_26_TFFTTT.json"
        );
    }

    /*****************************************
     ** Example 27
     *****************************************/

    @Test
    public void testXmlJson_27_FFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_27_FFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_27_FFFFTF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FFFFTF.json"
        );
    }

    @Test
    public void testXmlJson_27_FFFFTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FFFFTT.json"
        );
    }

    @Test
    public void testXmlJson_27_FFFTFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FFFTFT.json"
        );
    }

    @Test
    public void testXmlJson_27_FFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FFFTTT.json"
        );
    }

    @Test
    public void testXmlJson_27_FFTFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_TrimSpaces_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_FFTFFT.json"
        );
    }

    @Test
    public void testXmlJson_27_TFFFFF() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_TFFFFF.json"
        );
    }

    @Test
    public void testXmlJson_27_TFFFFT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_TFFFFT.json"
        );
    }

    @Test
    public void testXmlJson_27_TFFTTT() throws Exception {
        compareInputXmlFileWithOutputJsonFile(
                "marshal_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints",
                "xml-to-json/example_27.xml",
                "xml-to-json/example_27_TFFTTT.json"
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
                        from("direct:marshal")
                                .to("dataformat:custom-xmljsonlegacy:marshal")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshal_ForceTop")
                                .to("dataformat:custom-xmljsonlegacy:marshal?forceTopLevelObject=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshal_TrimSpaces")
                                .to("dataformat:custom-xmljsonlegacy:marshal?trimSpaces=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshal_SkipNamespaces")
                                .to("dataformat:custom-xmljsonlegacy:marshal?skipNamespaces=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshal_RemoveNamespacePrefixes")
                                .to("dataformat:custom-xmljsonlegacy:marshal?removeNamespacePrefixes=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshal_TypeHints")
                                .to("dataformat:custom-xmljsonlegacy:marshal?typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshal_ForceTop_TypeHints")
                                .to("dataformat:custom-xmljsonlegacy:marshal?forceTopLevelObject=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshal_TrimSpaces_TypeHints")
                                .to("dataformat:custom-xmljsonlegacy:marshal?trimSpaces=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshal_SkipNamespaces_TypeHints")
                                .to("dataformat:custom-xmljsonlegacy:marshal?skipNamespaces=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshal_RemoveNamespacePrefixes_TypeHints")
                                .to("dataformat:custom-xmljsonlegacy:marshal?removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshal_SkipNamespaces_RemoveNamespacePrefixes_TypeHints")
                                .to("dataformat:custom-xmljsonlegacy:marshal?skipNamespaces=true&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshal_SkipWhitespace_TrimSpaces_SkipNamespaces_RemoveNamespacePrefixes")
                                .to("dataformat:custom-xmljsonlegacy:marshal?skipWhitespace=true&trimSpaces=true&skipNamespaces=true&removeNamespacePrefixes=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshal_ForceTop_SkipNamespaces_RemoveNamespacePrefixes_TypeHints")
                                .to("dataformat:custom-xmljsonlegacy:marshal?forceTopLevelObject=true&skipNamespaces=true&removeNamespacePrefixes=true&typeHints=true")
                                .to("mock:result");
                    }
                },
                new RouteBuilder() {
                    public void configure() {
                        from("direct:marshal_ForceTop_SkipWhitespace_TrimSpaces_TypeHints")
                                .to("dataformat:custom-xmljsonlegacy:marshal?forceTopLevelObject=true&skipWhitespace=true&trimSpaces=true&typeHints=true")
                                .to("mock:result");
                    }
                },
        };
    }

}
