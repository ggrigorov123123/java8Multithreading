public class Main {
    private static ID id = new ID();

    public static void main(String[] args) {
        for (int i = 0; i < 2; ++i)
            (new Thread(() ->
            {
                while (id.getValue() < 10)
                    System.out.println(String.format(
                            "[%d] %d", Thread.currentThread().getId(), id.getId()));
            })).start();
    }

    static class ID {
        private int id = 1;

        public int getValue() {
            return id;
        }

        //race condition!
        public synchronized int getId() {
            int t = id;
            for (int i = 0; i < 1000000L; ++i) Math.cos(Math.sqrt(2));
            ++id;
            return t;
        }
    }
}