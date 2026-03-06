package org.assimbly.soap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SoapAttribute {

    @JsonIgnore
    private String id;

    private String name;
    private String value;

    public SoapAttribute() {}

    public SoapAttribute(String name) {
        this.name = name;
    }

    public SoapAttribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }
    public String getValue() { return value; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
