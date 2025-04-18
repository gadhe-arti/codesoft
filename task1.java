import java.util.Random;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 100;
        final int MAX_ATTEMPTS = 7;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsWon = 0;
        int roundsPlayed = 0;
        String playAgain;

        System.out.println("🎯 Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");

        do {
            int numberToGuess = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            roundsPlayed++;
            System.out.println("\n🔁 Starting Round " + roundsPlayed);

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess (" + attemptsLeft + " attempts left): ");

                if (!scanner.hasNextInt()) {
                    System.out.println("⚠️ Invalid input. Please enter a valid number.");
                    scanner.next(); // discard invalid input
                    continue;
                }

                int guess = scanner.nextInt();

                if (guess == numberToGuess) {
                    System.out.println("✅ Correct! You guessed the number!");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("🔼 Too low!");
                } else {
                    System.out.println("🔽 Too high!");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The number was: " + numberToGuess);
            }

            System.out.print("\nDo you want to play another round? (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        // Final score summary
        System.out.println("\n🎉 Game Over!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Rounds won: " + roundsWon);

        scanner.close();
    }
}
