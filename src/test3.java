import java.util.ArrayList;
import java.util.List;

public class test3 {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        List<Para> number = new ArrayList<>();
        for (int dividend = 10; dividend < 100; dividend++) {
            for (int divider = 10; divider < 100; divider++) {
                if (dividend != divider  && dividend % divider == 0){
                    Para para = new Para(dividend,divider);
                    number.add(para);
                }
            }
        }
        System.out.println(number);
    }
}
