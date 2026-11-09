package org.assimbly.xmltojsonlegacy.model;

public class Namespace {

    private final String uri;
    private final int level;

    public Namespace(String uri, int level) {
        this.uri = uri;
        this.level = level;
    }

    public String getNamespace() {
        return uri;
    }

    public int getLevel() {
        return level;
    }

}