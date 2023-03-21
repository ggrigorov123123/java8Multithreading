import java.util.Random;

public class Main {
    public static void main(String[] args) {
        (new Thread(new Worker1())).start();

        new Worker2().start();

        (new Thread(new Runnable() {
            @Override
            public void run() {
                ToDo.work(2, 5);
            }
        })).start();

        (new Thread(() -> ToDo.work(2, 5))).start();
    }

    static class Worker1 implements Runnable {
        public void run() {
            ToDo.work(2, 5);
        }
    }

    static class Worker2 extends Thread {
        public Worker2(){
            super();
        }
        public void run (){
            ToDo.work(2, 5);
        }
    }

    private class ToDo {
        private static Random rand = new Random();

        public static void work(int a, int b) {
            System.out.println("started");
            for (int i = 0, n = rand.nextInt(b - a) + a; i < n; ++i) {
                print("working....");
                work();
            }
            print("terminated");
        }

        private static void print(String text){
            long id = Thread.currentThread().getId();
            System.out.println("[" + id + "]" + text);
        }

        private static void work() {
            double y;
            for (int i = 0; i < 1000000L; ++i) {
                y = Math.cos(Math.sqrt(rand.nextDouble()));
            }
        }
    }

}