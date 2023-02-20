package org.assimbly.exceltoxml.domain;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.assimbly.exceltoxml.exception.Excel2XmlException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExcelReader {

    public static List<List<SheetCell>> readExcel(Workbook workbook, ExcelRule rule) throws Excel2XmlException {

        Sheet sheet = workbook.getSheet(rule.getWorksheet());

        if (sheet == null)
            throw new Excel2XmlException("Unable to load sheet with name: " + rule.getWorksheet());

        CellRangeAddress range = CellRangeAddress.valueOf(rule.getCellRange());
        List<List<SheetCell>> rows = new ArrayList<>();

        try {
            for (int i = range.getFirstRow(); i <= range.getLastRow(); i++) {
                Row row = sheet.getRow(i);
                List<SheetCell> rowCells = processRow(row, range);
                rows.add(rowCells);
            }
        } catch (Exception e) {
            throw new Excel2XmlException("Unable to process rule named " + rule.getName() + ". Unreadable range " + rule.getCellRange() + " in sheet " + rule.getWorksheet());
        }

        if (rule.getTranspose())
            rows = transpose(rows);

        if (rule.getHeaderRow())
            nameXmlElements(rows);

        return rows;
    }

    private static List<List<SheetCell>> transpose(List<List<SheetCell>> matrixIn) {
        if (matrixIn.isEmpty())
            return Collections.emptyList();

        int dataWidth = matrixIn.stream().mapToInt(List::size).max().getAsInt();

        List<List<SheetCell>> list = new ArrayList<>();
        for (int i = 0; i < dataWidth; i++) {
            List<SheetCell> collect = new ArrayList<>();
            for (List<SheetCell> row : matrixIn) {
                if (!row.isEmpty()) {
                    SheetCell sheetCell = row.get(i);
                    collect.add(sheetCell);
                }
            }
            list.add(collect);
        }
        return list;
    }

    private static List<SheetCell> processRow(Row row, CellRangeAddress range) {
        if (row == null)
            return Collections.emptyList();

        return IntStream.rangeClosed(range.getFirstColumn(), range.getLastColumn())
                .mapToObj(i -> row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK))
                .map(SheetCell::new)
                .collect(Collectors.toList());
    }

    private static void nameXmlElements(List<List<SheetCell>> rows) {
        if (rows.isEmpty())
            return;

        List<String> cellNames = rows.get(0).stream().map(SheetCell::getCellValue).collect(Collectors.toList());
        rows.remove(0);
        for (List<SheetCell> row : rows) {
            for (int i = 0; i < row.size(); i++) {
                if (!cellNames.isEmpty() && !cellNames.get(i).isEmpty())
                    row.get(i).setCellName(cellNames.get(i));
            }
        }
    }
}
