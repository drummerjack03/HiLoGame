/*

Author: Jack Crawford

Date: 8/29/24

Problem: PP 7.3, CHAPTER 7, SOFTWARE SOLUTIONS LEWIS, 8th edition
PP 6 Write a program that plays the Hi-Lo guessing game with numbers. The program should pick a
random number between 1 and 100 (inclusive), then repeatedly prompt the use to guess the number.
On each guess, report to the user that he or she is correct or that the guess is high or low. Continue
accepting guesses until the user guesses correctly or chooses to quit. Use a sentinel value to determine
whether the user wants to quit. Count the number of guesses and report that value when the user
guesses correctly. At the end of each game ( by quitting or a correct guess), prompt to determine
whether the user wants to play again. Continue playing games until the user chooses to stop.
 */

 import java.util.Random;
 import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Pick a number between 1 and 100
            int guessCount = 0;
            boolean correctGuess = false;

            System.out.println("I have picked a number between 1 and 100. Try to guess it!");
            System.out.println("Enter -1 to quit.");

            while (!correctGuess) {
                System.out.print("Your guess: ");
                int userGuess = scanner.nextInt();
                guessCount++;

                if (userGuess == -1) {
                    System.out.println("You chose to quit the game.");
                    break;
                }

                if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    System.out.println("It took you " + guessCount + " guesses.");
                    correctGuess = true;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Goodbye.");
        scanner.close();
    }
}
