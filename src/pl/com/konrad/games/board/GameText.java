package pl.com.konrad.games.board;

import java.util.HashMap;
import java.util.Map;

public class GameText {

    private static Map<String, String> messages = new HashMap<>();


    static {
        messages.put("show.welcome.message", "Welcome in Game Boards. Have fun. \n MAIN MENU: \n Choose option: ");

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
