import java.util.Random;
import java.util.Scanner;

public class rps {
    private static int wins = 0;
    private static int losses = 0;
    private static int ties = 0;
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadScoreFromStorage();

        while (true) {
            System.out.println("Choose your move: ");
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            System.out.println("4. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            if (choice == 4) {
                break;
            }

            String playerMove = getMove(choice);

            String computerMove = pickComputerMove();

            String result = getResult(playerMove, computerMove);

            updateScore(result);

            System.out.println("Result: " + result);
            System.out.println("Your move: " + playerMove);
            System.out.println("Computer's move: " + computerMove);
            System.out.println("Score: Wins - " + wins + ", Losses - " + losses + ", Ties - " + ties);
        }

        saveScoreToStorage();
    }

    private static void loadScoreFromStorage() {
        // This is a simplified version. In real-world applications, you'd use file I/O or a database.
        // For simplicity, we initialize the score to 0.
        wins = 0;
        losses = 0;
        ties = 0;
    }

    private static void saveScoreToStorage() {
        // In a real-world scenario, you'd save the score to storage (file, database, etc.).
        // Here, we just print the score for demonstration purposes.
        System.out.println("Final score: Wins - " + wins + ", Losses - " + losses + ", Ties - " + ties);
    }

    private static String getMove(int choice) {
        switch (choice) {
            case 1:
                return "rock";
            case 2:
                return "paper";
            case 3:
                return "scissors";
            default:
                return ""; // Invalid choice
        }
    }

    private static String pickComputerMove() {
        int randomNumber = random.nextInt(3); // Generate a random number between 0 and 2

        switch (randomNumber) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            case 2:
                return "scissors";
            default:
                return ""; // This should not happen
        }
    }

    private static String getResult(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Tie.";
        } else if ((playerMove.equals("rock") && computerMove.equals("scissors"))
                || (playerMove.equals("paper") && computerMove.equals("rock"))
                || (playerMove.equals("scissors") && computerMove.equals("paper"))) {
            return "You win.";
        } else {
            return "You lose.";
        }
    }

    private static void updateScore(String result) {
        if (result.equals("You win.")) {
            wins++;
        } else if (result.equals("You lose.")) {
            losses++;
        } else {
            ties++;
        }
    }
}
