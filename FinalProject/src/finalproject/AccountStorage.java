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
    
    private void sort(int low, int high) {
        // implement some kind of sort tht sorts accounts in alphabetical order based off names
        
       // bubble sort for initial binary search test
//        for (int i = 0; i < accounts.size() - 1; i++) {
//            for (int j = 0; j < accounts.size() - i - 1; j++) {
//                 if (accounts.get(j).getFullName().compareTo(accounts.get(j + 1).getFullName()) > 0) {
//                    Account temp = accounts.get(j);
//                    accounts.set(j, accounts.get(j + 1));
//                    accounts.set(j + 1, temp);
//                }
//            }
//        }

        // Quick Sort
         if (low < high) { 
            /* pI is partitioning index, arr[pI] is  
              now at right place */
            int pI = partition(low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(low, pI - 1); 
            sort(pI + 1, high); 
        } 

        sorted = true;
    }
    
    private int partition(int low, int high) { 
        String pivot = accounts.get(high).getFullName();  
        int i = (low - 1); // index of smaller element 
        for (int j = low; j < high; j++) { 
            // If current element is smaller than or 
            // equal to pivot 
            if (accounts.get(j).getFullName().compareToIgnoreCase(pivot) <= 0) { 
                i++; 
  
                // swap arr[i] and arr[j] 
                Account temp = accounts.get(i);  
                accounts.set(i, accounts.get(j));
                accounts.set(j, temp);
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        Account temp = accounts.get(i + 1); 
        accounts.set(i + 1, accounts.get(high));
        accounts.set(high, temp);
  
        return i + 1; 
    } 
    
    private Account search(String name, int low, int high) {
        if (!sorted) { // check if sorted before binary search
            //System.out.println("Sorting...");
            sort(low, high);
            //System.out.println("sorted");
        }    
        // Binary Search
        // Base Case
        if (low > high) {
            return null;
        } else {
            int mid = (low + high) / 2;
            if (name.equalsIgnoreCase(accounts.get(mid).getFullName())) {
                return accounts.get(mid);
            } else if (name.compareToIgnoreCase(accounts.get(mid).getFullName()) > 0) {
                // change the low to the midpoint
                // keep everything the same
                // and call search again
                return search(name, mid + 1, high);
            } else {
                // change the high to the midpoint
                // call search again
                return search(name, low, mid - 1);
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
       return search(name, 0 , accounts.size() - 1);
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
    
      // only for testing purposes
//    public void printAccnts() { 
//        System.out.println("Map:");
//        System.out.println(pinsAndNames);
//        
//        System.out.println("ArrayList:");
//        for (int i = 0; i < accounts.size(); i++) {
//            System.out.println(accounts.get(i).getFullName());
//        }
//    }
     
}
