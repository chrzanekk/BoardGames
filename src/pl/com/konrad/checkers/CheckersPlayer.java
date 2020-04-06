package pl.com.konrad.checkers;

public class CheckersPlayer extends Player{
    private CheckersPawn playerPawn;

    public CheckersPlayer(int index, String name, CheckersPawn playerPawn) {
        super(index, name);
        this.playerPawn = playerPawn;
    }

    public CheckersPawn getPlayerPawn() {
        return playerPawn;
    }
}
