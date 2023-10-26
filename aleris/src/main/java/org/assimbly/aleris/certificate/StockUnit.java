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
public class StockUnit {
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private String id;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    @XmlElement(name = "ingot-case")
    private String ingotCase;

    @SuppressWarnings({"FieldCanBeLocal", "unused", "MismatchedQueryAndUpdateOfCollection"})
    @XmlElementWrapper(name = "mechanical-properties")
    @XmlElement(name = "property")
    private List<MechanicalProperty> mechanicalProperties;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    @XmlElement(name = "chemical-composition")
    private ChemicalComposition chemicalComposition;

    // Required by JAXB for unmarshalling
    @SuppressWarnings("unused")
    protected StockUnit() {}

    public StockUnit(String id, String ingotCase, ChemicalComposition chemicalComposition) {
        this.id = id;
        this.ingotCase = ingotCase;
        this.mechanicalProperties = new ArrayList<>();
        this.chemicalComposition = chemicalComposition;
    }

    public void addMechanicalProperty(MechanicalProperty mechanicalProperty) {
        this.mechanicalProperties.add(mechanicalProperty);
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
