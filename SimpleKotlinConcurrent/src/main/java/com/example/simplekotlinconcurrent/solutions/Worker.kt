package com.example.simplekotlinconcurrent.solutions

import com.example.simplekotlinconcurrent.utils.Console

class Worker(name:String, runnable: Runnable):Thread(){
    private val mName:String = name;
    private val mRunnable:Runnable = runnable;

    override fun run() {
        Console.log("Worker " + mName + " started");
        mRunnable.run()
    }

}