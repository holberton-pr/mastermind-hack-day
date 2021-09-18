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
import java.util.Arrays;
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
    int usr_code = 0, num_of_tries = 20;

    System.out.println("Welcome to Mastermind!");
    System.out.println("For questions about to play the game please visit: ");
    System.out.println("https://en.wikipedia.org/wiki/Mastermind_(board_game)");
    System.out.println("To quit game type -1.");
    System.out.println("----------------------------------------------------\n");

    // Gets user input
    usr_code = prompt_and_validate();

    if (compare(code, usr_code) == 1) {
      System.out.println("You're a mastermind! You cracked the code on your first try!");
      System.exit(0);
    }
    // Displays the hints for the user
    count_correct_spots(code, usr_code);

    while(num_of_tries != 0)
    {
      System.out.println("You have " + num_of_tries + " tries left!\n");
      usr_code = prompt_and_validate();
      num_of_tries--;

      if (compare(code, usr_code) == 1) {
        System.out.println("Congrats! You've found the secret code." + code + ". You are a mastermind.");
        System.exit(0);
      }
      count_correct_spots(code, usr_code);
    }
    System.out.println("GAME OVER.\nThe code was " + code  + ". Thanks for playing!");

  }

  /*
   * Method prints out prompt: "Please enter a 4 digit number:"
   */
  public static int prompt_and_validate(){
    int usr_code = 0;
    Scanner input = new Scanner (System.in);
    String usr_code_str = "";

    while (usr_code_str.length() != 4 && usr_code != -1)
    {
      System.out.print("Please enter a 4 digit number: ");
      usr_code = input.nextInt();
      usr_code_str = new String(String.valueOf(usr_code));
    }
    return usr_code;
  }

  /*
   * Method compares the code and the user input and returns 1 if its a match.
   * If user enters '55555' the program will exit.
   * Otherwise it will return 0.
   */
  public static int compare(int code, int usr_number){

    // Players type -1 to exit
    if (usr_number == -1) {
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
  public static void count_correct_spots(int code, int usr_number){
    String u_number = new String(String.valueOf(usr_number));
    String g_code = new String(String.valueOf(code));
    int numbers_right = 0, numbers_almost_right = 0;

    for (int idx = 0; idx < 4; idx++) {
      if (u_number.substring(idx, idx + 1).equals(g_code.substring(idx, idx +1))){
        numbers_right++;
      }
    }
    numbers_almost_right = check_if_in_code(g_code, u_number);

    System.out.println("You got " + numbers_almost_right + " digit(s) correct.");
    System.out.println("You got " + numbers_right + " digit(s) in the correct position.");
  }

  /*
   * Method returns the numbers of times the numbers the user
   * entered appear in the code
   */
  public static int check_if_in_code(String code, String usr_number) {
    int idx = 0, numbers_almost_right = 0;
    char arr[] = {0, 0, 0, 0};

    for (idx = 0; idx < 4; idx++) {
      arr[idx] = code.charAt(idx);
    }
    for (idx = 0; idx < 4; idx++) {
      for (int idx2 = 0; idx2 < 4; idx2++) {
        if (arr[idx] == usr_number.charAt(idx2)) {
          numbers_almost_right++;
          break;
        }
      }
    }
    return numbers_almost_right;
  }
}
