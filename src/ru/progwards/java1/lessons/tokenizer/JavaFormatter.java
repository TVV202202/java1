package ru.progwards.java1.lessons.tokenizer;

import java.util.Arrays;


public class JavaFormatter {

    public static String format(String code) {
        StringBuilder result = new StringBuilder();
        int countBrace = 0; // счетчик фигурных скобок
        boolean operator = true;
        String[] strings = code.split("\n"); // разбиение текста на строки
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i].trim();
            String[] words = str.split(" "); // разбиение строки на слова
            switch (words[0]) {
                case "for", "while", "if", "else", "switch", "case" -> operator = false;
                case "}" -> countBrace--;
                default -> operator = true;
            }
            // обработка метода
            // если открывающая круглая скобка  -> склеиваем с предыдущим и со следующим
            // если закрывающая круглая скобка первый символ -> склеиваем с предыдущим

            // обработка операторов
            // если открывающая круглая  -> склеиваем со следующим
            // если закрывающая круглая  -> склеиваем с предыдущим

            // если открывающая или закрывающая квадратная скобка  -> склеиваем с предыдущим

            // для прототы понимания и отладки разнес круглые, квадратные и знаки по разным методам,
            // можно слить в один (циклов будет в 3 раза меньше), но надо ли...
            str = handlingBracket(str, operator);
            str = handlingSquareBracket(str);
            str = handlingSign(str);

            str = str.replace(" ;", ";");
            str = str.replace(" .", ".");
            str = str.replace(". ", ".");

            if (str.startsWith("{")) {
                strings[i - 1] = strings[i - 1] + " {";
                countBrace++;
                str = str.replace("{ ", "");

            }
            strings[i] = tab(countBrace) + str;

            if (str.endsWith("{")) { // увеличиваем счетчик отступов
                countBrace++;
            }
        }
        for (String str : strings) {
            if (result.toString().equals("")) {
                result = new StringBuilder(str);
            } else {
                result.append("\n").append(str);
            }
        }

        return result.toString();
    }

    private static String tab(int count) { // нужное количество отступов (табуляций)
        return "\t".repeat(Math.max(0, count));
    }

    private static String handlingBracket(String str, boolean operator) { // если метод, то true, если оператор, то false
        char[] chArr = str.toCharArray(); // разбиение строки на символы
        for (int j = 0; j < chArr.length; j++) {
            switch (chArr[j]) {
                case '(' -> {
                    str = str.replace(chArr[j] + " ", String.valueOf(chArr[j])); // всегда убираем пробел после (
                    str = str.replace(String.valueOf(chArr[j]), " " + chArr[j]); // добавляем пробел спереди для операторов
                    str = str.replace("  ", " "); // убираем двойные пробелы
                    if (operator) { // если метод, то убираем пробелы спереди
                        str = str.replace(" " + chArr[j], String.valueOf(chArr[j]));
                    }
                }
                case ')' -> str = str.replace(" " + chArr[j], String.valueOf(chArr[j])); // всегда убираем пробел перед )
                default -> {
                }
            }
        }
        return str;
    }

    private static String handlingSquareBracket(String str) {
        char[] chArr = str.toCharArray(); // разбиение строки на символы
        for (int j = 0; j < chArr.length; j++) {
            switch (chArr[j]) {
                case '[' -> {
                    str = str.replace(chArr[j] + " ", String.valueOf(chArr[j])); // всегда убираем пробел после [
                    str = str.replace(" " + chArr[j], String.valueOf(chArr[j])); // всегда убираем пробел перед [
                }
                case ']' -> str = str.replace(" " + chArr[j], String.valueOf(chArr[j])); // всегда убираем пробел перед ]
                default -> {
                }
            }
        }
        return str;
    }

    private static String handlingSign(String str) {
        char[] chArr = str.toCharArray(); // разбиение строки на символы
        for (int j = 0; j < chArr.length; j++) {
            switch (chArr[j]) {
                case '+', '-', '/', '*', '=', '<', '>', '!' -> {
                    if (j + 1 < chArr.length) {
                        switch (chArr[j + 1]) {
                            case '+', '-', '=' -> {
                                String tmp = chArr[j] + String.valueOf(chArr[j + 1]);
                                str = str.replace(tmp, " " + tmp + " ");
                                j++;
                            }
                            default -> str = str.replace(String.valueOf(chArr[j]), " " + chArr[j] + " ");
                        }
                        str = str.replace("  ", " ");
                    }
                }
                default -> {
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String code = """
                private static boolean isOpendBracketFirst ( String word, char ch )\s
                      { char [] str=word++toCharArray();
                        if (str [ 0 ] == ch) {
                            return true ;
                   a . length;
                }
                        return false;
                    }\s""";
        System.out.println(format(code));

    }
}
