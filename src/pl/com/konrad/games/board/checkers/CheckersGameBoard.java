package pl.com.konrad.games.board.checkers;

import pl.com.konrad.games.board.*;


import java.util.List;

class CheckersGameBoard implements GameBoard {
    private char[][] gameBoard;
    private Player playerOne;
    private Player playerTwo;
    private CheckersGameText checkersGameText = new CheckersGameText();
    private List<CheckersFigure> figures;
    CheckersGameLogic gameLogic;


    CheckersGameBoard(Player playerOne, Player playerTwo, List<CheckersFigure> figures) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.figures = figures;
        GameBoardDimension boardDimension = GameBoardDimension.SIZE_8X8;
        gameLogic = new CheckersGameLogic(figures);
        gameBoard = new char[boardDimension.size()][boardDimension.size()];
        setup();

    }


    @Override
    public void setup() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {
                if (isaTopGameBoard(row, col)) {
                    gameLogic.addFigure(playerOne, CheckersPawnType.MEN,
                            CheckersGameBoardMark.WHITE_MEN,
                            Color.WHITE, row, col);
                }
                if (isaBottomGameBoard(row, col)) {
                    gameLogic.addFigure(playerTwo, CheckersPawnType.MEN,
                            CheckersGameBoardMark.BLACK_MEN,
                            Color.BLACK, row, col);
                }
                if (isProhibitedField(row, col)) {
                    gameLogic.addFigure(null, CheckersPawnType.PROHIBITED, CheckersGameBoardMark.PROHIBITED_FIELD, null, row, col);
                }
            }
        }
    }


    private boolean isaTopGameBoard(int row, int col) {
        return (isEvenRowOddCol(row, col) && isTopGameBoard(row)) || (isOddRowEvenCol(row, col) && isTopGameBoard(row));
    }

    private boolean isaBottomGameBoard(int row, int col) {
        return (isEvenRowOddCol(row, col) && isBottomGameBoard(row)) || (isOddRowEvenCol(row, col) && isBottomGameBoard(row));
    }

    private boolean isProhibitedField(int row, int col) {
        return (isEvenRowEvenCol(row, col) || isOddRowOddCol(row, col));
    }


    @Override
    public void print() {
        checkersGameText.getMessage("show.actual.game.board");
        int verticalIndex = 1;

        for (int row = 0; row < gameBoard.length; row++) {
            printHorizontalLine();
            System.out.print("|");
            for (int col = 0; col < gameBoard.length; col++) {
                if (gameLogic.isFigureExist(row, col) || gameLogic.isFigureIsProhibited(row,col)) {
                    System.out.print(" " + gameLogic.getFigureByRowCol(row, col).getMark().pawn() +
                            " |");
                } else System.out.print("   |");
            }
            System.out.println(verticalIndex++ + " ");
        }
        printHorizontalLine();
        printUnderRow();
    }


    private void printHorizontalLine() {
        char minus = '-';
        System.out.print(minus);
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j <= 3; j++)
                System.out.print(minus);
        }
        System.out.println();
    }

    private void printUnderRow() {
        char underRowChar = 'A';
        for (int underRow = 0; underRow < gameBoard.length; underRow++) {
            System.out.print("  " + underRowChar + " ");
            underRowChar++;
        }
        System.out.println();
    }

    private boolean isBottomGameBoard(int row) {
        return row > gameBoard.length / 2;
    }

    private boolean isTopGameBoard(int row) {
        return row < gameBoard.length / 2 - 1;
    }

    private boolean isOddRowEvenCol(int row, int col) {
        return row % 2 != 0 && col % 2 == 0;
    }

    private boolean isEvenRowOddCol(int row, int col) {
        return row % 2 == 0 && col % 2 != 0;
    }

    private boolean isEvenRowEvenCol(int row, int col) {
        return row % 2 == 0 && col % 2 == 0;
    }

    private boolean isOddRowOddCol(int row, int col) {
        return row % 2 != 0 && col % 2 != 0;
    }


    @Override
    public char[][] getGameBoard() {
        return gameBoard;
    }

    @Override
    public char getPosition(int row, int col) {
        return gameBoard[row][col];
    }

    @Override
    public int getLength() {
        return gameBoard.length;
    }


    char generateLastLetterOfColumn(char firstChar, int gameBoardLength) {
        int lastCharByInt = (int) firstChar + gameBoardLength - 1;
        return (char) lastCharByInt;
    }

}
