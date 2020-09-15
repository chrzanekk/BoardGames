package pl.com.konrad.games.board.ships;

import java.util.HashMap;
import java.util.Map;

public class ShipsGameText {
    private Map<String, String> messages = new HashMap<>();
    {
        messages.put("show.try.again", "Try again.");
        messages.put("show.witch.player.move", "Player \"{0}\" move");
        messages.put("show.not.empty.row.col", "There is already ship here.");
        messages.put("show.setup.ship", "Set ship number \"{0}\" of \"{1}\".");
        messages.put("show.setup.mast", "Set mast number \"{0}\" of \"{1}\".");
        messages.put("show.layout.option", "Please,choose layout option for ship:");
        messages.put("show.wrong.layout.option", "Wrong layout option");
        messages.put("show,wrong.coordinates","You cannot put ship here.");
        messages.put("show.input.row", "Input number of row (from 1 to {0} ): ");
        messages.put("show.input.col", "Input single letter of col (from A to {0} ): ");
        messages.put("show.player.one", "Player one");
        messages.put("show.player.two", "Player two");

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
