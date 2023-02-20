package org.assimbly.soap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SoapHttpHeader {

    @JsonIgnore
    private String _id;

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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
