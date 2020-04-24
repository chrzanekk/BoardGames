package pl.com.konrad.games.board;

public final class Figure {
    private final PawnType type;
    private final GameBoardMark mark;
    private final Colors color;
    private final int currentRow;
    private final int currentCol;

    public Figure(PawnType type, GameBoardMark mark, Colors color, int currentRow, int currentCol) {
        this.type = type;
        this.mark = mark;
        this.color = color;
        this.currentRow = currentRow;
        this.currentCol = currentCol;
    }

    public PawnType getType() {
        return type;
    }

    public GameBoardMark getMark() {
        return mark;
    }

    public Colors getColor() {
        return color;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }


// move -> GameLogic
//    public Figure move(int newRow, int newCol) {
//        return new Figure(this.type, this.mark, this.color, newRow, newCol);
//    }

}
