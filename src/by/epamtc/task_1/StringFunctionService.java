package by.epamtc.task_1;

public class StringFunctionService {
    private static final String cons = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";

    public static String replaceKthSymbolInEveryWord(String s, int k, char to) {
        s.split(String.valueOf(k));
        return "";
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
