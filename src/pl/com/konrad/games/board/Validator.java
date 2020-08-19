package pl.com.konrad.games.board;

import java.util.Scanner;
import java.util.TreeMap;

/*
to do:
- walidacja wyboru menu
- walidacja wprowadzenia nazwy gracza
- walidacja ruchu
- walidacja wprowadzania pozycji pionka gracza(ruch)
- walidacja bicia(zabezpieczyc przed "przeskakiwaniem" swoich pionkow)

 */
public final class Validator {

    public static final int ZERO = 0;

    public boolean validateMainMenuOption(int userChoice) {
        return userChoice < GameMenuOption.CHECKERS.value() || userChoice > GameMenuOption.EXIT.value();
    }

    public boolean isNameDuplicated(String existingName, String newName) {
        return existingName != null && existingName.equals(newName);
    }

    public boolean validateRowColInput(int userChoice, GameBoard gameBoard) {
        return userChoice < ZERO || userChoice > gameBoard.getLength();
    }

    public boolean validateColInput(Character userChoice, TreeMap<Character, Integer> lettersAndDigits) {
        if (lettersAndDigits.containsKey(userChoice)) {
                return true;
            }
        return false;
    }

    public static String validateUserName(Scanner scanner, Validator validator,
                                           String playerParameter, String existingName) {
        String name;
        boolean shouldInputNameAgain = true;
        do {
            System.out.println(GameText.getMessage("show.input.name", playerParameter));
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
