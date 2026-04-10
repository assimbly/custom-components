package org.assimbly.exceltoxml;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.assimbly.exceltoxml.domain.ExcelReader;
import org.assimbly.exceltoxml.domain.ExcelRule;
import org.assimbly.exceltoxml.domain.SheetCell;
import org.assimbly.exceltoxml.exception.Excel2XmlException;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;
import java.util.List;

public class ExcelToXmlProcessor implements Processor {

    private static final Logger log = LoggerFactory.getLogger(ExcelToXmlProcessor.class);

    private final ExcelToXmlEndpoint endpoint;

    public ExcelToXmlProcessor(ExcelToXmlEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        ExcelToXmlConfiguration configuration = endpoint.getConfiguration();
        List<ExcelRule> excelRules = configuration.getReadRules();

        InputStream inputStream = exchange.getIn().getBody(InputStream.class);

        Workbook workbook = WorkbookFactory.create(inputStream);

        Document xmlDocument = newDocument();

        if(xmlDocument == null)
            throw new ParserConfigurationException();

        Element rootElement = xmlDocument.createElement("Excel");
        xmlDocument.appendChild(rootElement);

        for (ExcelRule rule: excelRules) {
            List<List<SheetCell>> ruleData = ExcelReader.readExcel(workbook, rule);
            rootElement.appendChild( buildRuleXml(ruleData, rule, xmlDocument) );
        }


        exchange.getIn().setBody(prettyPrint(xmlDocument));

    }

    private Element buildRuleXml(List<List<SheetCell>> list, ExcelRule rule, Document doc) {
        Element rangeData = doc.createElement(rule.getName());
        String xmlEntryName = Boolean.TRUE.equals(rule.getTranspose()) ? "excelCol" : "excelRow";

        for (List<SheetCell> cells : list) {

            if (allBlank(cells) && Boolean.TRUE.equals(rule.getDiscardEmpty()))
                continue;

            Element excelEntry = doc.createElement(xmlEntryName);

            try {
                for (SheetCell cell : cells) {
                    if (!cell.getCellValue().isEmpty() || !rule.getDiscardEmpty())
                        excelEntry.appendChild(cell.getXmlElement(doc));
                }
            } catch (Excel2XmlException e) {
                throw new Excel2XmlException("Error processing rule " + rule.getName() + e.getMessage());
            }

            rangeData.appendChild(excelEntry);
        }

        return rangeData;
    }

    private boolean allBlank(List<SheetCell> cells) {
        return cells.stream().allMatch(cell -> cell.getCellValue().isEmpty());
    }

    public static Document newDocument(){
        DocumentBuilderFactory icFactory;
        DocumentBuilder icBuilder;

        try {
            icFactory = DocumentBuilderFactory.newInstance();
            icBuilder = icFactory.newDocumentBuilder();

            return icBuilder.newDocument();
        } catch (ParserConfigurationException e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }

    public String prettyPrint(Document doc) {
        DOMImplementationLS domImplementation = (DOMImplementationLS) doc.getImplementation();
        LSSerializer lsSerializer = domImplementation.createLSSerializer();

        // Set the pretty print hint
        lsSerializer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);

        return lsSerializer.writeToString(doc);
    }

}
