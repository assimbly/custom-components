package org.assimbly.aleris.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlerisUnitMatcherTest {
    private AlerisUnitMatcher matcher;

    @BeforeEach
    public void setUp() {
        matcher = new AlerisUnitMatcher();
    }

    @Test
    public void elongation() {
        Assertions.assertTrue(matcher.elongation("A50(T)"));
        Assertions.assertTrue(matcher.elongation("A50 (T)"));
        Assertions.assertFalse(matcher.elongation(""));
        Assertions.assertFalse(matcher.elongation("A50"));
        Assertions.assertFalse(matcher.elongation("(T)"));
    }

    @Test
    public void tensileStrength() {
        Assertions.assertTrue(matcher.tensileStrength("RM(T)"));
        Assertions.assertTrue(matcher.tensileStrength("RM (T)"));
        Assertions.assertFalse(matcher.tensileStrength(""));
        Assertions.assertFalse(matcher.tensileStrength("RM"));
        Assertions.assertFalse(matcher.tensileStrength("(T)"));
    }
    @Test
    public void yieldStrength() {
        Assertions.assertTrue(matcher.yieldStrength("RP02(T)"));
        Assertions.assertTrue(matcher.yieldStrength("RP02 (T)"));
        Assertions.assertFalse(matcher.yieldStrength(""));
        Assertions.assertFalse(matcher.yieldStrength("RP02"));
        Assertions.assertFalse(matcher.yieldStrength("(T)"));
    }
}
