package pl.com.konrad.games.board;

import java.util.HashMap;
import java.util.Map;

public class TicTacToeText {

    private Map<String, String> messages = new HashMap<>();


    {
        messages.put("show.actual.game.board", "ACTUAL GAME BOARD");
        messages.put("show.witch.player.move", "Player {0} move.");
        messages.put("show.winner", "We have a winner! \n Player {0} wins.");
        messages.put("show.draw", "No one wins. We have a draw");
        messages.put("show.input.name", "Please set name of player who plays {0}.");
        messages.put("show.welcome.message", "Welcome in Tic-Tac-Toe game. Have fun. \n MAIN MENU: \n Choose option: ");
        messages.put("show.row.input", "Choose row (from 1 to {0}):");
        messages.put("show.col.input", "Choose col (from 1 to {0}):");
    }

    public String getMessage(String key) {
        return messages.get(key);
    }

    public String getMessage(String key, String... params) {
        String message = messages.get(key);
        for (int i = 0; i < params.length; i++) {
           message = message.replace("{" + i + "}", params[i]);
        }
        return message;
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
