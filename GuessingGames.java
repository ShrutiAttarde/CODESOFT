import java.util.Scanner;
import java.lang.Math;

public class GuessingGames {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int totalScore = 0;
    boolean playAgain = true;

    while (playAgain) {
      // Generate a random number between 1 and 100
      int answer = (int)(Math.random() * 100) + 1;
      // Number of trials that the user has to guess the number
      int ch = 5;
      boolean correct = false;


      System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("A number has been chosen between 1 and 100. \n  You have only 5 tries to guess the number.");
      while (ch > 0) {
        System.out.println("Enter your guess: ");
        int guess = input.nextInt();

        if (guess == answer) {
          System.out.println("  You guessed the number!\n           You win!");
          correct = true;
          totalScore += ch; // score based on remaining tries
          break;
        } else if (guess > answer) {
          System.out.println("  Your guess is too high.\n  You have " + (ch - 1) + " tries left.");
        } else {
          System.out.println("  Your guess is too low.\n  You have " + (ch - 1) + " tries left.");
        }
        ch--;
      }

      if (!correct) {
        System.out.println("\n\n  You ran out of tries.\n\n     You lose!\n     Better Luck next time:)");
      }

      System.out.println("Your total score so far is: " + totalScore);
      System.out.println("Do you want to play again? (yes/no)");
      String response = input.next();
      if (response.equalsIgnoreCase("no")) {
        playAgain = false;
      }
    }

    System.out.println("Thank you! Your final score is: " + totalScore);
    input.close();
  }
}
