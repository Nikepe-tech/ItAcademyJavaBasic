import homework09.task1.Season;
import homework09.task2.Season2;
import homework09.task4.Car;
import homework09.task4.Garage;
import homework09.task4.Motorcycle;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork09 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    /*
    Создать enum, который описывает сезоны года.
    Добавить поле description в этот enum. Добавить поле countOfDays в этот enum.
    Вывести на экран все константы сезоны года.
     */
    public static void task1() {
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value.name() + " : " + value.getDescription() + " : " + value.getCountOfDays());
        }
    }

    /*
    Написать метод, который выводит следующий сезон от заданного во входном параметре.
    Входной параметр ввести с клавиатуры.
     */
    public static void task2() {
        Season2[] values = Season2.values();
        System.out.print("Введите один из сезонов: " + Arrays.toString(values) + " : ");
        Scanner scanner = new Scanner(System.in);
        try {
            String s = scanner.next();
            Season2 season2 = Season2.valueOf(s);
            if (season2.ordinal() < values.length - 1) {
                System.out.println(values[season2.ordinal() + 1]);
            } else {
                System.out.println(values[0]);
            }

        } catch (IllegalArgumentException ex1) {
            System.out.println("Введено недопустимое значение.");
        }
    }

    /*
    Написать метод, который в зависимости от сезона, выводит на экран сумму дней в этом сезоне.
    Входной параметр ввести с клавиатуры.
     */
    public static void task3() {
        Season[] values = Season.values();
        System.out.print("Введите один из сезонов: " + Arrays.toString(values) + " : ");
        Scanner scanner = new Scanner(System.in);
        try {
            String s = scanner.next();
            Season season = Season.valueOf(s);
            System.out.println(season.name() + " - " + season.getCountOfDays());
        } catch (IllegalArgumentException ex1) {
            System.out.println("Введено недопустимое значение.");
        }
    }

    /*
    Создать классы Car и Motorcycle, которые наследуются от общего класса Vehicle.
    Создать поле name в классе Vehicle и проинициализировать его через конструктора.
    Создать generic класс Garage, который может хранить только объекты типа наследуемого от Vehicle.
    Создать 2 объекта класса Garage (все поля ввести с клавиатуры) и вывести на экран имя хранимого
    транспортного средства.
     */
    public static void task4() {
        System.out.print("Введите название автомобиля: ");
        Scanner scanner = new Scanner(System.in);
        Car car = new Car(scanner.next());
        Garage<Car> garage = new Garage<>(car);
        System.out.println(garage.getVehicleName());
        System.out.print("Введите название мотоцикла: ");
        Motorcycle motorcycle = new Motorcycle(scanner.next());
        Garage<Motorcycle> garage1 = new Garage<>(motorcycle);
        System.out.println(garage1.getVehicleName());
    }
}
