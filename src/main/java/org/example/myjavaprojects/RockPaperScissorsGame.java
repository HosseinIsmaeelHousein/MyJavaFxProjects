package org.example.myjavaprojects;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] options = {"rock", "paper", "scissors"};
        int playerScore = 0;
        int computerScore = 0;
        String playerChoice;

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Type 'rock', 'paper', or 'scissors' to play. Type 'exit' to quit the game.");

        while (true) {
            System.out.print("Enter your choice: ");
            playerChoice = scanner.nextLine().toLowerCase();

            if (playerChoice.equals("exit")) {
                System.out.println("Thanks for playing! Final score:");
                System.out.println("Player: " + playerScore + " - Computer: " + computerScore);
                break;
            }

            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                System.out.println("Invalid choice. Please enter 'rock', 'paper', or 'scissors'.");
                continue;
            }

            // Computer randomly selects rock, paper, or scissors
            String computerChoice = options[random.nextInt(3)];
            System.out.println("Computer chose: " + computerChoice);

            // Determine winner
            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                    (playerChoice.equals("scissors") && computerChoice.equals("paper")) ||
                    (playerChoice.equals("paper") && computerChoice.equals("rock"))) {
                System.out.println("You win!");
                playerScore++;
            } else {
                System.out.println("Computer wins!");
                computerScore++;
            }

            // Display current score
            System.out.println("Score - Player: " + playerScore + " - Computer: " + computerScore);
        }

        scanner.close();
    }
}

