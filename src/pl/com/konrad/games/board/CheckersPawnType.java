package pl.com.konrad.games.board;

public enum CheckersPawnType {
    MEN("men"),
    KING("KING");
    private final String type;

    CheckersPawnType(String type) {
        this.type = type;
    }

    String type() {
        return type;
    }
}
