package pl.com.konrad.games.board.ships;


import pl.com.konrad.games.board.Color;
import pl.com.konrad.games.board.Player;

import java.util.List;

public class Ship {
    private List<Mast> masts;

    public Ship(List<Mast> masts) {
        this.masts = masts;
    }

    public int getNumberOfMasts() {
        return masts.size();
    }

    public List<Mast> getMasts() {
        return masts;
    }



}
//https://devcave.pl/effective-java/wzorzec-projektowy-builder
//https://javadeveloper.pl/wzorzec-projektowy-fabryka/