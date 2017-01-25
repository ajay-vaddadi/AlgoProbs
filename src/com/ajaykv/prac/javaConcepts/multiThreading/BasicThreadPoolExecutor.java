package com.ajaykv.prac.javaConcepts.multiThreading;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ajaykv on 1/24/17.
 */
public class BasicThreadPoolExecutor {
    ThreadPoolExecutor cachedThreadPoolExecutor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
    ThreadPoolExecutor fixedThreadPoolExecutor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);

    public void createTaskAndExecute(int n){
        for (int i = 0; i < n; i++) {
            Runnable runnable = new Task("Task-" + i);
            System.out.println("Created new Task = Task" + i);
            fixedThreadPoolExecutor.execute(runnable);
        }
        fixedThreadPoolExecutor.shutdown();
    }

}



