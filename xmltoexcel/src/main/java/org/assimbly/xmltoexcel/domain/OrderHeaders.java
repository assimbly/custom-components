package org.assimbly.xmltoexcel.domain;

public enum OrderHeaders {
    UNORDERED, ASCENDING, DESCENDING;

    public static OrderHeaders fromString(String s) {
        return OrderHeaders.valueOf(s.toUpperCase());
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
