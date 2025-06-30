package org.assimbly.xmltojsonlegacy;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.assimbly.xmltojsonlegacy.model.ElementMetadata;
import org.assimbly.xmltojsonlegacy.service.MetadataAnalyzer;
import org.assimbly.xmltojsonlegacy.service.XmlMetadataExtractor;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.ElementNodeTransaction;
import org.assimbly.xmltojsonlegacy.transaction.elementnode.ElementNodeTransactionFactory;
import org.assimbly.xmltojsonlegacy.transaction.textnode.TextNodeTransaction;
import org.assimbly.xmltojsonlegacy.transaction.textnode.TextNodeTransactionFactory;
import org.assimbly.xmltojsonlegacy.utils.ElementMetadataUtils;
import org.assimbly.xmltojsonlegacy.utils.ExtractUtils;
import org.springframework.http.MediaType;

import java.io.InputStream;
import java.util.*;

public class XmlToJsonProcessor implements Processor {
    private final XmlToJsonEndpoint endpoint;

    public XmlToJsonProcessor(XmlToJsonEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        XmlToJsonConfiguration config = endpoint.getConfiguration();

        if(config.isToDiscard(config)) {
            // no transformation available
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNodeResp = objectMapper.createObjectNode().put("noTransformation", "Available");
            setBodyOnExchange(exchange, objectMapper.writeValueAsString(jsonNodeResp));
            return;
        }

        InputStream inputStream = exchange.getIn().getBody(InputStream.class);

        // first pass - generate metadataMap
        Map<String, ElementMetadata> metadataMap = XmlMetadataExtractor.extractMetadata(inputStream, config);

        // group all paths by depth
        Map<Integer, List<String>> depthMap = new HashMap<>();
        for (Map.Entry<String, ElementMetadata> entry : metadataMap.entrySet()) {
            int depth = entry.getValue().getLevel();
            depthMap.computeIfAbsent(depth, k -> new ArrayList<>()).add(entry.getKey());
        }

        // reverse order - bottom-up
        List<Integer> depths = new ArrayList<>(depthMap.keySet());
        depths.sort(Collections.reverseOrder());

        // process from deepest to shallowest
        for (int depth : depths) {
            for (String path : depthMap.get(depth)) {
                ElementMetadata metadata = metadataMap.get(path);

                // build json node from metadata
                JsonNode jsonNode = buildJsonNodeFromMetadata(metadataMap, metadata, config);
                // save result in the metadata for parent access
                metadata.setValueAsJson(jsonNode);

                // clean children
                for (String childPath : metadata.getChildPaths()) {
                    metadataMap.remove(childPath);
                }
            }
        }

        // extract root json
        Map.Entry<String, ElementMetadata> rootEntry = metadataMap.entrySet().iterator().next();
        JsonNode finalJson = rootEntry.getValue().getValueAsJson();
        ObjectMapper objectMapper = new ObjectMapper();

        // set json on the exchange
        setBodyOnExchange(exchange, objectMapper.writeValueAsString(finalJson));
    }

    private static JsonNode buildJsonNodeFromMetadata(
            Map<String, ElementMetadata> metadataMap,
            ElementMetadata metadata, XmlToJsonConfiguration config
    ) {
        // get parent metadata
        ElementMetadata parentMetadata = ElementMetadataUtils.getParentMetadata(metadataMap, metadata);

        // init metadata vars
        initMetadataVars(metadataMap, metadata, config);

        // add attributes in the object node
        ExtractUtils.addAttributesInObjectNode(metadata, config);

        String parentNamespacePrefix = parentMetadata != null ? parentMetadata.getNamespacePrefix() : null;
        // add namespace attribute
        ExtractUtils.addNamespaceAttributeInObjectNode(metadata, null, config, metadata.getObjectNode(), parentNamespacePrefix);

        if(metadata.getChildrenCount() == 0) {
            // process node as leaf
            JsonNode processTextResp = processNodeAsLeaf(metadataMap, metadata, config);
            if (processTextResp != null) {
                return processTextResp;
            }
        } else {
            // process node with children
            JsonNode processTextResp = processNodeWithChildren(metadataMap, metadata, config);
            if (processTextResp != null) {
                return processTextResp;
            }
        }

        // return json
        return getJsonFromMetadata(metadata, config);
    }

