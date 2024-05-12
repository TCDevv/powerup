package com.example.dishwasherconcurrentkt

import com.example.dishwasherconcurrentkt.solutions.DishWasherSolution
import com.example.dishwasherconcurrentkt.solutions.MainSolution

class Main {
    companion object {
        @JvmStatic

        fun main(args: Array<String>) {
            val dishWasherSolution:MainSolution = DishWasherSolution()
            dishWasherSolution.solve()
            try {
                Thread.currentThread().join()
            }
            catch (e:InterruptedException){
                e.printStackTrace()
            }
        }
    }
}