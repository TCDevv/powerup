package com.example.simpleconcurrent.solutions;

import com.example.simpleconcurrent.utils.Console;

public class Worker extends Thread{
    private String mName;
    private Runnable mRunnable;
    public Worker(String name, Runnable runnable){
        this.mName = name;
        this.mRunnable = runnable;
    }
    public void run(){
        Console.log(mName + " start");
        mRunnable.run();
    }
}
