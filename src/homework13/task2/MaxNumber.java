package homework13.task2;

public class MaxNumber implements Runnable {
    private String threadName;

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        int[] numbers = new int[10];
        for (int i = 0; i < 10; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }
        int max = 0;
        for (int n = 0; n < numbers.length - 1; n++) {
            max = Math.max(max, numbers[n]);
        }
        System.out.println(threadName + ": " + max);
    }
}
