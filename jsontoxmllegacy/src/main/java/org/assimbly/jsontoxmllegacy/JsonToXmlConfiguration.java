package org.assimbly.jsontoxmllegacy;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.HashMap;

@UriParams
public class JsonToXmlConfiguration implements Cloneable{

    protected Logger log = LoggerFactory.getLogger(getClass());

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

    private JsonNode jsonNode = null;
    private Document document = null;
    private Element element = null;
    private String name = null;
    private int level = 0;
    private HashMap<String, String> xmlnsMap = new HashMap<>();

    public JsonToXmlConfiguration() {}

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

    // create sub level configuration
    public JsonToXmlConfiguration createSubLevelConfig(JsonNode jsonNode, String name) {
        try {
            JsonToXmlConfiguration subLevelConfig = (JsonToXmlConfiguration)this.clone();

            subLevelConfig.setLevel(this.getLevel() +1);
            subLevelConfig.setName(name);
            subLevelConfig.setJsonNode(jsonNode);

            return subLevelConfig;
        } catch (java.lang.CloneNotSupportedException e) {
            log.error("Could not create config for sub level", e);
            return null;
        }
    }

}
