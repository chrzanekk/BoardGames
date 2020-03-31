package pl.com.konrad.checkers;

public class GameNotification {
    public void showWelcomeMessage() {
        System.out.println("Welcome in Checkers. Have fun.");
        System.out.println("MAIN MENU");
        System.out.println("Choose option:");
    }

    public void showInputName(String description) {
        System.out.println("Please input name of player who plays " + description + ":");
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

}
