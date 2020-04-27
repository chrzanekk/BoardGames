package pl.com.konrad.games.board;

import java.util.InputMismatchException;

/*
to do:
- walidacja wyboru menu
- walidacja wprowadzenia nazwy gracza
- walidacja ruchu
- walidacja wprowadzania pozycji pionka gracza(ruch)
- walidacja bicia(zabezpieczyc przed "przeskakiwaniem" swoich pionkow)

 */
public class Validator {

    public boolean validateMainMenuOption(int userChoice) {
        return userChoice < GameMenuOption.CHECKERS.value() || userChoice > GameMenuOption.EXIT.value();
    }

    public boolean isNameDuplicated(String existingName, String newName) {
        return existingName != null && existingName.equals(newName);
    }

    public void validateCorrectRowColInput(int userInput, int boardSize) throws InvalidParameterValueException,
            InputMismatchException {
        if (userInput < 0 || userInput> boardSize) {
            throw new InvalidParameterValueException();
        }
    }
    // ten walidator rozbuduję o poniższe metody sprawdzania poprawnosci ruchu i bicia gracza.
    public void validateMoveBeat(int userRow, int userCol, int boardSize) {

    }

    private boolean isInputRowCorrect(int row) {
        return true;
    }

    private boolean isInputColCorrect(int col) {
        return true;
    }

    private boolean isTopPlayerMoveDown() {
        return true;
    }

    private boolean isBottomPlayerMoveUp() {
        return true;
    }

    private boolean isTopPlayerMoveDiagonal() {
        return true;
    }

    private boolean isBottomPlayerMoveDiagonal() {
        return true;
    }

}
