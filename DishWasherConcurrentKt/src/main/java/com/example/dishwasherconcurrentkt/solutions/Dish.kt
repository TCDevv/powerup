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

    fun releaseFood() {
        listFood.removeFirst()
        Console.log("Release ${listFood.first()}")
    }

    fun printFood() {
       Console.log("Dish has ${listFood.size} food")
    }

}