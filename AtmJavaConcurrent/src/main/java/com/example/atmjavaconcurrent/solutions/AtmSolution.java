package com.example.atmjavaconcurrent.solutions;

import com.example.atmjavaconcurrent.utils.Console;

import java.util.Scanner;

public class AtmSolution implements MainSolution{
    private Account mAccount = new Account(1000);
    Scanner scanner = new Scanner(System.in);

    @Override
    public void solve() {
        Worker worker1 = new Worker("worker 1", new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        synchronized (mAccount) {
                            Console.log("worker1: Your balance is " + mAccount.getBalance());
                            Console.log("worker1: Enter amount to withdraw");
                            String input = scanner.nextLine();
                            int amount = Integer.parseInt(input);
                            mAccount.withdraw(amount);
                        }
                        Thread.sleep(1000);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Worker worker2 = new Worker("worker 2", new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        synchronized (mAccount) {
                            Console.log("worker2: Your balance is " + mAccount.getBalance());
                            Console.log("worker2: Enter amount to withdraw");
                            String input = scanner.nextLine();
                            int amount = Integer.parseInt(input);
                            mAccount.withdraw(amount);
                        }
                        Thread.sleep(1000);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            }  );

        worker1.start();
        worker2.start();
    }
}
