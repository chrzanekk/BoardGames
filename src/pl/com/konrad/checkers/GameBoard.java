package pl.com.konrad.checkers;

public interface GameBoard {
    Figure[][] getGameBoard();
    Figure getPosition(int row, int col);
    int getLength();
    void setup();
}
