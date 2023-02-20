package org.assimbly.smooksnoxml;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import static javax.xml.XMLConstants.NULL_NS_URI;

/**
 * Proxy to the Sax content handler that assumes some defaults and replaces
 * annoying checked exceptions with unchecked ones
 */
public class XmlDocumentHandler {

    private final ContentHandler contentHandler;
    private static final AttributesImpl EMPTY_ATTR = new AttributesImpl();

    public XmlDocumentHandler(ContentHandler contentHandler) {
        this.contentHandler = contentHandler;
    }

    public ContentHandler getContentHandler() {
        return contentHandler;
    }

    public void startElement(String name, Attributes attributes) {
        try {
            contentHandler.startElement(NULL_NS_URI, name, "", attributes);
        } catch (SAXException e) {
            throw new XmlDocumentStreamException(e);
        }
    }

    public void startElement(String name) {
        startElement(name, EMPTY_ATTR);
    }

    public void endElement(String name) {
        try {
            contentHandler.endElement(NULL_NS_URI, name, "");
        } catch (SAXException e) {
            throw new XmlDocumentStreamException(e);
        }
    }

    public void sendCharacters(String characters) {
        try {
            contentHandler.characters(characters.toCharArray(), 0, characters.length());
        } catch (SAXException e) {
            throw new XmlDocumentStreamException(e);
        }
    }

    public void startDocument() {
        try {
            contentHandler.startDocument();
        } catch (SAXException e) {
            throw new XmlDocumentStreamException(e);
        }
    }

    public void endDocument() {
        try {
            contentHandler.endDocument();
        } catch (SAXException e) {
            throw new XmlDocumentStreamException(e);
        }
    }
}
