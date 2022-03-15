public class HomeWork02 {
    public static void main (String[] arg){
        byte b = 0x55;
        short s = 0x55ff;
        int i = 1000000;
        long l = 0xffffffffL;
        char c = 'a' ;
        float f = .25f;
        double d = .00001234;
        boolean bool = true;
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(c);
        System.out.println(f);
        System.out.println(d);
        System.out.println(bool);

        System.out.println(new HomeWork02().task2(10, 19));

        int task3 = 32 + 20 * 60 + 3 * 60 * 60 + 15 * 60 * 60 * 24;
        System.out.println(
                "hours: " + (task3 / (60 * 60)) +
                        " minutes: " + (task3 / 60) +
                        " seconds: " + task3 +
                        " days: " + (task3 / (60 * 60 * 24)) +
                        " weeks: " + (task3 / (60 * 60 * 24 * 7))
        );
    }
    int task2(int number1,int number2){
        return number1 + number2 + number1 * number2;
    }
}
