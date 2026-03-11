package org.assimbly.jsontoxmllegacy;

import tools.jackson.databind.JsonNode;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;

@UriParams
public class JsonToXmlConfiguration {

    @UriParam
    @Metadata(required = true)
    private String elementName;

    @UriParam
    @Metadata(required = true)
    private String arrayName;

    @UriParam
    @Metadata(required = true)
    private String rootName;

    @UriParam
    @Metadata(required = true)
    private boolean namespaceLenient;

    @UriParam
    @Metadata(required = true)
    private boolean typeHints;

    private JsonNode jsonNode;
    private Document document;
    private Element element;
    private String name;
    private int level;
    private HashMap<String, String> xmlnsMap = new HashMap<>();

    public JsonToXmlConfiguration() {
        // Used for serialization or reflection
    }

    public JsonToXmlConfiguration(JsonToXmlConfiguration source) {
        this.elementName      = source.elementName;
        this.arrayName        = source.arrayName;
        this.rootName         = source.rootName;
        this.namespaceLenient = source.namespaceLenient;
        this.typeHints        = source.typeHints;
        this.document         = source.document;
        this.element          = source.element;
        this.jsonNode         = source.jsonNode;
        this.name             = source.name;
        this.level            = source.level;
        this.xmlnsMap         = new HashMap<>(source.xmlnsMap);
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getArrayName() {
        return arrayName;
    }

    public void setArrayName(String arrayName) {
        this.arrayName = arrayName;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public boolean isNamespaceLenient() {
        return namespaceLenient;
    }

    public void setNamespaceLenient(boolean namespaceLenient) {
        this.namespaceLenient = namespaceLenient;
    }

    public boolean isTypeHints() {
        return typeHints;
    }

    public void setTypeHints(boolean typeHints) {
        this.typeHints = typeHints;
    }

    public JsonNode getJsonNode() {
        return jsonNode;
    }

    public void setJsonNode(JsonNode jsonNode) {
        this.jsonNode = jsonNode;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public HashMap<String, String> getXmlnsMap() {
        return xmlnsMap;
    }

    public void setXmlnsMap(HashMap<String, String> xmlnsMap) {
        this.xmlnsMap = xmlnsMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void init() {
        setDocument(null);
        setElement(null);
        setJsonNode(null);
        setXmlnsMap(new HashMap<>());
    }

    // create sub level configuration
    public JsonToXmlConfiguration createSubLevelConfig(JsonNode jsonNode, String name) {
        JsonToXmlConfiguration subLevelConfig = new JsonToXmlConfiguration(this);
        subLevelConfig.setLevel(this.level + 1);
        subLevelConfig.setName(name);
        subLevelConfig.setJsonNode(jsonNode);
        return subLevelConfig;
    }

}