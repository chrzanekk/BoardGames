package pl.com.konrad.games.board.checkers;



import pl.com.konrad.games.board.GameBoard;
import pl.com.konrad.games.board.Player;

import java.util.List;

//lista figur w logice + operacje na figurach(sprawdzanie itp)
public class CheckersGameLogic {
    private List<CheckersFigure> figures;

    public CheckersGameLogic(List<CheckersFigure> figures) {
        this.figures = figures;
    }

    // check is figure exist in position used both if user choose pawn and if user choose place to move
    boolean isFigureExistByRowCol(int row, int col) {
        for (CheckersFigure figure : figures) {
            if (figure.getCurrentRow() == row && figure.getCurrentCol() == col && figure.getColor() != null)
                return true;
        }
        return false;
    }

    boolean isFigureBelongToPlayer(int row, int col,
                                   String currentPlayerName) {
        for (CheckersFigure figure : figures) {
            if (currentPlayerName.equals(figure.getPlayer().getName()) && figure.getCurrentRow() == row && figure.getCurrentCol() == col)
                return true;
        }
        return false;
    }

    //    przemyśleć czy metoda poniżej ma w ogóle sens.
    boolean isPlayerCanMovePawn(Player currentPlayer, Player playerOne, Player playerTwo, int row, int col) {
        return isPlayerCanMovePawnBottom(currentPlayer, playerOne, row, col) || isPlayerCanMovePawnTop(currentPlayer,
                playerTwo, row, col);
    }

    boolean isPlayerCanMovePawnBottom(Player currentPlayer, Player playerOne, int row, int col) {
        return currentPlayer.equals(playerOne) && checkForPlaceToMoveBottom(row, col);
    }

    boolean isPlayerCanMovePawnTop(Player currentPlayer, Player playerTwo, int row, int col) {
        return currentPlayer.equals(playerTwo) && checkForPlaceToMoveTop(row, col);
    }

    boolean checkForPlaceToMoveBottom(int userRow, int userCol) {
        if (userRow == figures.size())
            return false;
        else if (userRow < figures.size() && userCol == 0) {
            return !CheckersPlayerLogic.isFigureExistByRowCol(figures, userRow + 1, userCol + 2);
        } else if (userRow < figures.size() && userCol == figures.size() - 1) {
            return (!CheckersPlayerLogic.isFigureExistByRowCol(figures, userRow + 1, userCol - 2));
        } else {
            return ((!CheckersPlayerLogic.isFigureExistByRowCol(figures, userRow + 1, userCol - 1)) || !CheckersPlayerLogic.isFigureExistByRowCol(figures, userRow + 1, userCol + 1));
        }
    }

    boolean checkForPlaceToMoveTop(int userRow, int userCol) {
        if (userRow == 0)
            return false;
        else if (userRow < 0 && userCol == 0) {
            return !CheckersPlayerLogic.isFigureExistByRowCol(figures, userRow - 1, userCol + 2);
        } else if (userRow < 0 && userCol == figures.size() - 1) {
            return (!CheckersPlayerLogic.isFigureExistByRowCol(figures, userRow - 1, userCol - 2));
        } else {
            return ((!CheckersPlayerLogic.isFigureExistByRowCol(figures, userRow - 1, userCol - 1)) || !CheckersPlayerLogic.isFigureExistByRowCol(figures, userRow - 1, userCol + 1));
        }
    }

    void changeFigureType(int userRow, int userCol, GameBoard gameBoard, Player currentPlayer) {
        if (userRow == gameBoard.getLength()) {
            figures.remove(getFigureByRowCol(userRow,userCol));
//            figures.add(new CheckersFigure(currentPlayer.getColor(),userRow,userCol,currentPlayer,));
//dopisac metody pobierajace pola z figury po koordynatach.
        }
    }

    CheckersFigure getFigureByRowCol(int row, int col) {
        for (CheckersFigure figure : figures) {
            if (figure.getCurrentRow() == row && figure.getCurrentCol() == col) {
                return new CheckersFigure(figure.getColor(), row, col, figure.getPlayer(), figure.getType(), figure.getMark());
            }
        }
        return null;
    }

}







