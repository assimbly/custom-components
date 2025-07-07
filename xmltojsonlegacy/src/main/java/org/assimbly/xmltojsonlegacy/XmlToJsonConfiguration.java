package org.assimbly.xmltojsonlegacy;

import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

import java.util.Set;

@UriParams
public class XmlToJsonConfiguration {

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

    public boolean isSpecialCaseTTFTTF() {
        return (isForceTopLevelObject() && isSkipWhitespace() && !isTrimSpaces() && isSkipNamespaces() &&
                !isRemoveNamespacePrefixes() && isTypeHints());
    }

    public boolean isToDiscard(XmlToJsonConfiguration config) {
        Set<String> discardXmlToJsonOptionsSet = Set.of(
                "FFTFTF", "FFTFTT", "FFTTFF", "FFTTFT", "FFTTTF", "FFTTTT", "FTTFFF", "FTTFFT", "FTTFTF", "FTTFTT", "FTTTFF",
                "FTTTFT", "FTTTTT", "TFTFFF", "TFTFFT", "TFTFTF", "TFTFTT", "TFTTFF", "TFTTFT", "TFTTTF", "TFTTTT", "TTFTTT",
                "TTTFFF", "TTTFTF", "TTTFTT", "TTTTFF", "TTTTFT", "TTTTTF"
        );
        String optionCode = "" +
                (config.isForceTopLevelObject() ? "T" : "F") +
                (config.isSkipWhitespace() ? "T" : "F") +
                (config.isTrimSpaces() ? "T" : "F") +
                (config.isSkipNamespaces() ? "T" : "F") +
                (config.isRemoveNamespacePrefixes() ? "T" : "F") +
                (config.isTypeHints() ? "T" : "F");

        return discardXmlToJsonOptionsSet.contains(optionCode);
    }
}
