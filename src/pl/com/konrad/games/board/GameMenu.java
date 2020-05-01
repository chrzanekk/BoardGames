package pl.com.konrad.games.board;

import java.util.List;

public class GameMenu {
//    private GameMenuItem items[];
    private List<GameMenuItem> items;
    GameMenuOption gameMenuOption;

    public GameMenu() {
        for (int i = 0; i < items.size(); i++) {
            items.set(i, new GameMenuItem(this.gameMenuOption.value(), this.gameMenuOption.description()));
        }
//        items = new GameMenuItem[2];
//        items[0] = new GameMenuItem(1,"Start game.");
//        items[1] = new GameMenuItem(2,"Exit game.");
    }

    //rozbudować o aktualizacje z enuma.
    public GameMenuItem getMenuIndex(int index) {
        return items.get(index);
    }

    public int getItemCount() {
        return items.size();
    }

//    public GameMenuItem getMenuIndex(int index) {
//        return items[index];
//    }
//
//    public int getItemCount() {
//        return items.length;
//    }
}
