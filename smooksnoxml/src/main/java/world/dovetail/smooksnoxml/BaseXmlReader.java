package world.dovetail.smooksnoxml;

import org.milyn.container.ExecutionContext;
import org.milyn.xml.SmooksXMLReader;
import org.xml.sax.*;

import java.io.IOException;
import java.io.StringReader;

public abstract class BaseXmlReader implements SmooksXMLReader {

    // avoiding &#10; as line break representation due to issue CAMEL-4857
    protected static final String LINE_BREAK = "LB";

    protected XmlDocumentHandler documentHandler;

    protected static String quote(String string) {
        return java.util.regex.Pattern.quote(string);
    }

    public void parse(String s) throws IOException, SAXException {
        parse(new InputSource(new StringReader(s)));
    }

    public void setContentHandler(ContentHandler contentHandler) {
        this.documentHandler = new XmlDocumentHandler(contentHandler);
    }

    public ContentHandler getContentHandler() {
        return documentHandler.getContentHandler();
    }

    /****************************************************************************
     *
     * Unsupported methods below
     *
     ****************************************************************************/

    public void setExecutionContext(ExecutionContext executionContext) {
    }

    public boolean getFeature(String s) throws SAXNotRecognizedException, SAXNotSupportedException {
        return false;
    }

    public void setFeature(String s, boolean b) throws SAXNotRecognizedException, SAXNotSupportedException {
    }

    public Object getProperty(String s) throws SAXNotRecognizedException, SAXNotSupportedException {
        return null;
    }

    public void setProperty(String s, Object o) throws SAXNotRecognizedException, SAXNotSupportedException {
    }

    public void setEntityResolver(EntityResolver entityResolver) {
    }

    public EntityResolver getEntityResolver() {
        return null;
    }

    public void setDTDHandler(DTDHandler dtdHandler) {
    }

    public DTDHandler getDTDHandler() {
        return null;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
    }

    public ErrorHandler getErrorHandler() {
        return null;
    }
}
