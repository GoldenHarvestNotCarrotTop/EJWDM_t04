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

    public static WordBounds nextWordPos(String s, int start) {
        if (s.length() <= start)
            return new WordBounds(-1, -1);
        int wordStart = start;

        // Finding wordStart
        while (wordStart < s.length() && !Character.isLetter(s.charAt(wordStart))) {
            wordStart++;
        }
        if (wordStart == s.length())
            return new WordBounds(-1, -1);

        int wordEnd = wordStart + 1;
        while (wordEnd < s.length() && Character.isLetter(s.charAt(wordEnd))) {
            wordEnd++;
        }
        return new WordBounds(wordStart, wordEnd - 1);


    }
    public static char matchCase(char from, char to) {
        if (Character.isLowerCase(from))
            return Character.toLowerCase(to);
        else
            return Character.toUpperCase(to);

    }

    public static void main(String[] args) {
        nextWordPos("   asxc zc zxxx   ", 0);
    }
}
