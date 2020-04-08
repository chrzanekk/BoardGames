package pl.com.konrad.checkers;

public class Figure {
    private String description;


    public Figure(String description) {
        this.description = description;

    }

    public String getDescription() {
        return description;
    }

    public char[][] move(int newRow, int newCol) {
        return new char[newRow][newCol];
    }

}
