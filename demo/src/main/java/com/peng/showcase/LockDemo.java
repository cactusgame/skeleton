package com.peng.showcase;

import java.util.concurrent.locks.ReentrantLock;

class Helper {
    private ReentrantLock lock = new ReentrantLock();

    public void help(String threadName) {
        boolean ret = false;
        try {
            ret = lock.tryLock();
            System.out.println(String.format("[%s] do help...", threadName) + ret);

            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ret)
                lock.unlock();
        }
    }
}

class Consumer implements Runnable {
    private Helper helper;
    private String threadName;

    public Consumer(String threadName, Helper helper) {
        this.threadName = threadName;
        this.helper = helper;
    }

    @Override
    public void run() {
        this.helper.help(this.threadName);
    }
}

public class LockDemo {


    public static void main(String[] args) {
        Helper h = new Helper();

        Thread t1 = new Thread(new Consumer("thread1", h));
        t1.start();


        Thread t2 = new Thread(new Consumer("thread2", h));
        t2.start();

    }
}
