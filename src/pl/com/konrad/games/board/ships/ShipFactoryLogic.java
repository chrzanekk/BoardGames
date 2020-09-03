package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.Color;
import pl.com.konrad.games.board.Player;

import java.util.List;

public class ShipFactoryLogic implements ShipFactory {
    private int row;
    private int col;
    private final int shipSize;
    private Color color;
    private Player player;
    private ShipGameBoardMark shipGameBoardMark;
    private int gameBoardSize;
    private ShipsGameLogic shipsGameLogic;
    private List<Mast> masts;

    public ShipFactoryLogic(int row, int col, int shipSize, Color color, Player player,
                            ShipGameBoardMark shipGameBoardMark, int gameBoardSize, ShipsGameLogic shipsGameLogic) {
        this.row = row;
        this.col = col;
        this.shipSize = shipSize;
        this.color = color;
        this.player = player;
        this.shipGameBoardMark = shipGameBoardMark;
        this.gameBoardSize = gameBoardSize;
        this.shipsGameLogic = shipsGameLogic;
    }

    @Override
    public Ship horizontalShip() {
        for (int i = 0; i < shipSize; i++) {
            masts.add(new Mast(color, row, col, player, shipGameBoardMark));
            row++;
        }
        return new Ship(masts);
    }

    @Override
    public Ship verticalShip() {
        for (int i = 0; i < shipSize; i++) {
            if (gameBoardSize - col > shipSize && shipsGameLogic.isPlaceToPutMast(row, col)) {
                masts.add(new Mast(color, row, col, player, shipGameBoardMark));
                col++;
            } else {
                break;
            }
        }
        return new Ship(masts);
    }
}
