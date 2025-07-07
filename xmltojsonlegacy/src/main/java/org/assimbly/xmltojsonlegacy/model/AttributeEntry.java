package org.assimbly.xmltojsonlegacy.model;

import javax.xml.namespace.QName;

public class AttributeEntry {

    private final QName qname;
    private final String value;

    public AttributeEntry(QName qname, String value) {
        this.qname = qname;
        this.value = value;
    }

    public QName getQname() {
        return qname;
    }

    public String getValue() {
        return value;
    }
}
