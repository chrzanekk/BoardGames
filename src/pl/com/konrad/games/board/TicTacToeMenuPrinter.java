package pl.com.konrad.games.board;

public class TicTacToeMenuPrinter {

    private TicTacToeMenu ticTacToeMenu;

    public TicTacToeMenuPrinter(TicTacToeMenu ticTacToeMenu) {
        this.ticTacToeMenu = ticTacToeMenu;
    }

    public void print() {
        for (int i = 0; i < ticTacToeMenu.getItemCount(); i++) {
            GameMenuItem gameMenuItem = ticTacToeMenu.getMenuIndex(i);
            System.out.println(gameMenuItem.getIndex() + " " + gameMenuItem.getDescription());
        }
    }
}
