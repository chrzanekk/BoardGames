package pl.com.konrad.checkers;

public class Figure {
    private String name;
    private int startRow;
    private int startCol;

    public Figure(String name, int startRow, int startCol) {
        this.name = name;
        this.startRow = startRow;
        this.startCol = startCol;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public String getName() {
        return name;
    }

    public int[][] getStartPosition(int startRow, int startCol) {
        return new int[startRow][startCol];
    }

    public int[][] move(int newRow, int newCol) {
        return new int[newRow][newCol];
    }

}
