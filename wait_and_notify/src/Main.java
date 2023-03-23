public class Main {
    public static void main(String[] args) {
        Shared shared = new Shared();
        new Producer(shared).start();
        new Consumer(shared).start();
    }

    static class Shared {
        private char value;
        private volatile boolean writeable = true;

        public synchronized void setValue(char value) {
            while (!writeable) {
                try {
                    wait();
                } catch (InterruptedException e) { }
            }

            this.value = value;
            writeable = false;
            notify();
        }

        synchronized char getValue() {
            while (writeable) {
                try {
                    wait();
                } catch (InterruptedException e) { }
            }
            writeable = true;
            notify();
            return value;
        }
    }

    static class Producer extends Thread {
        private final Shared shared;

        public Producer(Shared shared) {
            this.shared = shared;
        }

        public void run() {
            for (char ch = 'A'; ch <= 'Z'; ++ch) {
                shared.setValue(ch);
            }
        }
    }

    static class Consumer extends Thread {
        private final Shared shared;

        public Consumer(Shared shared) {
            this.shared = shared;
        }

        public void run() {
            char ch;
            do {
                System.out.println(ch = shared.getValue());
            } while (ch != 'Z');
            System.out.println();
        }
    }
}