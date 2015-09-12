package com.example.epomeroy.accounts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by epomeroy on 9/6/15.
 */
public abstract class BankAccount {
    private List<Double> transactions = new ArrayList<>();
    private static final double OVERDRAFT_FEE = -30;

    public BankAccount() {

    }

    public double getBalance() {
        double total = 0;

        for (Double value : transactions) {
            total += value;
        }

        return total;
    }

    protected int getNumberOfWithdraw() {
        int count = 0;
        for (Double value: this.transactions) {
            if (value < 0) {
                count++;
            }
        }

        return count;
    }

    public void withdraw(double amount) {
        transactions.add(-amount);

        if (this.getBalance() < 0) {
            transactions.add(OVERDRAFT_FEE);
        }
    }

    public void deposit(double amount) {
        transactions.add(amount);
    }
}