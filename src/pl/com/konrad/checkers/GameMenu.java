package pl.com.konrad.checkers;

public class GameMenu {
    private GameMenuItem items[];

    public GameMenu() {
        items = new GameMenuItem[2];
        items[0] = new GameMenuItem(1,"Start game.");
        items[1] = new GameMenuItem(2,"Exit game.");
    }

    public GameMenuItem getMenuIndex(int index) {
        return items[index];
    }

    public int getItemCount() {
        return items.length;
    }
}
