
import org.junit.Test;
import static org.junit.Assert.*;

public class PasswordValidatorTest {

    @Test
    public void testAcceptablePassword() {
        assertTrue(PasswordValidator.isPasswordAcceptable("StrongP@ss123!"));
    }

    @Test
    public void testUnacceptablePassword() {
        assertFalse(PasswordValidator.isPasswordAcceptable("ShortPwd!"));

        assertFalse(PasswordValidator.isPasswordAcceptable("WeakPwd1"));
    }
}
