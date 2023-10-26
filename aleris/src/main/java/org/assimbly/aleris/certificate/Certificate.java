package org.assimbly.aleris.certificate;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Certificate {
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private String number;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    @XmlElement(name = "issue-date")
    private String issueDate;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    @XmlElement(name = "issued-by")
    private Company issuer;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    @XmlElement(name = "issued-to")
    private Company customer;

    @SuppressWarnings({"FieldCanBeLocal", "unused", "MismatchedQueryAndUpdateOfCollection"})
    @XmlElementWrapper(name = "stock-units")
    @XmlElement(name = "stock-unit")
    private List<StockUnit> stockUnits;

    // Required by JAXB for unmarshalling
    @SuppressWarnings("unused")
    protected Certificate() {}

    public Certificate(String number, String issueDate, Company issuer, Company customer) {
        this.number = number;
        this.issueDate = issueDate;
        this.issuer = issuer;
        this.customer = customer;
        this.stockUnits = new ArrayList<>();
    }

    public void addStockUnit(StockUnit stockUnit) {
        this.stockUnits.add(stockUnit);
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
