package org.assimbly.fmuta;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

public class BigDecimalConverter {
    private static final String pattern = "#,##0.00";

    private DecimalFormat format;

    public BigDecimalConverter(char decimalSeparator) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(decimalSeparator);
        format = new DecimalFormat(pattern, symbols);
        format.setGroupingUsed(false);
        format.setParseBigDecimal(true);
    }

    public BigDecimal convert(String input) {
        try {
            return (BigDecimal) format.parse(input);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Unable to parse '" + input + "' as decimal number");
        }
    }

    public String revert(BigDecimal input) {
        if (input == null) {
            throw new IllegalArgumentException("Cannot revert null to string. Expected instance of BigDecimal");
        }
        return format.format(input);
    }
}
