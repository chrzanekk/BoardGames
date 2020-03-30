package pl.com.konrad.checkers;

public enum PlayerPawns {
    BLACK_MEN('\u25CB'),
    WHITE_MEN('\u25CF'),
    BLACK_KING('\u25BF'),
    WHITE_KING('\u25B4');
    private final char pawn;

    PlayerPawns(char pawn) {
        this.pawn = pawn;
    }

    char pawn() {
        return pawn;
    }
}
