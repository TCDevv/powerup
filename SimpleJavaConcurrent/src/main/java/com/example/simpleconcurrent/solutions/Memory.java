package com.example.simpleconcurrent.solutions;

public class Memory {
    private int mSize;
    public Memory(int size) {
        this.mSize = size;
    }
    public int getSize() {
        return mSize;
    }
    public void increaseSize() {
        mSize++;
    }
    public void decreaseSize() {
        mSize--;
    }
}
