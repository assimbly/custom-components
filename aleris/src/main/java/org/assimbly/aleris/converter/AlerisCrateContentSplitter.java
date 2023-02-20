package org.assimbly.aleris.converter;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlerisCrateContentSplitter {
    private static final Pattern crateNumber = Pattern.compile("^\\s*(\\d+)\\s+([0-9a-zA-Z]+\\s+)?(\\d+)\\s+\\d+\\s*$", Pattern.MULTILINE);

    public Map<String, String> getCrateNumbers(String crateContent) {
        Map<String, String> crateNumbers = new HashMap<>();

        Matcher matcher = crateNumber.matcher(crateContent);
        while (matcher.find()) {
            crateNumbers.put(matcher.group(1), pad(matcher.group(3)));
        }

        return crateNumbers;
    }

    private String pad(String numericString) {
        Integer number = Integer.parseInt(numericString);
        return String.format("%04d", number);
    }
}
