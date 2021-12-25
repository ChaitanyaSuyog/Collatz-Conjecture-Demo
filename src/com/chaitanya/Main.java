package com.chaitanya;

import java.awt.*;
import java.net.URI;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("Enter a positive integer to get the values of its Collatz conjecture: ");
        getCollatz(new Scanner(System.in).nextInt(), 0, 0);
    }

    public static void getCollatz(int integer, int instance, int iter) throws Exception {
        if (integer < 0) {
            integer = Math.abs(integer);
            System.out.println("Negative " + integer + " has been converted to positive " + integer);
            Thread.sleep(1000);
        }

        System.out.println();
        System.out.println("Collatz initiated.");
        Thread.sleep(1000);
        System.out.println();

        switch (instance) {
            case 0:
                while (integer > 0) {
                    if (integer == 1) {
                        integer = 1;
                        conjectureReach(integer);
                    } else if (integer % 2 != 0) {
                        integer = (integer * 3) + 1;
                        System.out.println(integer);
                    } else {
                        integer = integer / 2;
                        System.out.println(integer);
                    }
                }
                break;
            case 1:
                for (int i = 0; i < iter; i++) {
                    if (integer % 2 == 0) {
                        integer = integer / 2;
                        System.out.println(integer);
                    } else if (integer % 2 != 0) {
                        integer = (integer * 3) + 1;
                        System.out.println(integer);
                    }
                }
                break;

            default:
                throw new Exception("Seems like you are trying to enter a negative integer.");
        }
    }
    public static void conjectureReach(int integer) throws Exception {
        String[] yes = {"yes, y"};
        String[] no = {"no", "n"};
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("The integer has reached or is at the conjecture, i.e. " + integer);
        System.out.println("Would you like to continue iterating?");
        String reply = scan.nextLine().toLowerCase();

        int iter;
        if (Arrays.toString(yes).contains(reply)) {
            System.out.println("Specify the number of iterations (<=100): ");
            iter = scan.nextInt();

            if (iter > 0 && iter <= 100) {
                System.out.print("Processing... ");
                Thread.sleep(700);
                System.out.println(" user stupidity confirmed. Thank you.");

                getCollatz(integer, 1, iter);
                System.exit(0);
            }
            else if (iter == 0) {
                System.out.println("You were smart. Here-> watch Veritasium's video.");
                Thread.sleep(3000);
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=094y1Z2wpJg"));
                System.exit(1);
            }
            else {
                System.out.println("Why do you want to confuse your beloved PC like this? Satisfy your curiosity by watching this video.");
                Thread.sleep(3000);
                Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
                System.exit(1);
            }
        }
        else if (Arrays.stream(no).toList().contains(reply)) {
            System.out.println("No probs, satisy your curiosity watching Veritasium's video. Here->");
            Thread.sleep(3000);
            Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=094y1Z2wpJg"));
            System.exit(1);
        }
        else {
            System.out.println("Please say \"yes\" or \"no\".");
        }
    }
}
