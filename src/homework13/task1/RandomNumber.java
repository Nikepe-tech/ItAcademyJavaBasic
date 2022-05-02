package homework13.task1;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber extends Thread{
    public void run(){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            numbers.add((int) (Math.random()* 100));
        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println((double) sum/numbers.size());
    }
}
