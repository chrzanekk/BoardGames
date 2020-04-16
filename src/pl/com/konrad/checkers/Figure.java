package pl.com.konrad.checkers;

public class Figure {
    private String type;
    private char mark;
    private String color;
    private int currentRow;
    private int currentCol;

    public Figure(String type, char mark, String color, int currentRow, int currentCol) {
        this.type = type;
        this.mark = mark;
        this.color = color;
        this.currentRow = currentRow;
        this.currentCol = currentCol;
    }

    public String getType() {
        return type;
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


    public char[][] move(int newRow, int newCol) {
        return new char[newRow][newCol];
    }

}
