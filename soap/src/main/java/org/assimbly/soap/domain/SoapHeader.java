package org.assimbly.soap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class SoapHeader {

    @JsonIgnore
    private String id;

    private String name;
    private List<SoapAttribute> attrs;

    public SoapHeader() {
        this.attrs = new ArrayList<>();
    }

    public SoapHeader(String name) {
        this.name = name;
        this.attrs = new ArrayList<>();
    }

    public boolean hasAttributes() {
        if (attrs.isEmpty())
            return false;

        List<SoapAttribute> tmp = attrs;
        tmp.removeIf(attr -> attr.getValue() == null);
        return !tmp.isEmpty();
    }

    public void addAttribute(SoapAttribute attribute){
        this.attrs.add(attribute);
    }

    public String getName() {
        return name;
    }

    public List<SoapAttribute> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<SoapAttribute> attributes) {
        this.attrs = attributes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
