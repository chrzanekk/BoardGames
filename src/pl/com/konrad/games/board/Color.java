package pl.com.konrad.games.board;

public enum Color {
    WHITE("white"),
    BLACK("black"),
    GRID("grid");
    private final String description;

    Color(String description) {
        this.description = description;
    }

     public String description() {
        return description;
    }
}
