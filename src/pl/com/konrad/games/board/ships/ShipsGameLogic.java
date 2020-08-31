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
    private List<Ship> fleet;

    public ShipsGameLogic(List<Ship> fleet) {
        this.fleet = fleet;
    }



    void addFigure (Player player, ShipGameBoardMark shipGameBoardMark, Color color, int row, int col) {
//dopisac dodawanie figury, jeszcze nie wiem jak to bedzie wygladac
    }

//    schemat metod do sprawdzania rozstawienia statkow - zanim napisze musze rozwiazac problem parametru
//    konstruktora klasy ShipsGameLogic.
    boolean isMastHavePlace(int row, int col) {
        return true;
    }

    boolean isMastAreSideWays(int row, int col) {
        return true;
    }

    boolean isMastTouchByCorners(int row, int col) {
        return true;
    }

}
