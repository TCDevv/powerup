package com.example.simpleconcurrent.solutions;

import com.example.simpleconcurrent.utils.Console;

public class ConcurrentSolution implements MainSolution {
    private static Memory mMemory = new Memory(1);
    @Override
    public void solve() {
        Runnable worker1Runnable = () -> {
            try{
                while(true){
                    synchronized (mMemory){
                        Console.log("worker1: " + mMemory.getSize() + "");
                        mMemory.increaseSize();
                        Thread.sleep(5000);
                    }

                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        Runnable worker2Runnable = () -> {
            try{
                while(true){
                    synchronized (mMemory){
                        Console.log("worker2: " + mMemory.getSize() + "");
                        Thread.sleep(5000);
                    }
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        Runnable worker3Runnable = () -> {
            try{
                while(true){
                    synchronized (mMemory){
                        Console.log("worker3: " + mMemory.getSize() + "");
                        Thread.sleep(5000);
                    }
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        Runnable worker4Runnable = () -> {
            try{
                while(true){
                    synchronized (mMemory){
                        Console.log("worker4: " + mMemory.getSize() + "");
                        mMemory.decreaseSize();
                        Thread.sleep(5000);
                    }
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        Runnable worker5Runnable = () -> {
            try{
                while(true){
                    synchronized (mMemory){
                        Console.log("worker5: " + mMemory.getSize() + "");
                        Thread.sleep(5000);
                    }
                }
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        Worker worker1 = new Worker("worker1", worker1Runnable);
        Worker worker2 = new Worker("worker2", worker2Runnable);
        Worker worker3 = new Worker("worker3", worker3Runnable);
        Worker worker4 = new Worker("worker4", worker4Runnable);
        Worker worker5 = new Worker("worker5", worker5Runnable);

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();
        worker5.start();
    }
}
