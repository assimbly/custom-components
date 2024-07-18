package org.assimbly.xmltojsonlegacy;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.assimbly.xmltojsonlegacy.checker.ElementChecker;
import org.assimbly.xmltojsonlegacy.utils.ElementUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import java.util.HashMap;
import java.util.Set;

@UriParams
public class XmlToJsonConfiguration implements Cloneable{

    protected Logger log = LoggerFactory.getLogger(getClass());

    @UriParam
    @Metadata(required = true)
    private boolean forceTopLevelObject;

    @UriParam
    @Metadata(required = true)
    private boolean skipWhitespace;

    @UriParam
    @Metadata(required = true)
    private boolean trimSpaces;

    @UriParam
    @Metadata(required = true)
    private boolean skipNamespaces;

    @UriParam
    @Metadata(required = true)
    private boolean removeNamespacePrefixes;

    @UriParam
    @Metadata(required = true)
    private boolean typeHints;

    // init config
    private boolean isSpecialCaseTTFTTF = false;
    private boolean isToDiscard = false;

    private Element element = null;
    private HashMap<String, Namespace> xmlnsMap = new HashMap<>();

    private int level = 0;
    private int parentSiblings = 0;

    private String grandParentClass = null;
    private String parentClass = null;
    private String parentNamespace = null;

    private boolean isGrandParentSiblingsNamesEqual = true;
    private boolean isParentSiblingsNamesEqual = true;
    private boolean isFirstChild = true;
    private boolean isFirstSibling = false;
    private boolean isParentWithEmptyTextContent = false;
    private boolean hasGrandParentAttributes = false;
    private boolean hasParentAttributes = false;

    // inside vars
    private ArrayNode rootArrayNode;
    private ObjectNode rootObjectNode;
    private HashMap<String, Namespace> xmlnsMapOnThisNode = new HashMap<>();

    private String classAttr;
    private String typeAttr;
    private String namespace;

    private int numberOfSiblings;
    private int numberOfChildren;
    private int elementDeepestDepth;
    private int nodeCount = 0;

    private boolean hasAttributes;
    private boolean isRootNode;
    private boolean areSiblingsNamesEqual;
    private boolean areChildrenNamesEqual;
    private boolean isElementDefiningNamespaces;
    private boolean isElementOnNamespace;
    private boolean isElementWithEmptyTextContent;
    private boolean isRootArray;
    private boolean isObject;
    private boolean isOneValue;
    private boolean isSingleChildren;
    private boolean isElementMustBeNull;

    public XmlToJsonConfiguration() {}

    public boolean isForceTopLevelObject() {
        return forceTopLevelObject;
    }

    public void setForceTopLevelObject(boolean forceTopLevelObject) {
        this.forceTopLevelObject = forceTopLevelObject;
    }

    public boolean isSkipWhitespace() {
        return skipWhitespace;
    }

    public void setSkipWhitespace(boolean skipWhitespace) {
        this.skipWhitespace = skipWhitespace;
    }

    public boolean isTrimSpaces() {
        return trimSpaces;
    }

    public void setTrimSpaces(boolean trimSpaces) {
        this.trimSpaces = trimSpaces;
    }

    public boolean isSkipNamespaces() {
        return skipNamespaces;
    }

    public void setSkipNamespaces(boolean skipNamespaces) {
        this.skipNamespaces = skipNamespaces;
    }

    public boolean isRemoveNamespacePrefixes() {
        return removeNamespacePrefixes;
    }

    public void setRemoveNamespacePrefixes(boolean removeNamespacePrefixes) {
        this.removeNamespacePrefixes = removeNamespacePrefixes;
    }

    public boolean isTypeHints() {
        return typeHints;
    }

