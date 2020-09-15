package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.GameBoard;
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

    Mast putMastInPlayerCheckBoard(int row, int col, Player player){
        return new Mast(null, row, col, player, ShipGameBoardMark.NOT_CHECKED);
    }

    boolean isMastExists(int row, int col) {
        if (getMastByRowCol(row, col) == null) {
            return false;
        }
        return true;
    }

    boolean isMastsCollideForHorizontal(int row,int col,int shipSize, GameBoard gameBoard){
        if(gameBoard.getLength() - col >= shipSize && isPlaceToPutMast(row, col, gameBoard)){
            return false;
        }
        return true;
    }

    boolean isMastsCollideForVertical(int row,int col,int shipSize, GameBoard gameBoard){
        if(gameBoard.getLength() - row >= shipSize && isPlaceToPutMast(row, col, gameBoard)){
            return false;
        }
        return true;
    }

    boolean isPlaceToPutMast(int row, int col, GameBoard gameBoard) {
        if (row == 0 && col == 0) {
            return isPlaceTopLeftCorner(row, col);
        } else if (row == 0 && col > 0 && col < gameBoard.getLength()) {
            return isPlaceTopEdge(row, col);
        } else if (row == 0 && col == gameBoard.getLength()) {
            return isPlaceTopRightCorner(row, col);
        } else if (row > 0 && row < gameBoard.getLength() && col == 0) {
            return isPlaceLeftEdge(row, col);
        } else if (row > 0 && row < gameBoard.getLength() && col > 0 && col < gameBoard.getLength()) {
            return isPlaceMiddle(row, col);
        } else if (row > 0 && row < gameBoard.getLength() && col == gameBoard.getLength()) {
            return isPlaceRightEdge(row, col);
        } else if (row == gameBoard.getLength() && col == 0) {
            return isPlaceBottomLeftCorner(row, col);
        } else if (row == gameBoard.getLength() && col > 0 && col < gameBoard.getLength()) {
            return isPlaceBottomEdge(row, col);
        } else
            return isPlaceBottomRightCorner(row, col);
    }

    boolean checkPlaceForVerticalShip(int row, int col, int shipSize, GameBoard gameBoard) {
        for (int i = row; i <= shipSize; i++) {
            if (!isPlaceToPutMast(i, col, gameBoard)) {
                return false;
            }
        }
        return true;
    }

    boolean checkPlaceForHorizontalShip(int row, int col, int shipSize, GameBoard gameBoard) {
        for (int i = col; i <= shipSize; i++) {
            if (!isPlaceToPutMast(row, i, gameBoard)) {
                return false;
            }
        }
        return true;
    }


    //    lewy gorny rog
    private boolean isPlaceTopLeftCorner(int row, int col) {
        for (int i = 0; i <= row + 1; i++) {
            for (int j = 0; j <= col + 1; j++) {
                if ((i == row) && (j == col)) {
                    continue;
                }
                if (isMastExists(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    //    lewy dolny rog
    private boolean isPlaceBottomLeftCorner(int row, int col) {
        for (int i = row - 1; i <= row; i++) {
            for (int j = 0; j <= col + 1; j++) {
                if ((i == row) && (j == col)) {
                    continue;
                }
                if (isMastExists(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    //    prawy gorny rog
    private boolean isPlaceTopRightCorner(int row, int col) {
        for (int i = 0; i <= row + 1; i++) {
            for (int j = col - 1; j <= col; j++) {
                if ((i == row) && (j == col)) {
                    continue;
                }
                if (isMastExists(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    //    prawy dolny rog
    private boolean isPlaceBottomRightCorner(int row, int col) {
        for (int i = row - 1; i <= row; i++) {
            for (int j = col - 1; j <= col; j++) {
                if ((i == row) && (j == col)) {
                    continue;
                }
                if (isMastExists(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

//    prawy srodek

    private boolean isPlaceRightEdge(int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col; j++) {
                if ((i == row) && (j == col)) {
                    continue;
                }
                if (isMastExists(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
//    lewy srodek

    private boolean isPlaceLeftEdge(int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = 0; j <= col + 1; j++) {
                if ((i == row) && (j == col)) {
                    continue;
                }
                if (isMastExists(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    //    gorny srodek
    private boolean isPlaceTopEdge(int row, int col) {
        for (int i = 0; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if ((i == row) && (j == col)) {
                    continue;
                }
                if (isMastExists(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    //    dolny srodek
    private boolean isPlaceBottomEdge(int row, int col) {
        for (int i = row - 1; i <= row; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if ((i == row) && (j == col)) {
                    continue;
                }
                if (isMastExists(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPlaceMiddle(int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if ((i == row) & (j == col)) {
                    continue;
                }
                if (isMastExists(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
