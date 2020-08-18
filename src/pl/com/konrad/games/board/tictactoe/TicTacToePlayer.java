package pl.com.konrad.games.board.tictactoe;


import pl.com.konrad.games.board.Player;


class TicTacToePlayer extends Player {
    private TicTacToePawnType playerMark;


    TicTacToePlayer(String name, TicTacToePawnType playerMark) {
        super(name);
        this.playerMark = playerMark;
    }

    TicTacToePawnType getPlayerMark() {
        return playerMark;
    }
}
