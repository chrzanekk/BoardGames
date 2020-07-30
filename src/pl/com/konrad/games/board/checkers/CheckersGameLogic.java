package pl.com.konrad.games.board.checkers;


import pl.com.konrad.games.board.Color;
import pl.com.konrad.games.board.Player;

import java.util.List;


public class CheckersGameLogic {
    private List<CheckersFigure> figures;

    public CheckersGameLogic(List<CheckersFigure> figures) {
        this.figures = figures;
    }

    CheckersFigure getFigureByRowCol(int row, int col) {
        for (CheckersFigure figure : figures) {
            if (figure.getCurrentRow() == row && figure.getCurrentCol() == col) {
                return figure;
            }
        }
        return null;
    }

    void removeFigureByRowCol(int row, int col) {
        CheckersFigure figure = getFigureByRowCol(row,col);
        figures.remove(figure);
    }

    void addFigure(Player player, CheckersPawnType checkersPawnType,
                   CheckersGameBoardMark checkersGameBoardMark, Color color, int row,
                   int col) {
        figures.add(new CheckersFigure(color, row, col, player, checkersPawnType, checkersGameBoardMark));
    }

    void movePawn(Player player, CheckersPawnType checkersPawnType,
                  CheckersGameBoardMark checkersGameBoardMark, Color color, int newRow,
                  int newCol, int oldRow, int oldCol) {
        addFigure(player,checkersPawnType,checkersGameBoardMark,color,newRow,newCol);
        removeFigureByRowCol(oldRow,oldCol);
    }

    Player swapPlayer(Player currentPlayer, Player playerOne, Player playerTwo) {
        if (currentPlayer.equals(playerOne)) {
            currentPlayer = playerTwo;
        }
        else {
            currentPlayer = playerOne;
        }
        return currentPlayer;
    }

