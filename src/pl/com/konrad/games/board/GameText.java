package pl.com.konrad.games.board;

import java.util.HashMap;
import java.util.Map;

public final class GameText {

    private static Map<String, String> messages = new HashMap<>();


    static {
        messages.put("show.welcome.message", "Welcome in Game Boards. Have fun. \n MAIN MENU: \n Choose option: ");
        messages.put("show.input.name", "Please set name of player who plays {0}.");

    }

    public static String getMessage(String key) {
        return messages.get(key);
    }

    public static String getMessage(String key, String... params) {
        String message = messages.get(key);
        for (int i = 0; i < params.length; i++) {
            message = message.replace("{" + i + "}", params[i]);
        }
        return message;
    }
}
