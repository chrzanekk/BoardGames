package pl.com.konrad.games.board;

/* w przypadku konsolowej aplikacji nazwy indentyfikują znaki gracza*/
public enum CheckersGameBoardMark {
    BLACK_MEN('\u25CB'),
    WHITE_MEN('\u25CF'),
    BLACK_KING('\u2460'),
    WHITE_KING('\u2776'),
    PROHIBITED_FIELD('#');
    private final char mark;


    CheckersGameBoardMark(char mark) {
        this.mark = mark;
    }

    char pawn() {
        return mark;
    }


}
