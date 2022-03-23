import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class HomeWork07 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
    }

    /*
    Введите с клавиатуры строку. Найти в строке не только запятые,
    но и другие знаки препинания. Подсчитать общее их количество.
     */
    public static void task1() {
        Scanner scanner = new Scanner(System.in);
        try {
            Pattern n = Pattern.compile("[.,:;]");
            String next = scanner.nextLine();
            Matcher matcher = n.matcher(next);
            System.out.println(matcher.results().count());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Введите с клавиатуры текст. Подсчитать количество слов в тексте.
    Учесть, что слова могут разделяться несколькими пробелами,
    в начале и конце текста также могут быть пробелы, но могут и отсутствовать.
    */
    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        try {
            Pattern n = Pattern.compile("\\s*[A-Za-zА-Яа-я0-9'_-]+\\s*");
            String next = scanner.nextLine();
            Matcher matcher = n.matcher(next);
            System.out.println(matcher.results().count());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Введите с клавиатуры текст. Выведите на экран текст,
    составленный из последних букв всех слов из исходного текста.
    */
    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        try {
            Pattern n = Pattern.compile("([A-Za-zА-Яа-я])[\\s.,;:()]");
            String next = scanner.nextLine();
            Matcher matcher = n.matcher(next);
            while (matcher.find()){
                System.out.print(matcher.group(1) + " ");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Введите с клавиатуры строку. Напишите метод,
    выполняющий поиск в строке шестнадцатеричных чисел,
    записанных по правилам Java, с помощью регулярных выражений.
    Результат работы метода выведите на экран.
     */
    public static void task4() {
        Scanner scanner = new Scanner(System.in);
        try {
            Pattern n = Pattern.compile("(0x[A-Fa-f0-9]{1,4})");
            String next = scanner.nextLine();
            Matcher matcher = n.matcher(next);
            while (matcher.find()){
                System.out.print(matcher.group(1) + " ");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Введите с клавиатуры строку. Напишите метод, выполняющий поиск в строке всех тегов абзацев,
    в том числе тех, у которых есть параметры, например, <p id=”p1”>, и замену их на простые теги абзацев <p>.
    Результат работы метода выведите на экран.
     */
    public static void task5() {
        Scanner scanner = new Scanner(System.in);
        try {
            Pattern n = Pattern.compile("(<p(\\s\\S+=\\S+)*>)");
            String next = scanner.nextLine();
            System.out.println(next.replaceAll("<p(\\s\\S+=\\S+)*>", "<p>"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Напишите два цикла выполняющих миллион сложений строк вида “aaabbbccc”,
    один с помощью оператора сложения и String, а другой с помощью StringBuilder и метода append.
    Сравните скорость их выполнения. Выведите сравнение на экран.
     */
    public static void task6() {
        long time = System.currentTimeMillis();
        String str = "";
        for (int n = 0; n < 1000000; n++){
            str += "aaabbbccc";
        }
        System.out.println(System.currentTimeMillis() - time);
        time = System.currentTimeMillis();
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < 1000000; i++){
            strBuilder.append("aaabbbccc");
        }
        System.out.println(System.currentTimeMillis() - time);
    }
}
