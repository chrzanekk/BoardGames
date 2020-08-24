package pl.com.konrad.games.board.chess;

import pl.com.konrad.games.board.Game;
import pl.com.konrad.games.board.GameText;
import pl.com.konrad.games.board.Validator;
import pl.com.konrad.games.board.ValidatorWarning;

import java.util.Scanner;

public class ChessGame implements Game {
    @Override
    public void play() {
    }


    public String getUserName(Scanner scanner, Validator validator,
                              String playerDescription, String existingName) {
        String name;
        boolean shouldInputNameAgain = true;
        do {
            System.out.println(GameText.getMessage("show.input.name", playerDescription));
            name = scanner.next();
            if (!validator.isNameDuplicated(existingName, name)) {
                shouldInputNameAgain = false;
            } else {
                System.out.println(ValidatorWarning.getMessage("show.wrong.name.input"));
                System.out.println(ValidatorWarning.getMessage("show.try.again"));
            }
        } while (shouldInputNameAgain);
        return name;
    }
}
