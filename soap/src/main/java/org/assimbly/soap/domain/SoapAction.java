package org.assimbly.soap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class SoapAction {

    @JsonIgnore
    private String _id;

    private String name;
    private List<SoapHeader> headers;

    public SoapAction(String name) {
        this.name = name;
        this.headers = new ArrayList<>();
    }

    public void addSoapheader(SoapHeader header){
        this.headers.add(header);
    }

    public String getName() {
        return name;
    }

    public List<SoapHeader> getHeaders() {
        return headers;
    }

    public void setHeaders(List<SoapHeader> headers) {
        this.headers = headers;
    }
}
