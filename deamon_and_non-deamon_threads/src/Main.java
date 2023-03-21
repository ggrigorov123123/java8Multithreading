public class Main {
    public static void main(String[] args) {
        System.out.println("Number of processors: " +
                Runtime.getRuntime().availableProcessors());

        Thread th1 = new Thread(new InfoThread(), "Thread number one");
        Thread th2 = new Thread(new InfoThread(), "Thread number two");

        System.out.println(th1.getState());
//        th1.setDaemon(true);
        th2.setDaemon(true);
        th1.start();
        th2.start();
        System.out.println(th1.isAlive());

    }

    static class InfoThread implements Runnable {
        @Override
        public void run() {
         Thread th = Thread.currentThread();
            System.out.println("[" + th.getId() + "]" + th.getName() + " is started");
            System.out.println("[" + th.getId() + "]" + (th.isDaemon() ? "Deamon" : "None deamon"));
            System.out.println("[" + th.getId() + "]" + th.getState());

            try {
                Thread.sleep(2000);
            } catch (Exception e){
            }
                System.out.println("[" + th.getId() + "]" + th.getName() + " is terminated");
        }
    }
}