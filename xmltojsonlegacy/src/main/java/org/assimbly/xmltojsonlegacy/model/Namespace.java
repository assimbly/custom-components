package org.assimbly.xmltojsonlegacy.model;

public class Namespace {

    private final String xmlNamespace;
    private final int level;

    public Namespace(String xmlNamespace, int level) {
        this.xmlNamespace = xmlNamespace;
        this.level = level;
    }

    public String getNamespace() {
        return xmlNamespace;
    }

    public int getLevel() {
        return level;
    }
}