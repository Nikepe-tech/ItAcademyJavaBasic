import homework11.MyException;

public class HomeWork11 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    /*
    Написать код, который выбрасывает NullPointerException.
    Написать обработчик этого исключения и вывести на экран сообщение,
    которое будет содержать описание данного исключения.
     */
    public static void task1() {
        try {
            method1();
        } catch (NullPointerException e) {
            System.out.println("Выполнение ошибки: " + e.getMessage());
        }
    }

    public static void method1() {
        throw new NullPointerException("NullPointerException");
    }

    /*
    Написать собственное исключение от Exception. Сгенерировать код,
    который будет выбрасывать его и обрабатывать. Результат работы программы вывести на экран.
     */
    public static void task2() {
        try {
            throw new MyException("Есть ошибка ");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }


    /*
    Написать метод, который будет возбуждать исключение и обработать это исключение на уровне выше.
    Результат работы программы вывести на экран.
     */
    public static void task3() {
        try {
            throw new Exception("Ошибка");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
