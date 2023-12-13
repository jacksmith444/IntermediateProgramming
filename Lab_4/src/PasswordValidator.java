
public class PasswordValidator {

    public static boolean isPasswordAcceptable(String password) {
        if (password.length() < 10) {
            System.out.println("Password length is less than 10");
            return false;
        }

        if (!containsDigit(password)) {
            System.out.println("No digit found in the password");
            return false;
        }

        if (!containsUppercase(password)) {
            System.out.println("No uppercase letter found in the password");
            return false;
        }

        if (!containsLowercase(password)) {
            System.out.println("No lowercase letter found in the password");
            return false;
        }

        if (!containsSpecialSymbol(password)) {
            System.out.println("No special symbol found in the password");
            return false;
        }

        return true;
    }

    private static boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsUppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsLowercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsSpecialSymbol(String password) {
        for (char c : password.toCharArray()) {
            if (c == '!' || c == '*' || c == '?') {
                return true;
            }
        }
        return false;
    }
}
