package thread.usecase.load;

public class LoadBusiness {

//    public static volatile boolean res1Loaded = false;
//    public static volatile boolean res2Loaded = false;

    public static boolean res1Loaded = false;
    public static boolean res2Loaded = false;

    public static void loadResource1() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("resource 1 loaded");
        res1Loaded = true;
    }

    public static void loadResource2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("resource 2 loaded");
        res2Loaded = true;
    }
}
