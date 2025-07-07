package org.assimbly.xmltojsonlegacy.utils;

import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.model.Namespace;

import javax.xml.XMLConstants;
import java.util.Map;

public class ElementMetadataUtils {

    private ElementMetadataUtils() {}

    // get parent path from path
    public static String getParentPath(String path) {
        if(path == null) {
            return null;
        }
        int lastSlash = path.lastIndexOf('/');
        return lastSlash == -1 ? "" : path.substring(0, lastSlash);
    }

    // get parent metadata
    public static ElementMetadata getParentMetadata(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata) {
        String parentPath = ElementMetadataUtils.getParentPath(metadata.getPath());
        if (parentPath == null) {
            return new ElementMetadata();
        }
        ElementMetadata parentMetadata = metadataMap.get(ElementMetadataUtils.getParentPath(metadata.getPath()));
        return parentMetadata != null ? metadataMap.get(ElementMetadataUtils.getParentPath(metadata.getPath())) : new ElementMetadata();
    }

    // get grandparent metadata
    public static ElementMetadata getGrandParentMetadata(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata) {
        ElementMetadata parentMetadata = getParentMetadata(metadataMap, metadata);
        return getParentMetadata(metadataMap, parentMetadata);
    }

    // get element namespace label
    public static String getElementNamespaceLabel(ElementMetadata metadata) {
        String namespaceLabel = XMLConstants.XMLNS_ATTRIBUTE;
        if (metadata.getNamespacePrefix() != null) {
            namespaceLabel += ":" + metadata.getNamespacePrefix();
        }
        return namespaceLabel;
    }


    // get element name
    // removes namespace from element name when isRemoveNamespacePrefixes flag is enabled
    public static String getElementName(ElementMetadata metadata, boolean removeNamespacePrefixes) {

        if(removeNamespacePrefixes || metadata.getNamespacePrefix() == null){
            return metadata.getName();
        }

        return metadata.getNamespacePrefix() + ":" + metadata.getName();
    }

    // get element value
    public static String getNodeValue(ElementMetadata metadata, boolean trimSpaces) {
        return trimSpaces ? metadata.getNormalizedTrimmedTextContent() : metadata.getNormalizedTextContent();
    }

    // check if attribute is a special attribute
    public static boolean isAnSpecialAttribute(String attribute) {
        return Constants.SPECIAL_JSON_XML_ATTR_TYPES.contains(attribute);
    }

    // check if node element is included on a namespace
    public static boolean isElementOnNamespace(ElementMetadata metadata) {
        if(metadata.getNamespaces() == null || metadata.getNamespaces().isEmpty()) {
            return false;
        }

        String namespaceLabel = getElementNamespaceLabel(metadata);
        Namespace namespace = metadata.getNamespaces().get(namespaceLabel);
        return namespace != null;
    }

}
