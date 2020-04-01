package thread.usecase.load;

public class Newbie {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                LoadBusiness.loadResource1();
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            public void run() {
                LoadBusiness.loadResource2();
            }
        };
        t2.start();

        System.out.println("Loading is staring");

        // blocking
        while (true) {
            if (LoadBusiness.res1Loaded && LoadBusiness.res2Loaded) {
                break;
            }
        }
        System.out.println("Loading is done");

    }
}
