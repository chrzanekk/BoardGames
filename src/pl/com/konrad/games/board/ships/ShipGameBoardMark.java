package pl.com.konrad.games.board.ships;
//rozdzielić oznaczenie masztów i oznaczenie strzałów itp. i dodać wtedy inta z ilością masztów w celu ewentualnego
// blokowania dodawania nowych masztów do statku?
public enum ShipGameBoardMark {
    ONE_MAST('1'),
    TWO_MASTS('2'),
    THREE_MASTS('3'),
    FOUR_MASTS('4'),
    FIVE_MASTS('5'),
    MISS('X'),
    HIT_BUT_NOT_SUNK('O'),
    HIT_AND_SUNK('S');

    private final char mark;

    ShipGameBoardMark(char mark) {
        this.mark = mark;
    }

    char mark() {
        return mark;
    }
}
