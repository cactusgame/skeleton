package com.peng.skeleton.routingservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
@RequestMapping(path = "/thread")
public class ThreadController {
    private ExecutorService pool = Executors.newFixedThreadPool(1);

    @RequestMapping(path = "/fixed")
    public String thread() throws ExecutionException, InterruptedException {

        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(1000);
                return 1;
            }
        });
        pool.submit(task);

        long activeCount = ((ThreadPoolExecutor) pool).getActiveCount();
        long taskCount = ((ThreadPoolExecutor) pool).getTaskCount();
        long completedTaskCount = ((ThreadPoolExecutor) pool).getCompletedTaskCount();

        System.out.println(String.format("activeCount= %d", activeCount));
        System.out.println(String.format("taskCount= %d", taskCount));
        System.out.println(String.format("completedTaskCount= %d", completedTaskCount));
        System.out.println("==========================================");

        return String.valueOf(task.get());
    }

}
