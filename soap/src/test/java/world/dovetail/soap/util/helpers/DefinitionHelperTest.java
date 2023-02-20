package world.dovetail.soap.util.helpers;

import org.junit.Before;
import org.junit.Test;

import javax.wsdl.Binding;
import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;

import static org.junit.Assert.assertEquals;

public class DefinitionHelperTest {

    private static Definition definition;

    @Before
    public void setup() throws WSDLException {
        WSDLFactory factory = WSDLFactory.newInstance();
        WSDLReader reader = factory.newWSDLReader();

        ClassLoader classLoader = getClass().getClassLoader();
        definition = reader.readWSDL(classLoader.getResource("mock.wsdl").getFile());
    }

    @Test
    public void testGettingDestinationUrl() {
        Binding binding = definition.getBinding(new QName("http://www.dovetail.world", "TestSoap12"));
        Binding bindingExt = definition.getBinding(new QName("http://www.dovetail.world", "TestSoapExt"));

        assertEquals("http://www.dovetail.world/testsoap.asmx", DefinitionHelper.destination(definition, binding));
        assertEquals("http://www.dovetail.world/testsoapext.asmx", DefinitionHelper.destination(definition, bindingExt));
    }
}
