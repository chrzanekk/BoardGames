package pl.com.konrad.checkers;
/*to do:
- wybrac odpowiedni znak dla damki.
*/
public enum PlayerPawn {
    BLACK_MEN('\u25CB',"Black pawn" ),
    WHITE_MEN('\u25CF', "White pawn"),
    BLACK_KING('\u25BF', "Black King"),
    WHITE_KING('\u25B4', "White King");
    private final char pawn;
    private final String description;

    PlayerPawn(char pawn, String description) {
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
