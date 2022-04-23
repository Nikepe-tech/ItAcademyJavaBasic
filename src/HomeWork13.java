import homework13.task1.RandomNumber;
import homework13.task2.MaxNumber;
import homework13.task3.NewFile;
import homework13.task4.MyRunnable;
import homework13.task5.Deadlock;
import homework13.task6.Consumer;
import homework13.task6.Manufacturer;
import homework13.task6.MyQueue;
import homework13.task7.MyCallable;

import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.concurrent.*;

public class HomeWork13 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
    }

    /*
    Создать 10 потоков, каждый из которых вычисляет среднее арифметическое
    коллекции из 10 случайных целых чисел и выводит на экран.
     */
    public static void task1() {
        for (int i = 0; i < 10; i++) {
            RandomNumber randomNumber = new RandomNumber();
            randomNumber.start();
        }
    }

    /*
    Создать класс поток, который генерирует массив случайных целых чисел из 10 элементов,
    затем находит максимальный элемент, в этом массиве, и выводит на экран в формате имя потока,
    максимальный элемент. Запустить 10 потоков.
     */
    public static void task2() {
        for (int i = 0; i < 10; i++) {
            MaxNumber maxNumber = new MaxNumber();
            Thread thread = new Thread(maxNumber);
            maxNumber.setThreadName(thread.getName());
            thread.start();
        }
    }

    /*
    Создать класс поток, который создает средствами Java файл и записать в него произвольно
    сгенерированный массив из 10 случайных целых чисел. Запустить 5 потоков.
     */
    public static void task3() {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new NewFile());
            thread.start();
        }
    }

    /*
    Создать метод, который печатает название потока и засыпает на 2 секунды.
    Запустить одновременно 10 потоков. Реализовать механизм синхронизации,
    чтобы все потоки выполнились последовательно.
     */
    public static void task4() {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    Создать программу, которая реализует deadlock между тремя потоками.
     */
    public static void task5() {
        Deadlock deadlock = new Deadlock();
        Thread thread1 = new Thread(deadlock);
        Thread thread2 = new Thread(deadlock);
        Thread thread3 = new Thread(deadlock);
        thread1.start();
        thread2.start();
        thread3.start();
    }

    /*
    Есть 3 производителя и 2 потребителя, все разные потоки и работают все одновременно.
    Есть очередь с 200 элементами. Производители добавляют случайное число от 1..100, а потребители берут эти числа.
    Если в очереди элементов >= 100 производители спят, если нет элементов в очереди – потребители спят.
    Если элементов стало <= 80, производители просыпаются. Все это работает до тех пор,
    пока обработанных элементов не станет 10000, только потом программа завершается.
     */
    public static void task6() {
        MyQueue queue = new MyQueue(200);
        Manufacturer producer1 = new Manufacturer(queue);
        Manufacturer producer2 = new Manufacturer(queue);
        Manufacturer producer3 = new Manufacturer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);

        Thread t1 = new Thread(producer1);
        Thread t2 = new Thread(producer2);
        Thread t3 = new Thread(producer3);
        Thread t4 = new Thread(consumer1);
        Thread t5 = new Thread(consumer2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

    /*
    Создать задачу Callable, которая генерирует 10 файлов с 10 произвольными строками
    -> засыпает произвольно на 1-3 секунды, результат выполнения – коллекция имен файлов.
    Запустить 10 задач параллельно в пуле из 3 потоков. Вывести ход программы на экран с указанием имени потока,
    который выполняет работу.
     */
    public static void task7() {
        List<String> fileNames = new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int n = 0; n < 10; n++) {
            Future<List<File>> listFuture = pool.submit(new MyCallable());
            try {
            while (!listFuture.isDone()) {
                Thread.sleep(1);
            }
            for (int i = 0; i < listFuture.get().size(); i++) {
                fileNames.add(listFuture.get().get(i).getName());
            }
        } catch (Exception e){
                e.printStackTrace();
            }
        }
        pool.shutdown();
        System.out.println(fileNames);
    }

    /*
    Создать задачу Callable, которая генерирует коллекцию из 10 рандомных целых чисел
    -> засыпает произвольно на 1-10 секунд, результат выполнения – сумму этих чисел в виде строки.
    Запустить 10 задач параллельно в пуле из 3 потоков. Вывести ход программы на экран с указанием имени потока,
    который выполняет работу.
     */
    public static void task8() {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Callable<String> stringCallable = new Callable<>() {
            @Override
            public String call() {
                List<Integer> numbers = new ArrayList<>();
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    numbers.add((int) (Math.random() * 10));
                    sum += numbers.get(i);
                }
                System.out.println(Thread.currentThread().getName() + " : считает сумму");
                try {
                    Thread.sleep((int) (Math.random() * 10 - 1) * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "" + sum;
            }
        };
        for (int i = 0; i < 10; i++){
            Future<String> stringFuture = pool.submit(stringCallable);
            while (!stringFuture.isDone()){
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                System.out.println(stringFuture.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }

    /*
    Создать задачу Callable, которая берет сообщение “Hello World” + текущее время и записывает его в файл.
    Запись в файл должна производиться последовательно через синхронизированный метод.
    Запустить 10 задач параллельно в пуле из 3 потоков. Вывести ход программы на экран с указанием имени потока,
    который выполняет работу.
     */
    public static void task9() {
        Callable<File> fileCallable = new Callable<>() {
            @Override
            public synchronized File call() {
                    File file = new File("./src/homework13/task9/hello");
                try {
                    FileWriter fileWriter = new FileWriter(file, true);
                    Date date = new Date();
                    fileWriter.write("Hello world" + date + "\n");
                    System.out.println(Thread.currentThread().getName() + " : выполняет задачу.");
                    fileWriter.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
                return file;
            }
        };
        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++){
            Future<File> fileFuture = pool.submit(fileCallable);
            while (!fileFuture.isDone()){
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        pool.shutdown();
    }
}
