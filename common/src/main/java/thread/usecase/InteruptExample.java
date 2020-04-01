package thread.usecase;


public class InteruptExample {
    public static void main(String[] args) {

        // start a thread and sleep a long time
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();

        try {
            Thread.sleep(   3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();

    }
}
