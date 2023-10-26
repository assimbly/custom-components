package org.assimbly.soap.util.helpers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.wsdl.Binding;
import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefinitionHelperTest {

    private static Definition definition;

    @BeforeEach
    public void setup() throws WSDLException {
        WSDLFactory factory = WSDLFactory.newInstance();
        WSDLReader reader = factory.newWSDLReader();

        ClassLoader classLoader = getClass().getClassLoader();
        definition = reader.readWSDL(classLoader.getResource("mock.wsdl").getFile());
    }

    @Test
    public void testGettingDestinationUrl() {
        Binding binding = definition.getBinding(new QName("http://www.assimbly.world", "TestSoap12"));
        Binding bindingExt = definition.getBinding(new QName("http://www.assimbly.world", "TestSoapExt"));

        assertEquals("http://www.assimbly.world/testsoap.asmx", DefinitionHelper.destination(definition, binding));
        assertEquals("http://www.assimbly.world/testsoapext.asmx", DefinitionHelper.destination(definition, bindingExt));
    }
}
