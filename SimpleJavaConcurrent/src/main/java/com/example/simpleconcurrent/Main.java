package com.example.simpleconcurrent;

import com.example.simpleconcurrent.solutions.ConcurrentSolution;
import com.example.simpleconcurrent.solutions.MainSolution;

public class Main {
    public static void main(String[] args) {
        MainSolution solution = new ConcurrentSolution();
        solution.solve();
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}