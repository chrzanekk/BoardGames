package pl.com.konrad.games.board.checkers;


import pl.com.konrad.games.board.Color;
import pl.com.konrad.games.board.Player;

import java.util.List;


public class CheckersGameLogic {
    private List<CheckersFigure> figures;

    public CheckersGameLogic(List<CheckersFigure> figures) {
        this.figures = figures;
    }

    // check is figure exist in position used both if user choose pawn and if user choose place to move
    boolean isFigureExistByRowCol(int userRow, int userCol) {
        CheckersFigure figure = getFigureByRowCol(userRow,userCol);
        if(figure==null) {
            return false;
        }
        else if (figure.getColor()!=null){
            return true;
        }
        else {
            return false;
        }
    }
//do poprawy - kompletnie nie działa.
    boolean isFigureBelongToPlayer(int userRow, int userCol,
                                   String currentPlayerName) {
        for (CheckersFigure figure : figures) {
            if (currentPlayerName.equals(figure.getPlayer().getName()) && figure.getCurrentRow() == userRow && figure.getCurrentCol() == userCol
            )
                return true;
        }
        return false;
    }

    //    przemyśleć czy metoda poniżej ma w ogóle sens.
    boolean isPlayerCanMovePawn(Player currentPlayer, Player playerOne, Player playerTwo, int userRow, int userCol,
                                int gameBoardSize) {
        return isPlayerCanMovePawnBottom(currentPlayer, playerOne, userRow, userCol, gameBoardSize) || isPlayerCanMovePawnTop(currentPlayer,
                playerTwo, userRow, userCol, gameBoardSize);
    }

    boolean isPlayerCanMovePawnBottom(Player currentPlayer, Player playerOne, int userRow, int userCol, int gameBoardSize) {
        return currentPlayer.equals(playerOne) && checkForPlaceToMoveBottom(userRow, userCol, gameBoardSize);
    }

    boolean isPlayerCanMovePawnTop(Player currentPlayer, Player playerTwo, int userRow, int userCol, int gameBoardSize) {
        return currentPlayer.equals(playerTwo) && checkForPlaceToMoveTop(userRow, userCol, gameBoardSize);
    }
//sprawdzić prawą stronę (dwie ostatnie kolumny się błędnie sprawdzaja)
    boolean checkForPlaceToMoveBottom(int userRow, int userCol, int gameBoardSize) {
        if (userRow == gameBoardSize) {
            return false;
        }
        else if (isBottomLeftSideOfBoard(userRow, userCol, gameBoardSize)) {
            return !isFigureExistByRowCol(userRow + 1, userCol + 1);
        } else if (isBottomRightSideOfBoard(userRow, userCol, gameBoardSize)) {
            return (!isFigureExistByRowCol(userRow + 1, userCol - 1));
        } else {
            return ((!isFigureExistByRowCol(userRow + 1, userCol - 1)) || !isFigureExistByRowCol(userRow + 1, userCol + 1));
        }
    }

    private boolean isBottomRightSideOfBoard(int userRow, int userCol, int gameBoardSize) {
        return userRow < gameBoardSize && userCol == gameBoardSize+1;
    }
//sprawdzić czy poprawny warunek.
    private boolean isBottomLeftSideOfBoard(int userRow, int userCol, int gameBoardSize) {
        return userRow < gameBoardSize && userCol == 0;
    }


    boolean checkForPlaceToMoveTop(int userRow, int userCol, int gameBoardSize) {
        if (userRow == 0)
            return false;
        else if (isTopLeftSideOfBoard(userRow, userCol)) {
            return !isFigureExistByRowCol( userRow - 1, userCol + 2);
        } else if (isTopRightSideOfBoard(userRow, userCol, gameBoardSize)) {
            return (!isFigureExistByRowCol( userRow - 1, userCol - 2));
        } else {
            return ((!isFigureExistByRowCol( userRow - 1, userCol - 1)) || !isFigureExistByRowCol(userRow - 1, userCol + 1));
        }
    }

    private boolean isTopRightSideOfBoard(int userRow, int userCol, int gameBoardSize) {
        return userRow > 0 && userCol == gameBoardSize;
    }

    private boolean isTopLeftSideOfBoard(int userRow, int userCol) {
        return userRow > 0 && userCol == 0;
    }


    void changeFigureType(int userRow, int userCol, int gameBoardLength, Player currentPlayer) {
        for (CheckersFigure figure : figures) {
            if (userRow == gameBoardLength && figure.getType() == CheckersPawnType.MEN && figure.getColor() == Color.WHITE) {
                figures.remove(getFigureByRowCol(userRow, userCol));
                figures.add(new CheckersFigure(Color.WHITE, userRow, userCol, currentPlayer, CheckersPawnType.KING,
                        CheckersGameBoardMark.WHITE_KING));
                if (userRow == 0 && figure.getType() == CheckersPawnType.MEN && figure.getColor() == Color.BLACK) {
                    figures.remove(getFigureByRowCol(userRow, userCol));
                    figures.add(new CheckersFigure(Color.BLACK, userRow, userCol, currentPlayer, CheckersPawnType.KING,
                            CheckersGameBoardMark.BLACK_KING));
                }
            }
        }
    }

    CheckersFigure getFigureByRowCol(int row, int col) {
        for (CheckersFigure figure : figures) {
            if (figure.getCurrentRow() == row && figure.getCurrentCol() == col) {
                return figure;
            }
        }
        return null;
    }
}







