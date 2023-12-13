import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void testReverseValidString() {
        assertEquals("tac", StringUtils.reverse("cat"));
    }

    @Test
    public void testReverseEmptyString() {
        assertEquals("", StringUtils.reverse(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testReverseNullString() {
        StringUtils.reverse(null);
    }

    @Test
    public void testReverseSingleCharacterString() {
        assertEquals("a", StringUtils.reverse("a"));
    }

    @Test
    public void testReverseLongString() {
        assertEquals("54321", StringUtils.reverse("12345"));
    }
}