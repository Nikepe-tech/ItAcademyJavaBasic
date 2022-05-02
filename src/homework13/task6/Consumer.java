package homework13.task6;

public class Consumer implements Runnable {

    private final MyQueue queue;

    public Consumer(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (queue.getCounter() < 10000) {
            try {
                Thread.sleep((int) (Math.random() * 999 + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (queue.getElementsCount() > 0) {
                queue.remove();
                System.out.println("Потребитель : элементов в очеред : "
                        + queue.getElementsCount()
                        + " (Обработаных элементов = "
                        + queue.getCounter()
                        + ")");
            }
        }
        System.out.println("Потребитель завершил работу." + Thread.currentThread().getName());

    }
}
