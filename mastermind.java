/*
 * Written by Caroline Del Carmen for the "Hack day: Mastermind challenge"
 * Holberton Programming School challenge.
 *
 * This is a java program that allows users to play Mastermind.
 *
 * Github: cmdelcarmen
 */

import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;


class mastermind {

      public static void main(String args[]){

                // Generates a random number between 1000 and 9999
                int random_num = ThreadLocalRandom.current().nextInt(1000, 10000);
                Scanner usr_input = new Scanner (System.in);
                int usr_number;

                System.out.println("Welcome to Mastermind!");
                System.out.println("For questions about to play the game please visit: ");
                System.out.println("https://en.wikipedia.org/wiki/Mastermind_(board_game)\n");

                // temp line for debugging purposes
                System.out.println(random_num);

                System.out.println("Please enter a 4 digit number:");
                usr_number = usr_input.nextInt();
                System.out.println(usr_number);

                if (random_num == usr_number) {
                  System.out.println("You're a mastermind! You got the right number on your first try!");
                }


      }
}
