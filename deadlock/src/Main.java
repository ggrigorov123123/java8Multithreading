public class Main {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    private static int count = 0;

    public static void main(String[] args) {
        final Main main = new Main();
        (new Thread(() -> {
            while (true) {
                main.work1();
                main.delay();
            }
        })).start();

        (new Thread(() -> {
            while (true) {
                main.work2();
                main.delay();
            }
        })).start();
    }

    public void work1() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("[" + Thread.currentThread().getId() + "]" + ++count);
            }
        }
    }

    public void work2() {
        synchronized (lock2) {
            synchronized (lock1) {
                System.out.println("[" + Thread.currentThread().getId() + "]" + ++count);
            }
        }
    }

    public void delay() {
        try {
            Thread.sleep(50);
        } catch (Exception e) {}
    }
}