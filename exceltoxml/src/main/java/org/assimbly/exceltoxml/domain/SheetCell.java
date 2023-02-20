package org.assimbly.exceltoxml.domain;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellReference;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.assimbly.exceltoxml.exception.Excel2XmlException;

import static org.apache.poi.ss.usermodel.CellType.FORMULA;
import static org.assimbly.util.helper.XmlHelper.fixInvalidXml;

public class SheetCell {

    private static final String DEFAULT_CELL_NAME = "cell";

    private String cellName;
    private String cellValue;
    private String rowIndex;
    private String colIndex;

    public SheetCell(Cell cell) {
        this.cellName = DEFAULT_CELL_NAME;
        this.cellValue = cell.getCellType() == FORMULA ? evaluateFormula(cell) : new DataFormatter().formatCellValue(cell);
        this.colIndex = CellReference.convertNumToColString(cell.getColumnIndex());
        this.rowIndex = String.valueOf(cell.getRowIndex());
    }

    private String evaluateFormula(Cell cell) {
        switch(cell.getCachedFormulaResultType()) {
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case STRING:
                return String.valueOf(cell.getRichStringCellValue());
            default:
                return cell.getStringCellValue();
        }
    }

    public String getCellValue() {
        return cellValue;
    }

    public void setCellValue(String cellValue) {
        this.cellValue = cellValue;
    }

    public String getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(String rowIndex) {
        this.rowIndex = rowIndex;
    }

    public String getColIndex() {
        return colIndex;
    }

    public void setColIndex(String colIndex) {
        this.colIndex = colIndex;
    }

    public void setCellName(String cellName) {
        this.cellName = fixInvalidXml(cellName);
    }

    public String getCellName() {
        return cellName;
    }

    public Element getXmlElement(Document doc) throws Excel2XmlException {
        try {
            Element cell = doc.createElement(cellName);

            cell.setTextContent(getCellValue());

            if (cellName.equals(DEFAULT_CELL_NAME)) {
                cell.setAttribute("colIndex", colIndex);
                cell.setAttribute("rowIndex", rowIndex);
            }

            return cell;

        } catch (DOMException e) {
            throw new Excel2XmlException(" at cell "
                    + colIndex + rowIndex + ": " + e.getMessage());
        }
    }
}
