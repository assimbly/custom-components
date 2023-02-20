package org.assimbly.xmltoexcel.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomWorksheet {

    private String name;
    private String xPathExpression;

    public CustomWorksheet() {
    }

    public CustomWorksheet(String name, String xPathExpression) {
        this.name = name;
        this.xPathExpression = xPathExpression;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("xPathExpression")
    public String getXPathExpression() {
        return xPathExpression;
    }

    public void setXPathExpression(String xPathExpression) {
        this.xPathExpression = xPathExpression;
    }
}
