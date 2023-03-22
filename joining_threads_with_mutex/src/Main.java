public class Main {
    private static double root = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        (new Thread(() -> {
            synchronized (lock) {
                root = sqrt2();
            }
        })).start();

        //sleep() is necessary, else you can risk that the primary thread takes the
        // lock before the calculating thread takes it.
        try { Thread.sleep(10); } catch (Exception e) {}

        synchronized (lock) {
            System.out.println(root);
        }
    }

    private static double sqrt2() {
        double y = 0;
        for (int i = 0; i < 100000000L; ++i) y = Math.sqrt(2);
        return y;
    }
}