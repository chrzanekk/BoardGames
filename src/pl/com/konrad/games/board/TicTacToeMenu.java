package pl.com.konrad.games.board;

public class TicTacToeMenu {
    private GameMenuItem items[];

    TicTacToeMenu() {
        items = new GameMenuItem[4];
        items[0] = new GameMenuItem(TicTacToeSizeOption.SIZE_OPTION_3X3.index(),TicTacToeSizeOption.SIZE_OPTION_3X3.description());
        items[1] = new GameMenuItem(TicTacToeSizeOption.SIZE_OPTION_4X4.index(),TicTacToeSizeOption.SIZE_OPTION_4X4.description());
        items[2] = new GameMenuItem(TicTacToeSizeOption.SIZE_OPTION_5X5.index(),TicTacToeSizeOption.SIZE_OPTION_5X5.description());
        items[3] = new GameMenuItem(TicTacToeSizeOption.EXIT.index(),TicTacToeSizeOption.EXIT.description());
    }

    public GameMenuItem getMenuIndex(int index) {
        return items[index];
    }

    public int getItemCount() {
        return items.length;
    }
}
