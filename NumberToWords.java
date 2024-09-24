import java.util.HashMap;
import java.util.Map;


public class NumberToWords {

    private static final String[] CASES = {"И", "Р", "Д", "В", "Т", "П"};
    private static final String[] GENDERS = {"М", "Ж", "С"};

    public static final Map<Integer, String[]> UNITS = new HashMap<>();
    public static final Map<Integer, String[]> TENS = new HashMap<>();
    public static final Map<Integer, String[]> HUNDREDS = new HashMap<>();
    public static final Map<Integer, String[]> THOUSANDS = new HashMap<>();
    public static final Map<Integer, String[]> MILLIONS = new HashMap<>();
    public static final Map<Integer, String[]> BILLIONS = new HashMap<>();
    public static final Map<String, Integer> CASE_MAP = new HashMap<>();
    public static final Map<String, Integer> GENDER_MAP = new HashMap<>();

    static {
        for (int i = 0; i < CASES.length; i++) {
            CASE_MAP.put(CASES[i], i);
        }
        for (int i = 0; i < GENDERS.length; i++) {
            GENDER_MAP.put(GENDERS[i], i);
        }

        // Инициализация чисел от 10 до 19
        TENS.put(10, new String[]{"десять", "десяти", "десяти", "десять", "десятью", "десяти"});
        TENS.put(11, new String[]{"одиннадцать", "одиннадцати", "одиннадцати", "одиннадцать", "одиннадцатью", "одиннадцати"});
        TENS.put(12, new String[]{"двенадцать", "двенадцати", "двенадцати", "двенадцать", "двенадцатью", "двенадцати"});
        TENS.put(13, new String[]{"тринадцать", "тринадцати", "тринадцати", "тринадцать", "тринадцатью", "тринадцати"});
        TENS.put(14, new String[]{"четырнадцать", "четырнадцати", "четырнадцати", "четырнадцать", "четырнадцатью", "четырнадцати"});
        TENS.put(15, new String[]{"пятнадцать", "пятнадцати", "пятнадцати", "пятнадцать", "пятнадцатью", "пятнадцати"});
        TENS.put(16, new String[]{"шестнадцать", "шестнадцати", "шестнадцати", "шестнадцать", "шестнадцатью", "шестнадцати"});
        TENS.put(17, new String[]{"семнадцать", "семнадцати", "семнадцати", "семнадцать", "семнадцатью", "семнадцати"});
        TENS.put(18, new String[]{"восемнадцать", "восемнадцати", "восемнадцати", "восемнадцать", "восемнадцатью", "восемнадцати"});
        TENS.put(19, new String[]{"девятнадцать", "девятнадцати", "девятнадцати", "девятнадцать", "девятнадцатью", "девятнадцати"});

        // Инициализация единиц
        UNITS.put(1, new String[]{
                "один", "одного", "одному", "один", "одним", "одном",
                "одна", "одной", "одной", "одну", "одной", "одной",
                "одно", "одного", "одному", "одно", "одним", "одном"
        });
        UNITS.put(2, new String[]{
                "два", "двух", "двум", "два", "двумя", "двух",
                "две", "двух", "двум", "две", "двумя", "двух",
                "два", "двух", "двум", "два", "двумя", "двух"
        });
        UNITS.put(3, new String[]{
                "три", "трех", "трем", "три", "тремя", "трех",
                "три", "трех", "трем", "три", "тремя", "трех",
                "три", "трех", "трем", "три", "тремя", "трех"
        });
        UNITS.put(4, new String[]{
                "четыре", "четырех", "четырем", "четыре", "четырьмя", "четырех",
                "четыре", "четырех", "четырем", "четыре", "четырьмя", "четырех",
                "четыре", "четырех", "четырем", "четыре", "четырьмя", "четырех"
        });
        UNITS.put(5, new String[]{
                "пять", "пяти", "пяти", "пять", "пятью", "пяти",
                "пять", "пяти", "пяти", "пять", "пятью", "пяти",
                "пять", "пяти", "пяти", "пять", "пятью", "пяти"
        });
        UNITS.put(6, new String[]{
                "шесть", "шести", "шести", "шесть", "шестью", "шести",
                "шесть", "шести", "шести", "шесть", "шестью", "шести",
                "шесть", "шести", "шести", "шесть", "шестью", "шести"
        });
        UNITS.put(7, new String[]{
                "семь", "семи", "семи", "семь", "семью", "семи",
                "семь", "семи", "семи", "семь", "семью", "семи",
                "семь", "семи", "семи", "семь", "семью", "семи"
        });
        UNITS.put(8, new String[]{
                "восемь", "восьми", "восьми", "восемь", "восьмью", "восьми",
                "восемь", "восьми", "восьми", "восемь", "восьмью", "восьми",
                "восемь", "восьми", "восьми", "восемь", "восьмью", "восьми"
        });
        UNITS.put(9, new String[]{
                "девять", "девяти", "девяти", "девять", "девятью", "девяти",
                "девять", "девяти", "девяти", "девять", "девятью", "девяти",
                "девять", "девяти", "девяти", "девять", "девятью", "девяти"
        });

        // Инициализация десятков
        TENS.put(20, new String[]{"двадцать", "двадцати", "двадцати", "двадцать", "двадцатью", "двадцати"});
        TENS.put(30, new String[]{"тридцать", "тридцати", "тридцати", "тридцать", "тридцатью", "тридцати"});
        TENS.put(40, new String[]{"сорок", "сорока", "сорока", "сорок", "сорока", "сорока"});
        TENS.put(50, new String[]{"пятьдесят", "пятидесяти", "пятидесяти", "пятьдесят", "пятьюдесятью", "пятидесяти"});
        TENS.put(60, new String[]{"шестьдесят", "шестидесяти", "шестидесяти", "шестьдесят", "шестьюдесятью", "шестидесяти"});
        TENS.put(70, new String[]{"семьдесят", "семидесяти", "семидесяти", "семьдесят", "семьюдесятью", "семидесяти"});
        TENS.put(80, new String[]{"восемьдесят", "восьмидесяти", "восьмидесяти", "восемьдесят", "восьмьюдесятью", "восьмидесяти"});
        TENS.put(90, new String[]{"девяносто", "девяноста", "девяноста", "девяносто", "девяноста", "девяноста"});

        HUNDREDS.put(100, new String[]{"сто", "ста", "ста", "сто", "ста", "ста"});
        HUNDREDS.put(200, new String[]{"двести", "двухсот", "двумстам", "двести", "двумястами", "двухстах"});
        HUNDREDS.put(300, new String[]{"триста", "трехсот", "тремстам", "триста", "тремястами", "трехстах"});
        HUNDREDS.put(400, new String[]{"четыреста", "четырехсот", "четыремстам", "четыреста", "четырьмястами", "четырехстах"});
        HUNDREDS.put(500, new String[]{"пятьсот", "пятисот", "пятисот", "пятьсот", "пятьюстами", "пятисот"});
        HUNDREDS.put(600, new String[]{"шестьсот", "шестисот", "шестистам", "шестьсот", "шестьюстами", "шестистах"});
        HUNDREDS.put(700, new String[]{"семьсот", "семисот", "семистам", "семьсот", "семьюстами", "семистах"});
        HUNDREDS.put(800, new String[]{"восемьсот", "восьмисот", "восьмистам", "восемьсот", "восемьюстами", "восьмистах"});
        HUNDREDS.put(900, new String[]{"девятьсот", "девятисот", "девятистам", "девятьсот", "девятьюстами", "девятистах"});

        THOUSANDS.put(1, new String[]{"одна тысяча", "одной тысячи", "одной тысяче", "одну тысячу", "одной тысячей", "одной тысяче"});
        THOUSANDS.put(2, new String[]{"две тысячи", "двух тысяч", "двум тысячам", "две тысячи", "двумя тысячами", "двух тысячах"});
        THOUSANDS.put(3, new String[]{"три тысячи", "трех тысяч", "трем тысячам", "три тысячи", "тремя тысячами", "трех тысячах"});
        THOUSANDS.put(4, new String[]{"четыре тысячи", "четырех тысяч", "четырем тысячам", "четыре тысячи", "четырьмя тысячами", "четырех тысячах"});
        THOUSANDS.put(5, new String[]{"пять тысяч", "пяти тысяч", "пяти тысячам", "пять тысяч", "пятью тысячами", "пяти тысячах"});
        THOUSANDS.put(6, new String[]{"шесть тысяч", "шести тысяч", "шести тысячам", "шесть тысяч", "шестью тысячами", "шести тысячах"});
        THOUSANDS.put(7, new String[]{"семь тысяч", "семи тысяч", "семи тысячам", "семь тысяч", "семью тысячами", "семи тысячах"});
        THOUSANDS.put(8, new String[]{"восемь тысяч", "восьми тысяч", "восьми тысячам", "восемь тысяч", "восьмью тысячами", "восьми тысячах"});
        THOUSANDS.put(9, new String[]{"девять тысяч", "девяти тысяч", "девяти тысячам", "девять тысяч", "девятью тысячами", "девяти тысячах"});

        MILLIONS.put(1, new String[]{"один миллион", "одного миллиона", "одному миллиону", "один миллион", "одним миллионом", "одном миллионе"});
        MILLIONS.put(2, new String[]{"два миллиона", "двух миллионов", "двум миллионам", "два миллиона", "двумя миллионами", "двух миллионах"});
        MILLIONS.put(3, new String[]{"три миллиона", "трех миллионов", "трем миллионам", "три миллиона", "тремя миллионами", "трех миллионах"});
        MILLIONS.put(4, new String[]{"четыре миллиона", "четырех миллионов", "четырем миллионам", "четыре миллиона", "четырьмя миллионами", "четырех миллионах"});
        MILLIONS.put(5, new String[]{"пять миллионов", "пяти миллионов", "пяти миллионам", "пять миллионов", "пятью миллионами", "пяти миллионах"});
        MILLIONS.put(6, new String[]{"шесть миллионов", "шести миллионов", "шести миллионам", "шесть миллионов", "шестью миллионами", "шести миллионах"});
        MILLIONS.put(7, new String[]{"семь миллионов", "семи миллионов", "семи миллионам", "семь миллионов", "семью миллионами", "семи миллионах"});
        MILLIONS.put(8, new String[]{"восемь миллионов", "восьми миллионов", "восьми миллионам", "восемь миллионов", "восьмью миллионами", "восьми миллионах"});
        MILLIONS.put(9, new String[]{"девять миллионов", "девяти миллионов", "девяти миллионам", "девять миллионов", "девятью миллионами", "девяти миллионах"});

        BILLIONS.put(1, new String[]{"один миллиард", "одного миллиарда", "одному миллиарду", "один миллиард", "одним миллиардом", "одном миллиарде"});
        BILLIONS.put(2, new String[]{"два миллиарда", "двух миллиардов", "двум миллиардом", "два миллиарда", "двумя миллиардами", "двух миллиардов"});
        BILLIONS.put(3, new String[]{"три миллиарда", "трех миллиардов", "трем миллиардом", "три миллиарда", "тремя миллиардами", "трех миллиардов"});
        BILLIONS.put(4, new String[]{"четыре миллиарда", "четырех миллиардов", "четырем миллиардом", "четыре миллиарда", "четырьмя миллиардами", "четырех миллиардов"});
        BILLIONS.put(5, new String[]{"пять миллиардов", "пяти миллиардов", "пяти миллиардом", "пять миллиардов", "пятью миллиардов", "пяти миллиардов"});
        BILLIONS.put(6, new String[]{"шесть миллиардов", "шести миллиардов", "шести миллиардом", "шесть миллиардов", "шестью миллиардов", "шести миллиардов"});
        BILLIONS.put(7, new String[]{"семь миллиардов", "семи миллиардов", "семи миллиардом", "семь миллиардов", "семью миллиардов", "семи миллиардов"});
        BILLIONS.put(8, new String[]{"восемь миллиардов", "восьми миллиардов", "восьми миллиардом", "восемь миллиардов", "восьмью миллиардов", "восьми миллиардов"});
        BILLIONS.put(9, new String[]{"девять миллиардов", "девяти миллиардов", "девяти миллиардом", "девять миллиардов", "девятью миллиардов", "девяти миллиардов"});
    }

