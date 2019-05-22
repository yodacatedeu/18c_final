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
public interface iAccount {
    void depositChecking (double amount);
    void withdrawlChecking (double amount); 
    void depositSavings (double amount); 
    void withdrawlSavings (double amount);
}
