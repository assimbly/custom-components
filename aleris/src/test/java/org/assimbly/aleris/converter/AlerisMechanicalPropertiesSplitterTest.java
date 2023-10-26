package org.assimbly.aleris.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlerisMechanicalPropertiesSplitterTest {
    private AlerisMechanicalPropertiesSplitter splitter;

    @BeforeEach
    public void setUp() {
        this.splitter = new AlerisMechanicalPropertiesSplitter();
    }

    @Test
    public void getUnits() {
        List<String> units = splitter.getUnits("line1\nline2\n RM(T) RP02(T) A50(T)\nline3\n");
        assertEquals(Arrays.asList("RM(T)", "RP02(T)", "A50(T)"), units);
    }

    @Test
    public void getNonExistingUnits() {
        Assertions.assertThrows(IllegalAlerisCertificateException.class, () -> {
            splitter.getUnits("");
        });
    }

    @Test
    public void getTestResultsWithoutSubCoil() {
        Map<String, List<List<String>>> testResults = splitter.getTestResults("line1\n 001 /A 120 112\n 001 /V 121 113\nline2\n");
        Map<String, List<List<String>>> expected = new HashMap<>();
        expected.put("001", Arrays.asList(Arrays.asList("120", "112"), Arrays.asList("121", "113")));
        assertEquals(expected, testResults);
    }

    @Test
    public void getTestResultsWithSubCoil() {
        Map<String, List<List<String>>> testResults = splitter.getTestResults("line1\n 001/A01 /A 120 112\n 001/A02 /V 121 113\nline2\n");
        Map<String, List<List<String>>> expected = new HashMap<>();
        expected.put("001", Arrays.asList(Arrays.asList("120", "112"), Arrays.asList("121", "113")));
        assertEquals(expected, testResults);
    }
}
