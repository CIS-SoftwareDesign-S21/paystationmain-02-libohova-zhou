/*
    Steven Zhou CIS 3296
    The main function of paystation implementation.
 */

package edu.temple.cis.paystation;

import javax.sound.sampled.Line;
import java.util.Scanner;

public class PaystationMain {
    public static void main(String[] args) throws IllegalCoinException {
        PayStation temp = new PayStationImpl(new LinearRateStrategy());

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
                    temp.setRateStrategy(subMenu(user_input));
                    break;
            }
            System.out.println("Have a nice day!");
            user_input.close();
        }
    }

    public static RateStrategy subMenu(Scanner user){
        System.out.println("Please choose one of the following rate strategies.");
        System.out.println("\t1.Alphatown(Linear1)");
        System.out.println("\t2.Betatown(Progressive)");
        System.out.println("\t3.Gammatown(Alternating1)");
        System.out.println("\t4.Deltatown(Linear2)");
        System.out.println("\t5.Omegatown(Alternating2)");

        //Some are placeholders until new strategies are pushed
        int subMenu_entry = user.nextInt();
        switch(subMenu_entry){
            case 1:
                return new LinearRateStrategy();
            case 2:
                return new ProgressiveRateStrategy();
            case 3:
                System.out.println("Enter a day of the week (all caps): ");
                String dayOfWeek = user.next();
                System.out.println("Enter a hour 0-23");
                int hour = user.nextInt();
                System.out.print("Enter minute 0-59");
                int minute = user.nextInt();
                return new Alternating2(dayOfWeek,hour,minute);
//            case 4:
//                return new LinearRateStrategy();
//            case 5:
//                return new AlternatingRateStrategy();
            default:
                return new LinearRateStrategy();
        }
    }
}