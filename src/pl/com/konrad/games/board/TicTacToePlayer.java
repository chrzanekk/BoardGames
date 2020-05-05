package pl.com.konrad.games.board;

import java.util.List;

public class TicTacToePlayer extends Player {
    private TicTacToePawnType playerMark;

    public TicTacToePlayer(String name, List<Figure> figures, TicTacToePawnType playerMark) {
        super(name, figures);
        this.playerMark = playerMark;
    }

    public TicTacToePawnType getPlayerMark() {
        return playerMark;
    }
}
