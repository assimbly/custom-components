package world.dovetail.soap.util.helpers;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NodeHelperTest {

    private static Document document;

    @Before
    public void setup() throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        document = db.newDocument();
    }


    @Test
    public void testNamedAttributes(){
        Element node = document.createElement("tag");

        Attr attr = document.createAttribute("type");
        attr.setNodeValue("tns:node");

        node.setAttributeNode(attr);

        Node actual = NodeHelper.getNamedAttribute(node, "type");

        assertTrue(NodeHelper.hasNamedAttribute(node, "type"));
        assertEquals(attr, actual);
    }

    @Test
    public void testNodeValues(){
        Element node = document.createElement("tag");

        Attr attr = document.createAttribute("type");
        attr.setNodeValue("tns:node");

        node.setAttributeNode(attr);

        assertEquals("tns", NodeHelper.getPrefix(attr));
        assertEquals("node", NodeHelper.getName(attr));

        node.removeAttribute("type");

        attr.setNodeValue("value");

        node.setAttributeNode(attr);

        assertEquals("", NodeHelper.getPrefix(attr));
        assertEquals("value", NodeHelper.getName(attr));
    }

    @Test
    public void testNodeNames(){
        Element node = document.createElement("tag");

        Attr attr = document.createAttribute("tns:type");
        attr.setNodeValue("value");

        node.setAttributeNode(attr);

        assertEquals("tns", NodeHelper.getPrefixOfNodeName(attr));
        assertEquals("type", NodeHelper.getNameOfNodeName(attr));

        node.removeAttribute("type");

        attr = document.createAttribute("type");
        attr.setNodeValue("value");

        node.setAttributeNode(attr);

        assertEquals("", NodeHelper.getPrefixOfNodeName(attr));
        assertEquals("type", NodeHelper.getNameOfNodeName(attr));
    }

    @Test
    public void testReference(){
        Element node = document.createElement("tag");

        Attr attr = document.createAttribute("ref");
        attr.setNodeValue("tns:reference");

        node.setAttributeNode(attr);

        assertTrue(NodeHelper.isReference(node));

        node.removeAttribute("ref");

        attr = document.createAttribute("no-ref");
        node.setAttributeNode(attr);

        assertFalse(NodeHelper.isReference(node));
    }

}
