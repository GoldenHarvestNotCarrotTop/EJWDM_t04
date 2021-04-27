package by.epamtc.task_1;

import java.nio.charset.StandardCharsets;

public class StringFunctionService {
    private static final String cons = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";

    public static void main(String[] args) {
        replaceKthSymbolInEveryWord("asdxc", 2, 'x');
    }

    public static String replaceKthSymbolInEveryWord(String s, int k, char to) {
        StringBuilder sb = new StringBuilder(s);
        WordBounds wordBounds = Util.nextWordPos(s, 0);
        while (wordBounds.isCorrect()) {
            if (wordBounds.wordSize() >= k) {
                sb.setCharAt(wordBounds.first + k - 1, to);
            }

            wordBounds = Util.nextWordPos(s, wordBounds.second + 1);

        }
        return sb.toString();
    }


    //    public static String deleteWordsStartsWithConsonantByLength(String s, int length) {
//    }
//
    private static char matchCase(char from, char to) {
        if (Character.isLowerCase(from))
            return Character.toLowerCase(to);
        else
            return Character.toUpperCase(to);

    }

    public static String fixTypoAtoO(String s) {
        StringBuilder sb = new StringBuilder(s);
        WordBounds wordBounds = Util.nextWordPos(s, 0);
        while (wordBounds.isCorrect()) {
            int indexOfp = s.indexOf('p', wordBounds.first);
            int indexOfP = s.indexOf('P', wordBounds.first);
            // TODO: remove code repeats
            if ((wordBounds.first <= indexOfp) && (indexOfp <= wordBounds.second)
                    && (indexOfp != s.length() - 1)
                    && (s.charAt(indexOfp + 1) == 'a' || s.charAt(indexOfp + 1) == 'A')) {

                sb.setCharAt(indexOfp + 1, matchCase(s.charAt(indexOfp + 1), 'o'));
            }

            if ((wordBounds.first <= indexOfP) && (indexOfP <= wordBounds.second)
                    && (indexOfP != s.length() - 1)
                    && (s.charAt(indexOfP + 1) == 'a' || s.charAt(indexOfP + 1) == 'A')) {

                sb.setCharAt(indexOfP + 1, matchCase(s.charAt(indexOfP + 1), 'o'));
            }

            wordBounds = Util.nextWordPos(s, wordBounds.second + 1);

        }
        return sb.toString();
    }
//
//    public static String replaceWordsByLength(String s, int length, String replace) {
//
//    }
//
//    public static String leaveOnlyWords(String s) {
//    }


    private static boolean isConsonant(char ch) {
        return cons.contains(String.valueOf(ch));
    }
}
