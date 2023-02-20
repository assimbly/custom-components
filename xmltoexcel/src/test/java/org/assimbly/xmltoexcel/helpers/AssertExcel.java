package org.assimbly.xmltoexcel.helpers;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;

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

        Assert.assertEquals("Expected sheet names to be equal", expectedSheetName, actual.getSheetName());
        Assert.assertEquals("Expected first row numbers to be equal in sheet: " + expectedSheetName,
                expectedFirstRowNum, actual.getFirstRowNum());
        Assert.assertEquals("Expected last row numbers to be equal in sheet: " + expectedSheetName,
                expectedLastRowNum, actual.getLastRowNum());

        for (int i = expectedFirstRowNum; i <= expectedLastRowNum; i++) {
            assertRowsAreEqual(expectedSheetName, actual.getRow(i), expected.getRow(i));
        }
    }

    private static void assertRowsAreEqual(String sheetName, Row actual, Row expected) {
        int expectedFirstCellNum = expected.getFirstCellNum();
        int expectedLastCellNum = expected.getLastCellNum();

        Assert.assertEquals("Expected first cell numbers to be equal in sheet: " + sheetName,
                expectedFirstCellNum, actual.getFirstCellNum());
        Assert.assertEquals("Expected last cell numbers to be equal in sheet: " + sheetName,
                expectedLastCellNum, actual.getLastCellNum());

        for (int i = expectedFirstCellNum; i <= expectedLastCellNum; i++) {
            assertCellsAreEqual(sheetName, actual.getCell(i), expected.getCell(i));
        }
    }

    private static void assertCellsAreEqual(String sheetName, Cell actual, Cell expected) {
        if (expected == null) {
            Assert.assertNull(actual);
            return;
        }

        Assert.assertEquals(String.format("Expected the cell type of cell %s to be equal in sheet: %s",
                expected.getAddress(), sheetName), expected.getCellType(), actual.getCellType());

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

        Assert.assertEquals(String.format("Expected the values of cell %s to be equal in sheet: %s",
                expected.getAddress(), sheetName), expectedValue, actualValue);
    }
}
