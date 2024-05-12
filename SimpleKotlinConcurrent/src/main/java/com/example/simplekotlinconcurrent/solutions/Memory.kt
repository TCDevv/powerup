package com.example.simplekotlinconcurrent.solutions

class Memory(private var size: Int) {

    fun getSize(): Int {
        return size
    }

    fun increaseSize() {
        size++
    }

    fun decreaseSize() {
        size--
    }
}