package thread.usecase.load;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    final static java.util.concurrent.CountDownLatch gate = new java.util.concurrent.CountDownLatch(2);

    public static void main(String[] args){

        Thread t1 = new Thread(){
            public void run(){
                LoadBusiness.loadResource1();
                gate.countDown();
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            public void run(){
                LoadBusiness.loadResource2();
                gate.countDown();
            }
        };
        t2.start();

        try {
            // blocking
            gate.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Loading is done");
    }
}
