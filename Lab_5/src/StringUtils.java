
public class StringUtils {

    public static String reverse(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input string cannot be null");
        }

        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        return new String(charArray);
    }
}