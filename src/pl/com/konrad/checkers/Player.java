package pl.com.konrad.checkers;

public class Player {
    final private int index;
    private String name;

    public Player(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
