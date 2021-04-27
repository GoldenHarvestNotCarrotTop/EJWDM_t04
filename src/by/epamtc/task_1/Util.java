package by.epamtc.task_1;

public class Util {
    public static final String CONSONANT_LETTERS = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";

    public static boolean isLetter(char ch) {
        if ('a' <= ch && ch <= 'z')
            return true;
        if ('A' <= ch && ch <= 'Z')
            return true;
        return false;
    }

    public static boolean isConsonant(char ch) {
        for (char letter : CONSONANT_LETTERS.toCharArray()) {
            if (letter == ch)
                return true;
        }
        return false;
    }
}
