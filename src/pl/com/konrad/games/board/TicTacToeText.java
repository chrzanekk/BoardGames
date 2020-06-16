package pl.com.konrad.games.board;

import java.util.HashMap;
import java.util.Map;

public class TicTacToeText {
//     do sprawdzenia i obgadania z Pawłem jak rozwiązań poprawnie formatowanie stringa w kolekcji.
    private char currentPlayer;
    private char pawnType;
    private Map<String, String> messages = new HashMap<>();

    public TicTacToeText() {
    }

    public TicTacToeText(char currentPlayer, char pawnType) {
        this.currentPlayer = currentPlayer;
        this.pawnType = pawnType;
    }

    {

        String whoShouldMoveNotification = String.format("Player %char move.", currentPlayer);
        String winnerNotification = String.format("We have a winner! Player %char wins.",
                currentPlayer);
        String setNameByPawnType = String.format("Please set name of player who plays  %char:",
                pawnType);
        messages.put("show.actual.game.board", "ACTUAL GAME BOARD");
        messages.put("show.witch.player.move", whoShouldMoveNotification);
        messages.put("show.winner", winnerNotification);
        messages.put("show.draw", "No one wins. We have a draw");
        messages.put("show.input.name", setNameByPawnType);
        messages.put("show.welcome.message", "Welcome in Tic-Tac-Toe game. Have fun. \n MAIN MENU: \n Choose option: ");
    }

    public String getMessage(String key) {
        return messages.get(key);
    }




//    poprzednia wersja ponizej.
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

    public void showInputName(TicTacToePawnType pawnType) {
        System.out.println("Please set name of player who plays " + pawnType + ":");
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
