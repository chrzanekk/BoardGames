package pl.com.konrad.checkers;
/*to do:
- wybrac odpowiedni znak dla damki.
*/
public enum CheckerPawn {
    BLACK_MEN('\u25CB',"Black pawn" ),
    WHITE_MEN('\u25CF', "White pawn"),
    BLACK_KING('\u2780', "Black King"),
    WHITE_KING('\u2776', "White King");
    private final char pawn;
    private final String description;

    CheckerPawn(char pawn, String description) {
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
