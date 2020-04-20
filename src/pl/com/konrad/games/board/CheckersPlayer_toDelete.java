package pl.com.konrad.games.board;

import java.util.ArrayList;

public class CheckersPlayer_toDelete {
    private static ArrayList<Figure> figureSet = new ArrayList<Figure>();
    private char playerPawn;

    public CheckersPlayer_toDelete(char playerPawn) {

        this.playerPawn = playerPawn;
    }

    public char getPlayerPawn() {
        return playerPawn;
    }
}
