/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Aron
 */
public class AccountStorage {
    private Boolean sorted;
    private ArrayList<Account> accounts;
    private HashMap<Integer, String> pinsAndNames;
    
    AccountStorage() {
        sorted = false;
        accounts = new ArrayList();
        pinsAndNames = new HashMap();
    }
    
    private void sort() {
        // implement some kind of sort tht sorts accounts in alphabetical order based off names
        // bubble sort
        for (int i = 0; i < accounts.size() - 1; i++) {
            for (int j = 0; j < accounts.size() - i - 1; j++) {
                 if (accounts.get(j).getFullName().compareTo(accounts.get(j + 1).getFullName()) > 0) {
                    Account temp = accounts.get(j);
                    accounts.set(j, accounts.get(j + 1));
                    accounts.set(j + 1, temp);
                }
            }
        }
        sorted = true;
    }
    
    private Account search(String name, int low, int high) {
        if (!sorted) {
            System.out.println("Sorting...");
            sort();
            System.out.println("sorted");
        }    
        // binary search
        // Base Case
        if (low > high) {
            return null;
        } else {
            int mid = (low + high) / 2;
            if (name.equals(accounts.get(mid).getFullName())) {
                return accounts.get(mid);
            } else if (name.compareTo(accounts.get(mid).getFullName()) > 0) {
                return search(name, mid + 1, high);
                // change the low to the midpoint
                // keep everything the same
                // and call search again
            } else {
                // change the high to the midpoint
                return search(name, low, mid - 1);
                // call search again
            }
        }
    }
    
    public Account login(int pin) {
        String name = pinsAndNames.get(pin);
        
       // return name == null ? null : search(name, 0, accounts.size() - 1);
       if (name == null) {
           //System.out.println("Name don't exist");
           return null;
       }
       return search(name, 0 , accounts.size() -1);
    }
    
    public void add(Account accnt) {
       if (pinsAndNames.get(accnt.getPin()) != null) {
           System.out.println("Error: pin already exists.  Pin must be unique.\n" + 
                                "Account not added to list.");
           return;
       }
        accounts.add(accnt);
        pinsAndNames.put(accnt.getPin(), accnt.getFullName());
        sorted = false;
    }
    
    public void printAccnts() {
        System.out.println("Map:");
        System.out.println(pinsAndNames);
        
        System.out.println("ArrayList:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i).getFullName());
        }
    }
     
}
