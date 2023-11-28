package code;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = generateRandomNumber(lowerBound, upperBound);
            int attempts = 0;
            boolean isCorrect = false;

            System.out.println("\nI have selected a number between " + lowerBound + " and " + upperBound +
                    ". Can you guess it?");

            while (attempts < maxAttempts) {
                int userGuess = getUserGuess(lowerBound, upperBound, scanner);

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! Your guess is correct.");
                    isCorrect = true;
                    score += maxAttempts - attempts;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                attempts++;
            }

            if (!isCorrect) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Your total score is: " + score);
    }

    private static int generateRandomNumber(int lowerBound, int upperBound) {
        return lowerBound + new Random().nextInt(upperBound - lowerBound + 1);
    }

    private static int getUserGuess(int lowerBound, int upperBound, Scanner scanner) {
        int userGuess;
        do {
            System.out.print("Enter your guess (" + lowerBound + " - " + upperBound + "): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); }
            userGuess = scanner.nextInt();
        } while (userGuess < lowerBound || userGuess > upperBound);

        return userGuess;
    }
}

