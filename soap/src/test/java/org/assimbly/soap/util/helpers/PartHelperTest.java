package org.assimbly.soap.util.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.wsdl.Definition;
import javax.wsdl.Input;
import javax.wsdl.Part;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartHelperTest {

    private static Definition definition;

    @BeforeEach
    public void setup() throws WSDLException {
        WSDLFactory factory = WSDLFactory.newInstance();
        WSDLReader reader = factory.newWSDLReader();

        ClassLoader classLoader = getClass().getClassLoader();
        definition = reader.readWSDL(classLoader.getResource("mock.wsdl").getFile());
    }

    @Test
    public void testContainingTypesAndElements(){
        QName name = new QName("http://www.assimbly.world","TestSoap");

        Input input = definition.getPortType(name).getOperation("OperationWithTypePart", null, null).getInput();

        assertEquals(1, PartHelper.getElements(input).size());
        assertEquals(2, PartHelper.getTypes(input).size());
    }

    @Test
    public void testGettingElement() {
        QName name = new QName("http://www.assimbly.world","TestSoap");

        Input input = definition.getPortType(name).getOperation("OperationWithTypePart", null, null).getInput();

        List<Part> parts = PartHelper.getElements(input);

        QName expected = new QName("http://www.assimbly.world/wsdl/local/import", "imp-element");

        assertEquals(expected, parts.get(0).getElementName());
    }

    @Test
    public void testGettingTypes() {
        QName name = new QName("http://www.assimbly.world","TestSoap");

        Input input = definition.getPortType(name).getOperation("OperationWithTypePart", null, null).getInput();

        List<Part> parts = PartHelper.getTypes(input);

        QName expected = new QName("http://www.w3.org/2001/XMLSchema", "string");

        assertEquals(expected, parts.get(0).getTypeName());

        expected = new QName("http://www.assimbly.world", "element");

        assertEquals(expected, parts.get(1).getTypeName());
    }

}
