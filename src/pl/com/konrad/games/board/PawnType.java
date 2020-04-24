package pl.com.konrad.games.board;

public enum PawnType {
    MEN("men"),
    KING("KING");
    private final String type;

    PawnType(String type) {
        this.type = type;
    }

    String type() {
        return type;
    }
}
