package org.assimbly.soap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SoapHttpHeader {

    @JsonIgnore
    private String id;

    private String name;
    private String value;

    public SoapHttpHeader() {
    }

    public SoapHttpHeader(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
