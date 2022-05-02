package homework13.task5;

public class Deadlock implements Runnable{

    public void method1() {
        synchronized (String.class) {
            System.out.println("Lock on String.class");
            synchronized (Integer.class) {
                System.out.println("Lock on Integer.class");
                synchronized (Double.class) {
                    System.out.println("Lock on Double.class");
                }
            }
        }
    }

    public void method2() {
        synchronized (Double.class) {
            System.out.println("Lock on Double.class");
            synchronized (String.class) {
                System.out.println("Lock on String.class");
                synchronized (Integer.class) {
                    System.out.println("Lock on Integer.class");
                }
            }
        }
    }

    public void method3() {
        synchronized (Integer.class) {
            System.out.println("Lock on Integer.class");
            synchronized (Double.class) {
                System.out.println("Lock on Double.class");
                synchronized (String.class) {
                    System.out.println("Lock on String.class");
                }
            }
        }
    }
    @Override
    public void run() {
        method1();
        method2();
        method3();
    }
}
