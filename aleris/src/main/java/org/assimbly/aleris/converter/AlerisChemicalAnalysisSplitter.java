package org.assimbly.aleris.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlerisChemicalAnalysisSplitter {
    private static final Pattern elementNames = Pattern.compile("^((\\s*[a-zA-Z]{2})+)\\s*$", Pattern.MULTILINE);
    private static final Pattern elementName = Pattern.compile("[a-zA-Z]{2}");

    private static final Pattern castAnalysis = Pattern.compile("^\\s*(\\d+)\\s+(\\d+)(\\s+\\d+,\\d+)+\\s*$", Pattern.MULTILINE);
    private static final Pattern decimalValue = Pattern.compile("\\d+,\\d+");

    public List<String> getElementNames(String mechanicalProperties) {
        Matcher matcher = elementNames.matcher(mechanicalProperties);
        boolean isFound = matcher.find();
        if (!isFound) {
            throw new IllegalAlerisCertificateException("Element names not found in certificate");
        }

        String elementNames = matcher.group();
        matcher = elementName.matcher(elementNames);

        List<String> result = new ArrayList<>();
        while(matcher.find()) {
            result.add(matcher.group());
        }

        return result;
    }

    public Map<String, List<String>> getCastAnalyses(String mechanicalProperties) {
        Map<String, List<String>> castAnalyses = new HashMap<>();

        Matcher castAnalysisMatcher = castAnalysis.matcher(mechanicalProperties);
        while (castAnalysisMatcher.find()) {
            String castAnalysis = castAnalysisMatcher.group();
            String coilNumber = castAnalysisMatcher.group(1);
            String castNumber = castAnalysisMatcher.group(2);

            List<String> properties = new ArrayList<>();
            properties.add(castNumber);
            Matcher decimalValueMatcher = decimalValue.matcher(castAnalysis);
            while (decimalValueMatcher.find()) {
                String decimalValue = decimalValueMatcher.group();
                properties.add(decimalValue);
            }

            castAnalyses.put(coilNumber, properties);
        }

        return castAnalyses;
    }
}
