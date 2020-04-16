package pl.com.konrad.checkers;

public enum CheckersMark {
    BLACK_MEN('\u25CB'),
    WHITE_MEN('\u25CF'),
    BLACK_KING('\u2460'),
    WHITE_KING('\u2776');
    private final char mark;


    CheckersMark(char mark) {
        this.mark = mark;
            }

    char pawn() {
        return mark;
    }


}
