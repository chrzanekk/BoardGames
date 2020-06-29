package pl.com.konrad.games.board.checkers;

import pl.com.konrad.games.board.Color;
import pl.com.konrad.games.board.Figure;
import pl.com.konrad.games.board.Player;

public class CheckersFigure extends Figure {
    private final CheckersPawnType type;
    private final CheckersGameBoardMark mark;

    public CheckersFigure(Color color, int currentRow, int currentCol, Player player, CheckersPawnType type, CheckersGameBoardMark mark) {
        super(color, currentRow, currentCol, player);
        this.type = type;
        this.mark = mark;
    }

    public CheckersPawnType getType() {
        return type;
    }

    public CheckersGameBoardMark getMark() {
        return mark;
    }
}
