package pl.com.konrad.games.board;

public final class Figure {
    private final CheckersPawnType type;
    private final GameBoardMark mark;
    private final Color color;
    private final int currentRow;
    private final int currentCol;

    public Figure(CheckersPawnType type, GameBoardMark mark, Color color, int currentRow, int currentCol) {
        this.type = type;
        this.mark = mark;
        this.color = color;
        this.currentRow = currentRow;
        this.currentCol = currentCol;
    }

    public CheckersPawnType getType() {
        return type;
    }

    public GameBoardMark getMark() {
        return mark;
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




}
