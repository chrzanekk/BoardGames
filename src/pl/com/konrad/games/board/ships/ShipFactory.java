package pl.com.konrad.games.board.ships;

public interface ShipFactory {
    Ship horizontalShip(int row, int col);
    Ship verticalShip(int row, int col);
}
