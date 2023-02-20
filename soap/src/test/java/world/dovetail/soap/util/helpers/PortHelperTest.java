package world.dovetail.soap.util.helpers;

import org.junit.Before;
import org.junit.Test;

import javax.wsdl.Definition;
import javax.wsdl.Port;
import javax.wsdl.Service;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;

import static org.junit.Assert.assertEquals;

public class PortHelperTest {

    private static Definition definition;

    @Before
    public void setup() throws WSDLException {
        WSDLFactory factory = WSDLFactory.newInstance();
        WSDLReader reader = factory.newWSDLReader();

        ClassLoader classLoader = getClass().getClassLoader();
        definition = reader.readWSDL(classLoader.getResource("mock.wsdl").getFile());
    }

    @Test
    public void testGettingAddress() {
        QName name = new QName("http://www.dovetail.world", "TestSoapService");

        Service service = definition.getService(name);
        Port port = service.getPort("TestSoap12");
        ExtensibilityElement expected = (ExtensibilityElement) port.getExtensibilityElements().get(0);

        ExtensibilityElement actual = PortHelper.address(port);

        assertEquals(expected, actual);
    }
}
