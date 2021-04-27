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
//    public static String fixTypoAtoO(String s) {
//    }
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
