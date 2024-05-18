package com.example.atmjavaconcurrent.solutions;

import com.example.atmjavaconcurrent.utils.Console;

public class Account {
    private int mBalance;
    public Account(int balance) {
        this.mBalance = balance;
    }

    public int getBalance() {
        return this.mBalance;
    }

    public void deposit(int amount) {
        mBalance += amount;
    }

    public void withdraw(int amount) {
        if(mBalance < amount){
            Console.log("Insufficient funds");
            return;
        }
        mBalance -= amount;
    }
}
