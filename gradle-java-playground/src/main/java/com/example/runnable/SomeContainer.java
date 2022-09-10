package com.example.runnable;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SomeContainer {
    private final List<SomeTask> tasks;


    public void runAll() {
        // tasks.forEach(CompletableFuture::runAsync);
        for (SomeTask task : tasks) {
            ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
            executor.execute(task);
        }
    }
}
