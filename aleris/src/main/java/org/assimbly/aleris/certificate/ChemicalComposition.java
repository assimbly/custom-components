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
public class ChemicalComposition {
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private String unit;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    @XmlElement(name = "base-metal")
    private Component baseMetal;

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    @XmlElementWrapper(name = "components")
    @XmlElement(name = "component")
    private List<Component> components;

    // Required by JAXB for unmarshalling
    @SuppressWarnings("unused")
    protected ChemicalComposition() {}

    public ChemicalComposition(String unit, Component baseMetal) {
        this.unit = unit;
        this.baseMetal = baseMetal;
        this.components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        this.components.add(component);
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
