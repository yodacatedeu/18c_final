/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.math.BigDecimal;


public interface iAccount {
    void depositChecking (BigDecimal amount);
    void withdrawlChecking (BigDecimal amount); 
    void depositSavings (BigDecimal amount); 
    void withdrawlSavings (BigDecimal amount);
}
