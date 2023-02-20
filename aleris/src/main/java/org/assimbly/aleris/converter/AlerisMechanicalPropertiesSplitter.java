package org.assimbly.aleris.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlerisMechanicalPropertiesSplitter {
    private static final Pattern units = Pattern.compile("^(?:\\s*[^(\\n]+\\([^)\\n]+\\))+\\s*$", Pattern.MULTILINE);
    private static final Pattern unit = Pattern.compile("[^(]+\\([^)]+\\)");
    private static final Pattern testResults = Pattern.compile("^\\s*(\\d+)(?:/[A-Z]+\\d+)?\\s+/(?:A|M|V|O)((\\s+\\d+)+)\\s*$$", Pattern.MULTILINE);
    private static final Pattern integerNumber = Pattern.compile("\\d+");

    public List<String> getUnits(String mechanicalProperties) {
        Matcher unitsMatcher = units.matcher(mechanicalProperties);
        boolean isFound = unitsMatcher.find();
        if (!isFound) {
            throw new IllegalAlerisCertificateException("Units not found in mechanical properties of certificate");
        }
        String units = unitsMatcher.group();

        Matcher unitMatcher = unit.matcher(units);
        List<String> result = new ArrayList<>();
        while (unitMatcher.find()) {
            result.add(unitMatcher.group().trim());
        }

        return result;
    }

    public Map<String, List<List<String>>> getTestResults(String mechanicalProperties) {
        Matcher testResultsMatcher = testResults.matcher(mechanicalProperties);
        Map<String, List<List<String>>> result = new HashMap<>();
        while (testResultsMatcher.find()) {
            String testResult = testResultsMatcher.group(2);
            String testNumber = testResultsMatcher.group(1);

            List<List<String>> a = result.get(testNumber);
            if (a == null) {
                a = new ArrayList<>();
                result.put(testNumber, a);
            }

            List<String> numbers = new ArrayList<>();
            Matcher integerNumberMatcher = integerNumber.matcher(testResult);
            while (integerNumberMatcher.find()) {
                numbers.add(integerNumberMatcher.group().trim());
            }

            a.add(numbers);
        }

        return result;
    }

}
