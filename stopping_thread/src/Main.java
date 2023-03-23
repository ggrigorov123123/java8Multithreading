import java.util.ArrayList;

public class Main {

    //the Thread class has a method stop(), which is used to stop a running thread. This method is not secure and is
    //defined deprecated, and you should avoid using it.
    public static void main(String[] args) {
        ArrayList<AThread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) threads.add(new AThread());
        for (AThread th : threads) th.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { }

        for(AThread thread : threads) thread.stopThread();
    }

    static class AThread extends Thread {
        private volatile boolean stopped = false;

        public void run() {
            while (!stopped) {
                System.out.println(Thread.currentThread().getName() + " is running!");
            }
        }

        public void stopThread() {
            stopped = true;
        }
    }
}