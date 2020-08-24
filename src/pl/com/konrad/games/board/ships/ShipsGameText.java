package pl.com.konrad.games.board.ships;

import java.util.HashMap;
import java.util.Map;

public class ShipsGameText {
    private Map<String, String> messages = new HashMap<>();
    {
        messages.put("show.try.again", "Try again.");
        messages.put("show.witch.player.move", "Player \"{0}\" move");
        messages.put("show.not.empty.row.col", "There is already ship here.");
        messages.put("show.input.row", "Input number of row (from 1 to {0} ): ");
        messages.put("show.input.col", "Input single letter of col (from A to {0} ): ");
    }
}
