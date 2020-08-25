package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.Color;
import pl.com.konrad.games.board.Player;

import java.util.List;

/* to do
- sprawdzanie rozstawienia statkow (3masztowce: zasada stykajacego sie boku, niedozwolone stykanie sie rogami pola(po skosie)
- sprawdzanie czy trafienie
- sprawdzanie czy ktorys gracz wygral
- sprawdzanie czy trafiony-zatopiony czy tylko trafiony.
 */
public class ShipsGameLogic {
    private List<ShipsFigure[]> fleet;

    public ShipsGameLogic(List<ShipsFigure[]> fleet) {
        this.fleet = fleet;
    }

    void addFigure (Player player, ShipGameBoardMark shipGameBoardMark, Color color, int row, int col) {

    }

}
