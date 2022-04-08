import java.util.*;

public class HomeWork10 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    /*
    Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками.
    Удалить неудовлетворительные оценки из списка.
     */
    public static void task1() {
        ArrayList<Integer> mark = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mark.add((int) (Math.random() * 10 + 1));
        }
        System.out.println(mark);
        for (int i = 0; i < mark.size(); i++) {
            if (mark.get(i) < 4) {
                mark.remove(i);
                i--;
            }
        }
        System.out.println(mark);
    }

    /*
    Создать коллекцию, заполнить ее случайными целыми числами.
    Удалить повторяющиеся числа. Результат - коллекция без повторов.
     */
    public static void task2() {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            numbers.add((int) (Math.random() * 10));
        }
        System.out.println(numbers);

        //Вариант 2
        ArrayList<Integer> numbers2 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            numbers2.add((int) (Math.random() * 10));
        }
        for (int i = 0; i < numbers2.size(); i++) {
            for (int j = 0; j < numbers2.size(); j++) {
                if (numbers2.get(i).equals(numbers2.get(j)) && i != j) {
                    numbers2.remove(j);
                    j--;
                }
            }
        }
        System.out.println(numbers2);
    }

    /*
    Создать список оценок учеников с помощью ArrayList, заполнить случайными оценками.
    Найти самую высокую оценку с использованием итератора.
     */
    public static void task3() {
        ArrayList<Integer> mark = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mark.add((int) (Math.random() * 10 + 1));
        }
        System.out.println(mark);

        Iterator<Integer> iterator = mark.iterator();
        int max = 0;
        while (iterator.hasNext()) {
            max = Math.max(max, iterator.next());
        }
        System.out.println("Самая высокая оценка: " + max);
    }

    /*
    Ввести текст с клавиатуры. Для текста создать Map, где ключом будет слово,
    а значение – количество повторений этого слова в тексте.
     */
    public static void task4() {
        Map<String, Integer> result = new HashMap<>();
        System.out.print("Введите предложение: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] words = s.split("[-,.:;\\s]+");
        for (String word : words) {
            if (result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
            } else {
                result.put(word, 1);
            }
        }
        System.out.println(result);
    }
}
