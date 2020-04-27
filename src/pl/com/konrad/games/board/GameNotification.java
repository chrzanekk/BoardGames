package pl.com.konrad.games.board;

import java.util.Arrays;

public class GameNotification {
    public void showWelcomeMessage() {
        System.out.println("Welcome in Checkers. Have fun.");
        System.out.println("MAIN MENU");
        System.out.println("Choose option:");
    }

    public void showInputName(Colors colors) {
        System.out.println("Please set name of player who plays " + colors + ":");
    }

    public void showWrongNameInput(String existingName) {
        System.out.println("Name " + existingName + " already exists. Try different name.");
    }

    public void showActualBoard() {
        System.out.println("ACTUAL GAME BOARD");
    }

    public void showWrongMove() {
        System.out.println("You cannot move here. Try again.");
    }

    public void showWrongBeat() {
        System.out.println("You cannot beat this pawn. Try again.");
    }

    public void showInvalidUserInput() {
        System.out.println("Invalid choice. Try again.");
    }

    public void showWhichPlayerMove(String playerName) {
        System.out.println("Player \"" + playerName + "\" move.");
    }

    public void showCurrentPawnToMove() {
        System.out.println("Choose current pawn to move:");
    }

    public void showInputRow(int gameBoardSize) {
        System.out.println("Input number of row (form 1 to " + gameBoardSize + "): ");
    }

    public void showInputCol(int gameBoardSize) {
        char firstChar = 'A';

        System.out.println("Input letter of col (form " + firstChar + " to " + lastLetterOfCol(firstChar,
                gameBoardSize) +"): ");
    }

    public void showNewPawnPosition() {
        System.out.println("Choose new pawn position: ");
    }

    private char lastLetterOfCol(char firstChar, int gameBoardLength) {
        int lastCharByInt = (int) firstChar +gameBoardLength-1;
        return (char)lastCharByInt;
    }


}
