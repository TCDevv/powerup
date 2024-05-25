package com.example.atmjavaconcurrent;

import com.example.atmjavaconcurrent.solutions.AtmSolution;
import com.example.atmjavaconcurrent.solutions.MainSolution;

public class Main {
    public static void main(String[] args){
        MainSolution atmSolution = new AtmSolution();
        atmSolution.solve();
        try{
            Thread.currentThread().join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}