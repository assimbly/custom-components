package org.assimbly.soap.util.helpers;

import com.ibm.wsdl.extensions.soap.SOAPHeaderImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12BodyImpl;
import com.ibm.wsdl.extensions.soap12.SOAP12HeaderImpl;
import org.assimbly.util.Pair;
import org.junit.Before;
import org.junit.Test;

import javax.wsdl.Binding;
import javax.wsdl.BindingOperation;
import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BindingInputHelperTest {

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

        List<SOAP12HeaderImpl> soap12HeaderList = BindingInputHelper.getSoap12Headers(operation.getBindingInput());

        assertEquals(2, soap12HeaderList.size());

        List<SOAPHeaderImpl> soapHeaderList = BindingInputHelper.getSoapHeaders(operation.getBindingInput());

        assertEquals(0, soapHeaderList.size());
    }

    @Test
    public void testGettingSoapBodies() {
        Pair<Definition, Binding> lookup = DefinitionHelper.binding(definition,"OperationWithTypePart");

        assertNotNull(lookup);

        BindingOperation operation = BindingHelper.operation(lookup.getValue(), "OperationWithTypePart");

        assertNotNull(operation);

        SOAP12BodyImpl soap12Body = BindingInputHelper.getSoap12Body(operation.getBindingInput());

        assertNotNull(soap12Body);

        assertEquals("http://www.assimbly.world/wsdl/types/", soap12Body.getNamespaceURI());
    }

}
