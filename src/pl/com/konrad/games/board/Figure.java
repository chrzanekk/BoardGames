package pl.com.konrad.games.board;

public final class Figure {
    private final String description;
    private final char mark;
    private final String color;
    private final int currentRow;
    private final int currentCol;

    public Figure(String description, char mark, String color, int currentRow, int currentCol) {
        this.description = description;
        this.mark = mark;
        this.color = color;
        this.currentRow = currentRow;
        this.currentCol = currentCol;
    }

    public String getDescription() {
        return description;
    }

    public char getMark() {
        return mark;
    }

    public String getColor() {
        return color;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }


    public Figure move(int newRow, int newCol) {
        return new Figure(this.description, this.mark, this.color, newRow, newCol);
        //brakuje usuniecia starego obiektu?

    }

}
