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
import java.lang.String;
import java.lang.System;

class mastermind {

  /*
   * Method greets user and compares user input to code,
   * breaking out of while loop once they match or the user
   * enters five consecutive 5's.
   */
  public static void main(String args[]){

    // Generates a random number between 1000 and 9999
    int code = ThreadLocalRandom.current().nextInt(1000, 10000);
    //declares variable used for collecting user input
    Scanner usr_input = new Scanner (System.in);
    int usr_number = 0;
    int num_of_tries = 1;

    //Welcome prompts
    System.out.println("Welcome to Mastermind!");
    System.out.println("For questions about to play the game please visit: ");
    System.out.println("https://en.wikipedia.org/wiki/Mastermind_(board_game)");
    System.out.println("To quit game type 55555, 5 consecutive 5's\n");

    prompt();
    // Gets user input
    usr_number = usr_input.nextInt();

    if (compare(code, usr_number) == 1) {
      System.out.println("You're a mastermind! You got the right number on your first try!");
      System.exit(0);
    }
    display_correct_spots(code, usr_number);

    while (code != usr_number)
    {
      prompt();
      usr_number = usr_input.nextInt();
      num_of_tries++;

      if (compare(code, usr_number) == 1) {
        System.out.println("Congrats! You've found the secret code. You are a mastermind.");
        System.out.println("It took you " + num_of_tries + " tries!");
        System.exit(0);
      }

      display_correct_spots(code, usr_number);
    }
  }

  /*
   * Method prints out prompt: "Please enter a 4 digit number:"
   */
  public static void prompt(){
    System.out.print("Please enter a 4 digit number: ");
  }

  /*
   * Method compares the code and the user input and returns 1 if its a match.
   * If user enters '55555' the program will exit.
   * Otherwise it will return 0.
   */
  public static int compare(int code, int usr_number){

    if (usr_number == 55555) {
      System.out.println("The code was " + code + ". Thank you for playing!");
      System.exit(0);
    }

    if (code == usr_number) {
      return (1);
    }

    return (0);
  }

  /*
   * Method prints out the location of correctly entered numbers.
   * For example: If the code is "2222" and the use enters "1234",
   * then "X2XX" will print out.
   */
  public static void display_correct_spots(int code, int usr_number){
    String u_number = new String(String.valueOf(usr_number));
    String g_code = new String(String.valueOf(code));
    int numbers_right = 0;

    if (u_number.substring(0, 1).equals(g_code.substring(0, 1))){
      System.out.print(u_number.substring(0, 1));
      numbers_right++;
    } else {
      System.out.print("X");
    }
    if (u_number.substring(1, 2).equals(g_code.substring(1, 2))){
      System.out.print(u_number.substring(1, 2));
      numbers_right++;
    } else {
      System.out.print("X");
    }
    if (u_number.substring(2, 3).equals(g_code.substring(2, 3))){
      System.out.print(u_number.substring(2, 3));
      numbers_right++;
    } else {
      System.out.print("X");
    }
    if (u_number.substring(3, 4).equals(g_code.substring(3, 4))){
      System.out.print(u_number.substring(3, 4));
      numbers_right++;
    } else {
      System.out.print("X");
    }
    System.out.println();
    System.out.println("You got " + numbers_right + " digit(s) correct!\n");
  }
}
