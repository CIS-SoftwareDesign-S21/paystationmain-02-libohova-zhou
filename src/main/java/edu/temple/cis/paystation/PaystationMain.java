/*
    Steven Zhou CIS 3296
    The main function of paystation implementation.
 */

package edu.temple.cis.paystation;

import java.util.Scanner;

public class PaystationMain {
    public static void main(String[] args) throws IllegalCoinException {
        PayStation temp = new PayStationImpl();

        System.out.println("Welcome to the Paystation please select from the following options.");
        boolean running = true;
        Scanner user_input = new Scanner(System.in);

        while (running){
            System.out.println("\t1.Deposit Coins");
            System.out.println("\t2.Display Time");
            System.out.println("\t3.Purchase Ticket");
            System.out.println("\t4.Cancel Transaction");
            System.out.println("\t5.Empty(Admin)");
            System.out.println("\t6.Change Rate (Admin)");

            int user_entry = user_input.nextInt();

            //I am going to hide admin entries by not displaying as possible entry on menu
            //Not secure
            switch(user_entry){
                case 1:
                    System.out.println("Nickels, Dimes, and Quarters are accepted.");
                    System.out.print("Push 1 to return to main menu.\n");
                    int coin_entry = 0;
                    while (coin_entry!=1){
                        coin_entry = user_input.nextInt();
                        temp.addPayment(coin_entry);
                    }
                    break;
                case 2:
                    temp.readDisplay();
                    break;
                case 3:
                    temp.buy();
                    break;
                case 4:
                    running = false;
                    break;
                case 5:
                    temp.empty();
                    break;
                case 6:
                    //Placeholder for rate change
                    break;
            }
            System.out.println("Have a nice day!");
        }
    }

    public void subMenu(){

    }
}
