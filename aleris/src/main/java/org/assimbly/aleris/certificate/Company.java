package org.assimbly.aleris.certificate;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Company {
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private String name;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private String code;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    @XmlElement(name = "order-number")
    private String orderNumber;

    // Required by JAXB for unmarshalling
    @SuppressWarnings("unused")
    protected Company() {}

    public Company(String name, String code, String orderNumber) {
        this.name = name;
        this.code = code;
        this.orderNumber = orderNumber;
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(obj, this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
