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


    Mast getMastByRowCol(int row, int col) {
        for (Ship ship : fleet) {
            for (Mast mast : ship.getMasts()) {
                if (row == mast.getCurrentRow() && col == mast.getCurrentCol()) {
                    return mast;
                }
            }
        }
        return null;
    }


//  flagą "prohibited" w celu uniemozliwienia postawienia tam nowego statku.

    boolean isMastExists(int row, int col) {
        if (getMastByRowCol(row, col) == null) {
            return false;
        }
        return true;
    }

    boolean isPlaceToPutMast(int row, int col){
        for (int i=0; i<3;i++){
            for (int j=0; j<3;j++) {
                if ((i==row)&&(i==col)){
                    continue;
                }
                if (getMastByRowCol(i,j)!=null){
                    return false;
                }
            }
        }
        return true;
    }
}
