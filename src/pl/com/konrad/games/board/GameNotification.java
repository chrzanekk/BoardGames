package pl.com.konrad.games.board;

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


}
