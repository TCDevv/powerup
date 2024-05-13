package com.example.dishwasherconcurrentkt.solutions

import com.example.dishwasherconcurrentkt.utils.Console

class Dish {
    private val listFood = mutableListOf<String>()

    fun checkDishEmpty():Boolean{
        return listFood.isEmpty()
    }
    fun putFood(food: String) {
        listFood.add(food)
        Console.log("Put ${food}")
    }

    fun releaseFood(type:Int) {
        if(type == DishWasherSolution.WASH){
            Console.log("Wash ${listFood.first()}")
        }
        else{
            Console.log("Eat ${listFood.first()}")
        }
        listFood.removeFirst()
    }

    fun printFood() {
       Console.log("Dish has ${listFood.size} food")
    }

    fun getFoodCount():Int{
        return listFood.size
    }

}