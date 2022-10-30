public class sss {
    private static String formatName(String name) {
        // Создаем новый массив строк words.
        // name.trim() убирает пробелы в начале и конце строки.
        // name.split(" "); делит строку в местах пробела.
        //Например строку Багиров Эмин Этибарович он разделит на массив "Багиров", "Эмин", "Этибарович".
        String[] words = name.trim().split(" ");
        //Чуть выше мы создали массив из 3 строк где каждый эллемент это что-то из ФИО
        //тут мы сортируем данным массив по длине слов.
        sortByLength(words);
        String result = "";
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            char firstChar = str.charAt(0);
            if (!Character.isUpperCase(firstChar)) {
                result += Character.toUpperCase(firstChar) + str.substring(1) + " ";
            } else {
                result += str + "";
            }
        }
        return result;
    }

    private static void sortByLength(String[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - 1; j++) {
                if (words[j].length() > words[j + 1].length()) {
                    String tmp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = tmp;
                }
            }
        }
    }
}
