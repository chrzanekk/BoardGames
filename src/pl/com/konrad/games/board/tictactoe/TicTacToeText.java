package pl.com.konrad.games.board.tictactoe;

import java.util.HashMap;
import java.util.Map;

class TicTacToeText {

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

    String getMessage(String key) {
        return messages.get(key);
    }

    String getMessage(String key, String... params) {
        String message = messages.get(key);
        for (int i = 0; i < params.length; i++) {
           message = message.replace("{" + i + "}", params[i]);
        }
        return message;
    }
}
