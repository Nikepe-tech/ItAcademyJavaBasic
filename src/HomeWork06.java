import homework06.task01.Time;
import homework06.task02.ATM;

public class HomeWork06 {
    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1() {
        Time t1 = new Time(100002332);
        Time t2 = new Time(27778, 25, 32);
        Time t3 = new Time(1000023321);
        Time t4 = new Time(1, 1, 1);
        System.out.println(t1.compereTo(t2));
        System.out.println(t1.compereTo(t3));
        System.out.println(t1.compereTo(t4));
        System.out.println(t2.fullSec());
        System.out.println(t4.fullSec());
    }

    public static void task2() {
        ATM atm = new ATM(3, 5, 1);
        System.out.println(atm.getCache());
        atm.addCache(2, 3, 3);
        System.out.println(atm.getCache());
    }
}
