package org.assimbly.xmltojsonlegacy.service;

import org.assimbly.xmltojsonlegacy.XmlToJsonConfiguration;
import org.assimbly.xmltojsonlegacy.model.AttributeEntry;
import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.model.Namespace;
import org.assimbly.xmltojsonlegacy.utils.Constants;
import org.assimbly.xmltojsonlegacy.utils.ElementMetadataUtils;
import org.assimbly.xmltojsonlegacy.utils.JsonUtils;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class XmlMetadataExtractor {

    private XmlMetadataExtractor() {}

    // extracts metadata from the xml
    public static Map<String, ElementMetadata> extractMetadata(InputStream xmlInputStream, XmlToJsonConfiguration config) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = factory.createXMLEventReader(xmlInputStream);
        Map<String, ElementMetadata> metadataMap = new LinkedHashMap<>();

        Deque<String> pathStack = new ArrayDeque<>();
        Map<String, Integer> elementCounter = new HashMap<>();
        Map<String, Integer> childrenCountMap = new HashMap<>();
        Deque<String> textStack = new ArrayDeque<>();
        Map<String, Integer> siblingIndexMap = new HashMap<>();

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();

            if (event.isStartElement()) {
                textStack.push("");

                ElementMetadata metadata = new ElementMetadata();
                StartElement startElement = event.asStartElement();

                String name = startElement.getName().getLocalPart();
                String path = buildPath(pathStack, name, elementCounter);
                String parentPath = ElementMetadataUtils.getParentPath(path);

                // set name
                metadata.setName(name);
                // set path
                metadata.setPath(path);
                // set index
                setIndex(siblingIndexMap, parentPath, metadata);
                // add children at parent level
                addChildrenAtParentLevel(metadataMap, path, parentPath, childrenCountMap);
                // set hasAttributes
                setHasAttributes(config, startElement, metadata);
                // set namespaces
                setNamespaces(metadataMap, startElement, metadata, parentPath);
                // set attributes
                setAttributes(startElement, metadata);

                // save metadata
                metadataMap.put(path, metadata);

                // add current segment to path stack (just the name[index])
                String currentSegment = name + "[" + getPathIndex(path) + "]";
                pathStack.push(currentSegment);

                // set deepest depth
                propagateDeepestDepth(metadataMap, path);

            } else if (event.isCharacters()) {
                Characters characters = event.asCharacters();

                String text = characters.getData();
                String currentText = textStack.pop();
                String newText = currentText + text;

                textStack.push(newText);

            } else if (event.isEndElement()) {
                String currentPath = buildCurrentPathFromStack(pathStack);
                ElementMetadata metadata = metadataMap.get(currentPath);
                String text = textStack.pop();

                // set text content
                setTextContent(text, metadata, config.isSkipWhitespace());

                pathStack.pop();
            }
        }

        reader.close();
        return metadataMap;
    }

    // set attributes
    private static void setAttributes(StartElement startElement, ElementMetadata metadata) {
        Iterator<Attribute> attrIterator = startElement.getAttributes();
        Map<String, AttributeEntry> attributes = new HashMap<>();
        while (attrIterator.hasNext()) {
            Attribute attr = (Attribute) attrIterator.next();
            QName qname = attr.getName();
            String attrName = qname.getPrefix().isEmpty()
                    ? qname.getLocalPart()
                    : qname.getPrefix() + ":" + qname.getLocalPart();

            attributes.put(attrName, new AttributeEntry(qname, attr.getValue()));

            if(qname.getLocalPart().equals(Constants.JSON_XML_ATTR_TYPE) && isNumberOrBoolean(attr.getValue())) {
                metadata.setHasTypeNumberOrBoolean(true);
            }
        }
        metadata.setAttributes(attributes);
    }

    // set has attributes
    private static void setHasAttributes(XmlToJsonConfiguration config, StartElement startElement, ElementMetadata metadata) {
        boolean hasSimpleAttrs = config.isTypeHints() ? hasSimpleAttributes(startElement) : startElement.getAttributes().hasNext();
        metadata.setHasAttributes(hasSimpleAttrs);
    }

    // set internal index
    private static void setIndex(Map<String, Integer> siblingIndexMap, String parentPath, ElementMetadata metadata) {
        int currentIndex = siblingIndexMap.getOrDefault(parentPath, 0);
        metadata.setIndex(currentIndex);
        siblingIndexMap.put(parentPath, currentIndex + 1);
    }

    // check if it has simple attributes
    private static boolean hasSimpleAttributes(StartElement startElement) {
        Set<String> complexAttrs = Set.of(
                Constants.JSON_XML_ATTR_TYPE,
                Constants.JSON_XML_ATTR_CLASS
        );

        Iterator<Attribute> attributes = startElement.getAttributes();
        while (attributes.hasNext()) {
            Attribute attr = attributes.next();
            String attrName = attr.getName().getLocalPart();
            if (!complexAttrs.contains(attrName)) {
                return true; // Found a "simple" (non-type/class) attribute
            }
        }
        return false;
    }

    public static boolean isNumberOrBoolean(String type) {
        return type != null && (type.equals(Constants.JSON_XML_ATTR_TYPE_NUMBER) || type.equals(Constants.JSON_XML_ATTR_TYPE_BOOLEAN));
    }

    // check if text content is considered empty
    private static boolean isTextConsideredEmpty(String text) {
        return text == null || text.replace("\n", "").replace("\r", "").replace("\t", "").isEmpty();
    }

    // set text content
    private static void setTextContent(String text, ElementMetadata metadata, boolean isSkipWhitespace) {
        metadata.setTextContent(text);
        String normalizedTextContent = text.replace("\r\n","").replace("\n", "");
        metadata.setNormalizedTextContent(normalizedTextContent);
        metadata.setNormalizedTrimmedTextContent(normalizedTextContent.trim());
        metadata.setValueAsJson(JsonUtils.getValidJson(text));
        metadata.setHasEmptyTextContent(!isSkipWhitespace && isTextConsideredEmpty(text));
    }

    // add children at parent level
    private static void addChildrenAtParentLevel(Map<String, ElementMetadata> metadataMap, String path, String parentPath, Map<String, Integer> childrenCountMap) {

        int childrenIndex = childrenCountMap.getOrDefault(parentPath, 0) + 1;
        childrenCountMap.put(parentPath, childrenIndex);

        // Save parent metadata
        ElementMetadata parentMetadata = metadataMap.get(parentPath);
        if(parentMetadata == null) {
            parentMetadata = new ElementMetadata();
            parentMetadata.setPath(parentPath);
        }
        // set num children
        parentMetadata.setChildrenCount(childrenCountMap.get(parentPath));

        // add child name
        String childName = path.substring(path.lastIndexOf("/") +1, path.lastIndexOf("["));
        parentMetadata.addChildName(childName);

        // add child complete path
        parentMetadata.addChildPath(path);

        metadataMap.put(path, parentMetadata);
    }

    // build path
    private static String buildPath(Deque<String> stack, String name, Map<String, Integer> counter) {
        List<String> pathList = new ArrayList<>();
        stack.descendingIterator().forEachRemaining(pathList::add);

        String basePath = String.join("/", pathList);
        String fullPath = basePath.isEmpty() ? name : String.join("/", basePath, name);

        int index = counter.getOrDefault(fullPath, 0) + 1;
        counter.put(fullPath, index);

        return basePath.isEmpty() ? String.format("%s[%d]", name, index) : String.format("%s/%s[%d]", basePath, name, index);
    }

    // get path index
    private static int getPathIndex(String path) {
        int open = path.lastIndexOf('[');
        int close = path.lastIndexOf(']');
        if (open != -1 && close != -1 && open < close) {
            return Integer.parseInt(path.substring(open + 1, close));
        }
        return 1;
    }

    // set namespaces
    private static void setNamespaces(
            Map<String, ElementMetadata> metadataMap,
            StartElement startElement,
            ElementMetadata metadata,
            String parentPath
    ) {
        Map<String, Namespace> definedNamespacesMap = new HashMap<>();
        Map<String, Namespace> parentNamespaces = Optional.ofNullable(metadataMap.get(parentPath))
                .map(ElementMetadata::getNamespaces)
                .map(HashMap::new) // create a copy to avoid mutating parent
                .orElseGet(HashMap::new);

        Iterator<?> attrIterator = startElement.getNamespaces();
        if(attrIterator.hasNext()) {
            metadata.setDefinesNamespaces(true);
            while (attrIterator.hasNext()) {
                javax.xml.stream.events.Namespace ns = (javax.xml.stream.events.Namespace) attrIterator.next();
                String prefix = ns.getPrefix();
                String name = (prefix == null || prefix.isEmpty()) ? XMLConstants.XMLNS_ATTRIBUTE : XMLConstants.XMLNS_ATTRIBUTE + ":" + prefix;

                definedNamespacesMap.put(name, new Namespace(ns.getNamespaceURI(), metadata.getLevel()));
                parentNamespaces.put(name, new Namespace(ns.getNamespaceURI(), metadata.getLevel()));
            }
        }

        metadata.setNamespaces(parentNamespaces);
        metadata.setDefinedNamespaces(definedNamespacesMap);
        metadata.setNamespacePrefix(getElementNamePrefix(startElement));
    }

    // get element name prefix
    private static String getElementNamePrefix(StartElement startElement) {
        if (startElement == null) {
            return null;
        }
        String prefix = startElement.getName().getPrefix();
        return (prefix != null && !prefix.isEmpty()) ? prefix : null;
    }

    // propagate deepest depth
    private static void propagateDeepestDepth(Map<String, ElementMetadata> metadataMap, String path) {
        String childPath = path;
        int currentDepth = 0;

        while (true) {
            String parentPath = ElementMetadataUtils.getParentPath(childPath);
            if (parentPath.isEmpty()) {
                break;
            }

            ElementMetadata parentMeta = metadataMap.computeIfAbsent(parentPath, p -> {
                ElementMetadata m = new ElementMetadata();
                m.setPath(p);
                return m;
            });

            int parentDepth = parentMeta.getDeepestDepth();
            if (parentDepth < currentDepth + 1) {
                parentMeta.setDeepestDepth(currentDepth + 1);
            } else {
                // stop propagating if no deeper depth is added
                break;
            }

            childPath = parentPath;
            currentDepth++;
        }
    }

    // build current path from stack
    private static String buildCurrentPathFromStack(Deque<String> pathStack) {
        List<String> segments = new ArrayList<>();
        pathStack.descendingIterator().forEachRemaining(segments::add);
        return String.join("/", segments);
    }

}
