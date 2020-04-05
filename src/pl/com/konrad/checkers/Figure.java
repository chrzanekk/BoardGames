package pl.com.konrad.checkers;

public class Figure {
    private String description;
    private int startRow;
    private int startCol;

    public Figure(int startCol, int startRow, String description) {
        this.description = description;
        this.startRow = startRow;
        this.startCol = startCol;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public String getDescription() {
        return description;
    }

    public char[][] move(int newRow, int newCol) {
        return new char[newRow][newCol];
    }

}
