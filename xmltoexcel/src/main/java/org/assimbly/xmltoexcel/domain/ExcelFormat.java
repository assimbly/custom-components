package org.assimbly.xmltoexcel.domain;

public enum ExcelFormat {
    XLSX, XLS;

    public static ExcelFormat fromString(String s) {
        return ExcelFormat.valueOf(s.toUpperCase());
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
