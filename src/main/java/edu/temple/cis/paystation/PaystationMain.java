package edu.temple.cis.paystation;

import java.util.Scanner;

public class PaystationMain {
    public static void main(String[] args){
        Paystation ps;

        system.out.println("Welcome to the Paystation please select from the following options.");
        boolean running = true;
        Scanner user_input = new Scanner(System.in);

        while (running){
            system.out.println("\t1.Deposit Coins");
            system.out.println("\t2.Display Time");
            system.out.println("\t3.Purchase Ticket");
            system.out.println("\t4.Cancel Transaction");
            system.out.println("\t5.Admin");

            switch(user_input.nextInt()){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        }
    }
}
