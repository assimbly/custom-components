package org.assimbly.aleris.converter;

import java.util.regex.Pattern;

public class AlerisUnitMatcher {
    private static final Pattern elongation = Pattern.compile("A50\\s*\\(T\\)");
    private static final Pattern tensileStrength = Pattern.compile("RM\\s*\\(T\\)");
    private static final Pattern yieldStrength = Pattern.compile("RP02\\s*\\(T\\)");

    public boolean elongation(String unit) {
        return elongation.matcher(unit).matches();
    }

    public boolean tensileStrength(String unit) {
        return tensileStrength.matcher(unit).matches();
    }

    public boolean yieldStrength(String unit) {
        return yieldStrength.matcher(unit).matches();
    }
}
