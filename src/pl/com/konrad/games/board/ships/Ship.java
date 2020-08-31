package pl.com.konrad.games.board.ships;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private ShipsMast shipsMast;
    private int numberOfMasts;
    private List<ShipsMast> masts = new ArrayList<>();

    public Ship(ShipsMast shipsMast, int numberOfMasts) {
        this.shipsMast = shipsMast;
        this.numberOfMasts = numberOfMasts;
    }

    public ShipsMast getShipsMast() {
        return shipsMast;
    }

    public int getNumberOfMasts() {
        return numberOfMasts;
    }

    public List<ShipsMast> getMasts() {
        return masts;
    }
}
