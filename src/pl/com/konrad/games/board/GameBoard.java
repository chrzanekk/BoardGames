package pl.com.konrad.games.board;

public interface GameBoard {
    char[][] getGameBoard();
    char getPosition(int row, int col);
    int getLength();
    void setup();
    void print();
}
