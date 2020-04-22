package pl.com.konrad.games.board;

public interface GameBoard {
    Figure[][] getGameBoard();
    Figure getPosition(int row, int col);
    int getLength();
    void setup();

}
