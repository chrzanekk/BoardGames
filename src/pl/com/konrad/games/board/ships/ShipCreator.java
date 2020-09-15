package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.Color;
import pl.com.konrad.games.board.GameBoard;
import pl.com.konrad.games.board.Player;

import java.util.ArrayList;
import java.util.List;

public class ShipCreator implements ShipFactory {
    private final int shipSize;
    private Color color;
    private Player player;
    private ShipGameBoardMark shipGameBoardMark;
    private GameBoard gameBoard;
    private ShipsGameLogic shipsGameLogic;
    private List<Mast> masts = new ArrayList<>();

    public ShipCreator(int shipSize, Color color, Player player,
                       ShipGameBoardMark shipGameBoardMark, GameBoard gameBoard, ShipsGameLogic shipsGameLogic) {
        this.shipSize = shipSize;
        this.color = color;
        this.player = player;
        this.shipGameBoardMark = shipGameBoardMark;
        this.gameBoard = gameBoard;
        this.shipsGameLogic = shipsGameLogic;
    }

    public int getShipSize() {
        return shipSize;
    }

    @Override
    public Ship horizontalShip(int row, int col) {
        for (int i = 0; i < shipSize; i++) {
            masts.add(new Mast(color, row, col, player, shipGameBoardMark));
            col++;
        }
        return new Ship(masts);
    }

    @Override
    public Ship verticalShip(int row, int col) {
        for (int i = 0; i < shipSize; i++) {
            masts.add(new Mast(color, row, col, player, shipGameBoardMark));
            row++;
        }
        return new Ship(masts);
    }
}
