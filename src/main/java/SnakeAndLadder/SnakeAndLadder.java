package SnakeAndLadder;

import java.util.Random;

public class SnakeAndLadder {
    private static final int WINNING_POSITION = 100;
    private static int[] playerPositions;
    private static int currentPlayer = 0;
    private static Random random = new Random();


    private static void movePlayer(int diceValue) {
        int newPosition = playerPositions[currentPlayer] + diceValue; // New position of the player
        if (newPosition > WINNING_POSITION) return; // handles use case 5
        if (newPosition == WINNING_POSITION) {
            playerPositions[currentPlayer] = newPosition;
            return;
        }
        int option = random.nextInt(3); // 0 for No Play, 1 for Ladder, 2 for Snake
        switch (option) {
            case 0: // No Play
                break;
            case 1: // Ladder
                playerPositions[currentPlayer] = newPosition;
                movePlayer(diceValue); // Plays again if ladder
                break;
            case 2: // Snake
                playerPositions[currentPlayer] = Math.max(newPosition - diceValue, 0); // handles use case 4
                break;
        }
    }

    private static int rollDice() {
        return random.nextInt(6) + 1; // Generates a random number between 1 and 6
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Simulator!");
        playerPositions = new int[1]; // For single player
        int diceRolls = 0;

        while (playerPositions[0] < WINNING_POSITION) {
            int diceValue = rollDice();
            diceRolls++;
            System.out.println("Player " + (currentPlayer + 1) + " rolled a " + diceValue);
            movePlayer(diceValue);
            System.out.println("Player " + (currentPlayer + 1) + " is now at position " + playerPositions[currentPlayer]);
        }

        System.out.println("Player wins after " + diceRolls + " rolls!");
    }
}
