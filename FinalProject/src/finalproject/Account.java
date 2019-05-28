/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.math.BigDecimal;


public class Account implements iAccount{
    private String fullName;
    private BigDecimal checkingBalance;
    private BigDecimal savingsBalance;
    private int pin;
    
    // constructor
    Account(String fullName, BigDecimal checkingBalance, BigDecimal savingsBalance, int pin) {
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
    public BigDecimal getCheckingBalance() {
        return checkingBalance;
    }

    /**
     * @return the savingsBalance
     */
    public BigDecimal getSavingsBalance() {
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
    private void setCheckingBalance(BigDecimal checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    /**
     * @param savingsBalance the savingsBalance to set
     */
    private void setSavingsBalance(BigDecimal savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    /**
     * @param pin the pin to set
     */
    private void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public void depositChecking(BigDecimal amount) {
        setCheckingBalance(getCheckingBalance().add(amount));
    }

    @Override
    public void withdrawlChecking(BigDecimal amount) {
        setCheckingBalance(getCheckingBalance().subtract(amount));
    }

    @Override
    public void depositSavings(BigDecimal amount) {
        setSavingsBalance(getSavingsBalance().add(amount));
    }

    @Override
    public void withdrawlSavings(BigDecimal amount) {
        setSavingsBalance(getSavingsBalance().subtract(amount));
    }
    
}
