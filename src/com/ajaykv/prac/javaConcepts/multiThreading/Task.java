package com.ajaykv.prac.javaConcepts.multiThreading;

import java.util.concurrent.TimeUnit;

/**
 * Created by ajaykv on 1/24/17.
 */
public class Task implements Runnable {
    String name;
    Task(String name){
        this.name = name;
    }

    @Override
    public void run() {
        try{
            while(true){
                long sleep = (long)(Math.random()*10);
                System.out.println("Running the Task : "+ name+" ,and will sleep for "+sleep+" seconds." );
                TimeUnit.SECONDS.sleep(sleep);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
