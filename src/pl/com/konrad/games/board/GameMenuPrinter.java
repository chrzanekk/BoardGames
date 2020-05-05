package pl.com.konrad.games.board;

public class GameMenuPrinter {
    private GameMenu gameMenu;

    public GameMenuPrinter(GameMenu gameMenu) {
        this.gameMenu = gameMenu;
    }

    public void print() {
        for (int i = 0; i < gameMenu.getItemCount(); i++) {
            GameMenuItem gameMenuItem = gameMenu.getMenuIndex(i);
            System.out.println(gameMenuItem.getIndex() + " " + gameMenuItem.getDescription());
        }
    }


}
