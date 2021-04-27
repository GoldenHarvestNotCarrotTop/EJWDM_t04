package by.epamtc.task_1;

import by.epamtc.task_1.exception.NullStringException;

import javax.swing.*;

import static by.epamtc.task_1.Util.isConsonant;
import static by.epamtc.task_1.Util.isLetter;

public class StringManualService {

    public static String replaceKthSymbolInEveryWord(String s, int k, char to) throws NullStringException {
        if(s == null)
            throw new NullStringException("String must not be null!");
        StringBuilder sb = new StringBuilder();

        int wordSize = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char append = ch;

            if (isLetter(ch)) {
                wordSize++;
                if (wordSize == k)
                    append = to;
            } else {
                wordSize = 0;
            }
            sb.append(append);
        }
        return sb.toString();
    }

    public static String deleteWordsStartsWithConsonantByLength(String s, int length) throws NullStringException {
        if(s == null)
            throw new NullStringException("String must not be null!");
        StringBuilder sb = new StringBuilder();

        int wordSize = 0;
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isLetter(ch)) {
                wordSize++;
                word.append(ch);
            } else {
                if (wordSize != length || !isConsonant(word.charAt(0)))
                    sb.append(word);
                sb.append(ch);
                word.setLength(0);
                wordSize = 0;
            }
        }

        if (wordSize != length || !isConsonant(word.charAt(0)))
            sb.append(word);

        return sb.toString();
    }

    public static String fixTypoAtoO(String s) throws NullStringException {
        if(s == null)
            throw new NullStringException("String must not be null!");
        StringBuilder sb = new StringBuilder();

        boolean isPrevP = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char append = ch;

            if (isPrevP && (ch == 'a' || ch == 'A')) {
                if (ch == 'a')
                    append = 'o';
                if (ch == 'A')
                    append = 'O';
            }

            isPrevP = ch == 'p' || ch == 'P';

            sb.append(append);
        }
        return sb.toString();
    }

    public static String replaceWordsByLength(String s, int length, String replace) throws NullStringException {
        if(s == null)
            throw new NullStringException("String must not be null!");
        StringBuilder sb = new StringBuilder();

        int wordSize = 0;
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isLetter(ch)) {
                wordSize++;
                word.append(ch);
            } else {
                if (wordSize == length)
                    sb.append(replace);
                else
                    sb.append(word);
                sb.append(ch);
                word.setLength(0);
                wordSize = 0;
            }
        }

        if (wordSize == length)
            sb.append(replace);
        else
            sb.append(word);

        return sb.toString();
    }

    public static String leaveOnlyWords(String s) throws NullStringException {
        if(s == null)
            throw new NullStringException("String must not be null!");
        StringBuilder sb = new StringBuilder();

        int wordSize = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isLetter(ch)) {
                wordSize++;
                sb.append(ch);
            } else {
                if (wordSize != 0)
                    sb.append(' ');
                wordSize = 0;
            }
        }

        return sb.toString();
    }

}
