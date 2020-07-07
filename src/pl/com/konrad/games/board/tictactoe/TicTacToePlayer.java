package pl.com.konrad.games.board.tictactoe;


import pl.com.konrad.games.board.Color;
import pl.com.konrad.games.board.Player;

import java.util.List;

class TicTacToePlayer extends Player {
    private TicTacToePawnType playerMark;


    TicTacToePlayer(String name, Color color, TicTacToePawnType playerMark) {
        super(name);
        this.playerMark = playerMark;
    }

    TicTacToePawnType getPlayerMark() {
        return playerMark;
    }
}
