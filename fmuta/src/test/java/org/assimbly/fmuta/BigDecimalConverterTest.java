package org.assimbly.fmuta;

import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BigDecimalConverterTest {
    @Test
    public void convertWithComma() {
        BigDecimalConverter converter = new BigDecimalConverter(',');

        assertEquals(BigDecimal.ZERO,               converter.convert("0"));
        assertEquals(new BigDecimal("0.00"),        converter.convert("0,00"));
        assertEquals(new BigDecimal("0.01"),        converter.convert("0,01"));
        assertEquals(new BigDecimal("0.10"),        converter.convert("0,10"));
        assertEquals(new BigDecimal("1.00"),        converter.convert("1,00"));
        assertEquals(new BigDecimal("1000.00"),     converter.convert("1000,00"));
        assertEquals(new BigDecimal("1000000.00"),  converter.convert("1000000,00"));

        assertEquals(BigDecimal.ZERO,               converter.convert("-0"));
        assertEquals(new BigDecimal("-0.00"),       converter.convert("-0,00"));
        assertEquals(new BigDecimal("-0.01"),       converter.convert("-0,01"));
        assertEquals(new BigDecimal("-0.10"),       converter.convert("-0,10"));
        assertEquals(new BigDecimal("-1.00"),       converter.convert("-1,00"));
        assertEquals(new BigDecimal("-1000.00"),    converter.convert("-1000,00"));
        assertEquals(new BigDecimal("-1000000.00"), converter.convert("-1000000,00"));
    }

    @Test
    public void revertWithComma() {
        BigDecimalConverter converter = new BigDecimalConverter(',');

        assertEquals("0,00", converter.revert(BigDecimal.ZERO));
        assertEquals("0,00", converter.revert(new BigDecimal("0.00")));

        assertEquals("0,01",        converter.revert(new BigDecimal("0.01")));
        assertEquals("0,10",        converter.revert(new BigDecimal("0.10")));
        assertEquals("1,00",        converter.revert(new BigDecimal("1.00")));
        assertEquals("1000,00",     converter.revert(new BigDecimal("1000.00")));
        assertEquals("1000000,00",  converter.revert(new BigDecimal("1000000.00")));

        assertEquals("-0,01",       converter.revert(new BigDecimal("-0.01")));
        assertEquals("-0,10",       converter.revert(new BigDecimal("-0.10")));
        assertEquals("-1,00",       converter.revert(new BigDecimal("-1.00")));
        assertEquals("-1000,00",    converter.revert(new BigDecimal("-1000.00")));
        assertEquals("-1000000,00", converter.revert(new BigDecimal("-1000000.00")));
    }

    @Test
    public void convertWithPeriod() {
        BigDecimalConverter converter = new BigDecimalConverter('.');

        assertEquals(BigDecimal.ZERO,               converter.convert("0"));
        assertEquals(new BigDecimal("0.00"),        converter.convert("0.00"));
        assertEquals(new BigDecimal("0.01"),        converter.convert("0.01"));
        assertEquals(new BigDecimal("0.10"),        converter.convert("0.10"));
        assertEquals(new BigDecimal("1.00"),        converter.convert("1.00"));
        assertEquals(new BigDecimal("1000.00"),     converter.convert("1000.00"));
        assertEquals(new BigDecimal("1000.00"),     converter.convert("1000.00"));
        assertEquals(new BigDecimal("1000000.00"),  converter.convert("1000000.00"));

        assertEquals(BigDecimal.ZERO,               converter.convert("-0"));
        assertEquals(new BigDecimal("-0.00"),       converter.convert("-0.00"));
        assertEquals(new BigDecimal("-0.01"),       converter.convert("-0.01"));
        assertEquals(new BigDecimal("-0.10"),       converter.convert("-0.10"));
        assertEquals(new BigDecimal("-1.00"),       converter.convert("-1.00"));
        assertEquals(new BigDecimal("-1000.00"),    converter.convert("-1000.00"));
        assertEquals(new BigDecimal("-1000.00"),    converter.convert("-1000.00"));
        assertEquals(new BigDecimal("-1000000.00"), converter.convert("-1000000.00"));
    }

    @Test
    public void revertWithPeriod() {
        BigDecimalConverter converter = new BigDecimalConverter('.');

        assertEquals("0.00", converter.revert(BigDecimal.ZERO));
        assertEquals("0.00", converter.revert(new BigDecimal("0.00")));

        assertEquals("0.01",        converter.revert(new BigDecimal("0.01")));
        assertEquals("0.10",        converter.revert(new BigDecimal("0.10")));
        assertEquals("1.00",        converter.revert(new BigDecimal("1.00")));
        assertEquals("1000.00",     converter.revert(new BigDecimal("1000.00")));
        assertEquals("1000000.00",  converter.revert(new BigDecimal("1000000.00")));

        assertEquals("-0.01",       converter.revert(new BigDecimal("-0.01")));
        assertEquals("-0.10",       converter.revert(new BigDecimal("-0.10")));
        assertEquals("-1.00",       converter.revert(new BigDecimal("-1.00")));
        assertEquals("-1000.00",    converter.revert(new BigDecimal("-1000.00")));
        assertEquals("-1000000.00", converter.revert(new BigDecimal("-1000000.00")));
    }

    @Test
    public void convertException() {
        BigDecimalConverter converter = new BigDecimalConverter('.');
        boolean exceptionThrown = false;
        try {
            converter.convert("nonsense");
        } catch (IllegalArgumentException e) {
            assertEquals("Unable to parse 'nonsense' as decimal number", e.getMessage());
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }

    @Test
    public void revertException() {
        BigDecimalConverter converter = new BigDecimalConverter('.');
        boolean exceptionThrown = false;
        try {
            converter.revert(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Cannot revert null to string. Expected instance of BigDecimal", e.getMessage());
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }
}
