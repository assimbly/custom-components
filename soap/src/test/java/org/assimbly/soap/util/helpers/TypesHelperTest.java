package org.assimbly.soap.util.helpers;

import org.junit.Before;
import org.junit.Test;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

import static org.junit.Assert.assertNotNull;

public class TypesHelperTest {

    private static Definition definition;

    @Before
    public void setup() throws WSDLException {
        WSDLFactory factory = WSDLFactory.newInstance();
        WSDLReader reader = factory.newWSDLReader();

        ClassLoader classLoader = getClass().getClassLoader();
        definition = reader.readWSDL(classLoader.getResource("mock.wsdl").getFile());
    }

    @Test
    public void testFindSchema() {
        Schema schema = TypesHelper.schema(definition.getTypes(), "http://www.assimbly.world");
        Schema schemaExt = TypesHelper.schema(definition.getTypes(), "http://www.assimbly.world/wsdl/external/");
        Schema schemaUnq = TypesHelper.schema(definition.getTypes(), "http://www.assimbly.world/wsdl/unqualified/");
        Schema schemaTypes = TypesHelper.schema(definition.getTypes(), "http://www.assimbly.world/wsdl/types/");
        Schema schemaSch = TypesHelper.schema(definition.getTypes(), "http://www.assimbly.world/wsdl/schema/");

        assertNotNull(schema);
        assertNotNull(schemaExt);
        assertNotNull(schemaUnq);
        assertNotNull(schemaTypes);
        assertNotNull(schemaSch);
    }
}
