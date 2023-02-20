package org.assimbly.soap.util.helpers;

import org.w3c.dom.Node;

import javax.wsdl.extensions.schema.Schema;

public final class NodeHelper {

    public static boolean isReference(Node node){
        return node.getAttributes() != null && node.getAttributes().getNamedItem("ref") != null;
    }

    public static boolean isType(Node node){
        return node.getAttributes() != null && node.getAttributes().getNamedItem("type") != null;
    }

    public static boolean isExtension(Node node){
        return node.getLocalName().equals("extension");
    }

    public static boolean hasPrefix(Node ref){
        return ref.getNodeValue().contains(":");
    }

    public static String getPrefix(Node ref){
        if(ref.getNodeValue().contains(":"))
            return ref.getNodeValue().split(":")[0];

        return "";
    }

    public static String getName(Node ref){
        if(ref.getNodeValue().contains(":"))
            return ref.getNodeValue().split(":")[1];

        return ref.getNodeValue();
    }

    public static String getPrefixOfNodeName(Node ref){
        if(ref.getNodeName().contains(":"))
            return ref.getNodeName().split(":")[0];

        return "";
    }

    public static String getNameOfNodeName(Node ref){
        if(ref.getNodeName().contains(":"))
            return ref.getNodeName().split(":")[1];

        return ref.getNodeName();
    }

    public static boolean hasInlineNamespace(Node node) {
        for (int i = 0; i < node.getAttributes().getLength(); i++) {
            Node attr = node.getAttributes().item(i);

            if(attr.getPrefix() != null && attr.getPrefix().equals("xmlns"))
                return true;
        }

        return false;
    }

    public static boolean hasNamedAttribute(Node node, String attr){
        return node.getAttributes() != null && node.getAttributes().getNamedItem(attr) != null;
    }

    public static Node getNamedAttribute(Node node, String attr){
        return node.getAttributes().getNamedItem(attr);
    }
}
