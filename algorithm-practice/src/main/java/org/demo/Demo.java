package org.demo;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS,
//                new ArrayBlockingQueue<>(1),  Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
//        threadPoolExecutor.execute(() -> {
//        });
//        threadPoolExecutor.shutdown();
//        threadPoolExecutor.awaitTermination(1, TimeUnit.SECONDS);


        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(20);
        executor.scheduleWithFixedDelay(() -> {
            System.out.println(LocalDateTime.now());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {

            }
        }, 0, 2, TimeUnit.MILLISECONDS);

    }
}
