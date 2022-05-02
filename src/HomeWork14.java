import homework14.task2.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class HomeWork14 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    /*
    Напишите программу, которая для всех четных значений длиной от 1 до 20 дюймов:
    a. печатает на экран значения в дюймах;
    b. переводит значения в сантиметры;
    c. печатает на экран сумму в сантиментах.
     */
    public static void task1() {
        double sum = IntStream.range(0, 30)
                .filter(intValue -> intValue < 20)
                .filter(intValue -> intValue % 2 == 0)
                .mapToDouble(a -> a)
                .peek((e) -> System.out.println(e + " inch"))
                .map((s) -> s * 2.54)
                .sum();
        System.out.println(sum + " cm");
    }

    /*
    Создайте класс Person с полями names, surnames, age.
    Сгенерируйте группу из 100 человек в возрасте от 15 до 30.
    Напишите ОДНУ НЕПРЕРЫВНУЮ цепочку stream вызовов, которая:
    a. выбирает объекты, возраст которых меньше 21;
    b. распечатывает их на экран;
    c. сортирует по фамилии, а потом по имени (использовать thenComparing у объекта Comparator);
    d. берет 4 первых объекта;
    e. формирует коллекцию из фамилий объектов;
    f. агрегирует все в коллекцию.
     */
    public static void task2() {
        try {
            List<String> nameList = new ArrayList<>();
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader("./src/homework14/task2/names"));
            String line;
            while ((line = bufferedReader1.readLine()) != null) {
                nameList.add(line);
            }
            List<String> surnameList = new ArrayList<>();
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("./src/homework14/task2/surnames"));
            while ((line = bufferedReader2.readLine()) != null) {
                surnameList.add(line);
            }
            List<String> people = IntStream.range(0, 100).mapToObj(i -> {
                        Person person = new Person();
                        person.setName(nameList.get((int) (Math.random() * 100)));
                        person.setSurname(surnameList.get((int) (Math.random() * 100)));
                        person.setAge((int) (Math.random() * 15 + 15));
                        return person;
                    })
                    .filter(p -> p.getAge() < 21)
                    .peek(System.out::println)
                    .sorted(Comparator.comparing(Person::getSurname).thenComparing(Person::getName))
                    .limit(4)
                    .map(Person::getSurname).toList();
            System.out.println(people);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Сгенерируйте List коллекцию целых чисел из n элементов от minValue до maxValue.
    Определить, содержатся ли в данной коллекции числа, которые делятся и на 3, и на 5 с помощью stream.
     */
    public static void task3() {

        List<Integer> numbers = IntStream.range(3, 10000)
                .filter(n -> n % 3 == 0 && n % 5 == 0).boxed().toList();
        System.out.println(numbers);
    }
}

