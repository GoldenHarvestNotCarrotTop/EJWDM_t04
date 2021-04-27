package by.epamtc.task_1;

public class StringFunctionService {
    private static final String cons = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";

    public static String replaceKthSymbolInEveryWord(String s, int k, char to) {
        StringBuilder sb = new StringBuilder(s);
        WordBounds wordBounds = Util.nextWordPos(s, 0);
        while (wordBounds.isCorrect()) {
            if (wordBounds.wordSize() >= k) {
                sb.setCharAt(wordBounds.left + k - 1, to);
            }

            wordBounds = Util.nextWordPos(s, wordBounds.right + 1);

        }
        return sb.toString();
    }


    public static String deleteWordsStartsWithConsonantByLength(String s, int length) {
        StringBuilder sb = new StringBuilder(s);
        WordBounds wordBounds = Util.nextWordPos(s, 0);
        while (wordBounds.isCorrect()) {
            if (isConsonant(s.charAt(wordBounds.left)) && wordBounds.wordSize() == length) {
                sb.delete(wordBounds.left, wordBounds.right + 1);
                wordBounds = Util.nextWordPos(sb.toString(), wordBounds.left);
            } else {
                wordBounds = Util.nextWordPos(sb.toString(), wordBounds.right + 1);
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
        return fixTypo(s,'p','a','o');
    }

    public static String fixTypo(String s, char prev, char old, char replace) {
        StringBuilder sb = new StringBuilder(s);
        WordBounds wordBounds = Util.nextWordPos(s, 0);
        while (wordBounds.isCorrect()) {
            int indexOfLcPrev = s.indexOf(Character.toLowerCase(prev), wordBounds.left);
            int indexOfUcPrev = s.indexOf(Character.toUpperCase(prev), wordBounds.left);

            replaceCharAfterCharInWord(s, sb, wordBounds, indexOfLcPrev, old, replace);

            replaceCharAfterCharInWord(s, sb, wordBounds, indexOfUcPrev, old, replace);

            wordBounds = Util.nextWordPos(s, wordBounds.right + 1);

        }
        return sb.toString();
    }

    private static void replaceCharAfterCharInWord(String s, StringBuilder sb, WordBounds wordBounds, int afterCharPos, char old,
                                                   char _new) {
        if ((wordBounds.left <= afterCharPos) && (afterCharPos <= wordBounds.right)
                && (afterCharPos != s.length() - 1)
                && Character.toLowerCase(s.charAt(afterCharPos + 1)) == old) {

            sb.setCharAt(afterCharPos + 1, matchCase(s.charAt(afterCharPos + 1), _new));
        }
    }

    public static String replaceWordsByLength(String s, int length, String replace) {
        StringBuilder sb = new StringBuilder(s);
        WordBounds wordBounds = Util.nextWordPos(s, 0);
        while (wordBounds.isCorrect()) {
            if (wordBounds.wordSize() == length) {
                sb.replace(wordBounds.left, wordBounds.right + 1, replace);
            }

            wordBounds = Util.nextWordPos(sb.toString(), wordBounds.left + replace.length());

        }
        return sb.toString();
    }

    public static String leaveOnlyWords(String s) {
        StringBuilder sb = new StringBuilder();
        WordBounds wordBounds = Util.nextWordPos(s, 0);
        while (wordBounds.isCorrect()) {
            sb.append(s, wordBounds.left, wordBounds.right + 1).append(" ");

            wordBounds = Util.nextWordPos(s, wordBounds.right + 1);

        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    private static boolean isConsonant(char ch) {
        return cons.contains(String.valueOf(ch));
    }
}
