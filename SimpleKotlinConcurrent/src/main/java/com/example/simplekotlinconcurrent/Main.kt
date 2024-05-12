package com.example.simplekotlinconcurrent

import com.example.simplekotlinconcurrent.solutions.MainSolution
import com.example.simplekotlinconcurrent.solutions.MemorySolution

public class Main {
    companion object {
        @JvmStatic
        public fun main(args: Array<String>){
            val memorySolution:MainSolution = MemorySolution()
            memorySolution.solve()
            try {
                Thread.currentThread().join()
            }
            catch (e:InterruptedException){
                e.printStackTrace()
            }
        }
    }
}
