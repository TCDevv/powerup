package com.example.dishwasherconcurrentkt.solutions

class Worker(name:String, runnable: Runnable):Thread() {
    private val mName = name
    private val mRunnable = runnable
    override fun run() {
        mRunnable.run()
    }
}