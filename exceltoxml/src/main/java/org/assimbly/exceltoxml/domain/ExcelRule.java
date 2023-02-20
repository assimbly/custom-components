package org.assimbly.exceltoxml.domain;

public class ExcelRule {

    private String name;
    private String cellRange;
    private Boolean transpose;
    private Boolean headerRow;
    private Boolean discardEmpty;
    private String worksheet;

    public ExcelRule() {
    }

    public ExcelRule(String name, String cellRange, Boolean transpose, Boolean headerRow, Boolean discardEmpty, String worksheet) {
        this.name = name;
        this.cellRange = cellRange;
        this.transpose = transpose;
        this.headerRow = headerRow;
        this.discardEmpty = discardEmpty;
        this.worksheet = worksheet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellRange() {
        return cellRange;
    }

    public void setCellRange(String cellRange) {
        this.cellRange = cellRange;
    }

    public Boolean getTranspose() {
        return transpose;
    }

    public void setTranspose(Boolean transpose) {
        this.transpose = transpose;
    }

    public Boolean getHeaderRow() {
        return Boolean.TRUE.equals(headerRow);
    }

    public void setHeaderRow(Boolean headerRow) {
        this.headerRow = headerRow;
    }

    public Boolean getDiscardEmpty() {
        return Boolean.TRUE.equals(discardEmpty);
    }

    public void setDiscardEmpty(Boolean discardEmpty) {
        this.discardEmpty = discardEmpty;
    }

    public String getWorksheet() {
        return worksheet;
    }

    public void setWorksheet(String worksheet) {
        this.worksheet = worksheet;
    }
}
