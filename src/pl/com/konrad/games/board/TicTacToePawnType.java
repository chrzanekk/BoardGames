package pl.com.konrad.games.board;

public enum TicTacToePawnType {
    CROSS ('X'),
    CIRCLE ('O');

    private final char mark;

    TicTacToePawnType(char mark) {
        this.mark = mark;
    }

    char mark() {
        return mark;
    }
}
