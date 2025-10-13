package org.assimbly.xmltocsv.domain;

public enum QuoteFields {
    ALL_FIELDS, NON_INTEGER_FIELDS, NO_FIELDS;

    public static QuoteFields fromString(String s) {
        return QuoteFields.valueOf(s.toUpperCase());
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}