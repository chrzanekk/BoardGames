package pl.com.konrad.games.board;

import java.util.HashMap;
import java.util.Map;

public final class ValidatorWarning {

    private static Map<String, String> messages = new HashMap<>();
//informacja o blednych danych z klawiry
    static {
        messages.put("show.not.empty.row.col", "There is already a mark here.");
        messages.put("show.invalid.user.input", "Invalid input.");
        messages.put("show.invalid.row.user.input", "Invalid row input.");
        messages.put("show.invalid.col.user.input", "Invalid column input.");
        messages.put("show.wrong.move", "You cannot move here.");
        messages.put("show.wrong.beat", "You cannot beat this pawn.");
        messages.put("show.wrong.name.input", "Name is already exists. Try different name.");
        messages.put("show.string.to.long", "Put single letter only.");
        messages.put("show.digit.in.string", "You cannot put digit here.");
        messages.put("show.try.again", "Try again.");
    }

    public static String getMessage(String key) {
        return messages.get(key);
    }
}
