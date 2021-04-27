package by.epamtc.task_1;

import by.epamtc.task_1.exception.NullStringException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringServiceTest {


    @Test
    void replaceKthSymbolInEveryWord() throws NullStringException {
        String tst = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ";
        String ans = "oorem opsum oolor oit omet, oonsectetur odipiscing olit. ";
        assertEquals(ans,
                StringManualService.replaceKthSymbolInEveryWord(tst, 1, 'o'));
        assertEquals(ans,
                StringRegexService.replaceKthSymbolInEveryWord(tst, 1, 'o'));
        assertEquals(ans,
                StringFunctionService.replaceKthSymbolInEveryWord(tst, 1, 'o'));


        tst = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. ";
        ans = "Loreo ipsuo doloo sit amet, consoctetur adiposcing elit. ";
        assertEquals(ans,
                StringManualService.replaceKthSymbolInEveryWord(tst, 5, 'o'));
        assertEquals(ans,
                StringRegexService.replaceKthSymbolInEveryWord(tst, 5, 'o'));
        assertEquals(ans,
                StringFunctionService.replaceKthSymbolInEveryWord(tst, 5, 'o'));


        tst = "xxxxx";
        ans = "xxxxo";
        assertEquals(ans,
                StringManualService.replaceKthSymbolInEveryWord(tst, 5, 'o'));
        assertEquals(ans,
                StringRegexService.replaceKthSymbolInEveryWord(tst, 5, 'o'));
        assertEquals(ans,
                StringFunctionService.replaceKthSymbolInEveryWord(tst, 5, 'o'));


        tst = "       ";
        assertEquals(tst,
                StringManualService.replaceKthSymbolInEveryWord(tst, 3, 'x'));
        assertEquals(tst,
                StringRegexService.replaceKthSymbolInEveryWord(tst, 3, 'x'));
        assertEquals(tst,
                StringFunctionService.replaceKthSymbolInEveryWord(tst, 3, 'x'));
    }

    @Test
    void fixTypoAtoO() throws NullStringException {
        String tst = "Axczpa, xvvvxcvbp      cxvpaxcv,,,cvvpovvx, CXvpAv, cvvPav, bfgPA,c";
        String ans = "Axczpo, xvvvxcvbp      cxvpoxcv,,,cvvpovvx, CXvpOv, cvvPov, bfgPO,c";
        assertEquals(ans, StringManualService.fixTypoAtoO(tst));
        assertEquals(ans, StringRegexService.fixTypoAtoO(tst));
        assertEquals(ans, StringFunctionService.fixTypoAtoO(tst));
    }

    @Test
    void replaceWordsByLength() throws NullStringException {
        String tst = "c s 2 3 4 f c x v g s asjfsc xv s fsdcv xcv ,   xcv x z     , z";
        String ans = "xxx xxx 2 3 4 xxx xxx xxx xxx xxx xxx asjfsc xv xxx fsdcv xcv ,   xcv xxx xxx     , xxx";
        assertEquals(ans, StringManualService.replaceWordsByLength(tst, 1, "xxx"));
        assertEquals(ans, StringRegexService.replaceWordsByLength(tst, 1, "xxx"));
        assertEquals(ans, StringFunctionService.replaceWordsByLength(tst, 1, "xxx"));
    }

    @Test
    void leaveOnlyWords() throws NullStringException {
        String tst = "c s 2 3 4 f c x v g s asjfsc xv s fsdcv xcv ,   xcv x z     , z";
        String ans = "c s f c x v g s asjfsc xv s fsdcv xcv xcv x z z";
        assertEquals(ans, StringManualService.leaveOnlyWords(tst));
        assertEquals(ans, StringRegexService.leaveOnlyWords(tst));


        tst = "Axczpa, xvvvxcvbp      cxvpaxcv,,,cvvpovvx, CXvpAv, cvvPav, bfgPA,c";
        ans = "Axczpa xvvvxcvbp cxvpaxcv cvvpovvx CXvpAv cvvPav bfgPA c";
        assertEquals(ans, StringManualService.leaveOnlyWords(tst));
        assertEquals(ans, StringRegexService.leaveOnlyWords(tst));
        assertEquals(ans, StringFunctionService.leaveOnlyWords(tst));
    }

    @Test
    void deleteWordsStartsWithConsonantByLength() throws NullStringException {
        String tst = "Lorem ipsum dolor sit amet, consectetur adipiscing rlita";
        String ans = " ipsum  sit amet, consectetur adipiscing ";
        assertEquals(ans, StringManualService.deleteWordsStartsWithConsonantByLength(tst, 5));
        assertEquals(ans, StringRegexService.deleteWordsStartsWithConsonantByLength(tst, 5));
        assertEquals(ans, StringFunctionService.deleteWordsStartsWithConsonantByLength(tst, 5));
    }

    @Test
    void test() {
        String s = "xcz , a sdd axczxc dfdsf sd dffff Fxcv DXCZCX sfsXCZc ";
        String news = s.replaceAll("([a-zA-Z]{3,})", "$1_____");
    }
}