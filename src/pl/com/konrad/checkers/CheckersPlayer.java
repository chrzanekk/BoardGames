package pl.com.konrad.checkers;

public class CheckersPlayer extends Player{
    private char playerPawn;

    public CheckersPlayer(String name, char playerPawn) {
        super(name, figureSet);
        this.playerPawn = playerPawn;
    }

    public char getPlayerPawn() {
        return playerPawn;
    }
}
