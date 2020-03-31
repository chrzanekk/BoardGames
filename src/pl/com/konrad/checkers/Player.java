package pl.com.konrad.checkers;

public class Player {
    private char playerMark;
    private String name;

    public Player(char playerMark, String name) {
        this.playerMark = playerMark;
        this.name = name;
    }

    public char getPlayerMark() {
        return playerMark;
    }

    public String getName() {
        return name;
    }
}
