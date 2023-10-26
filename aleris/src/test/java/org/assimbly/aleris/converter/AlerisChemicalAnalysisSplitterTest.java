package org.assimbly.aleris.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlerisChemicalAnalysisSplitterTest {
    private AlerisChemicalAnalysisSplitter splitter;

    @BeforeEach
    public void setUp() {
        this.splitter = new AlerisChemicalAnalysisSplitter();
    }

    @Test
    public void getElementNames() {
        List<String> elementNames = splitter.getElementNames("line1\nline2\n  AL  ZI   MN  \nline3\nline4");
        assertEquals(Arrays.asList("AL", "ZI", "MN"), elementNames);
    }

    @Test
    public void getNonExistingElementNames() {
        Assertions.assertThrows(IllegalAlerisCertificateException.class, () -> {
            splitter.getElementNames("");
        });
    }

    @Test
    public void getCastAnalyses() {
        Map<String, List<String>> castAnalyses = splitter.getCastAnalyses("lin1\nline2\n001 0095823 0,09 0,31\n002 0095824 0,19 0,32\nline3");

        Map<String, List<String>> expected = new HashMap<>();
        expected.put("001", Arrays.asList("0095823", "0,09", "0,31"));
        expected.put("002", Arrays.asList("0095824", "0,19", "0,32"));

        assertEquals(expected, castAnalyses);
    }
}
