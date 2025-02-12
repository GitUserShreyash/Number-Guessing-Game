package project;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minNum = 1, maxNum = 100;
        int attemptsLimit = 10;
        int score = 0;

        while (true) {
            int numberToGuess = random.nextInt(maxNum - minNum + 1) + minNum;
            int attempts = 0;

            System.out.println("\nGuess the number between " + minNum + " and " + maxNum + ". You have " + attemptsLimit + " attempts!");

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                    continue;
                }
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score++;
                    break;
                }
            }

            if (attempts >= attemptsLimit) {
                System.out.println("You've run out of attempts! The correct number was " + numberToGuess + ".");
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing! Final score: " + score);
                break;
            }
        }
        scanner.close();
    }
}

