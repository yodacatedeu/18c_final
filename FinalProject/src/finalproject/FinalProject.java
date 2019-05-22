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
public class FinalProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AccountStorage list = new AccountStorage();
//        Account temp1 = new Account("", 0, 0, 0);
//        list.add(temp1);
        list.add(new Account("Steven Hickman", 0, 0, 1234));
        list.add(new Account("Aron Bauer", 0, 0, 4321));
        list.add(new Account("Michael Robles", 0, 0, 2345));
 
        list.printAccnts();
        
        int pin = 1234;
        Account temp = list.login(pin);
        if (temp != null)
            System.out.println("Logged in as " + temp.getFullName());
        else
            System.out.println("Incorrect pin");
        
        list.printAccnts();
        
//          Account temp1 = list.login(4321);
//        if (temp != null)
//            System.out.println("Logged in as " + temp1.getFullName());
//        else
//            System.out.println("Incorrect pin");

    }
    
}
