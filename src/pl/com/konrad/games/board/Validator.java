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

    public boolean validateRowColInput(int userChoice, GameBoard gameBoard) {
        return userChoice < ZERO || userChoice > gameBoard.getLength();
    }

    public void validateCorrectRowColInput(int userInput, CheckersGameBoard checkersGameBoard) throws InvalidParameterValueException,
            InputMismatchException {
        if (userInput < ZERO || userInput > checkersGameBoard.getLength()) {
            throw new InvalidParameterValueException();
        }
    }



    // ten walidator rozbuduję o poniższe metody sprawdzania poprawnosci ruchu i bicia gracza.
    public void validateMoveBeat(int userRow, int userCol, CheckersGameBoard checkersGameBoard) {

    }

    private boolean isInputRowCorrect(int currentRow, int userRow, CheckersGameBoard checkersGameBoard) {
        return currentRow != userRow && userRow > ZERO && userRow < checkersGameBoard.getLength();
    }

    private boolean isInputColCorrect(int currentCol, int userCol, CheckersGameBoard checkersGameBoard) {
        return currentCol != userCol && userCol > ZERO && userCol < checkersGameBoard.getLength();
    }

    private boolean isTopPlayerMoveDown(int currentRow, int userRow, CheckersGameBoard checkersGameBoard) {
        return currentRow < userRow && userRow< checkersGameBoard.getLength();
    }

    private boolean isBottomPlayerMoveUp(int currentRow, int userRow) {
        return currentRow > userRow && userRow >ZERO;
    }

    private boolean isTopPlayerMoveDiagonal(int currentRow, int userRow, int currentCol, int userCol,
                                            CheckersGameBoard checkersGameBoard) {
        return currentCol != userCol && userCol > ZERO && userCol < checkersGameBoard.getLength() && isTopPlayerMoveDown(currentRow,userRow, checkersGameBoard);
    }

    private boolean isBottomPlayerMoveDiagonal(int currentRow, int userRow, int currentCol, int userCol,
                                               CheckersGameBoard checkersGameBoard) {
        return currentCol != userCol && userCol > ZERO && userCol < checkersGameBoard.getLength() && isBottomPlayerMoveUp(currentRow,userRow);
    }

    public boolean validateGameMenuInput(int userMenuChoice)  {
        return userMenuChoice<GameBoardDimension.SIZE_3X3.size() || userMenuChoice > GameBoardDimension.SIZE_5X5.size();
    }

    public void validateCorrectRowColInput(short userInput, int boardSize) throws InvalidParameterValueException, InputMismatchException {
        if (userInput < ZERO || userInput > boardSize) {
            throw new InvalidParameterValueException();
        }
    }

}
