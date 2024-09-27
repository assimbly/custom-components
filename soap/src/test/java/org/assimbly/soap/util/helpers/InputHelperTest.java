package org.assimbly.soap.util.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.wsdl.Definition;
import javax.wsdl.Input;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InputHelperTest {

    private static Definition definition;

    @BeforeEach
    public void setup() throws WSDLException {
        WSDLFactory factory = WSDLFactory.newInstance();
        WSDLReader reader = factory.newWSDLReader();

        ClassLoader classLoader = getClass().getClassLoader();
        definition = reader.readWSDL(classLoader.getResource("mock.wsdl").getFile());
    }

    @Test
    public void testGettingMessage() {
        QName name = new QName("http://www.assimbly.world","TestSoap");

        Input input = definition.getPortType(name).getOperation("OperationWithReference", null, null).getInput();

        QName messagePart = InputHelper.getMessagePart(input);

        assertNotNull(messagePart);

        QName expected = new QName("http://www.assimbly.world", "withReferenceRequest");

        assertEquals(expected, messagePart);
    }

}
