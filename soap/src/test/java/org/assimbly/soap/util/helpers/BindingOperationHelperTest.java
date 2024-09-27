package org.assimbly.soap.util.helpers;

import org.assimbly.util.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.wsdl.Binding;
import javax.wsdl.BindingOperation;
import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BindingOperationHelperTest {

    private static Definition definition;

    @BeforeEach
    public void setup() throws WSDLException {
        WSDLFactory factory = WSDLFactory.newInstance();
        WSDLReader reader = factory.newWSDLReader();

        ClassLoader classLoader = getClass().getClassLoader();
        definition = reader.readWSDL(classLoader.getResource("mock.wsdl").getFile());
    }

    @Test
    public void testGettingActionUri() {
        Pair<Definition, Binding> lookup = DefinitionHelper.binding(definition,"OperationWithReference");

        assertNotNull(lookup);

        BindingOperation operation = BindingHelper.operation(lookup.getValue(), "OperationWithReference");

        assertNotNull(operation);

        String actionUri = BindingOperationHelper.getOperationAction(operation);

        assertEquals("http://www.assimbly.world/WithReference", actionUri);
    }

}
