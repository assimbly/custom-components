package org.assimbly.exceltoxml.domain;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.CellReference;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.assimbly.exceltoxml.exception.Excel2XmlException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.poi.ss.usermodel.CellType.FORMULA;

public class SheetCell {

    private static final String DEFAULT_CELL_NAME = "cell";

    private String cellName;
    private String cellValue;
    private String rowIndex;
    private String colIndex;

    private static final String INVALID_CHAR_REGEX = "[^A-Za-z0-9_.-]";
    private static final String INVALID_START_REGEX = "^([0-9.-]|(?i)xml).*";

    public SheetCell(Cell cell) {
        this.cellName = DEFAULT_CELL_NAME;
        this.cellValue = cell.getCellType() == FORMULA ? evaluateFormula(cell) : new DataFormatter().formatCellValue(cell);
        this.colIndex = CellReference.convertNumToColString(cell.getColumnIndex());
        this.rowIndex = String.valueOf(cell.getRowIndex());
    }

    private String evaluateFormula(Cell cell) {
        return switch(cell.getCachedFormulaResultType()) {
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case STRING -> String.valueOf(cell.getRichStringCellValue());
            default -> cell.getStringCellValue();
        };
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

    public static String fixInvalidXml(String input) {
        String result = input;

        result = result.replaceAll(INVALID_CHAR_REGEX, "");

        Pattern startPattern = Pattern.compile(INVALID_START_REGEX);
        Matcher startMatcher = startPattern.matcher(result);

        if (startMatcher.matches() || result.isEmpty()) {
            String stripped = result.replaceAll("^([0-9.-]+|(?i)xml)", "");

            if (stripped.isEmpty()) {
                result = "element-" + result; // nothing usable remains, e.g. "789" → "element-789"
            } else {
                result = stripped; // valid remainder, e.g. "xmlCreateOrderAW" → "CreateOrderAW"
            }
        }

        return result;
    }


}