    // check is figure exist in position used both if user choose pawn and if user choose place to move - working
    boolean isFigureExist(int userRow, int userCol) {
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
    /**
    ********************
    ****MOVE SECTION****
    ********************
    **/
    boolean isPlayerCanMovePawn(Player currentPlayer, Player playerOne, int userRow, int userCol,
                                int gameBoardSize) {
        if (currentPlayer.equals(playerOne)) {
            return checkForPlaceToMoveBottom(userRow, userCol, gameBoardSize);
        } else {
            return checkForPlaceToMoveTop(userRow, userCol, gameBoardSize);
        }
    }


    boolean checkForPlaceToMoveBottom(int userRow, int userCol, int gameBoardSize) {
        if (userRow == gameBoardSize) {
            return false;
        } else if (isBottomLeftSideOfBoardForMove(userRow, userCol, gameBoardSize)) {
            return isFigureExist(userRow + 1, userCol + 1);
        } else if (isBottomRightSideOfBoardForMove(userRow, userCol, gameBoardSize)) {
            return isFigureExist(userRow + 1, userCol - 1);
        } else {
            return ((isFigureExist(userRow + 1, userCol - 1)) || isFigureExist(userRow + 1, userCol + 1));
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
            return isFigureExist(userRow - 1, userCol + 1);
        } else if (isTopRightSideOfBoard(userRow, userCol, gameBoardSize)) {
            return (isFigureExist(userRow - 1, userCol - 1));
        } else {
            return ((isFigureExist(userRow - 1, userCol - 1)) || isFigureExist(userRow - 1, userCol + 1));
        }
    }

    private boolean isTopRightSideOfBoard(int userRow, int userCol, int gameBoardSize) {
        return userRow > 0 && userCol == gameBoardSize;
    }

    private boolean isTopLeftSideOfBoard(int userRow, int userCol) {
        return userRow > 0 && userCol == 0;
    }


    /**
    ***********************
    ****CAPTURE SECTION****
    ***********************
    **/
    boolean isPlayerCanCapturePawn(Player currentPlayer, Player playerOne, int userRow, int userCol,
                                int gameBoardSize) {
        if (currentPlayer.equals(playerOne)) {
            return checkForPlaceToCapturePawnBottom(userRow, userCol, gameBoardSize, currentPlayer.getName());
        } else {
            return checkForPlaceToCapturePawnTop(userRow, userCol, gameBoardSize, currentPlayer.getName());
        }
    }

/**
    *******************************************
    ****bottom destination - for player one****
    *******************************************
 **/
    private boolean checkForPlaceToCapturePawnBottom(int userCurrentRow, int userCurrentCol, int gameBoardSize, String currentPlayerName) {
        if (userCurrentRow + 1 == gameBoardSize) {
            return false;
        } else if (checkForBottomLeftEdge(userCurrentRow, userCurrentCol, gameBoardSize)) {
            return checkForCaptureBottomLeftSide(userCurrentRow, userCurrentCol, currentPlayerName);
        } else if (checkForBottomRightEdge(userCurrentRow, userCurrentCol, gameBoardSize)) {
            return checkForCaptureBottomRightSide(userCurrentRow, userCurrentCol, currentPlayerName);
        } else {
            return checkForCaptureBottomLeftRightSide(userCurrentRow, userCurrentCol);
        }
    }

    //    checking for capture pawn right or left diagonal
    private boolean checkForCaptureBottomLeftRightSide(int userCurrentRow, int userCurrentCol) {
        return !isFigureExist(userCurrentRow + 2, userCurrentCol + 2) ||
                !isFigureExist(userCurrentRow + 2, userCurrentCol - 2);
    }

    private boolean checkForBottomLeftEdge(int userCurrentRow, int userCurrentCol, int gameBoardSize) {
        return userCurrentRow + 2 < gameBoardSize && userCurrentCol == 0;
    }

    private boolean checkForBottomRightEdge(int userCurrentRow, int userCurrentCol, int gameBoardSize) {
        return userCurrentRow + 2 < gameBoardSize && userCurrentCol == gameBoardSize;
    }

    //    tu brakuje sprawdzania czy pionek przez który idzie bicie wogole istnieje - wiem jak to dodać, tylko nie wiem
//    jak skrócić warunek
    private boolean checkForCaptureBottomLeftSide(int userCurrentRow, int userCurrentCol, String currentPlayerName) {
        return !isFigureExist(userCurrentRow + 2, userCurrentCol + 2) &&
                !isFigureBelongToPlayer(userCurrentRow + 1, userCurrentCol + 1, currentPlayerName);
    }

    private boolean checkForCaptureBottomRightSide(int userCurrentRow, int userCurrentCol, String currentPlayerName) {
        return !isFigureExist(userCurrentRow + 2, userCurrentCol - 2) &&
                !isFigureBelongToPlayer(userCurrentRow + 1, userCurrentCol - 1, currentPlayerName);
    }

    /**
    ****************************************
    ****top destination - for player two****
    ****************************************
    **/
    private boolean checkForPlaceToCapturePawnTop(int userCurrentRow, int userCurrentCol, int gameBoardSize,
                                                  String currentPlayerName) {
        if (userCurrentRow - 1 == 0) {
            return false;
        } else if (checkForTopLeftEdge(userCurrentRow, userCurrentCol)) {
            return checkForCaptureTopLeftSide(userCurrentRow, userCurrentCol, currentPlayerName);
        } else if (checkForTopRightEdge(userCurrentRow, userCurrentCol, gameBoardSize)) {
            return checkForCaptureTopRightSide(userCurrentRow, userCurrentCol, currentPlayerName);
        } else {
            return checkForCaptureTopLeftRightSide(userCurrentRow, userCurrentCol);
        }
    }

    //    checking for capture pawn right or left diagonal
    private boolean checkForCaptureTopLeftRightSide(int userCurrentRow, int userCurrentCol) {
        return !isFigureExist(userCurrentRow - 2, userCurrentCol + 2) ||
                isFigureExist(userCurrentRow - 2, userCurrentCol - 2);
    }

    private boolean checkForTopLeftEdge(int userCurrentRow, int userCurrentCol) {
        return userCurrentRow - 2 > 0 && userCurrentCol == 0;
    }

    private boolean checkForTopRightEdge(int userCurrentRow, int userCurrentCol, int gameBoardSize) {
        return userCurrentRow - 2 > 0 && userCurrentCol == gameBoardSize;
    }

    //    tu brakuje sprawdzania czy pionek przez który idzie bicie wogole istnieje - wiem jak to dodać, tylko nie wiem
//    jak skrócić warunek
    private boolean checkForCaptureTopLeftSide(int userCurrentRow, int userCurrentCol, String currentPlayerName) {
        return !isFigureExist(userCurrentRow - 2, userCurrentCol + 2) && !isFigureBelongToPlayer(userCurrentRow - 1, userCurrentCol + 1, currentPlayerName);
    }

    private boolean checkForCaptureTopRightSide(int userCurrentRow, int userCurrentCol, String currentPlayerName) {
        return !isFigureExist(userCurrentRow - 2, userCurrentCol - 2) && !isFigureBelongToPlayer(userCurrentRow - 1, userCurrentCol - 1, currentPlayerName);
    }


    //in development - maybe not working at all.
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


}







