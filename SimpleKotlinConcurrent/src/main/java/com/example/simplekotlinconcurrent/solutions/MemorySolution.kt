package com.example.simplekotlinconcurrent.solutions

import com.example.simplekotlinconcurrent.utils.Console

class MemorySolution:MainSolution{
    private var mMemory: Memory = Memory(1)
    override fun solve() {
        val worker1:Worker = Worker("worker1", Runnable {
            try {
                while (true){
                    synchronized(mMemory){
                        Thread.sleep(1000)
                        Console.log("worker1 ${mMemory.getSize().toString()}")
                    }
                }
            }
            catch(e:InterruptedException){
                e.printStackTrace()
            }
        })

        val worker2:Worker = Worker("worker2", Runnable {
            try {
                while (true){
                    synchronized(mMemory){
                        mMemory.increaseSize()
                        Thread.sleep(1000)
                        Console.log("worker2 ${mMemory.getSize().toString()}")
                    }
                }
            }
            catch (e:InterruptedException){
                e.printStackTrace()
            }
        })

        val worker3:Worker = Worker("worker3", Runnable {
            try {
                while (true) {
                    synchronized(mMemory) {
                        mMemory.decreaseSize()
                        Thread.sleep(1000)
                        Console.log("worker3 ${mMemory.getSize().toString()}")
                    }
                }
            }
            catch (e:InterruptedException){
                e.printStackTrace()
            }
        })

        worker1.start()
        worker2.start()
        worker3.start()
    }
}