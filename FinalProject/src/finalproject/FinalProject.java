/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        AccountStorage list = new AccountStorage();
        
        // starting value for checking and savings as big decimal
        BigDecimal checking = new BigDecimal("0");
        BigDecimal savings = new BigDecimal("0");
        
        list.add(new Account("Steven Hickman", checking, savings, 1234));
        list.add(new Account("Aron Bauer", checking, savings, 4321));
        list.add(new Account("Michael Robles", checking, savings, 2345));
        
        
        System.out.println("Enter your pin or enter 0 to exit:");
        int pin = input.nextInt();
        
        Account user = list.login(pin);
        
        while(user == null){
            if(pin == 0)
                return;
            System.out.println("Incorrect pin, please try again or enter 0 to exit.");
            pin = input.nextInt();
            user = list.login(pin);
        }
        
        int choice;
        boolean enoughFunds;
        boolean exit = false;
        
        while (exit != true){
            System.out.println("Logged in as " + user.getFullName());
            System.out.println("You currently have $" + user.getCheckingBalance().setScale(2, RoundingMode.HALF_UP) + " in your checking account and $" + user.getSavingsBalance().setScale(2, RoundingMode.HALF_UP) + " in your savings account.\nWhat would you like to do?\n1)Deposit to checking."
                    + "\n2)Deposit to savings.\n3)Withdraw from checking.\n4)Withdraw from savings.\n5)Transfer from checking account to savings account.\n6)Transfer from savings account to checking account\n7)Exit.");
            choice = input.nextInt();
            enoughFunds = true;
            switch(choice){
                case 1: // deposit checking
                    System.out.println("How much money do you want to deposit to your checking account?");
                    BigDecimal checkingAmmount = input.nextBigDecimal();
                    user.depositChecking(checkingAmmount.setScale(2, RoundingMode.HALF_UP));
                    System.out.println("New checking balance: $" + user.getCheckingBalance().setScale(2, RoundingMode.HALF_UP));
                    break;
                case 2: // deposit savings
                    System.out.println("How much money do you want to deposit to your savings account?");
                    BigDecimal savingsAmmount = input.nextBigDecimal();
                    user.depositSavings(savingsAmmount.setScale(2, RoundingMode.HALF_UP));
                    System.out.println("New savings balance: $" + user.getSavingsBalance().setScale(2, RoundingMode.HALF_UP));
                    break;
                case 3: // withdraw checking
                    System.out.println("How much money do you want to withdraw from your checking account?");
                    BigDecimal checkingWithdraw = input.nextBigDecimal();
                    if(user.getCheckingBalance().setScale(2, RoundingMode.HALF_UP).compareTo(checkingWithdraw.setScale(2, RoundingMode.HALF_UP)) == -1){ // .compare to returns -1 if checkingsWithdraw is greater than checking balance
                        System.out.println("Sorry, you do not have enough funds in checking to withdraw that ammount.");
                        enoughFunds = false;
                    }
                    if(enoughFunds){
                        user.withdrawlChecking(checkingWithdraw.setScale(2, RoundingMode.HALF_UP));
                        System.out.println("New checking balance: $" + user.getCheckingBalance().setScale(2, RoundingMode.HALF_UP));
                    }
                    break;
                case 4: // withdraw savings
                    System.out.println("How much money do you want to withdraw from your savings account?");
                    BigDecimal savingsWithdraw = input.nextBigDecimal();
                    if(user.getSavingsBalance().setScale(2, RoundingMode.HALF_UP).compareTo(savingsWithdraw.setScale(2, RoundingMode.HALF_UP)) == -1){ // .compare to returns -1 if savingsWithdraw is greater than savings balance
                        System.out.println("Sorry, you do not have enough funds in savings to withdraw that ammount.");
                        enoughFunds = false;
                    }
                    if(enoughFunds){
                    user.withdrawlSavings(savingsWithdraw.setScale(2, RoundingMode.HALF_UP));
                    System.out.println("New savings balance: $" + user.getSavingsBalance().setScale(2, RoundingMode.HALF_UP));
                    }
                    break;
                case 5: // transfer checking -> savings
                    System.out.println("How much would you like to transfer from your checking account to your savings account?");
                    BigDecimal toSavings = input.nextBigDecimal();
                    if(user.getCheckingBalance().setScale(2, RoundingMode.HALF_UP).compareTo(toSavings.setScale(2, RoundingMode.HALF_UP)) == -1){ // .compare to returns -1 if toSavings is greater than checking balance
                        System.out.println("Sorry, you do not have enough funds to transfer to your savings account");
                        enoughFunds = false;
                    }
                    if(enoughFunds){
                        user.withdrawlChecking(toSavings.setScale(2, RoundingMode.HALF_UP));
                        user.depositSavings(toSavings.setScale(2, RoundingMode.HALF_UP));
                    }
                    break;
                case 6: // transfer savings -> checking
                    System.out.println("How much would you like to transfer from your savings account to your checkings account?");
                    BigDecimal toChecking = input.nextBigDecimal();
                    if(user.getSavingsBalance().setScale(2, RoundingMode.HALF_UP).compareTo(toChecking.setScale(2, RoundingMode.HALF_UP)) == -1){ // .compare to returns -1 if toChecking is greater than savings balance
                        System.out.println("Sorry, you do not have enough funds to transfer to your checking account");
                        enoughFunds = false;
                    }
                    if(enoughFunds){
                        user.withdrawlSavings(toChecking.setScale(2, RoundingMode.HALF_UP));
                        user.depositChecking(toChecking.setScale(2, RoundingMode.HALF_UP));
                    }
                    break;
                case 7: // exit
                    System.out.println("Goodbye.");
                    exit = true;
                    break;
                default: // input error
                    System.out.println("Invalid choice, please try again");
                    break;
            }  
         }
     }    
}