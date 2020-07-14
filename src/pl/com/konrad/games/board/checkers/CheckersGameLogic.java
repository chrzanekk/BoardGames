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
        CheckersFigure figure = getFigureByRowCol(userRow, userCol);
        if (figure == null) {
            return false;
        } else if (figure.getColor() != null) {
            return true;
        } else {
            return false;
        }
    }

    boolean isFigureIsProhibited(int userRow, int userCol) {
        CheckersFigure figure = getFigureByRowCol(userRow, userCol);
        if (figure == null) {
            return false;
        } else if (figure.getColor() == null && figure.getMark() != null) {
            return true;
        } else {
            return false;
        }
    }

    boolean isFigureBelongToPlayer(int userRow, int userCol,
                                   String currentPlayerName) {
        CheckersFigure figure = getFigureByRowCol(userRow, userCol);
        if (figure == null) {
            return false;
        } else if (figure.getPlayer() == null) {
            return false;
        } else if (figure.getPlayer().getName().equals(currentPlayerName)) {
            return true;
        } else {
            return false;
        }
    }

    boolean isPlayerCanMovePawn(Player currentPlayer, Player playerOne, Player playerTwo, int userRow, int userCol,
                                int gameBoardSize) {
        if (currentPlayer.equals(playerOne)) {
            return checkForPlaceToMoveBottom(userRow, userCol, gameBoardSize);
        } else {
            return checkForPlaceToMoveTop(userRow, userCol, gameBoardSize);
        }
    }

//    przemyslec zmodyfikowanie ponizszych podobnych metod w kilka potrzebnych z "modifkatorem sprawdzania".

    boolean checkForPlaceToMoveBottom(int userRow, int userCol, int gameBoardSize) {
        if (userRow == gameBoardSize) {
            return false;
        } else if (isBottomLeftSideOfBoardForMove(userRow, userCol, gameBoardSize)) {
            return isFigureExistByRowCol(userRow + 1, userCol + 1);
        } else if (isBottomRightSideOfBoardForMove(userRow, userCol, gameBoardSize)) {
            return isFigureExistByRowCol(userRow + 1, userCol - 1);
        } else {
            return ((isFigureExistByRowCol(userRow + 1, userCol - 1)) || isFigureExistByRowCol(userRow + 1, userCol + 1));
        }
    }

    private boolean isBottomRightSideOfBoardForMove(int userRow, int userCol, int gameBoardSize) {
        return userRow < gameBoardSize && userCol == gameBoardSize;
    }

    private boolean isBottomLeftSideOfBoardForMove(int userRow, int userCol, int gameBoardSize) {
        return userRow < gameBoardSize && userCol == 0;
    }

    boolean checkForPlaceToMoveTop(int userRow, int userCol, int gameBoardSize) {
        if (userRow == 0)
            return false;
        else if (isTopLeftSideOfBoard(userRow, userCol)) {
            return !isFigureExistByRowCol(userRow - 1, userCol + 1);
        } else if (isTopRightSideOfBoard(userRow, userCol, gameBoardSize)) {
            return (!isFigureExistByRowCol(userRow - 1, userCol - 1));
        } else {
            return ((!isFigureExistByRowCol(userRow - 1, userCol - 1)) || !isFigureExistByRowCol(userRow - 1, userCol + 1));
        }
    }

    private boolean isTopRightSideOfBoard(int userRow, int userCol, int gameBoardSize) {
        return userRow > 0 && userCol == gameBoardSize;
    }

    private boolean isTopLeftSideOfBoard(int userRow, int userCol) {
        return userRow > 0 && userCol == 0;
    }
// przemyslec dodanie sprawdzenia czy bicie jest nad figura a nie nad pustym polem.
    private boolean checkForPlaceToCapturePawnBottom(int userCurrentRow, int userCurrentCol, int gameBoardSize, String currentPlayerName) {
        if (userCurrentRow + 1 == gameBoardSize) {
            return false;
        } else if (checkForBottomLeftSide(userCurrentRow, userCurrentCol, gameBoardSize)) {
            return checkForCaptureLeftSide(userCurrentRow, userCurrentCol, currentPlayerName);
        } else if (checkForBottomRightSide(userCurrentRow, userCurrentCol, gameBoardSize)) {
            return checkForCaptureRightSide(userCurrentRow, userCurrentCol, currentPlayerName);
        } else {
            return !isFigureExistByRowCol(userCurrentRow + 2, userCurrentCol - 2) || isFigureExistByRowCol(userCurrentRow + 2, userCurrentCol - 2);
        }
    }

    private boolean checkForCaptureLeftSide(int userCurrentRow, int userCurrentCol, String currentPlayerName) {
        return !isFigureExistByRowCol(userCurrentRow + 2, userCurrentRow + 2) && !isFigureBelongToPlayer(userCurrentRow+1,userCurrentCol+1,currentPlayerName);
    }

    private boolean checkForBottomLeftSide(int userCurrentRow, int userCurrentCol, int gameBoardSize) {
        return userCurrentRow + 2 < gameBoardSize && userCurrentCol == 0;
    }

    private boolean checkForBottomRightSide(int userCurrentRow, int userCurrentCol, int gameBoardSize) {
        return userCurrentRow + 2 < gameBoardSize && userCurrentCol == gameBoardSize;
    }

    private boolean checkForCaptureRightSide(int userCurrentRow, int userCurrentCol, String currentPlayerName) {
        return !isFigureExistByRowCol(userCurrentRow + 2, userCurrentCol - 2) && !isFigureBelongToPlayer(userCurrentRow+1,userCurrentCol-1,currentPlayerName);
    }


    //in developmnet - maybe not working at all.
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







