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
    Account(String fullName, double checkingBalance, double savingsBalance, int pin) {
        this.fullName = fullName;
        this.checkingBalance = checkingBalance;
        this.savingsBalance = savingsBalance;
        this.pin = pin;
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
    protected int getPin() {
        return pin;
    }
    
    /**
     * @param fullName the fullName to set
     */
    private void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @param checkingBalance the checkingBalance to set
     */
    private void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    /**
     * @param savingsBalance the savingsBalance to set
     */
    private void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    /**
     * @param pin the pin to set
     */
    private void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public void depositChecking(double amount) {
        setCheckingBalance(getCheckingBalance() + amount);
    }

    @Override
    public void withdrawlChecking(double amount) {
        setCheckingBalance(getCheckingBalance() - amount);
    }

    @Override
    public void depositSavings(double amount) {
        setSavingsBalance(getSavingsBalance() + amount);
    }

    @Override
    public void withdrawlSavings(double amount) {
        setSavingsBalance(getSavingsBalance() - amount);
    }
    
    
}
