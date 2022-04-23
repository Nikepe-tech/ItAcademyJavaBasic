package homework13.task6;

public class Manufacturer implements Runnable {
    private final MyQueue queue;

    public Manufacturer(MyQueue queue) {
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
            queue.add((int) (Math.random() * 99 + 1));
            System.out.println("Производитель : элементов в очереди : " + queue.getElementsCount());
        }
        System.out.println("Производитель завершил работу." + Thread.currentThread().getName());
    }
}
