package by.epamtc.task_1;

import java.nio.charset.StandardCharsets;

public class StringFunctionService {
    private static final String cons = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";

    public static void main(String[] args) {
        // TODO: remove main
        StringBuilder sb = new StringBuilder("x xxx ccz z");
        sb.replace(0, 1, "zzzzzz");
        System.out.println(sb);
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


    public static String deleteWordsStartsWithConsonantByLength(String s, int length) {
        StringBuilder sb = new StringBuilder(s);
        WordBounds wordBounds = Util.nextWordPos(s, 0);
        while (wordBounds.isCorrect()) {
            if (isConsonant(s.charAt(wordBounds.first)) && wordBounds.wordSize() == length) {
                sb.delete(wordBounds.first, wordBounds.second + 1);
                wordBounds = Util.nextWordPos(sb.toString(), wordBounds.first);
            } else {
                wordBounds = Util.nextWordPos(sb.toString(), wordBounds.second + 1);
            }

        }
        return sb.toString();
    }

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

    public static String replaceWordsByLength(String s, int length, String replace) {
        StringBuilder sb = new StringBuilder(s);
        WordBounds wordBounds = Util.nextWordPos(s, 0);
        while (wordBounds.isCorrect()) {
            if (wordBounds.wordSize() == length) {
                sb.replace(wordBounds.first, wordBounds.second + 1, replace);
            }

            //TODO: remove sb.toString()
            wordBounds = Util.nextWordPos(sb.toString(), wordBounds.first + replace.length());

        }
        return sb.toString();
    }

    public static String leaveOnlyWords(String s) {
        StringBuilder sb = new StringBuilder();
        WordBounds wordBounds = Util.nextWordPos(s, 0);
        while (wordBounds.isCorrect()) {
            sb.append(s, wordBounds.first, wordBounds.second + 1).append(" ");

            wordBounds = Util.nextWordPos(s, wordBounds.second + 1);

        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    private static boolean isConsonant(char ch) {
        return cons.contains(String.valueOf(ch));
    }
}
