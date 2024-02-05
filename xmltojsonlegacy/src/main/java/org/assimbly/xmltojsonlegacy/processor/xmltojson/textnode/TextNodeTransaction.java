package org.assimbly.xmltojsonlegacy.processor.xmltojson.textnode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.assimbly.xmltojsonlegacy.Namespace;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.HashMap;

public interface TextNodeTransaction {

    JsonNode process(
            Node childNode, Element element, ArrayNode rootArrayNode, ObjectNode rootObjectNode, int level, int index,
            int nodeListSize, String grandParentClass, String parentClass, boolean isRootArray, boolean isRootNode,
            boolean isObject, boolean isOneValue, String namespace, HashMap<String, Namespace> xmlnsMap,
            boolean forceTopLevelObject, boolean trimSpaces, boolean skipNamespaces, boolean removeNamespacePrefixes,
            boolean typeHints, boolean areSiblingsNamesEqual, boolean isParentSiblingsNamesEqual, boolean hasAttributes,
            boolean hasParentAttributes, boolean isElementMustBeNull
    );

}
