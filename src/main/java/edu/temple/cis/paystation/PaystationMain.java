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
                    int coin_entry = user_input.nextInt();
                    while (coin_entry!=1){
                        temp.addPayment(coin_entry);
                        coin_entry = user_input.nextInt();
                    }
                    break;
                case 2:
                    System.out.println(temp.readDisplay());
                    break;
                case 3:
                    System.out.println(temp.buy().value());
                    running = false;
                    break;
                case 4:
                    System.out.print(temp.cancel());
                    running = false;
                    break;
                case 5:
                    System.out.println(temp.empty());
                    break;
                case 6:
                    temp.setRateStrategy(subMenu(user_input));
//                    System.out.println(temp.getRateStrategy());
                    break;
            }
        }
        System.out.println("Have a nice day!");
        user_input.close();
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
        String dayOfWeek;
        int hour, minute;
        /*I set the default option to linear, I thought about creating a while loop for entries that are not 1-5
        but decided against it for the sake of simplicity.
         */
        switch(subMenu_entry){
            case 1:
                return new LinearRateStrategy();
            case 2:
                return new ProgressiveRateStrategy();
            case 3:
                System.out.println("Enter a day of the week (all caps): ");
                dayOfWeek = user.next();
                System.out.println("Enter a hour 0-23");
                hour = user.nextInt();
                System.out.print("Enter minute 0-59");
                minute = user.nextInt();
                return new CleanerAlternating1(dayOfWeek,hour,minute);
            case 4:
                return new Linear2RateStrategy();
            case 5:
                System.out.println("Enter a day of the week (all caps): ");
                dayOfWeek = user.next();
                System.out.println("Enter a hour 0-23");
                hour = user.nextInt();
                System.out.print("Enter minute 0-59");
                minute = user.nextInt();
                return new CleanerAlternating2(dayOfWeek,hour,minute);
            default:
                return new LinearRateStrategy();
        }
    }
}