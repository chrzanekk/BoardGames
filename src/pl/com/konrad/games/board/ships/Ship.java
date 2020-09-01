package pl.com.konrad.games.board.ships;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private int numberOfMasts;
    private List<Mast> masts = new ArrayList<>();

    public Ship(int numberOfMasts) {
        this.numberOfMasts = numberOfMasts;
    }



    public int getNumberOfMasts() {
        return numberOfMasts;
    }

    public List<Mast> getShip() {
        return masts;
    }
}
