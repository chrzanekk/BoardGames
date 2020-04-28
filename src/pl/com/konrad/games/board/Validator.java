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

    public static final int ZERO = 0;

    public boolean validateMainMenuOption(int userChoice) {
        return userChoice < GameMenuOption.CHECKERS.value() || userChoice > GameMenuOption.EXIT.value();
    }

    public boolean isNameDuplicated(String existingName, String newName) {
        return existingName != null && existingName.equals(newName);
    }

    public void validateCorrectRowColInput(int userInput, CheckerGameBoard checkerGameBoard) throws InvalidParameterValueException,
            InputMismatchException {
        if (userInput < 0 || userInput > checkerGameBoard.getLength()) {
            throw new InvalidParameterValueException();
        }
    }

    // ten walidator rozbuduję o poniższe metody sprawdzania poprawnosci ruchu i bicia gracza.
    public void validateMoveBeat(int userRow, int userCol, CheckerGameBoard checkerGameBoard) {

    }

    private boolean isInputRowCorrect(int currentRow, int userRow, CheckerGameBoard checkerGameBoard) {
        return currentRow != userRow && userRow > ZERO && userRow < checkerGameBoard.getLength();
    }

    private boolean isInputColCorrect(int currentCol, int userCol, CheckerGameBoard checkerGameBoard) {
        return currentCol != userCol && userCol > ZERO && userCol < checkerGameBoard.getLength();
    }

    private boolean isTopPlayerMoveDown(int currentRow, int userRow, CheckerGameBoard checkerGameBoard) {
        return currentRow < userRow && userRow<checkerGameBoard.getLength();
    }

    private boolean isBottomPlayerMoveUp(int currentRow, int userRow) {
        return currentRow > userRow && userRow >ZERO;
    }

    private boolean isTopPlayerMoveDiagonal(int currentRow, int userRow, int currentCol, int userCol,
                                            CheckerGameBoard checkerGameBoard) {
        return currentCol != userCol && userCol > ZERO && userCol < checkerGameBoard.getLength() && isTopPlayerMoveDown(currentRow,userRow,checkerGameBoard);
    }

    private boolean isBottomPlayerMoveDiagonal(int currentRow, int userRow, int currentCol, int userCol,
                                               CheckerGameBoard checkerGameBoard) {
        return currentCol != userCol && userCol > ZERO && userCol <checkerGameBoard.getLength() && isBottomPlayerMoveUp(currentRow,userRow);
    }

}