    public void setTypeHints(boolean typeHints) {
        this.typeHints = typeHints;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public HashMap<String, Namespace> getXmlnsMap() {
        return xmlnsMap;
    }

    public void setXmlnsMap(HashMap<String, Namespace> xmlnsMap) {
        this.xmlnsMap = xmlnsMap;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getParentSiblings() {
        return parentSiblings;
    }

    public void setParentSiblings(int parentSiblings) {
        this.parentSiblings = parentSiblings;
    }

    public String getGrandParentClass() {
        return grandParentClass;
    }

    public void setGrandParentClass(String grandParentClass) {
        this.grandParentClass = grandParentClass;
    }

    public String getParentClass() {
        return parentClass;
    }

    public void setParentClass(String parentClass) {
        this.parentClass = parentClass;
    }

    public String getParentNamespace() {
        return parentNamespace;
    }

    public void setParentNamespace(String parentNamespace) {
        this.parentNamespace = parentNamespace;
    }

    public boolean isGrandParentSiblingsNamesEqual() {
        return isGrandParentSiblingsNamesEqual;
    }

    public void setGrandParentSiblingsNamesEqual(boolean grandParentSiblingsNamesEqual) {
        isGrandParentSiblingsNamesEqual = grandParentSiblingsNamesEqual;
    }

    public boolean isParentSiblingsNamesEqual() {
        return isParentSiblingsNamesEqual;
    }

    public void setParentSiblingsNamesEqual(boolean parentSiblingsNamesEqual) {
        isParentSiblingsNamesEqual = parentSiblingsNamesEqual;
    }

    public boolean isHasGrandParentAttributes() {
        return hasGrandParentAttributes;
    }

    public void setHasGrandParentAttributes(boolean hasGrandParentAttributes) {
        this.hasGrandParentAttributes = hasGrandParentAttributes;
    }

    public boolean isHasParentAttributes() {
        return hasParentAttributes;
    }

    public void setHasParentAttributes(boolean hasParentAttributes) {
        this.hasParentAttributes = hasParentAttributes;
    }

    public boolean isFirstChild() {
        return isFirstChild;
    }

    public void setFirstChild(boolean firstChild) {
        isFirstChild = firstChild;
    }

    public boolean isParentWithEmptyTextContent() {
        return isParentWithEmptyTextContent;
    }

    public void setParentWithEmptyTextContent(boolean parentWithEmptyTextContent) {
        isParentWithEmptyTextContent = parentWithEmptyTextContent;
    }

    public boolean isSpecialCaseTTFTTF() {
        return (isForceTopLevelObject() && isSkipWhitespace() && !isTrimSpaces() && isSkipNamespaces() &&
                !isRemoveNamespacePrefixes() && isTypeHints());
    }

    public void setSpecialCaseTTFTTF(boolean specialCaseTTFTTF) {
        isSpecialCaseTTFTTF = specialCaseTTFTTF;
    }

    public ArrayNode getRootArrayNode() {
        return rootArrayNode;
    }

    public void setRootArrayNode(ArrayNode rootArrayNode) {
        this.rootArrayNode = rootArrayNode;
    }

    public ObjectNode getRootObjectNode() {
        return rootObjectNode;
    }

    public void setRootObjectNode(ObjectNode rootObjectNode) {
        this.rootObjectNode = rootObjectNode;
    }

    public HashMap<String, Namespace> getXmlnsMapOnThisNode() {
        return xmlnsMapOnThisNode;
    }

    public void setXmlnsMapOnThisNode(HashMap<String, Namespace> xmlnsMapOnThisNode) {
        this.xmlnsMapOnThisNode = xmlnsMapOnThisNode;
    }

    public String getClassAttr() {
        return classAttr;
    }

    public void setClassAttr(String classAttr) {
        this.classAttr = classAttr;
    }

    public String getTypeAttr() {
        return typeAttr;
    }

    public void setTypeAttr(String typeAttr) {
        this.typeAttr = typeAttr;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public int getNumberOfSiblings() {
        return numberOfSiblings;
    }

    public void setNumberOfSiblings(int numberOfSiblings) {
        this.numberOfSiblings = numberOfSiblings;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public int getElementDeepestDepth() {
        return elementDeepestDepth;
    }

    public void setElementDeepestDepth(int elementDeepestDepth) {
        this.elementDeepestDepth = elementDeepestDepth;
    }

    public boolean isHasAttributes() {
        return hasAttributes;
    }

    public void setHasAttributes(boolean hasAttributes) {
        this.hasAttributes = hasAttributes;
    }

    public boolean isRootNode() {
        return isRootNode;
    }

    public void setRootNode(boolean rootNode) {
        isRootNode = rootNode;
    }

    public boolean isAreSiblingsNamesEqual() {
        return areSiblingsNamesEqual;
    }

    public void setAreSiblingsNamesEqual(boolean areSiblingsNamesEqual) {
        this.areSiblingsNamesEqual = areSiblingsNamesEqual;
    }

    public boolean isAreChildrenNamesEqual() {
        return areChildrenNamesEqual;
    }

    public void setAreChildrenNamesEqual(boolean areChildrenNamesEqual) {
        this.areChildrenNamesEqual = areChildrenNamesEqual;
    }

    public boolean isElementDefiningNamespaces() {
        return isElementDefiningNamespaces;
    }

    public void setElementDefiningNamespaces(boolean elementDefiningNamespaces) {
        isElementDefiningNamespaces = elementDefiningNamespaces;
    }

    public boolean isElementOnNamespace() {
        return isElementOnNamespace;
    }

    public void setElementOnNamespace(boolean elementOnNamespace) {
        isElementOnNamespace = elementOnNamespace;
    }

    public boolean isElementWithEmptyTextContent() {
        return isElementWithEmptyTextContent;
    }

    public void setElementWithEmptyTextContent(boolean elementWithEmptyTextContent) {
        isElementWithEmptyTextContent = elementWithEmptyTextContent;
    }

    public boolean isRootArray() {
        return isRootArray;
    }

    public void setRootArray(boolean rootArray) {
        isRootArray = rootArray;
    }

    public boolean isObject() {
        return isObject;
    }

    public void setObject(boolean object) {
        isObject = object;
    }

    public boolean isOneValue() {
        return isOneValue;
    }

    public void setOneValue(boolean oneValue) {
        isOneValue = oneValue;
    }

    public boolean isSingleChildren() {
        return isSingleChildren;
    }

    public void setSingleChildren(boolean singleChildren) {
        isSingleChildren = singleChildren;
    }

    public boolean isElementMustBeNull() {
        return isElementMustBeNull;
    }

    public void setElementMustBeNull(boolean elementMustBeNull) {
        isElementMustBeNull = elementMustBeNull;
    }

    public int getNodeCount() {
        return nodeCount;
    }

    public void setNodeCount(int nodeCount) {
        this.nodeCount = nodeCount;
    }

    public boolean isFirstSibling() {
        return isFirstSibling;
    }

    public void setFirstSibling(boolean firstSibling) {
        isFirstSibling = firstSibling;
    }

    public boolean isToDiscard() {
        Set<String> discardXmlToJsonOptionsSet = Set.of(
                "FFTFTF", "FFTFTT", "FFTTFF", "FFTTFT", "FFTTTF", "FFTTTT", "FTTFFF", "FTTFFT", "FTTFTF", "FTTFTT", "FTTTFF",
                "FTTTFT", "FTTTTT", "TFTFFF", "TFTFFT", "TFTFTF", "TFTFTT", "TFTTFF", "TFTTFT", "TFTTTF", "TFTTTT", "TTFTTT",
                "TTTFFF", "TTTFTF", "TTTFTT", "TTTTFF", "TTTTFT", "TTTTTF"
        );
        String optionCode = "" +
                (forceTopLevelObject ? "T" : "F") +
                (skipWhitespace ? "T" : "F") +
                (trimSpaces ? "T" : "F") +
                (skipNamespaces ? "T" : "F") +
                (removeNamespacePrefixes ? "T" : "F") +
                (typeHints ? "T" : "F");

        return discardXmlToJsonOptionsSet.contains(optionCode);
    }

    public void setToDiscard(boolean toDiscard) {
        isToDiscard = toDiscard;
    }

    public void init() {
        setXmlnsMap(new HashMap<>());
        setXmlnsMapOnThisNode(new HashMap<>());
        setElement(null);
        setRootObjectNode(JsonNodeFactory.instance.objectNode());
        setRootArrayNode(JsonNodeFactory.instance.arrayNode());
    }

    public void initVariables() {

        setRootObjectNode(JsonNodeFactory.instance.objectNode());
        setRootArrayNode(JsonNodeFactory.instance.arrayNode());

        setNumberOfSiblings(ElementUtils.calculateNumberOfSiblings(element));
        setNumberOfChildren(ElementUtils.calculateNumberOfChildren(element));
        setElementDeepestDepth(ElementUtils.calculateElementDeepestDepth(element));

        setClassAttr(element.getAttribute(Constants.JSON_XML_ATTR_CLASS));
        setTypeAttr(element.getAttribute(Constants.JSON_XML_ATTR_TYPE));

        setHasAttributes(isTypeHints() ? ElementChecker.hasSimpleAttributes(element) : element.hasAttributes());
        setRootNode(level == 0);
        setAreSiblingsNamesEqual(ElementUtils.areSiblingsNamesEqual(element));
        setAreChildrenNamesEqual(ElementUtils.areChildrenNamesEqual(element));

        setXmlnsMapOnThisNode(ElementUtils.getNamespacesOnThisNode(element, xmlnsMap, level));
        setXmlnsMap(xmlnsMapOnThisNode);

        setElementDefiningNamespaces(ElementUtils.isElementDefiningNamespaces(element));
        setElementOnNamespace(ElementUtils.isElementOnNamespace(element, xmlnsMapOnThisNode));
        setNamespace(ElementUtils.getElementNamePrefix(element));
        setElementWithEmptyTextContent(
                !isSkipWhitespace() && ElementUtils.isElementWithEmptyTextContent(element)
        );

        setRootArray(ElementChecker.isRootArray(this));
        setObject(ElementChecker.isObject(this));
        setOneValue(ElementChecker.isOneValue(this));
        setSingleChildren(ElementChecker.isSingleChildren(this));
    }

    // create sub level configuration
    public XmlToJsonConfiguration createSubLevelConfig(Element childElement) {
        try {
            XmlToJsonConfiguration subLevelConfig = (XmlToJsonConfiguration)this.clone();

            subLevelConfig.setElement(childElement);
            subLevelConfig.setLevel(this.getLevel() +1);
            subLevelConfig.setGrandParentClass(this.getParentClass());
            subLevelConfig.setParentClass(this.getClassAttr());
            subLevelConfig.setParentSiblings(this.getNumberOfSiblings());
            subLevelConfig.setGrandParentSiblingsNamesEqual(this.isParentSiblingsNamesEqual());
            subLevelConfig.setParentSiblingsNamesEqual(this.isAreSiblingsNamesEqual());
            subLevelConfig.setHasGrandParentAttributes(this.hasParentAttributes);
            subLevelConfig.setHasParentAttributes(this.hasAttributes);
            subLevelConfig.setFirstChild(this.isFirstSibling());
            subLevelConfig.setParentNamespace(this.getNamespace());
            subLevelConfig.setParentWithEmptyTextContent(this.isElementWithEmptyTextContent());

            return subLevelConfig;
        } catch (java.lang.CloneNotSupportedException e) {
            log.error("Could not create config for sub level", e);
            return null;
        }
    }
}
