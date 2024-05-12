package com.example.dishwasherconcurrentkt.solutions

import com.example.dishwasherconcurrentkt.utils.Console

class DishWasherSolution:MainSolution {
    private val mDish:Dish = Dish()
    override fun solve() {
        for (i in 0..10){
            mDish.putFood("Dirty")
        }
        val dishWasher:Worker = Worker("DishWasher", Runnable {
            try {
                synchronized(mDish) {
                    Console.log("DishWasher took the dish")
                    while (true){
                        if(!mDish.checkDishEmpty()) {
                            Console.log("Dish is washing")
                            mDish.releaseFood()
                        }
                        else{
                            Console.log("Finish washing")
                        }
                        Thread.sleep(1000)
                    }
                }
            }
            catch(e:InterruptedException){
                e.printStackTrace()
            }
        })

        val foodPlacer:Worker = Worker("FoodPlacer", Runnable {
            try {
                synchronized(mDish) {
                    Console.log("FoodPlacer took the dish")
                    while (true){
                        mDish.putFood("Food")
                        Console.log("Food is placing")
                        Thread.sleep(1000)
                    }
                }
            }
            catch(e:InterruptedException){
                e.printStackTrace()
            }
        })

        val foodConsumer:Worker = Worker("FoodConsumer", Runnable {
            try {
                synchronized(mDish) {
                    Console.log("FoodConsumer took the dish")
                        if(!mDish.checkDishEmpty()){
                            while (true){
                                mDish.releaseFood()
                                Console.log("Food is consuming")
                                Thread.sleep(1000)
                            }
                        }
                        else {
                            Console.log("Not thing to consume")
                        }
                }
            }
            catch(e:InterruptedException){
                e.printStackTrace()
            }
        })

        dishWasher.start()
        foodPlacer.start()
        foodConsumer.start()
    }

}