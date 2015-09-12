package com.example.epomeroy.mybank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by epomeroy on 9/6/15.
 */
public class BankAccount {
    public enum Type {
        CHECKING, SAVINGS
    }

    private List<Double> transactions = new ArrayList<>();
    private static final double OVERDRAFT_FEE = -30;
    private Type accountType;

    public BankAccount(Type acctType) {
        this.accountType = acctType;
    }

    public double getBalance() {
        double total = 0;

        for (Double value : transactions) {
            total += value;
        }

        return total;
    }

    private int getNumberOfWithdraw() {
        int count = 0;
        for (Double value: this.transactions) {
            if (value < 0) {
                count++;
            }
        }

        return count;
    }

    public void withdraw(double amount) {
        if (this.accountType.equals(Type.SAVINGS) && this.getNumberOfWithdraw() >= 3) {
            return;
        }

        transactions.add(-amount);

        if (this.getBalance() < 0) {
            transactions.add(OVERDRAFT_FEE);
        }
    }

    public void deposit(double amount) {
        transactions.add(amount);
    }
}