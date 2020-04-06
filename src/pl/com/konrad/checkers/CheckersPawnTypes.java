package pl.com.konrad.checkers;

public enum CheckersPawnTypes {
    BLACK_MEN('\u25CB',"Black pawn" ),
    WHITE_MEN('\u25CF', "White pawn"),
    BLACK_KING('\u2460', "Black King"),
    WHITE_KING('\u2776', "White King");
    private final char pawn;
    private final String description;

    CheckersPawnTypes(char pawn, String description) {
        this.pawn = pawn;
        this.description = description;
    }

    char pawn() {
        return pawn;
    }

    String description(){
        return description;
    }
}
