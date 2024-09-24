import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class NumberToWordsTest {

    private NumberToWords numberToWords;

    @BeforeEach
    public void setUp() {
        numberToWords = new NumberToWords();
    }

    @Test
    public void testNumberToWordsUnits() {
        Map<Integer, String[]> units = NumberToWords.UNITS;
        assertArrayEquals(new String[]{"один", "одного", "одному", "один", "одним", "одном",
                "одна", "одной", "одной", "одну", "одной", "одной",
                "одно", "одного", "одному", "одно", "одним", "одном"}, units.get(1));
        assertArrayEquals(new String[]{"два", "двух", "двум", "два", "двумя", "двух",
                "две", "двух", "двум", "две", "двумя", "двух",
                "два", "двух", "двум", "два", "двумя", "двух"}, units.get(2));
    }

    @Test
    public void testNumberToWordsTens() {
        Map<Integer, String[]> tens = NumberToWords.TENS;
        assertArrayEquals(new String[]{"десять", "десяти", "десяти", "десять", "десятью", "десяти"}, tens.get(10));
        assertArrayEquals(new String[]{"двенадцать", "двенадцати", "двенадцати", "двенадцать", "двенадцатью", "двенадцати"}, tens.get(12));
    }

    @Test
    public void testNumberToWordsHundreds() {
        Map<Integer, String[]> hundreds = NumberToWords.HUNDREDS;
        assertArrayEquals(new String[]{"сто", "ста", "ста", "сто", "ста", "ста"}, hundreds.get(100));
        assertArrayEquals(new String[]{"триста", "трехсот", "тремстам", "триста", "тремястами", "трехстах"}, hundreds.get(300));
    }

    @Test
    public void testNumberToWordsThousands() {
        Map<Integer, String[]> thousands = NumberToWords.THOUSANDS;
        assertArrayEquals(new String[]{"одна тысяча", "одной тысячи", "одной тысяче", "одну тысячу", "одной тысячей", "одной тысяче"}, thousands.get(1));
        assertArrayEquals(new String[]{"пять тысяч", "пяти тысяч", "пяти тысячам", "пять тысяч", "пятью тысячами", "пяти тысячах"}, thousands.get(5));
    }

    @Test
    public void testNumberToWordsMillions() {
        Map<Integer, String[]> millions = NumberToWords.MILLIONS;
        assertArrayEquals(new String[]{"один миллион", "одного миллиона", "одному миллиону", "один миллион", "одним миллионом", "одном миллионе"}, millions.get(1));
        assertArrayEquals(new String[]{"три миллиона", "трех миллионов", "трем миллионам", "три миллиона", "тремя миллионами", "трех миллионах"}, millions.get(3));
    }

    // Тестирование числа 15132
    @Test
    public void testFifteenThousandOneHundredThirtyTwo() {
        assertEquals("пятнадцать тысяч сто тридцать два", NumberToWords.sumProp(15132, "М", "И"));
        assertEquals("пятнадцати тысяч ста тридцати двух", NumberToWords.sumProp(15132, "М", "Р"));
        assertEquals("пятнадцати тысячам ста тридцати двум", NumberToWords.sumProp(15132, "М", "Д"));
        assertEquals("пятнадцать тысяч сто тридцать два", NumberToWords.sumProp(15132, "М", "В"));
        assertEquals("пятнадцатью тысячами ста тридцатью двумя", NumberToWords.sumProp(15132, "М", "Т"));
        assertEquals("пятнадцати тысячах ста тридцати двух", NumberToWords.sumProp(15132, "М", "П"));
    }


    @Test
    public void testThirtyOne() {
        // Тестирование числа 31
        assertEquals("тридцать один", NumberToWords.sumProp(31, "М", "И"));
        assertEquals("тридцати одного", NumberToWords.sumProp(31, "М", "Р"));
        assertEquals("тридцати одному", NumberToWords.sumProp(31, "М", "Д"));
        assertEquals("тридцать один", NumberToWords.sumProp(31, "М", "В"));
        assertEquals("тридцатью одним", NumberToWords.sumProp(31, "М", "Т"));
        assertEquals("тридцати одном", NumberToWords.sumProp(31, "М", "П"));
    }

    @Test
    public void testTwentyTwoMiddleGender() {
        // Тестирование числа 22 - Средний род
        assertEquals("двадцать два", NumberToWords.sumProp(22, "С", "И"));
        assertEquals("двадцати двух", NumberToWords.sumProp(22, "С", "Р"));
        assertEquals("двадцати двум", NumberToWords.sumProp(22, "С", "Д"));
        assertEquals("двадцать два", NumberToWords.sumProp(22, "С", "В"));
        assertEquals("двадцатью двумя", NumberToWords.sumProp(22, "С", "Т"));
        assertEquals("двадцати двух", NumberToWords.sumProp(22, "С", "П"));
    }


    @Test
    public void testTwentyTwoMasculineGender() {
        // Тестирование числа 22 - Мужской род
        assertEquals("двадцать два", NumberToWords.sumProp(22, "М", "И"));
        assertEquals("двадцати двух", NumberToWords.sumProp(22, "М", "Р"));
        assertEquals("двадцати двум", NumberToWords.sumProp(22, "М", "Д"));
        assertEquals("двадцать два", NumberToWords.sumProp(22, "М", "В"));
        assertEquals("двадцатью двумя", NumberToWords.sumProp(22, "М", "Т"));
        assertEquals("двадцати двух", NumberToWords.sumProp(22, "М", "П"));
    }

    @Test
    public void testTwentyTwoFeminineGender() {
        // Тестирование числа 22 - Женский род
        assertEquals("двадцать две", NumberToWords.sumProp(22, "Ж", "И"));
        assertEquals("двадцати двух", NumberToWords.sumProp(22, "Ж", "Р"));
        assertEquals("двадцати двум", NumberToWords.sumProp(22, "Ж", "Д"));
        assertEquals("двадцать две", NumberToWords.sumProp(22, "Ж", "В"));
        assertEquals("двадцатью двумя", NumberToWords.sumProp(22, "Ж", "Т"));
        assertEquals("двадцати двух", NumberToWords.sumProp(22, "Ж", "П"));
    }


    @Test
    public void testThreeBillionOneHundredFortyOneMillionThreeHundredFortyFiveThousandOneMasculine() {
        // Тестирование числа 3 141 345 001 - Мужской род
        assertEquals("три миллиарда сто сорок один миллион триста сорок пять тысяч один", NumberToWords.sumProp(3141345001L, "М", "И"));
        assertEquals("трех миллиардов ста сорока одного миллиона трехсот сорока пяти тысяч одного", NumberToWords.sumProp(3141345001L, "М", "Р"));
        assertEquals("трем миллиардом ста сорока одному миллиону тремстам сорока пяти тысячам одному", NumberToWords.sumProp(3141345001L, "М", "Д"));
        assertEquals("три миллиарда сто сорок один миллион триста сорок пять тысяч один", NumberToWords.sumProp(3141345001L, "М", "В"));
        assertEquals("тремя миллиардами ста сорока одним миллионом тремястами сорока пятью тысячами одним", NumberToWords.sumProp(3141345001L, "М", "Т"));
        assertEquals("трех миллиардов ста сорока одном миллионе трехстах сорока пяти тысячах одном", NumberToWords.sumProp(3141345001L, "М", "П"));
    }

    @Test
    public void testThreeBillionOneHundredFortyOneMillionThreeHundredFortyFiveThousandOneFeminine() {
        // Тестирование числа 3 141 345 001 - Женский род
        assertEquals("три миллиарда сто сорок один миллион триста сорок пять тысяч одна", NumberToWords.sumProp(3141345001L, "Ж", "И"));
        assertEquals("трех миллиардов ста сорока одного миллиона трехсот сорока пяти тысяч одной", NumberToWords.sumProp(3141345001L, "Ж", "Р"));
        assertEquals("трем миллиардом ста сорока одному миллиону тремстам сорока пяти тысячам одной", NumberToWords.sumProp(3141345001L, "Ж", "Д"));
        assertEquals("три миллиарда сто сорок один миллион триста сорок пять тысяч одну", NumberToWords.sumProp(3141345001L, "Ж", "В"));
        assertEquals("тремя миллиардами ста сорока одним миллионом тремястами сорока пятью тысячами одной", NumberToWords.sumProp(3141345001L, "Ж", "Т"));
        assertEquals("трех миллиардов ста сорока одном миллионе трехстах сорока пяти тысячах одной", NumberToWords.sumProp(3141345001L, "Ж", "П"));
    }


    @Test
    public void testElevenMasculine() {
        // Тестирование числа 11 - Мужской род
        assertEquals("одиннадцать", NumberToWords.sumProp(11, "М", "И"));
        assertEquals("одиннадцати", NumberToWords.sumProp(11, "М", "Р"));
        assertEquals("одиннадцати", NumberToWords.sumProp(11, "М", "Д"));
        assertEquals("одиннадцать", NumberToWords.sumProp(11, "М", "В"));
        assertEquals("одиннадцатью", NumberToWords.sumProp(11, "М", "Т"));
        assertEquals("одиннадцати", NumberToWords.sumProp(11, "М", "П"));
    }

    @Test
    public void testElevenFeminine() {
        // Тестирование числа 11 - Женский род
        assertEquals("одиннадцать", NumberToWords.sumProp(11, "Ж", "И"));
        assertEquals("одиннадцати", NumberToWords.sumProp(11, "Ж", "Р"));
        assertEquals("одиннадцати", NumberToWords.sumProp(11, "Ж", "Д"));
        assertEquals("одиннадцать", NumberToWords.sumProp(11, "Ж", "В"));
        assertEquals("одиннадцатью", NumberToWords.sumProp(11, "Ж", "Т"));
        assertEquals("одиннадцати", NumberToWords.sumProp(11, "Ж", "П"));
    }

    @Test
    public void testElevenNeuter() {
        // Тестирование числа 11 - Средний род
        assertEquals("одиннадцать", NumberToWords.sumProp(11, "С", "И"));
        assertEquals("одиннадцати", NumberToWords.sumProp(11, "С", "Р"));
        assertEquals("одиннадцати", NumberToWords.sumProp(11, "С", "Д"));
        assertEquals("одиннадцать", NumberToWords.sumProp(11, "С", "В"));
        assertEquals("одиннадцатью", NumberToWords.sumProp(11, "С", "Т"));
        assertEquals("одиннадцати", NumberToWords.sumProp(11, "С", "П"));
    }

    @Test
    public void testOneHundredTwentySevenMasculine() {
        // Тестирование числа 127 - Мужской род
        assertEquals("сто двадцать семь", NumberToWords.sumProp(127, "М", "И"));
        assertEquals("ста двадцати семи", NumberToWords.sumProp(127, "М", "Р"));
        assertEquals("ста двадцати семи", NumberToWords.sumProp(127, "М", "Д"));
        assertEquals("сто двадцать семь", NumberToWords.sumProp(127, "М", "В"));
        assertEquals("ста двадцатью семью", NumberToWords.sumProp(127, "М", "Т"));
        assertEquals("ста двадцати семи", NumberToWords.sumProp(127, "М", "П"));
    }

    @Test
    public void testOneHundredTwentySevenFeminine() {
        // Тестирование числа 127 - Женский род
        assertEquals("сто двадцать семь", NumberToWords.sumProp(127, "Ж", "И"));
        assertEquals("ста двадцати семи", NumberToWords.sumProp(127, "Ж", "Р"));
        assertEquals("ста двадцати семи", NumberToWords.sumProp(127, "Ж", "Д"));
        assertEquals("сто двадцать семь", NumberToWords.sumProp(127, "Ж", "В"));
        assertEquals("ста двадцатью семью", NumberToWords.sumProp(127, "Ж", "Т"));
        assertEquals("ста двадцати семи", NumberToWords.sumProp(127, "Ж", "П"));
    }

    @Test
    public void testOneHundredTwentySevenNeuter() {
        // Тестирование числа 127 - Средний род
        assertEquals("сто двадцать семь", NumberToWords.sumProp(127, "С", "И"));
        assertEquals("ста двадцати семи", NumberToWords.sumProp(127, "С", "Р"));
        assertEquals("ста двадцати семи", NumberToWords.sumProp(127, "С", "Д"));
        assertEquals("сто двадцать семь", NumberToWords.sumProp(127, "С", "В"));
        assertEquals("ста двадцатью семью", NumberToWords.sumProp(127, "С", "Т"));
        assertEquals("ста двадцати семи", NumberToWords.sumProp(127, "С", "П"));
    }

    @Test
    public void testFiveHundredEightySevenMasculine() {
        // Тестирование числа 587 - Мужской род
        assertEquals("пятьсот восемьдесят семь", NumberToWords.sumProp(587, "М", "И"));
        assertEquals("пятисот восьмидесяти семи", NumberToWords.sumProp(587, "М", "Р"));
        assertEquals("пятисот восьмидесяти семи", NumberToWords.sumProp(587, "М", "Д"));
        assertEquals("пятьсот восемьдесят семь", NumberToWords.sumProp(587, "М", "В"));
        assertEquals("пятьюстами восьмьюдесятью семью", NumberToWords.sumProp(587, "М", "Т"));
        assertEquals("пятисот восьмидесяти семи", NumberToWords.sumProp(587, "М", "П"));
    }

    @Test
    public void testFiveHundredEightySevenFeminine() {
        // Тестирование числа 587 - Женский род
        assertEquals("пятьсот восемьдесят семь", NumberToWords.sumProp(587, "Ж", "И"));
        assertEquals("пятисот восьмидесяти семи", NumberToWords.sumProp(587, "Ж", "Р"));
        assertEquals("пятисот восьмидесяти семи", NumberToWords.sumProp(587, "Ж", "Д"));
        assertEquals("пятьсот восемьдесят семь", NumberToWords.sumProp(587, "Ж", "В"));
        assertEquals("пятьюстами восьмьюдесятью семью", NumberToWords.sumProp(587, "Ж", "Т"));
        assertEquals("пятисот восьмидесяти семи", NumberToWords.sumProp(587, "Ж", "П"));
    }

    @Test
    public void testFiveHundredEightySevenNeuter() {
        // Тестирование числа 587 - Средний род
        assertEquals("пятьсот восемьдесят семь", NumberToWords.sumProp(587, "С", "И"));
        assertEquals("пятисот восьмидесяти семи", NumberToWords.sumProp(587, "С", "Р"));
        assertEquals("пятисот восьмидесяти семи", NumberToWords.sumProp(587, "С", "Д"));
        assertEquals("пятьсот восемьдесят семь", NumberToWords.sumProp(587, "С", "В"));
        assertEquals("пятьюстами восьмьюдесятью семью", NumberToWords.sumProp(587, "С", "Т"));
        assertEquals("пятисот восьмидесяти семи", NumberToWords.sumProp(587, "С", "П"));
    }


    @Test
    public void testOneThousandTwoMasculine() {
        // Тестирование числа 1002 - Мужской род
        assertEquals("одна тысяча два", NumberToWords.sumProp(1002, "М", "И"));
        assertEquals("одной тысячи двух", NumberToWords.sumProp(1002, "М", "Р"));
        assertEquals("одной тысяче двум", NumberToWords.sumProp(1002, "М", "Д"));
        assertEquals("одну тысячу два", NumberToWords.sumProp(1002, "М", "В"));
        assertEquals("одной тысячей двумя", NumberToWords.sumProp(1002, "М", "Т"));
        assertEquals("одной тысяче двух", NumberToWords.sumProp(1002, "М", "П"));
    }


    @Test
    public void testOneThousandTwoNeuter() {
        // Тестирование числа 1002 - Средний род
        assertEquals("одна тысяча два", NumberToWords.sumProp(1002, "С", "И"));
        assertEquals("одной тысячи двух", NumberToWords.sumProp(1002, "С", "Р"));
        assertEquals("одной тысяче двум", NumberToWords.sumProp(1002, "С", "Д"));
        assertEquals("одну тысячу два", NumberToWords.sumProp(1002, "С", "В"));
        assertEquals("одной тысячей двумя", NumberToWords.sumProp(1002, "С", "Т"));
        assertEquals("одной тысяче двух", NumberToWords.sumProp(1002, "С", "П"));
    }

    @Test
    public void testOneThousandSevenHundredSixtyFiveMasculine() {
        // Тестирование числа 1765 - Мужской род
        assertEquals("одна тысяча семьсот шестьдесят пять", NumberToWords.sumProp(1765, "М", "И"));
        assertEquals("одной тысячи семисот шестидесяти пяти", NumberToWords.sumProp(1765, "М", "Р"));
        assertEquals("одной тысяче семистам шестидесяти пяти", NumberToWords.sumProp(1765, "М", "Д"));
        assertEquals("одну тысячу семьсот шестьдесят пять", NumberToWords.sumProp(1765, "М", "В"));
        assertEquals("одной тысячей семьюстами шестьюдесятью пятью", NumberToWords.sumProp(1765, "М", "Т"));
        assertEquals("одной тысяче семистах шестидесяти пяти", NumberToWords.sumProp(1765, "М", "П"));
    }

    @Test
    public void testOneThousandSevenHundredSixtyFiveFeminine() {
        // Тестирование числа 1765 - Женский род
        assertEquals("одна тысяча семьсот шестьдесят пять", NumberToWords.sumProp(1765, "Ж", "И"));
        assertEquals("одной тысячи семисот шестидесяти пяти", NumberToWords.sumProp(1765, "Ж", "Р"));
        assertEquals("одной тысяче семистам шестидесяти пяти", NumberToWords.sumProp(1765, "Ж", "Д"));
        assertEquals("одну тысячу семьсот шестьдесят пять", NumberToWords.sumProp(1765, "Ж", "В"));
        assertEquals("одной тысячей семьюстами шестьюдесятью пятью", NumberToWords.sumProp(1765, "Ж", "Т"));
        assertEquals("одной тысяче семистах шестидесяти пяти", NumberToWords.sumProp(1765, "Ж", "П"));
    }

    @Test
    public void testOneThousandSevenHundredSixtyFiveNeuter() {
        // Тестирование числа 1765 - Средний род
        assertEquals("одна тысяча семьсот шестьдесят пять", NumberToWords.sumProp(1765, "С", "И"));
        assertEquals("одной тысячи семисот шестидесяти пяти", NumberToWords.sumProp(1765, "С", "Р"));
        assertEquals("одной тысяче семистам шестидесяти пяти", NumberToWords.sumProp(1765, "С", "Д"));
        assertEquals("одну тысячу семьсот шестьдесят пять", NumberToWords.sumProp(1765, "С", "В"));
        assertEquals("одной тысячей семьюстами шестьюдесятью пятью", NumberToWords.sumProp(1765, "С", "Т"));
        assertEquals("одной тысяче семистах шестидесяти пяти", NumberToWords.sumProp(1765, "С", "П"));
    }

    @Test
    public void testThirteenThousandFourHundredNineMasculine() {
        // Тестирование числа 13 409 - Мужской род
        assertEquals("тринадцать тысяч четыреста девять", NumberToWords.sumProp(13409, "М", "И"));
        assertEquals("тринадцати тысяч четырехсот девяти", NumberToWords.sumProp(13409, "М", "Р"));
        assertEquals("тринадцати тысячам четыремстам девяти", NumberToWords.sumProp(13409, "М", "Д"));
        assertEquals("тринадцать тысяч четыреста девять", NumberToWords.sumProp(13409, "М", "В"));
        assertEquals("тринадцатью тысячами четырьмястами девятью", NumberToWords.sumProp(13409, "М", "Т"));
        assertEquals("тринадцати тысячах четырехстах девяти", NumberToWords.sumProp(13409, "М", "П"));
    }

    @Test
    public void testThirteenThousandFourHundredNineFeminine() {
        // Тестирование числа 13 409 - Женский род
        assertEquals("тринадцать тысяч четыреста девять", NumberToWords.sumProp(13409, "Ж", "И"));
        assertEquals("тринадцати тысяч четырехсот девяти", NumberToWords.sumProp(13409, "Ж", "Р"));
        assertEquals("тринадцати тысячам четыремстам девяти", NumberToWords.sumProp(13409, "Ж", "Д"));
        assertEquals("тринадцать тысяч четыреста девять", NumberToWords.sumProp(13409, "Ж", "В"));
        assertEquals("тринадцатью тысячами четырьмястами девятью", NumberToWords.sumProp(13409, "Ж", "Т"));
        assertEquals("тринадцати тысячах четырехстах девяти", NumberToWords.sumProp(13409, "Ж", "П"));
    }

    @Test
    public void testThirteenThousandFourHundredNineNeuter() {
        // Тестирование числа 13 409 - Средний род
        assertEquals("тринадцать тысяч четыреста девять", NumberToWords.sumProp(13409, "С", "И"));
        assertEquals("тринадцати тысяч четырехсот девяти", NumberToWords.sumProp(13409, "С", "Р"));
        assertEquals("тринадцати тысячам четыремстам девяти", NumberToWords.sumProp(13409, "С", "Д"));
        assertEquals("тринадцать тысяч четыреста девять", NumberToWords.sumProp(13409, "С", "В"));
        assertEquals("тринадцатью тысячами четырьмястами девятью", NumberToWords.sumProp(13409, "С", "Т"));
        assertEquals("тринадцати тысячах четырехстах девяти", NumberToWords.sumProp(13409, "С", "П"));
    }

    //................................ Еще больше тестов.......................................
    //................................ Еще больше тестов.......................................
    //................................ Еще больше тестов.......................................
    //................................ Еще больше тестов.......................................
}
