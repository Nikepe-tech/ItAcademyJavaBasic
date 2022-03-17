public class HomeWork04 {
    public static void main(String[] args) {
        HomeWork04 homeWork04 = new HomeWork04();
        homeWork04.task1();
        System.out.println(homeWork04.task2());
        System.out.println(homeWork04.task3());
        System.out.println(homeWork04.task4());
        homeWork04.task5();
        System.out.println(homeWork04.task6(20023143));
        System.out.println(homeWork04.task6(1029303929));
        System.out.println(homeWork04.task6(200002));
    }

    public void task1() {
        int i = 0;
        while (i <= 10) {
            System.out.println(getFactorial(i));
            i++;
        }
    }

    public static int getFactorial(int f) {
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

    public long task2() {
        long n = 1;
        int m = 1;
        do {
            n *= m;
            m++;
        } while (m <= 25);
        return n;
    }

    public int task3() {
        int[] array = {7, 8, 9, 3, 8, 2, 3, 4, 4, 5};
        int i = 0;
        int sum = 0;
        do {
            sum += array[i];
            i++;
        } while (i < array.length);
        return sum;
    }

    public int task4() {
        int f = 50;
        int i = 0;
        while (f >= 50 && f <= 70) {
            if (isPrime(f)) {
                i++;
                if (i == 2) {
                    break;
                }
            }
            f++;
        }
        return f;
    }

    public boolean isPrime(int n) {
        for (int j = 2; j <= n / j; j++) {
            if ((n % j) == 0) {
                return false;
            }
        }
        return true;
    }

    public void task5() {
        for (int i = 1; i <= 100; i++) {
            if ((i % 7) == 0) {
                System.out.print("Hope! ");
            }
        }
        System.out.println();
    }

    public String task6(int n) {
        String str_n = "" + n;
        String result = "";
        int c = 0;
        for (int i = str_n.length() - 1; i >= 0; i--) {
            if (c == 3) {
                result = " " + result;
                c = 0;
            }
            result = str_n.charAt(i) + result;
            c++;
        }
        return result;
    }
}
