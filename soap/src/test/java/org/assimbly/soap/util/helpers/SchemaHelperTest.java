package org.assimbly.soap.util.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.extensions.schema.SchemaImport;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SchemaHelperTest {

    private static Definition definition;

    @BeforeEach
    public void setup() throws WSDLException {
        WSDLFactory factory = WSDLFactory.newInstance();
        WSDLReader reader = factory.newWSDLReader();

        ClassLoader classLoader = getClass().getClassLoader();
        definition = reader.readWSDL(classLoader.getResource("mock.wsdl").getFile());
    }

    @Test
    public void testGettingElementByName(){
        Schema schema = (Schema) definition.getTypes().getExtensibilityElements().get(1);

        Node expected = schema.getElement().getChildNodes().item(3);

        Node actual = SchemaHelper.findElementByName(schema, expected.getAttributes().getNamedItem("name").getNodeValue());

        assertEquals(expected, actual);
    }

    @Test
    public void testGettingImport() {
        Schema schema = (Schema) definition.getTypes().getExtensibilityElements().get(1);

        @SuppressWarnings("unchecked")
        Vector<SchemaImport> expected = (Vector<SchemaImport>) schema.getImports().get("http://www.assimbly.world/wsdl/local/import");

        SchemaImport actual = SchemaHelper.findImport(schema, expected.get(0).getNamespaceURI());

        assertEquals(expected.get(0), actual);
    }

}
