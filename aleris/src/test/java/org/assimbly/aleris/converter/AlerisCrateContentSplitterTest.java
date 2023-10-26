package org.assimbly.aleris.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlerisCrateContentSplitterTest {
    private AlerisCrateContentSplitter splitter;

    @BeforeEach
    public void setUp() {
        splitter = new AlerisCrateContentSplitter();
    }

    @Test
    public void getCrateNumbersWithoutSubRoll() {
        Map<String, String> crateNumbers = splitter.getCrateNumbers("line1\nline2\n   123   456   789\n  012  345  678\nline4\nline5");
        Map<String, String> expected = new HashMap<>();
        expected.put("123", "0456");
        expected.put("012", "0345");
        assertEquals(expected, crateNumbers);
    }

    @Test
    public void getCrateNumbersWithSubRoll() {
        Map<String, String> crateNumbers = splitter.getCrateNumbers("line1\nline2\n   123   AB1   456   789\n  012  CD2  345  678\nline4\nline5");
        Map<String, String> expected = new HashMap<>();
        expected.put("123", "0456");
        expected.put("012", "0345");
        assertEquals(expected, crateNumbers);
    }

    @Test
    public void padding() {
        Map<String, String> crateNumbers = splitter.getCrateNumbers("line1\nline2\n   123   4   567\n  012  34567  89\nline4\nline5");
        Map<String, String> expected = new HashMap<>();
        expected.put("123", "0004");
        expected.put("012", "34567");
        assertEquals(expected, crateNumbers);
    }
}
