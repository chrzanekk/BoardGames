package pl.com.konrad.games.board;

public class GameMenuItem {
    private int index;
    private String description;

    public GameMenuItem(int index, String description) {
        this.index = index;
        this.description = description;
    }

    public int getIndex() {
        return index;
    }

    public String getDescription() {
        return description;
    }
}
