package pl.com.konrad.games.board;

import java.util.HashMap;
import java.util.Map;

public final class ValidatorWarning {

    private static Map<String, String> messages = new HashMap<>();

    static {
        messages.put("show.not.empty.row.col", "There is already a mark here. Try again.");
        messages.put("show.invalid.user.input", "Invalid choice. Try again.");
        messages.put("show.wrong.move", "You cannot move here. Try again.");
        messages.put("show.wrong.beat", "You cannot beat this pawn. Try again.");
        messages.put("show.wrong.name.input", "Name is already exists. Try different name.");
    }

    public static String getMessage(String key) {
        return messages.get(key);
    }
}
