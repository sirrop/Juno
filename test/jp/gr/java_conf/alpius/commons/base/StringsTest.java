package jp.gr.java_conf.alpius.commons.base;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringsTest {

    @Test
    public void emptyToNull() {
        assertNull(Strings.emptyToNull(""));
    }

    @Test
    public void nullToEmpty() {
        assertEquals("", Strings.nullToEmpty(null));
    }

    @Test
    public void isNullOrEmpty() {
        assertTrue(Strings.isNullOrEmpty(""));
        assertTrue(Strings.isNullOrEmpty(null));
        assertFalse(Strings.isNullOrEmpty("foo"));
    }

    @Test
    public void isNotNullOrEmpty() {
        assertFalse(Strings.isNotNullOrEmpty(""));
        assertFalse(Strings.isNotNullOrEmpty(null));
        assertTrue(Strings.isNotNullOrEmpty("foo"));
    }
}
