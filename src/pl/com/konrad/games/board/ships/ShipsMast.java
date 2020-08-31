package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.Color;
import pl.com.konrad.games.board.Figure;
import pl.com.konrad.games.board.Player;


public class ShipsMast extends Figure {
    private char mast;

    public ShipsMast(Color color, int currentRow, int currentCol, Player player, char mast) {
        super(color, currentRow, currentCol, player);
        this.mast = mast;
    }
}
