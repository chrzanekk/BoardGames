package pl.com.konrad.games.board;

/* w przypadku konsolowej aplikacji nazwy indentyfikują znaki gracza*/
public enum GameBoardMark {
    BLACK_MEN('\u25CB'),
    WHITE_MEN('\u25CF'),
    BLACK_KING('\u2460'),
    WHITE_KING('\u2776');
    private final char mark;


    GameBoardMark(char mark) {
        this.mark = mark;
    }

    char pawn() {
        return mark;
    }


}
