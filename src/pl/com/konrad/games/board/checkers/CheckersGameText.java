package pl.com.konrad.games.board.checkers;

import java.util.HashMap;
import java.util.Map;

class CheckersGameText {

    private Map<String, String> messages = new HashMap<>();

    {
        messages.put("show.input.name", "Please set name of player who plays {0}.");
        messages.put("show.actual.game.board", "ACTUAL GAME BOARD");
        messages.put("show.witch.player.move", "Player\" {0} \"move");
        messages.put("show.choose.current.pawn.to.move", "Choose current pawn to move: ");
        messages.put("show.pawn.doesnt.belong.to.current.player", "This pawn doesn't belong to you. Try again.");
        messages.put("show.new.pawn.position", "Choose new pawn position: ");
        messages.put("show.not.empty.row.col", "There is already figure here. Try again.");
        messages.put("show.empty.row.col", "There is no pawn here. Try again.");
        messages.put("show.input.row", "Input number of row (from 1 to {0} ): ");
        messages.put("show.input.col", "Input letter of col (from A to {0} ): ");
        messages.put("show.winner", "We have a winner! \n Player {0} wins.");
        messages.put("show.draw", "No one wins. We have a draw");
        messages.put("show.player.cant.move.pawn", "You cannot move this pawn, choose another");

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
}
