package org.assimbly.soap.util.helpers;

import org.assimbly.util.Pair;
import org.junit.Before;
import org.junit.Test;

import javax.wsdl.Binding;
import javax.wsdl.BindingOperation;
import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BindingHelperTest {

    private static Definition definition;

    @Before
    public void setup() throws WSDLException {
        WSDLFactory factory = WSDLFactory.newInstance();
        WSDLReader reader = factory.newWSDLReader();

        ClassLoader classLoader = getClass().getClassLoader();
        definition = reader.readWSDL(classLoader.getResource("mock.wsdl").getFile());
    }

    @Test
    public void testGettingSoapHeaders() {
        Pair<Definition, Binding> lookup = DefinitionHelper.binding(definition,"OperationWithHeaders");

        assertNotNull(lookup);

        BindingOperation operation = BindingHelper.operation(lookup.getValue(), "OperationWithHeaders");

        assertNotNull(operation);

        assertEquals("OperationWithHeaders", operation.getName());
    }
}

