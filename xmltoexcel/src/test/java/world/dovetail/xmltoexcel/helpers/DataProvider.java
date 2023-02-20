package world.dovetail.xmltoexcel.helpers;

import world.dovetail.xmltoexcel.XmlToExcelConfiguration;
import world.dovetail.xmltoexcel.domain.CustomWorksheet;
import world.dovetail.xmltoexcel.domain.ExcelFormat;
import world.dovetail.xmltoexcel.domain.OrderHeaders;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    public static XmlToExcelConfiguration getStandardConfig() {
        return new XmlToExcelConfiguration(true, false, "line",
                OrderHeaders.UNORDERED, ExcelFormat.XLSX);
    }

    public static XmlToExcelConfiguration getIndexColumnOnConfig() {
        XmlToExcelConfiguration config = getStandardConfig();
        config.setIncludeIndexColumn(true);
        return config;
    }

    public static XmlToExcelConfiguration getIndexColumnOffConfig() {
        XmlToExcelConfiguration config = getStandardConfig();
        config.setIncludeIndexColumn(false);
        return config;
    }

    public static XmlToExcelConfiguration getIncludeHeaderOnConfig() {
        XmlToExcelConfiguration config = getStandardConfig();
        config.setIncludeHeader(true);
        return config;
    }

    public static XmlToExcelConfiguration getIncludeHeaderOffConfig() {
        XmlToExcelConfiguration config = getStandardConfig();
        config.setIncludeHeader(false);
        return config;
    }

    public static XmlToExcelConfiguration getCustomIndexColumnNameConfig() {
        XmlToExcelConfiguration config = getStandardConfig();
        config.setIncludeIndexColumn(true);
        config.setIndexColumnName("index");
        return config;
    }

    public static XmlToExcelConfiguration getOrderingAscendingConfig() {
        XmlToExcelConfiguration config = getStandardConfig();
        config.setOrderHeaders(OrderHeaders.ASCENDING);
        return config;
    }

    public static XmlToExcelConfiguration getOrderingDescendingConfig() {
        XmlToExcelConfiguration config = getStandardConfig();
        config.setOrderHeaders(OrderHeaders.DESCENDING);
        return config;
    }

    public static XmlToExcelConfiguration getOrderingUnorderedConfig() {
        XmlToExcelConfiguration config = getStandardConfig();
        config.setOrderHeaders(OrderHeaders.UNORDERED);
        return config;
    }

    public static XmlToExcelConfiguration getXLSFormatConfig() {
        XmlToExcelConfiguration config = getStandardConfig();
        config.setExcelFormat(ExcelFormat.XLS);
        return config;
    }

    public static XmlToExcelConfiguration getCustomSheetsForStandardSettingsConfig() {
        XmlToExcelConfiguration config = getStandardConfig();
        List<CustomWorksheet> worksheets = new ArrayList<CustomWorksheet>() {{
            add(new CustomWorksheet("Foods", "//food"));
            add(new CustomWorksheet("Drinks", "/breakfast_menu/Drinks"));
            add(new CustomWorksheet("Named", "/breakfast_menu/Named"));
        }};
        config.setWorksheets(worksheets);
        return config;
    }

    public static XmlToExcelConfiguration getCustomSheetsExampleUseCaseConfig() {
        XmlToExcelConfiguration config = getStandardConfig();
        List<CustomWorksheet> worksheets = new ArrayList<CustomWorksheet>() {{
            add(new CustomWorksheet("Foods", "//food"));
            add(new CustomWorksheet("Drinks", "//drink"));
        }};
        config.setWorksheets(worksheets);
        return config;
    }
}
