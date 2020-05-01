package pl.com.konrad.games.board;

import java.util.InputMismatchException;

public class TicTacToeValidator {
    public static final int MENU_OPTION_SIZE_3X3 = 1;
    public static final int MENU_OPTION_EXIT = 4;
    public static final int ZERO = 0;


    public boolean validateGameMenuInput(int userMenuChoice)  {
        return userMenuChoice<MENU_OPTION_SIZE_3X3 || userMenuChoice > MENU_OPTION_EXIT;
    }

    public void validateCorrectRowColInput(short userInput, int boardSize) throws InvalidParameterValueException, InputMismatchException {
        if (userInput < ZERO || userInput > boardSize) {
            throw new InvalidParameterValueException();
        }
    }
}
