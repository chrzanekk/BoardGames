package pl.com.konrad.checkers;

public class CheckersPlayer extends Player{
    private char playerPawn;

    public CheckersPlayer(int index, String name, char playerPawn) {
        super(index, name);
        this.playerPawn = playerPawn;
    }

    public char getPlayerPawn() {
        return playerPawn;
    }
}
