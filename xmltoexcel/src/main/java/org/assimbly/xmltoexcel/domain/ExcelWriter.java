package org.assimbly.xmltoexcel.domain;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ExcelWriter {

    private final Workbook workbook;
    private Sheet sheet;
    private int rowNum;
    private int cellNum;
    private Row row;

    public ExcelWriter(ExcelFormat excelFormat) {
        if (excelFormat == ExcelFormat.XLS)
            workbook = new HSSFWorkbook(); // XLS
        else
            workbook = new XSSFWorkbook(); // XLSX
    }

    public void addSheet(String name) {
        sheet = workbook.createSheet(name);
        rowNum = 0;
    }

    public void addRow() {
        row = sheet.createRow(rowNum++);
        cellNum = 0;
    }

    public void addCell(String value) {
        Cell cell = row.createCell(cellNum++);
        setCellValue(value, cell);
    }

    public void addCell(int value ) {
        Cell cell = row.createCell(cellNum++);
        cell.setCellValue(value);
    }

    public void write(ByteArrayOutputStream outputStream) throws IOException {
        workbook.write(outputStream);
        workbook.close();
    }

    private void setCellValue(String value, Cell cell) {
        String integerRegex = "-?\\d+";
        if (value.matches(integerRegex)) {
            cell.setCellValue(Integer.parseInt(value));
        }
        else cell.setCellValue(value);
    }
}
