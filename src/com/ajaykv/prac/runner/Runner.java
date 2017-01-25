package com.ajaykv.prac.runner;


import com.ajaykv.prac.javaConcepts.multiThreading.BasicThreadPoolExecutor;

/**
 * Created by ajaykv on 1/3/17.
 */
public class Runner {
    public static void main(String[] args) {
        BasicThreadPoolExecutor basicThreadPoolExecutor = new BasicThreadPoolExecutor();
        basicThreadPoolExecutor.createTaskAndExecute(100);
    }
}
