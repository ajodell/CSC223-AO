package csc223.ad;

import java.util.Scanner;

public class TicTacToe implements Game{

    String[][] grid;
    String currentPlayer;
    String winner;
    
    // Intakes the decision to play or not
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play (yes/no): ");
        String decision  = scanner.next();
        scanner.close();

        if (decision == "yes" || decision == "y") {
            playGame();
        }
    }

    // Prints out the tic tac toe board
    public void printBoard() {
        System.out.println("  A  B  C");
        System.out.println("0 " + this.grid[0][0] + " " + this.grid[0][1] + " " + this.grid[0][2]);
        System.out.println("1 " + this.grid[1][0] + " " + this.grid[1][1] + " " + this.grid[1][2]);
        System.out.println("2 " + this.grid[2][0] + " " + this.grid[2][1] + " " + this.grid[2][2]);
        System.out.println("\nPlayer " + this.currentPlayer + "'s turn.");
    }

    // Intakes the square to mark
    public void takeTurn() {
        printBoard();
        int firstIndex = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter square (e.g. A0): ");
        String decision  = scanner.next();
        scanner.close();

        // "Converts" the letter to a usable integer
        if (decision.charAt(0) == 'A') {
            firstIndex = 0;
        }
        else if (decision.charAt(1) == 'B') {
            firstIndex = 1;
        }
        else if (decision.charAt(2) == 'C') {
            firstIndex = 2;
        }
        int secondIndex = decision.charAt(1);

        this.grid[firstIndex][secondIndex] = this.currentPlayer;

        // Checks if the game is over, switching the player if not
        if (isGameOver() == true) {
            endGame();
        }
        else {
            if (this.currentPlayer == "X"){
                this.currentPlayer = "O";
            }
            else {
                this.currentPlayer = "X";
            }
            takeTurn();
        }
    }

    public boolean isGameOver() {
        // Check all rows
        for (int i = 0; i < 3; i++) {
            // Ignores rows without marks
            if ((this.grid[i][0] != "_") && (this.grid[i][1] != "_") && (this.grid[i][2] != "_")) {
                // Checks to make sure all marks are the same
                if ((this.grid[i][0] == this.grid[i][1]) && (this.grid[i][0] == this.grid[i][2])) {
                    this.winner = this.grid[i][0];
                    return true;
                }
            }
        }

        // Check all columns
        for (int i = 0; i < 3; i++) {
            // Ignores rows without marks
            if ((this.grid[0][i] != "_") && (this.grid[1][i] != "_") && (this.grid[2][i] != "_")) {
                // Checks to make sure all marks are the same
                if ((this.grid[0][i] == this.grid[1][i]) && (this.grid[0][i] == this.grid[2][i])) {
                    this.winner = this.grid[0][i];
                    return true;
                }
            }
        }
        
        // Checks diagonals
        // Ignores rows without marks
        if ((this.grid[0][0] != "_") && (this.grid[1][1] != "_") && (this.grid[2][2] != "_")) {
            // Makes sure the left-right diagonal is the same
            if ((this.grid[0][0] == this.grid[1][1]) && (this.grid[0][0] == this.grid[2][2])) {
                this.winner = this.grid[0][0];
                return true;
            }
        }
        // Ignores rows without marks
        if ((this.grid[0][2] != "_") && (this.grid[1][1] != "_") && (this.grid[2][0] != "_")) {
            // Makes sure the right-left diagonal is the same
            if ((this.grid[0][2] == this.grid[1][1]) && (this.grid[0][2] == this.grid[2][0])) {
                this.winner = this.grid[2][0];
                return true;
            }
        }
        boolean full;
        // Check if all spots are full
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.grid[i][j] == "_") {
                    full = false;
                }
            }
        }
        if (full = true) {
            this.winner = null;
            return true;
        }

        // Returns if nobody won
        return false;
    }

    public void endGame() {
        if (this.winner == null) {
            System.out.println("Nobody won :(");
        }
        else {
            System.out.println("Player " + this.winner + " wins!");
        }
        startGame();
    }

    // Allows the player to start or end the game
    public void playGame() {
        this.grid = new String[][] {{"_", "_", "_"}, {"_", "_", "_"}, {"_", "_", "_"}};
        this.currentPlayer = "X";
        this.winner = null;
    }
}
