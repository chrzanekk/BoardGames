package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.GameBoard;
import pl.com.konrad.games.board.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * to do
 * - sprawdzanie rozstawienia statkow (3masztowce: zasada stykajacego sie boku, niedozwolone stykanie sie rogami pola(po
 * skosie) - done
 * - sprawdzanie czy trafienie
 * - sprawdzanie czy ktorys gracz wygral
 * - sprawdzanie czy trafiony-zatopiony czy tylko trafiony.
 */
public class ShipsGameLogic {
    private List<Ship> fleet;
    private int sumOfAllMasts;


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

    Ship getShipByRowCol(int row, int col) {
        for (Ship ship : fleet) {
            for (Mast mast : ship.getMasts()) {
                if (row == mast.getCurrentRow() && col == mast.getCurrentCol()) {
                    return ship;
                }
            }
        }
        return null;
    }


    Mast createNewMast(int row, int col, Player player, ShipGameBoardMark shipGameBoardMark) {
        return new Mast(null, row, col, player, shipGameBoardMark);
    }

    void removeMast(int row, int col) {
        for (Ship ship : fleet) {
            ship.getMasts().removeIf(mast -> row == mast.getCurrentRow() && col == mast.getCurrentCol());

        }
    }

    boolean isMastExists(int row, int col) {
        if (getMastByRowCol(row, col) == null) {
            return false;
        }
        return true;
    }


    /**
     * METHODS TO CHECK SHIP DEPLOYMENT
     */


    boolean isPlaceToPutMast(int row, int col, GameBoard gameBoard) {
        if (isTopLeftCorner(row, col)) {
            return isPlaceTopLeftCorner(row, col);
        } else if (isTopMiddleEdge(row, col, gameBoard)) {
            return isPlaceTopEdge(row, col);
        } else if (isTopRightCorner(row, col, gameBoard)) {
            return isPlaceTopRightCorner(row, col);
        } else if (isLeftMiddleEdge(row, col, gameBoard)) {
            return isPlaceLeftEdge(row, col);
        } else if (isMiddleField(row, col, gameBoard)) {
            return isPlaceMiddle(row, col);
        } else if (isRightMiddleEdge(row, col, gameBoard)) {
            return isPlaceRightEdge(row, col);
        } else if (isBottomLeftCorner(row, col, gameBoard)) {
            return isPlaceBottomLeftCorner(row, col);
        } else if (isBottomMiddleEdge(row, col, gameBoard)) {
            return isPlaceBottomEdge(row, col);
        } else {
            return isPlaceBottomRightCorner(row, col);
        }
    }

    private boolean isBottomMiddleEdge(int row, int col, GameBoard gameBoard) {
        return row == gameBoard.getLength() && col > 0 && col < gameBoard.getLength();
    }

    private boolean isBottomLeftCorner(int row, int col, GameBoard gameBoard) {
        return row == gameBoard.getLength() && col == 0;
    }

    private boolean isRightMiddleEdge(int row, int col, GameBoard gameBoard) {
        return row > 0 && row < gameBoard.getLength() && col == gameBoard.getLength();
    }

    private boolean isMiddleField(int row, int col, GameBoard gameBoard) {
        return row > 0 && row < gameBoard.getLength() && col > 0 && col < gameBoard.getLength();
    }

    private boolean isLeftMiddleEdge(int row, int col, GameBoard gameBoard) {
        return row > 0 && row < gameBoard.getLength() && col == 0;
    }

    private boolean isTopRightCorner(int row, int col, GameBoard gameBoard) {
        return row == 0 && col == gameBoard.getLength();
    }

    private boolean isTopMiddleEdge(int row, int col, GameBoard gameBoard) {
        return row == 0 && col > 0 && col < gameBoard.getLength();
    }

    private boolean isTopLeftCorner(int row, int col) {
        return row == 0 && col == 0;
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
        if (isMastExists(row, col + 1)
                || isMastExists(row + 1, col)
                || isMastExists(row + 1, col + 1)) {
            return false;
        }
        return true;
    }

    //    lewy dolny rog
    private boolean isPlaceBottomLeftCorner(int row, int col) {
        if (isMastExists(row - 1, col)
                || isMastExists(row - 1, col + 1)
                || isMastExists(row, col + 1)) {
            return false;
        }
        return true;
    }

    //    prawy gorny rog
    private boolean isPlaceTopRightCorner(int row, int col) {
        if (isMastExists(row, col - 1)
                || isMastExists(row + 1, col - 1)
                || isMastExists(row + 1, col)) {
            return false;
        }
        return true;
    }

    //    prawy dolny rog
    private boolean isPlaceBottomRightCorner(int row, int col) {
        if (isMastExists(row, col - 1)
                || isMastExists(row - 1, col - 1)
                || isMastExists(row - 1, col)) {
            return false;
        }
        return true;
    }

//    prawy srodek

    private boolean isPlaceRightEdge(int row, int col) {
        if (isMastExists(row - 1, col - 1)
                || isMastExists(row - 1, col)
                || isMastExists(row, col - 1)
                || isMastExists(row + 1, col - 1)
                || isMastExists(row + 1, col)) {
            return false;
        }
        return true;
    }
//    lewy srodek

    private boolean isPlaceLeftEdge(int row, int col) {
        if (isMastExists(row - 1, col)
                || isMastExists(row - 1, col + 1)
                || isMastExists(row, col + 1)
                || isMastExists(row + 1, col)
                || isMastExists(row + 1, col + 1)) {
            return false;
        }
        return true;
    }

    //    gorny srodek
    private boolean isPlaceTopEdge(int row, int col) {
        if (isMastExists(row, col - 1)
                || isMastExists(row, col + 1)
                || isMastExists(row + 1, col - 1)
                || isMastExists(row + 1, col)
                || isMastExists(row + 1, col + 1)) {
            return false;
        }
        return true;
    }

    //    dolny srodek
    private boolean isPlaceBottomEdge(int row, int col) {
        if (isMastExists(row, col - 1)
                || isMastExists(row - 1, col - 1)
                || isMastExists(row - 1, col)
                || isMastExists(row - 1, col + 1)
                || isMastExists(row, col + 1)) {
            return false;
        }
        return true;
    }

    private boolean isPlaceMiddle(int row, int col) {
        if (isMastExists(row - 1, col - 1)
                || isMastExists(row - 1, col)
                || isMastExists(row - 1, col + 1)
                || isMastExists(row, col - 1)
                || isMastExists(row, col + 1)
                || isMastExists(row + 1, col - 1)
                || isMastExists(row + 1, col)
                || isMastExists(row + 1, col + 1)) {
            return false;
        }
        return true;
    }


    /**
     * METHODS TO CHECK SHIP HITS AND TO CHANGE STATUS ON PLAYER CHECK BOARD
     */


    boolean isPlayerLoose() {
        for (Ship ship : fleet) {
            for (Mast mast : ship.getMasts()) {
                if (!mast.getMast().equals(ShipGameBoardMark.HIT_AND_SUNK)) {
                    return false;
                }
            }
        }
        return true;
    }

    //to dziala poprawnie - zmienia statusy masztow z U na H z U na X i dodaje X u gracza na planszy ze statkami.
    void changeMastStatus(int row, int col, Player player, ShipGameBoardMark statusMark) {
        if (checkForHit(row, col)) {
            int shipIndex = fleet.indexOf(getShipByRowCol(row, col));
            removeMast(row, col);
            Ship ship = fleet.get(shipIndex);
            ship.getMasts().add(createNewMast(row, col, player, statusMark));
        } else {
            List<Mast> missedMast = new ArrayList<>();
            missedMast.add(createNewMast(row, col, player, ShipGameBoardMark.MISS));
            fleet.add(new Ship(missedMast));
        }
    }


    boolean checkShipForStatusChange(int row, int col) {
        boolean isStatusToChange = false;
        if (isMastExists(row,col)) {
            Ship ship = getShipByRowCol(row, col);
            isStatusToChange = isMastsMarkEqualsHitButNotSunk(ship);
        }
        return isStatusToChange;
    }

    private boolean isMastsMarkEqualsHitButNotSunk(Ship ship) {
        int sameMastStatusCount = 0;
        for (Mast mast : ship.getMasts()) {
            if (mast.getMast().equals(ShipGameBoardMark.HIT_BUT_NOT_SUNK)) {
                sameMastStatusCount++;
            }
        }
        if (sameMastStatusCount == ship.getNumberOfMasts()) {
            return true;
        }
        return false;
    }

    void changeShipStatusToSunk(int row, int col, Player player) {
        Ship ship = getShipByRowCol(row, col);
        ship.getMasts().replaceAll(mast -> createNewMast(mast.getCurrentRow(), mast.getCurrentCol(), player, ShipGameBoardMark.HIT_AND_SUNK));
    }

    boolean checkForHit(int row, int col) {
        if (isMastExists(row, col)) {
            return true;
        }
        return false;
    }

    //    metoda aktualizujaca checkboard gracza o zatopiony statek
    void changeShipStatusToSinkOnCheckBoard(List<Ship> oppositeFleet, Player player) {
        for (Ship ship : oppositeFleet) {
            for (Mast mast : ship.getMasts()) {
                if (mast.getMast().equals(ShipGameBoardMark.HIT_AND_SUNK)) {
                    changeShipStatusToSunk(mast.getCurrentRow(), mast.getCurrentCol(), player);
                }
            }
        }
    }
}
