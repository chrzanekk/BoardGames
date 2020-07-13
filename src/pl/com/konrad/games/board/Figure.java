package pl.com.konrad.games.board;


public class Figure {
    private final Color color;
    private final int currentRow;
    private final int currentCol;
    private final Player player;

    public Figure(Color color, int currentRow, int currentCol,
                  Player player) {
        this.color = color;
        this.currentRow = currentRow;
        this.currentCol = currentCol;
        this.player = player;
    }

    public Color getColor() {
        return color;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public Player getPlayer() {
        return player;
    }
}
