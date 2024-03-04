package org.assimbly.xmltojsonlegacy.transaction.textnode.types;

import com.fasterxml.jackson.databind.JsonNode;
import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.logs.Print;
import org.assimbly.xmltojsonlegacy.transaction.textnode.TextNodeTransaction;
import org.w3c.dom.Node;

public class ObjectType implements TextNodeTransaction {

    @Override
    public JsonNode process(XmlToJsonConfiguration config, Node childNode, int index, int nodeListSize) {
        //process text node identified as an object
        Print.data(" 2. OBJECT", config.getLevel());
        return null;
    }
}
