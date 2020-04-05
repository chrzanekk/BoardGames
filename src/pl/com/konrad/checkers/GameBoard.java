package pl.com.konrad.checkers;

public interface GameBoard {
    char[][] getGameBoard();
    char getPosition(int row, int col);
    int getLength();
}
