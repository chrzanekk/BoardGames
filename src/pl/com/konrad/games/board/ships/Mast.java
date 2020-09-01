package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.Color;
import pl.com.konrad.games.board.Figure;
import pl.com.konrad.games.board.Player;


public class Mast extends Figure {
    private ShipGameBoardMark mast;

    public Mast(Color color, int currentRow, int currentCol, Player player, ShipGameBoardMark mast) {
        super(color, currentRow, currentCol, player);
        this.mast = mast;
    }

    public ShipGameBoardMark getMast() {
        return mast;
    }

}