    public static String sumProp(long nSum, String sGender, String sCase) {
        // Проверка на допустимые значения
        if (nSum < 0 || nSum >= 999_000_000_000L) {
            throw new IllegalArgumentException("Число должно быть меньше 999-ти миллиардов и больше нуля");
        }

        StringBuilder result = new StringBuilder();

        // Обрабатываем миллиарды
        if (nSum >= 1_000_000_000) {
            long billions = nSum / 1_000_000_000;
            result.append(convertNumberToWords(billions, "С", sCase, BILLIONS)).append(" ");
            nSum %= 1_000_000_000;
        }

        if (nSum >= 1_000_000) {
            long millions = nSum / 1_000_000;
            result.append(convertNumberToWords(millions, "С", sCase, MILLIONS)).append(" ");
            nSum %= 1_000_000;
        }

        // Обрабатываем тысячи
        if (nSum >= 1_000) {
            long thousands = nSum / 1_000;
            result.append(convertThousands(thousands, sCase)).append(" ");
            nSum %= 1_000;
        }

        // Обрабатываем сотни, десятки и единицы
        if (nSum > 0) {
            result.append(convertNumberToWords(nSum, sGender, sCase, UNITS));
        } else if (result.isEmpty()) {
            result.append("ноль");
        }

        return result.toString().trim();
    }

