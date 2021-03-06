package pl.com.konrad.games.board.tictactoe;

import pl.com.konrad.games.board.GameBoard;
import pl.com.konrad.games.board.GameBoardDimension;

class TicTacToeGameBoard implements GameBoard {

    private char gameBoard[][];
    private TicTacToePlayer playerOne;
    private TicTacToePlayer playerTwo;
    private GameBoardDimension gameBoardDimension;

    TicTacToeGameBoard(TicTacToePlayer playerOne, TicTacToePlayer playerTwo, GameBoardDimension gameBoardDimension) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.gameBoardDimension = gameBoardDimension;
        gameBoard = new char[gameBoardDimension.size()][gameBoardDimension.size()];
        setup();
        print();
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

    @Override
    public void setup() {

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                gameBoard[i][j] = '-';
            }
        }
    }

    @Override
    public void print() {

        int verticalIndex = 1;

        for (int row = 0; row < gameBoard.length; row++) {
            printHorizontalLine();
            System.out.print("|");
            for (int col = 0; col < gameBoard.length; col++) {
                if (isFigureByRowCol(row, col, playerOne)) {
                    System.out.print(" " + playerOne.getPlayerMark().mark() + " |");
                } else if (isFigureByRowCol(row, col, playerTwo)) {
                    System.out.print(" " + playerTwo.getPlayerMark().mark() + " |");
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
        int horizontalIndex = 1;
        for (int underRow = 0; underRow < gameBoard.length; underRow++) {
            System.out.print("  " + horizontalIndex + " ");
            horizontalIndex++;
        }
        System.out.println();
    }

    private boolean isFigureByRowCol(int row, int col, TicTacToePlayer player) {
        return TicTacToeGameLogic.isFigureExistByRowCol(player, row, col, gameBoard);
    }

}

