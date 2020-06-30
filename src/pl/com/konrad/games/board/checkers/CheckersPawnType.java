package pl.com.konrad.games.board.checkers;

enum CheckersPawnType {
    MEN("MEN"),
    KING("KING"),
    PROHIBITED("PROHIBITED FIELD");
    private final String type;

    CheckersPawnType(String type) {
        this.type = type;
    }

    String type() {
        return type;
    }
}
