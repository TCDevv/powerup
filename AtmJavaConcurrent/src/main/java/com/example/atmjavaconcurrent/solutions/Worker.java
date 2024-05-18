package com.example.atmjavaconcurrent.solutions;

public class Worker extends Thread{
    private final String mName;
    private final Runnable mRunnable;
    public Worker(String name, Runnable runnable){
        this.mName = name;
        this.mRunnable = runnable;
    }
    @Override
    public void run(){
        System.out.println(mName + " is running");
        mRunnable.run();
    }
}
