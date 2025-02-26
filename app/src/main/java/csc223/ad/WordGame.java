package csc223.ad;
import java.util.Random;
import java.util.Scanner;

public class WordGame {
    
    String[] wordlist = {"piano", "ghoul", "heart", "slate", "flake", "pains"};
    String word;
    String[] guessList;
    String guess;
    int chances;
    Random rand;
    boolean gameState;
    boolean win;

    // Allows the player to start or end the game
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play (yes/no): ");
        String decision  = scanner.next();
        scanner.close();

        if (decision == "yes" || decision == "y") {
            playGame();
        }
    }

    // Prints out the letters guessed and remaining chances
    public void printBoard() {
        System.out.println("    " + this.guessList[0] + " " + this.guessList[1] + " " + this.guessList[2] + " " + this.guessList[3] + " " + this.guessList[4]);
        System.out.println("You have " + this.chances + " guesses remaining.");
    }

    // Handles the guesses made
    public void takeTurn() {

        // Takes the user's guess as input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess the letter or the entire word: ");
        this.guess  = scanner.next();
        scanner.close();

        // Runs if the guess is a single letter
        if (this.guess.length() == 1) {
            // Runs if the guess was incorrect
            if (this.word.indexOf(this.guess) == -1) {
                this.chances -= 1;
                System.out.println(this.guess + " is not in the word.");
                printBoard();
            }
            // Runs if the guess was correct
            else {
                this.guessList[this.word.indexOf(this.guess)] = this.guess;
                printBoard();
            }
        }
        // Runs if the guess is a word
        else {
            // Runs if the guess was incorrect
            if (this.guess != this.word) {
                this.chances -= 1;
                System.out.println("The word is not " + this.guess);
                printBoard();
            }
            // Runs if the guess was correct
            else {
                for (int i = 0; i < 6; i++) {
                    char letterToAdd = this.guess.charAt(i);
                    this.guessList[i] = String.valueOf(letterToAdd);
                    printBoard();
                }
            }
        }
        // Checks to see if the game is over
        if (isGameOver() == true) {
            endGame();
        }
        else {
            takeTurn();
        }
    }

    // Checks if all the spaces in guessList are filled
    public boolean isGameOver() {
        
        // Runs if you lost your chances
        if (this.chances == 0) {
            this.win = false;
            return true;
        }
        // Checks if all the letters are correct
        for (int i = 0; i < 6; i++) {
            if (this.guessList[i] == "_") {
                return false;
            }
        }
        // Runs if all the letters were correct
        this.win = true;
        return true;
    }

    // Prints the win/lose screen
    public void endGame() {
        if (win == true) {
            System.out.println("Congrats! You guessed the word correctly!");
        }
        else {
            System.out.println("You lost! The word was " + this.word +".");
        }
        startGame();
    }

    // Picks a word and initializes a few variables
    public void playGame() {
        Random rand = new Random();
        this.word = wordlist[rand.nextInt(6)];
        this.chances = 7;
        this.guessList = new String[]{"_", "_", "_", "_", "_"};
        this.win = false;
        takeTurn();
    }
}
