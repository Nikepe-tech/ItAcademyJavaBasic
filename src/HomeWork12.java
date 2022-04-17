import homework12.task6.Person;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork12 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
    }

    /*
    Вывести список файлов и каталогов выбранного каталога на диске.
    Файлы и каталоги должны быть распечатаны отдельно.
     */
    public static void task1() {
        try {
            File f1 = new File("./src");
            List<String> directory = new ArrayList<>();
            List<String> files = new ArrayList<>();
            File[] listFiles = f1.listFiles();
            if (listFiles == null) {
                System.out.println("Файлы не прочитаны");
            } else {
                for (File file : listFiles) {
                    if (file.isDirectory()) {
                        directory.add(file.getName());
                    } else if (file.isFile()) {
                        files.add(file.getName());
                    }
                }
                System.out.println("Directories: " + directory);
                System.out.println("Files: " + files);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Создать файл с текстом, прочитать, подсчитать в тексте количество знаков препинания и слов.
    Вывести результат на экран.
     */
    public static void task2() {
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader("./src/homework12/task2/homework12.task2"));
            StringBuilder res = new StringBuilder();
            String l = reader.readLine();
            while (l != null) {
                res.append(l);
                l = reader.readLine();
            }
            Pattern n = Pattern.compile("[.,:;!?]");/*-*/
            Matcher matcher = n.matcher(res.toString());
            System.out.println("Количество знаков препинания: " + matcher.results().count());
            Pattern s = Pattern.compile("\\s*[A-Za-zА-Яа-я0-9'_-]+\\s*");
            Matcher matcher2 = s.matcher(res.toString());
            System.out.println("Количество слов: " + matcher2.results().count());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
    Создать файл с текстом, в котором присутствуют числа. Найти все числа, вывести на экран,
    посчитать сумму, убрать все повторяющиеся числа и снова вывести на экран.
     */
    public static void task3() {
        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader("./src/homework12/task3/homework12.task3"));
            StringBuilder res = new StringBuilder();
            String l = reader.readLine();
            while (l != null) {
                res.append(l);
                res.append("\n");
                l = reader.readLine();
            }
            Pattern s = Pattern.compile("[0-9]+");
            List<Integer> numbers = new ArrayList<>();
            Matcher matcher = s.matcher(res.toString());
            while (matcher.find()) {
                numbers.add(Integer.valueOf(matcher.group()));
            }
            System.out.println(numbers);
            int sum = 0;
            List<Integer> uniqueNumbers = new ArrayList<>();
            for (Integer number : numbers) {
                sum += number;
                if (!uniqueNumbers.contains(number)) {
                    uniqueNumbers.add(number);
                }
            }
            System.out.println("Сумма: " + sum);
            System.out.println(uniqueNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Записать с помощью Java в двоичный файл 20 случайных чисел.
    Прочитать записанный файл, вывести на экран числа и их среднее арифметическое.
     */
    public static void task4() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add((int) (Math.random() * 10 + 1));
        }
        FileOutputStream task4 = null;
        try {
            task4 = new FileOutputStream("./src/homework12/task4/homework12.task4");
            ObjectOutputStream task4_1 = new ObjectOutputStream(task4);
            task4_1.writeObject(list);
            task4_1.close();
            FileInputStream task4d = new FileInputStream("./src/homework12/task4/homework12.task4");
            ObjectInputStream task4d_1 = new ObjectInputStream(task4d);
            //noinspection unchecked
            List<Integer> list1 = (List<Integer>) task4d_1.readObject();
            System.out.println(list1);
            int sum = 0;
            for (Integer integer : list1) {
                sum += integer;
            }
            System.out.println((double) sum / list1.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Создать цепочку из трех папок. В конечном каталоге создать 5 произвольных текстовых файлов.
    Заполнить их 10 случайными целыми числами. Содержимое файлов записать в один файл в том же каталоге.
    Создать файл, который будет содержать список файлов данного каталога.
     */
    public static void task5() {
        String[] files = {"one", "two", "three", "four", "five"};
        try {
            StringBuilder res = new StringBuilder();
            for (String file : files) {
                BufferedReader reader1 =
                        new BufferedReader(new FileReader("./src/homework12/task5/package1/" + file));
                String l = reader1.readLine();
                while (l != null) {
                    res.append(l);
                    res.append("\n");
                    l = reader1.readLine();
                }
            }
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new FileWriter("./src/homework12/task5/package1/content"));
            bufferedWriter.write(res.toString());
            bufferedWriter.close();
            File f1 = new File("./src/homework12/task5/package1");
            String[] listFiles = f1.list();
            BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter("./src/homework12/task5/list"));
            if (listFiles == null) {
                System.out.println("Файлы не прочитаны");
            } else {
                bufferedWriter1.write(String.join("\n", listFiles));
                bufferedWriter1.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Создать объект Person c полями name, surname, age. Создать два массива (имена и фамили).
    Сгенерировать 10 объектов класса Person со случайным age и случайно выбранными именами и
    фамилиями соответствующего типа. С помощью Java создать файл, в который запишется информация о этих людях.
     */
    public static void task6() {
        String[] names = {
                "Илья",
                "Михаил",
                "Иван",
                "Ярослав",
                "Егор",
                "Алексей",
                "Глеб",
                "Владислав",
                "Даниил",
                "Марк"};
        String[] surnames = {
                "Акимов",
                "Евсеев",
                "Корнеев",
                "Кузьмин",
                "Шапошников",
                "Горлов",
                "Тихонов",
                "Зубков",
                "Никитин",
                "Голубев"};
        try {
            List<String> personList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Person person = new Person();
                person.setAge((int) (Math.random() * 60));
                person.setName(names[(int) (Math.random() * names.length)]);
                person.setSurname(surnames[(int) (Math.random() * names.length)]);
                personList.add(person.toString());
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./src/homework12/task6/person"));
            bufferedWriter.write(personList.toString());
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
