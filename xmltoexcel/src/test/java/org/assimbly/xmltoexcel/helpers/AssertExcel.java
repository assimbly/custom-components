package org.assimbly.xmltoexcel.helpers;

import org.apache.poi.ss.usermodel.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AssertExcel {
    public static void assertWorkbooksAreEqual(Workbook actual, Workbook expected) {
        for (int i = 0; i < expected.getNumberOfSheets(); i++) {
            assertSheetsAreEqual(actual.getSheetAt(i), expected.getSheetAt(i));
        }
    }

    private static void assertSheetsAreEqual(Sheet actual, Sheet expected) {
        String expectedSheetName = expected.getSheetName();
        int expectedFirstRowNum = expected.getFirstRowNum();
        int expectedLastRowNum = expected.getLastRowNum();

        assertEquals(expectedSheetName, actual.getSheetName(), "Expected sheet names to be equal");
        assertEquals(expectedFirstRowNum, actual.getFirstRowNum(), "Expected first row numbers to be equal in sheet: " + expectedSheetName);
        assertEquals(expectedLastRowNum, actual.getLastRowNum(), "Expected last row numbers to be equal in sheet: " + expectedSheetName);

        for (int i = expectedFirstRowNum; i <= expectedLastRowNum; i++) {
            assertRowsAreEqual(expectedSheetName, actual.getRow(i), expected.getRow(i));
        }
    }

    private static void assertRowsAreEqual(String sheetName, Row actual, Row expected) {
        int expectedFirstCellNum = expected.getFirstCellNum();
        int expectedLastCellNum = expected.getLastCellNum();

        assertEquals(expectedFirstCellNum, actual.getFirstCellNum(), "Expected first cell numbers to be equal in sheet: " + sheetName);
        assertEquals(expectedLastCellNum, actual.getLastCellNum(), "Expected last cell numbers to be equal in sheet: " + sheetName);

        for (int i = expectedFirstCellNum; i <= expectedLastCellNum; i++) {
            assertCellsAreEqual(sheetName, actual.getCell(i), expected.getCell(i));
        }
    }

    private static void assertCellsAreEqual(String sheetName, Cell actual, Cell expected) {
        if (expected == null) {
            assertNull(actual);
            return;
        }

        assertEquals(expected.getCellType(), actual.getCellType(), String.format("Expected the cell type of cell %s to be equal in sheet: %s",
                expected.getAddress(), sheetName));

        assertCellValuesAreEqual(sheetName, actual, expected);
    }

    private static void assertCellValuesAreEqual(String sheetName, Cell actual, Cell expected) {
        String actualValue;
        String expectedValue;

        if (expected.getCellType() == CellType.NUMERIC) {
            actualValue = String.valueOf(actual.getNumericCellValue());
            expectedValue = String.valueOf(expected.getNumericCellValue());
        }
        else {
            actualValue = actual.getStringCellValue();
            expectedValue = expected.getStringCellValue();
        }

        assertEquals(expectedValue, actualValue, String.format("Expected the values of cell %s to be equal in sheet: %s",
                expected.getAddress(), sheetName));
    }
}
