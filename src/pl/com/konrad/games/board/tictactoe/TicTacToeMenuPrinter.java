package pl.com.konrad.games.board.tictactoe;

import pl.com.konrad.games.board.GameMenuItem;

class TicTacToeMenuPrinter {

    private TicTacToeMenu ticTacToeMenu;

    TicTacToeMenuPrinter(TicTacToeMenu ticTacToeMenu) {
        this.ticTacToeMenu = ticTacToeMenu;
    }

    void print() {
        for (int i = 0; i < ticTacToeMenu.getItemCount(); i++) {
            GameMenuItem gameMenuItem = ticTacToeMenu.getMenuIndex(i);
            System.out.println(gameMenuItem.getIndex() + " " + gameMenuItem.getDescription());
        }
    }
}
