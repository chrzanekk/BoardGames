package pl.com.konrad.checkers;

import java.util.ArrayList;

public class CheckersPlayer extends Player{
    private static final ArrayList<Figure> figureSet = new ArrayList<Figure>();
    private char playerPawn;

    public CheckersPlayer(String name, char playerPawn) {
        super(name, figureSet);
        this.playerPawn = playerPawn;
    }

    public char getPlayerPawn() {
        return playerPawn;
    }
}