    // Метод для обработки тысяч
    private static String convertThousands(long thousands, String sCase) {
        String result;
        String gender = "Ж";

        switch (sCase) {
            case "И":
                result = (thousands == 1) ? "одна тысяча" : convertNumberToWords(thousands, gender, sCase, UNITS) + " тысяч";
                break;
            case "Р":
                result = (thousands == 1) ? "одной тысячи" : convertNumberToWords(thousands, gender, sCase, UNITS) + " тысяч";
                break;
            case "Д":
                result = (thousands == 1) ? "одной тысяче" : convertNumberToWords(thousands, gender, sCase, UNITS) + " тысячам";
                break;
            case "В":
                result = (thousands == 1) ? "одну тысячу" : convertNumberToWords(thousands, gender, sCase, UNITS) + " тысяч";
                break;
            case "Т":
                result = (thousands == 1) ? "одной тысячей" : convertNumberToWords(thousands, gender, sCase, UNITS) + " тысячами";
                break;
            case "П":
                result = (thousands == 1) ? "одной тысяче" : convertNumberToWords(thousands, gender, sCase, UNITS) + " тысячах";
                break;
            default:
                result = "";
                break;
        }

        return result.trim();
    }

    private static String convertNumberToWords(long number, String sGender, String sCase, Map<Integer, String[]> map) {
        StringBuilder result = new StringBuilder();

        // Обработка сотен
        if (number >= 100) {
            long hundreds = number / 100;
            String hundredWord = HUNDREDS.get((int) (hundreds * 100))[CASE_MAP.get(sCase)];
            result.append(hundredWord).append(" ");
            number %= 100;
        }

        // Обработка десятков и единиц
        if (number >= 20) {
            long tens = (number / 10) * 10;
            result.append(TENS.get((int) tens)[CASE_MAP.get(sCase)]).append(" ");
            number %= 10;
        } else if (number >= 10) {
            result.append(TENS.get((int) number)[CASE_MAP.get(sCase)]).append(" ");
            number = 0;
        }

        // Обработка единиц
        if (number > 0) {
            if (sGender.equals("Ж")) {
                if (number == 1) {
                    if (sCase.equals("И")) {
                        result.append("одна");
                    } else if (sCase.equals("Р")) {
                        result.append("одной");
                    } else if (sCase.equals("Д")) {
                        result.append("одной");
                    } else if (sCase.equals("В")) {
                        result.append("одну");
                    } else if (sCase.equals("Т")) {
                        result.append("одной");
                    } else if (sCase.equals("П")) {
                        result.append("одной");
                    }
                } else if (number == 2) {
                    if (sCase.equals("И")) {
                        result.append("две");
                    } else if (sCase.equals("Р")) {
                        result.append("двух");
                    } else if (sCase.equals("Д")) {
                        result.append("двум");
                    } else if (sCase.equals("В")) {
                        result.append("две");
                    } else if (sCase.equals("Т")) {
                        result.append("двумя");
                    } else if (sCase.equals("П")) {
                        result.append("двух");
                    }
                } else {
                    result.append(map.get((int) number)[CASE_MAP.get(sCase)]);
                }
            } else {
                result.append(map.get((int) number)[CASE_MAP.get(sCase)]);
            }
        }

        return result.toString().trim();
    }


    public static void main(String[] args) {
        System.out.println(sumProp(3_234_567_890L, "М", "И"));
        System.out.println(sumProp(3_234_567_890L, "М", "Р"));
        System.out.println(sumProp(3_234_567_890L, "Ж", "Д"));
        System.out.println(sumProp(3_234_567_890L, "Ж", "В"));
        System.out.println(sumProp(3_234_567_890L, "С", "Т"));
        System.out.println(sumProp(3_234_567_890L, "С", "П"));

        System.out.println(sumProp(154323, "М", "Т"));
        System.out.println(sumProp(154323, "М", "И"));

        System.out.println(sumProp(22, "С", "Т"));
        System.out.println(sumProp(22, "Ж", "И"));

        System.out.println(sumProp(31, "М", "Р"));

        System.out.println(sumProp(1, "М", "И"));
        System.out.println(sumProp(1, "М", "И"));
        System.out.println(sumProp(1, "М", "Р"));
        System.out.println(sumProp(1, "С", "Д"));
        System.out.println(sumProp(1, "С", "Т"));
        System.out.println(sumProp(1, "Ж", "В"));
        System.out.println(sumProp(1, "Ж", "П"));
    }
}