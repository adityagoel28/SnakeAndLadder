package SnakeAndLadder;

import java.util.Random;

public class SnakeAndLadder {
    private static int currentPlayer = 0;
    private static Random random = new Random();

    private static int rollDice() {
        return random.nextInt(6) + 1; // Generates a random number between 1 and 6
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Simulator!");
        int diceRolls = 0;
    }
}
