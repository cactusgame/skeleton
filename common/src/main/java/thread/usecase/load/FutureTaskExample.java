package thread.usecase.load;

import java.util.concurrent.*;

public class FutureTaskExample {
    public static void main(String[] args) {
        FutureTask<Integer> task1 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                LoadBusiness.loadResource1();
                return 0;
            }
        });
        FutureTask<Integer> task2 = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                LoadBusiness.loadResource2();
                return 0;
            }
        });

        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(task1);
        service.submit(task2);

        // blocking
        try {
            task1.get();
            task2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Loading is done");
    }
}
