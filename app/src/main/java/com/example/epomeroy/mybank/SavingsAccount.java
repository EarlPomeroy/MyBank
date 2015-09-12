package com.example.epomeroy.mybank;

/**
 * Created by epomeroy on 9/12/15.
 */
public class SavingsAccount extends BankAccount {
    @Override
    public void withdraw(double amount) {
        if ( this.getNumberOfWithdraw() >= 3) {
            return;
        }

        super.withdraw(amount);
    }
}
