package pl.com.konrad.games.board.chess;

import pl.com.konrad.games.board.GameBoard;

public class ChessGameBoard implements GameBoard {
    private char[][] gameBoard;


    public ChessGameBoard() {

    }
    @Override
    public void setup(){}

    @Override
    public void print() {

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
}
