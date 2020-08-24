package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.Color;
import pl.com.konrad.games.board.Figure;
import pl.com.konrad.games.board.Player;

import java.util.Map;
//statek musi sie skladac z figur
public class ShipsFigure extends Figure {

    public ShipsFigure(Color color, int currentRow, int currentCol, Player player) {
        super(color, currentRow, currentCol, player);
    }


}
