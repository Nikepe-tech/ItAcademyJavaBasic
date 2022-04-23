package homework13.task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;

public class NewFile implements Runnable {
    @Override
    public void run() {
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length - 1; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        try {
            FileWriter numbers1 = new FileWriter("./src/homework13/task3/numbers");
            BufferedWriter task3 = new BufferedWriter(numbers1);
            task3.write(Arrays.toString(numbers));
            task3.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
