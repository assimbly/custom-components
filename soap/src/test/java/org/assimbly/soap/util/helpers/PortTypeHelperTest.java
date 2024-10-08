package org.assimbly.soap.util.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.wsdl.Definition;
import javax.wsdl.Input;
import javax.wsdl.PortType;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PortTypeHelperTest {

    private static Definition definition;

    @BeforeEach
    public void setup() throws WSDLException {
        WSDLFactory factory = WSDLFactory.newInstance();
        WSDLReader reader = factory.newWSDLReader();

        ClassLoader classLoader = getClass().getClassLoader();
        definition = reader.readWSDL(classLoader.getResource("mock.wsdl").getFile());
    }

    @Test
    public void testGettingOperationInput() {
        QName name = new QName("http://www.assimbly.world","TestSoap");

        PortType portType = definition.getPortType(name);
        Input input = PortTypeHelper.input(portType, "OperationWithReference");

        assertNotNull(input);
        assertEquals(
                new QName("http://www.assimbly.world", "OperationWithReferenceIn"),
                input.getMessage().getQName()
        );
    }

}
