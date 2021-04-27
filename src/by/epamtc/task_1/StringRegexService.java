package by.epamtc.task_1;

import by.epamtc.task_1.exception.NullStringException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegexService {

    public static String replaceKthSymbolInEveryWord(String s, int k, char to) throws NullStringException {
        if(s == null)
            throw new NullStringException("String must not be null!");
        String patternStr = "([a-zA-Z]{" + (k - 1) + "})([a-zA-Z])([a-zA-Z]*)";
        return s.replaceAll(patternStr, "$1" + to + "$3");
    }


    public static String fixTypoAtoO(String s) throws NullStringException {
        if(s == null)
            throw new NullStringException("String must not be null!");
        String replacedLowerCase = s.replaceAll("([p|P])(a)", "$1o");

        @SuppressWarnings("UnnecessaryLocalVariable")
        String replacedLowerAndUpperCase = replacedLowerCase.replaceAll("([p|P])(A)", "$1O");

        return replacedLowerAndUpperCase;
    }


    public static String replaceWordsByLength(String s, int length, String replace) throws NullStringException {
        if(s == null)
            throw new NullStringException("String must not be null!");
        String patternString = "\\b[a-zA-Z]{" + length + "}\\b";

        return s.replaceAll(patternString, replace);
    }


    public static String leaveOnlyWords(String s) throws NullStringException {
        if(s == null)
            throw new NullStringException("String must not be null!");
        StringBuilder sb = new StringBuilder();

        Pattern pattern = Pattern.compile("\\b[a-zA-Z]+\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            sb.append(matcher.group()).append(" ");
        }

        // remove previously added  space
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }


    public static String deleteWordsStartsWithConsonantByLength(String s, int length) throws NullStringException {
        if(s == null)
            throw new NullStringException("String must not be null!");
        String patternString = "(\\b[" + Util.CONSONANT_LETTERS + "][a-zA-Z]{" + (length - 1) + "}\\b)";
        return s.replaceAll(patternString, "");
    }
}