    // process node with children
    private static JsonNode processNodeWithChildren(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, XmlToJsonConfiguration config) {

        // iterate over children
        for (String childPath : metadata.getChildPaths()) {

            // get child  metadata
            ElementMetadata childMetadata = metadataMap.get(childPath);

            if (childMetadata == null) {
                continue;
            }

            // set elementMustBeNull flag
            metadata.setElementMustBeNull(MetadataAnalyzer.isElementMustBeNull(metadataMap, metadata, childMetadata, config));

            if (metadata.isObject() && metadata.isRootArray()) {
                if (!metadata.getObjectNode().isEmpty() || !childMetadata.getObjectNode().isEmpty()) {
                    // force rootArray flag
                    metadata.setRootArray(false);
                }
            } else {
                // process text node
                JsonNode processTextResp = processTextNode(metadataMap, metadata, config);

                if (ExtractUtils.rootObjectNodeContainsTextAttribute(metadata.getObjectNode())) {
                    // force rootArray flag
                    metadata.setRootArray(false);
                }

                if (processTextResp != null) {
                    return processTextResp;
                }
            }

            // get json child already processed
            JsonNode childNode = childMetadata.getValueAsJson();
            if (childNode == null) {
                continue;
            }

            // process element node
            JsonNode processNodeResp = processElementNode(metadataMap, metadata, childMetadata, childNode, config);
            if (processNodeResp != null) {
                return processNodeResp;
            }
        }

        return null;
    }

    // process node as leaf (no children found)
    private static JsonNode processNodeAsLeaf(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, XmlToJsonConfiguration config) {

        if(metadata.getTextContent() != null && !metadata.getTextContent().isEmpty()) {

            // set elementMustBeNull flag
            metadata.setElementMustBeNull(MetadataAnalyzer.isElementMustBeNull(metadataMap, metadata, null, config));

            if (metadata.isObject() && metadata.isRootArray()) {
                if (!metadata.getObjectNode().isEmpty()) {
                    // force rootArray flag
                    metadata.setRootArray(false);
                }
            } else {
                // process text node
                JsonNode processTextResp = processTextNode(metadataMap, metadata, config);

                if (ExtractUtils.rootObjectNodeContainsTextAttribute(metadata.getObjectNode())) {
                    // force rootArray flag
                    metadata.setRootArray(false);
                }

                if (processTextResp != null) {
                    return processTextResp;
                }
            }
        }

        return null;
    }

    // init metadata vars
    private static void initMetadataVars(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, XmlToJsonConfiguration config) {
        // init objectNode and arrayNode
        metadata.setObjectNode(JsonNodeFactory.instance.objectNode());
        metadata.setArrayNode(JsonNodeFactory.instance.arrayNode());
        // init flags
        metadata.setRootArray(MetadataAnalyzer.isRootArray(metadataMap, metadata, config));
        metadata.setObject(MetadataAnalyzer.isObject(metadataMap, metadata, config));
        metadata.setOneValue(MetadataAnalyzer.isOneValue(metadataMap, metadata, config));
    }

    // process an element node of type Node
    private static JsonNode processElementNode(
            Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, ElementMetadata childMetadata, JsonNode childNode, XmlToJsonConfiguration config
    ) {
        ElementNodeTransaction transactionProcessor = ElementNodeTransactionFactory.getProcessorFor(metadata);
        return transactionProcessor.process(metadataMap, metadata, childMetadata, childNode, config);
    }

    // process an element node of type Text
    private static JsonNode processTextNode(Map<String, ElementMetadata> metadataMap, ElementMetadata metadata, XmlToJsonConfiguration config) {
        TextNodeTransaction transactionProcessor = TextNodeTransactionFactory.getProcessorFor(metadata);
        return transactionProcessor.process(metadataMap, metadata, config);
    }

    // get json from metadata
    private static JsonNode getJsonFromMetadata(ElementMetadata metadata, XmlToJsonConfiguration config) {
        if(metadata.isRootNode() && config.isForceTopLevelObject()) {
            ObjectNode parentNode = JsonNodeFactory.instance.objectNode();
            parentNode.set(ElementMetadataUtils.getElementName(metadata, config.isRemoveNamespacePrefixes()), metadata.isRootArray() ? metadata.getArrayNode() : metadata.getObjectNode());
            return parentNode;
        } else {
            return metadata.isRootArray() ? metadata.getArrayNode() : metadata.getObjectNode();
        }
    }

    // set body on exchange
    private void setBodyOnExchange(Exchange exchange, String body) {
        setContentTypeHeader(exchange);
        exchange.getIn().setBody(body);
    }

    // set content type header
    private void setContentTypeHeader(Exchange exchange) {
        exchange.getMessage().setHeader(Exchange.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    }
}
