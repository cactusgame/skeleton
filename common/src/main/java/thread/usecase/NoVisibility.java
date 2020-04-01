package thread.usecase;

public class NoVisibility {
    private static boolean ready;
    private static int number;


    static class ReaderThread extends Thread {
        public void run() {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            int a = 1;
            if (a != a){
                System.out.println("asd");
            }
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        (new ReaderThread()).start();

        ready = true;
        number = 33;
    }
}
