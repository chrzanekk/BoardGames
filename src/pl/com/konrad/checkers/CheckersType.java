package pl.com.konrad.checkers;

public enum CheckersType {
    MEN("men"),
    KING("KING");
    private String type;

    CheckersType(String type) {
        this.type = type;
    }

    String type() {
        return type;
    }
}
