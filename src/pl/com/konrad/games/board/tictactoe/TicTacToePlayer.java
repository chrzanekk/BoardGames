package pl.com.konrad.games.board.tictactoe;

import pl.com.konrad.games.board.Figure;
import pl.com.konrad.games.board.Player;

import java.util.List;

class TicTacToePlayer extends Player {
    private TicTacToePawnType playerMark;

    TicTacToePlayer(String name, List<Figure> figures, TicTacToePawnType playerMark) {
        super(name, figures);
        this.playerMark = playerMark;
    }

    TicTacToePawnType getPlayerMark() {
        return playerMark;
    }
}
