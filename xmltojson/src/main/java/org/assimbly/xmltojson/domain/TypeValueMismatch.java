package org.assimbly.xmltojson.domain;

public enum TypeValueMismatch {
    ORIGINAL, NULL, ERROR;

    public static TypeValueMismatch fromString(String s) {
        return TypeValueMismatch.valueOf(s.toUpperCase());
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
