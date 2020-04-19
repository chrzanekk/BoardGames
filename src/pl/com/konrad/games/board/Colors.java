package pl.com.konrad.games.board;

public enum Colors {
    WHITE("white"),
    BLACK("black");
    private final String description;

    Colors(String description) {
        this.description = description;
    }

     String Description() {
        return description;
    }
}
