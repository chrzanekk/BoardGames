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
    private List<Mast> ship;

    public ShipsGameLogic(List<Ship> fleet) {
        this.fleet = fleet;
    }

    void createShip(int numberOfMasts) {
        fleet.add(new Ship(numberOfMasts));
    }

    //    jak ograniczyc dodawanie ewentualnych kolejnych masztow do statku ponad ilosc podana? (listy sie automatycznie powiekszaja)
    void addMast(Player player, ShipGameBoardMark shipGameBoardMark, Color color, int row, int col, int numberOfMasts) {
        for (int i = 0; i < numberOfMasts; i++) {
            ship.add(new Mast(color, row, col, player, shipGameBoardMark));
        }
    }


    Mast getMastByRowCol(int row, int col) {
        for(Ship ship : fleet){
            for (Mast mast : ship.getShip()) {
                if(row==mast.getCurrentRow() && col==mast.getCurrentCol()) {
                    return mast;
                }
            }
        }
        return null;
    }


//    schemat metod do sprawdzania rozstawienia statkow.

    boolean isMastHavePlace(int row, int col) {
        return true;
    }

    boolean isMastAreSideWays(int row, int col) {
        return true;
    }

    boolean isMastTouchByCorners(int row, int col) {
        return true;
    }

    boolean isLeftFieldClear(int row,int col){
        return true;
    }

    boolean isRightSideClear(int row,int col){
        return true;
    }

    boolean isBottomSideClear(int row, int col){
        return true;
    }

    boolean isTopSideClear(int row, int col) {
        return true;
    }
    boolean isTopLeftSideClear(int row, int col) {
        return true;
    }
    boolean isTopRightSideClear(int row, int col) {
        return true;
    }
    boolean isBottomLeftSideClear(int row, int col) {
        return true;
    }
    boolean isBottomRightSideClear(int row, int col) {
        return true;
    }

}
