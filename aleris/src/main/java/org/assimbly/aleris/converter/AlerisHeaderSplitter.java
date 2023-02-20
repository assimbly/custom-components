package org.assimbly.aleris.converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlerisHeaderSplitter {
    private static final Pattern customerName = Pattern.compile("(?:KLANT|CUSTOMER)\\s*:\\s*(.+)$", Pattern.MULTILINE);
    private static final Pattern customerOrderNumber = Pattern.compile("(?:UW ORDERNUMMER|YOUR ORDER NUMBER)\\s*:\\s*(.+)(?:KLANT|CUSTOMER)\\s*:");
    private static final Pattern issuerOrderNumber = Pattern.compile("^\\s*(?:ONS ORDERNUMMER|OUR ORDER NUMBER)\\s*:\\s*(\\S+)", Pattern.MULTILINE);
    private static final Pattern issuerOrderNumberPartOne = Pattern.compile("([^/]+)/");
    private static final Pattern documentNumber = Pattern.compile("DOC\\s*:\\s*(.+)(?:DATUM|DATE)");
    private static final Pattern date = Pattern.compile("(?:DATUM|DATE)\\s*:\\s*(.+)PROD\\. REF\\.");

    public String getCustomerName(String header) {
        return getFirstGroup(customerName, header, "Customer name not found in certificate");
    }

    public String getCustomerOrderNumber(String header) {
        return getFirstGroup(customerOrderNumber, header, "Customer order number not found in certificate");
    }

    public String getIssuerOrderNumber(String header) {
        return getFirstGroup(issuerOrderNumber, header, "Issuer order number not found in certificate");
    }

    public String getIssuerOrderNumberPartOne(String header) {
        String issuerOrderNumber = getIssuerOrderNumber(header);
        return getFirstGroup(issuerOrderNumberPartOne, issuerOrderNumber, "First part of issuer order number not found in certificate");
    }

    public String getDocumentNumber(String header) {
        return getFirstGroup(documentNumber, header, "Document number not found in certificate");
    }

    public String getDate(String header) {
        return getFirstGroup(date, header, "Date not found in certificate");
    }

    private String getFirstGroup(Pattern pattern, String input, String errorMessage) {
        return getGroup(pattern, input, 1, errorMessage);
    }

    private String getGroup(Pattern pattern, String input, int groupNumber, String errorMessage) {
        Matcher matcher = pattern.matcher(input);
        boolean isFound = matcher.find();

        if (!isFound) {
            throw new IllegalAlerisCertificateException(errorMessage);
        }

        return matcher.group(groupNumber).trim();
    }
}
