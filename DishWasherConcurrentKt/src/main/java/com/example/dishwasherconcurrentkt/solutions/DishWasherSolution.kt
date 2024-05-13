package com.example.dishwasherconcurrentkt.solutions

import com.example.dishwasherconcurrentkt.utils.Console

class DishWasherSolution : MainSolution {
    private val mDish: Dish = Dish()
    companion object{
        const val WASH = 1
        const val CONSUME = 2
    }
    override fun solve() {
        for (i in 0..10) {
            mDish.putFood("Dirty")
        }
        val dishWasher: Worker = Worker("DishWasher", Runnable {
            try {
                while (true) {
                    synchronized(mDish) {
                        Console.log("DishWasher took the dish")
                        if (!mDish.checkDishEmpty()) {
                            Console.log("Dish is washing")
                            mDish.releaseFood(WASH)
                        } else {
                            Console.log("Finish washing")
                        }
                        Thread.sleep(1000)
                    }
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        })

        val foodPlacer: Worker = Worker("FoodPlacer", Runnable {
            try {
                while (true) {
                    synchronized(mDish) {
                        Console.log("FoodPlacer took the dish")
                        for (i in 0..10) {
                            mDish.putFood("Food")
                            Thread.sleep(1000)
                        }
                        Console.log("Foods was placed")
                        Thread.sleep(1000)
                    }
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        })

        val foodConsumer: Worker = Worker("FoodConsumer", Runnable {
            try {
                while (true) {
                    synchronized(mDish) {
                        if (!mDish.checkDishEmpty()) {
                            Console.log("FoodConsumer took the dish")
                            for (i in 0..mDish.getFoodCount()) {
                                mDish.releaseFood(CONSUME)
                                Thread.sleep(1000)
                            }
                            Console.log("Consume foods finished")
                            Thread.sleep(1000)
                        } else {
                            Console.log("Not thing to consume")
                        }
                    }
                }
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        })

        dishWasher.start()
        foodPlacer.start()
        foodConsumer.start()
    }

}