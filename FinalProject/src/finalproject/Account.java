/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author Aron
 */
public class Account implements iAccount {
    private String fullName;
    private double checkingBalance;
    private double savingsBalance;
    private int pin;
    
    // constructor
    Account(String fN, double cB, double sB, int p) {
        fullName = fN;
        checkingBalance = cB;
        savingsBalance = sB;
        pin = p;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @return the checkingBalance
     */
    public double getCheckingBalance() {
        return checkingBalance;
    }

    /**
     * @return the savingsBalance
     */
    public double getSavingsBalance() {
        return savingsBalance;
    }

    /**
     * @return the pin
     */
    public int getPin() {
        return pin;
    }

    @Override
    public void depositChecking(double amount) {
        checkingBalance = checkingBalance + amount;
    }

    @Override
    public void withdrawlChecking(double amount) {
        checkingBalance = checkingBalance - amount;
    }

    @Override
    public void depositSavings(double amount) {
        savingsBalance = savingsBalance + amount;
    }

    @Override
    public void withdrawlSavings(double amount) {
        savingsBalance = savingsBalance - amount;
    }
    
    
}
