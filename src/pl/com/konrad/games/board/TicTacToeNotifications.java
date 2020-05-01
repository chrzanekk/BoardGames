package pl.com.konrad.games.board;

public class TicTacToeNotifications {
    public void showActualGameBoard() {
        System.out.println("ACTUAL GAME BOARD");
    }

    public void showWhichPlayerMove(char currentPlayer) {
        System.out.println("Player \"" + currentPlayer + "\" move.");
    }

    public void showWinner(char currentPlayer) {
        System.out.println("We have a winner!");
        System.out.println("Player \"" + currentPlayer + "\" wins.");
    }

    public void showDraw() {
        System.out.println("No one wins. We have a draw");
    }

    public void showNotEmptyRowCol() {
        System.out.println("There is already a mark here. Try again.");
    }

    public void showInvalidUserInput() {
        System.out.println("Invalid choice. Try again.");
    }

    public void showWelcomeMessage() {
        System.out.println("Welcome in Tic-Tac-Toe game. Have fun.");
        System.out.println("MAIN MENU:");
        System.out.println("Choose option:");
    }

    public void showRowInput(int gameBoardSize) {
        System.out.println("Choose row (from 1 to " + gameBoardSize + "):");
    }

    public void showColInput(int gameBoardSize) {
        System.out.println("Choose col (from 1 to " + gameBoardSize + "):");
    }
}
