package org.assimbly.aleris.converter;

import org.assimbly.aleris.certificate.*;

import java.util.*;
import java.util.stream.Collectors;

public class AlerisCertificateConverter {
    private static final AlerisCertificateSplitter certificateSplitter = new AlerisCertificateSplitter();

    private static final AlerisHeaderSplitter headerSplitter = new AlerisHeaderSplitter();
    private static final AlerisChemicalAnalysisSplitter chemicalAnalysisSplitter = new AlerisChemicalAnalysisSplitter();
    private static final AlerisMechanicalPropertiesSplitter mechanicalPropertiesSplitter = new AlerisMechanicalPropertiesSplitter();
    private static final AlerisCrateContentSplitter crateContentSplitter = new AlerisCrateContentSplitter();

    private static final AlerisUnitMatcher unitMatcher = new AlerisUnitMatcher();

    public Certificates convert(String textualCertificate) {
        Certificates certificates = new Certificates();
        certificates.addCertificate(convertCertificate(textualCertificate));

        return certificates;
    }

    private Certificate convertCertificate(String textualCertificate) {
        String textualHeader = certificateSplitter.getHeader(textualCertificate);
        String textualChemicalAnalysis = certificateSplitter.getChemicalAnalysis(textualCertificate);
        String textualMechanicalProperties = certificateSplitter.getMechanicalProperties(textualCertificate);
        String textualCrateContent = certificateSplitter.getCrateContent(textualCertificate);

        final String customerName = headerSplitter.getCustomerName(textualHeader);
        String issuerCode = null;
        String customerCode = null;
        // The following issuer codes have been provided by Euramax.
        if (customerName.endsWith("B.V.")) {
            // The customer name refers to Euramax Roermond.
            issuerCode = "07410";
            customerCode = "R";
        } else if (customerName.endsWith("LTD")) {
            // The customer name refers to Euramax Corby.
            issuerCode = "C0870";
            customerCode = "C";
        }

        Company customer = new Company(customerName, customerCode, headerSplitter.getCustomerOrderNumber(textualHeader));
        Company issuer = new Company("Aleris", issuerCode, headerSplitter.getIssuerOrderNumber(textualHeader));

        // Euramax confirmed that the document number should be used as the certificate number.
        final String certificateNumber = headerSplitter.getDocumentNumber(textualHeader);
        final String issueDate = headerSplitter.getDate(textualHeader);
        Certificate certificate = new Certificate(certificateNumber, issueDate, issuer, customer);

        final String issuerOrderNumberPartOne = headerSplitter.getIssuerOrderNumberPartOne(textualHeader);

        List<String> units = mechanicalPropertiesSplitter.getUnits(textualMechanicalProperties);
        Map<String, List<List<String>>> testResults = mechanicalPropertiesSplitter.getTestResults(textualMechanicalProperties);
        Map<String, List<MechanicalProperty>> mechanicalProperties = convertTestResults(units, testResults);

        List<String> elementNames = chemicalAnalysisSplitter.getElementNames(textualChemicalAnalysis);
        Map<String, List<String>> castAnalyses = chemicalAnalysisSplitter.getCastAnalyses(textualChemicalAnalysis);
        Map<String, String> crateNumbers = crateContentSplitter.getCrateNumbers(textualCrateContent);
        List<StockUnit> stockUnits = convertCastAnalyses(elementNames, castAnalyses, mechanicalProperties, issuerOrderNumberPartOne, crateNumbers);
        stockUnits.forEach(certificate::addStockUnit);

        return certificate;
    }

    Map<String, List<MechanicalProperty>> convertTestResults(List<String> units, Map<String, List<List<String>>> testResults) {
        Map<String, List<MechanicalProperty>> properties = new HashMap<>();
        testResults.forEach((castNumber, testResultsForCast) -> properties.put(castNumber, convertTestResultsForCast(units, testResultsForCast)));

        return properties;
    }

    List<MechanicalProperty> convertTestResultsForCast(List<String> units, List<List<String>> testResultsForCast) {
        List<MechanicalProperty> properties = new ArrayList<>();

        List<MechanicalProperty> elongations = Collections.emptyList();
        List<MechanicalProperty> yieldStrengths = Collections.emptyList();
        List<MechanicalProperty> tensileStrengths = Collections.emptyList();

        for (int i = 0; i < units.size(); ++i) {
            String unit = units.get(i);
            if (unitMatcher.elongation(unit)) {
                elongations = getMechanicalProperties(testResultsForCast, i, "ELO", "%");
            } else if (unitMatcher.yieldStrength(unit)) {
                yieldStrengths = getMechanicalProperties(testResultsForCast, i, "PST", "N/mm2");
            } else if (unitMatcher.tensileStrength(unit)) {
                tensileStrengths = getMechanicalProperties(testResultsForCast, i, "UTS", "N/mm2");
            }
        }

        properties.addAll(elongations);
        properties.addAll(yieldStrengths);
        properties.addAll(tensileStrengths);

        return properties;
    }

    List<MechanicalProperty> getMechanicalProperties(List<List<String>> testResults, int index, String code, String unit) {
        return testResults.stream().map(row -> new MechanicalProperty(code, null, row.get(index), unit)).collect(Collectors.toList());
    }

    List<StockUnit> convertCastAnalyses(List<String> elementNames, Map<String, List<String>> castAnalyses, Map<String, List<MechanicalProperty>> mechanicalProperties, String issuerOrderNumberPartOne, Map<String, String> crateNumbers) {
        return castAnalyses.entrySet().stream().map(entry -> convertCastAnalysis(elementNames, entry.getValue(), mechanicalProperties.get(entry.getKey()), issuerOrderNumberPartOne, crateNumbers.get(entry.getKey()))).collect(Collectors.toList());
    }

    StockUnit convertCastAnalysis(List<String> elementNames, List<String> properties, List<MechanicalProperty> mechanicalProperties, String issuerOrderNumberPartOne, String crateNumber) {
        Component baseMetal = new Component("Al", "Aluminium", null);
        ChemicalComposition chemicalComposition = new ChemicalComposition("% mass", baseMetal);

        for (int i = 0; i < elementNames.size(); ++i) {
            String elementName = convertElementName(elementNames.get(i));
            String percentage = properties.get(i + 1);
            chemicalComposition.addComponent(new Component(elementName, null, convertPercentage(percentage)));
        }

        // Euramax confirmed that the cast number ("geutnummer") should be used as ingot case.
        final String ingotCase = properties.get(0);

        // Euramax confirmed that the stock unit identifier is constructed by concatenating the first part of the
        // issuer order number and the crate number.
        final String stockUnitId = issuerOrderNumberPartOne + crateNumber;

        StockUnit stockUnit = new StockUnit(stockUnitId, ingotCase, chemicalComposition);
        mechanicalProperties.forEach(stockUnit::addMechanicalProperty);

        return stockUnit;
    }

    private String convertElementName(String name) {
        String firstLetter = name.substring(0, 1).toUpperCase();
        String remainder = name.substring(1, name.length()).toLowerCase();
        return firstLetter + remainder;
    }

    private String convertPercentage(String percentage) {
        return percentage.replace(',', '.');
    }
}
