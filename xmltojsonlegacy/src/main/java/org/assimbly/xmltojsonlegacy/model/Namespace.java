package org.assimbly.xmltojsonlegacy.model;

public class Namespace {

    private String namespace;
    private int level;

    public Namespace(String namespace, int level) {
        this.namespace = namespace;
        this.level = level;
    }

    public String getNamespace() {
        return namespace;
    }

    public int getLevel() {
        return level;
    }
}