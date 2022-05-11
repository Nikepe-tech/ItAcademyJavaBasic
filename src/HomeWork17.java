import homework17.task1.NowDate;
import homework17.task2.Person;
import homework17.task3.Logger;

import java.util.Scanner;

public class HomeWork17 {

    public static void main(String[] args) throws Exception {
        task1();
        task2();
        task3();
    }

    /*
    Создайте простейший сервис с методом, который выводит на экран текущую дату.
    Сделайте его Singleton и используйте в основном теле программы.
     */
    public static void task1() {
        NowDate.getInstance().displaysTheCurrentDate();
    }

    /*
    Создайте класс Person с полями: имя, фамилия, год рождения. Реализуйте у этого класса паттерн Строитель.
    Введите поля с клавиатуры и заполните объект класса Person с помощью паттерна Строитель.
     */
    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите своё имя: ");
        String name = scanner.next();
        System.out.print("Введите свою фамилию: ");
        String surname = scanner.next();
        System.out.print("Введите свой год рождения: ");
        int year = Integer.parseInt(scanner.next());
        Person myPerson = new Person.PersonBuilder().setName(name).setSurname(surname).setYearOfBirth(year).build();
        System.out.println(myPerson.toString());
    }

    /*
    Создайте простейший логгер, выводящий сообщения об ошибках в текстовый файл.
    Объект логгера должен быть создан с помощью ШП Singleton. У объекта должен быть обязательным один метод,
    получающий на вход текст сообщения об ошибке и записывающий
    его в файл вместе с информацией о дате и времени происшествия.
     */
    public static void task3() {
        Logger.getLogger().debug("Отладочная информация");
        Logger.getLogger().error("Произошлла ошибка");
        Logger.getLogger().fatal("Приложение упало");
        Logger.getLogger().info("Получена новая информация");
        Logger.getLogger().warn("Внимание тут возможно будет ошибка");
    }
}
