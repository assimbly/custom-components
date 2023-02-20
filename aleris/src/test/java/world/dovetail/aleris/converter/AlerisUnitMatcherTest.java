package world.dovetail.aleris.converter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlerisUnitMatcherTest {
    private AlerisUnitMatcher matcher;

    @Before
    public void setUp() {
        matcher = new AlerisUnitMatcher();
    }

    @Test
    public void elongation() {
        Assert.assertTrue(matcher.elongation("A50(T)"));
        Assert.assertTrue(matcher.elongation("A50 (T)"));
        Assert.assertFalse(matcher.elongation(""));
        Assert.assertFalse(matcher.elongation("A50"));
        Assert.assertFalse(matcher.elongation("(T)"));
    }

    @Test
    public void tensileStrength() {
        Assert.assertTrue(matcher.tensileStrength("RM(T)"));
        Assert.assertTrue(matcher.tensileStrength("RM (T)"));
        Assert.assertFalse(matcher.tensileStrength(""));
        Assert.assertFalse(matcher.tensileStrength("RM"));
        Assert.assertFalse(matcher.tensileStrength("(T)"));
    }
    @Test
    public void yieldStrength() {
        Assert.assertTrue(matcher.yieldStrength("RP02(T)"));
        Assert.assertTrue(matcher.yieldStrength("RP02 (T)"));
        Assert.assertFalse(matcher.yieldStrength(""));
        Assert.assertFalse(matcher.yieldStrength("RP02"));
        Assert.assertFalse(matcher.yieldStrength("(T)"));
    }
}
