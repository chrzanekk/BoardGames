package pl.com.konrad.games.board.tictactoe;

enum TicTacToePawnType {
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
