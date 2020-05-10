package pl.com.konrad.games.board;

public enum Color {
    WHITE("white"),
    BLACK("black");
    private final String description;

    Color(String description) {
        this.description = description;
    }

     String Description() {
        return description;
    }
}