package pl.com.konrad.games.board;

import java.util.List;

public class GameMenu {
    private GameMenuItem items[];
//    private List<GameMenuItem> items;
    GameMenuOption gameMenuOption;

    public GameMenu() {
//        for (int i = 0; i < items.size(); i++) {
//            items.set(i, new GameMenuItem(this.gameMenuOption.value(), this.gameMenuOption.description()));
//        }
        items = new GameMenuItem[4];
        items[0] = new GameMenuItem(GameMenuOption.CHECKERS.value(),GameMenuOption.CHECKERS.description());
        items[1] = new GameMenuItem(GameMenuOption.CHESS.value(),GameMenuOption.CHESS.description());
        items[2] = new GameMenuItem(GameMenuOption.TIC_TAC_TOE.value(),GameMenuOption.TIC_TAC_TOE.description());
        items[3] = new GameMenuItem(GameMenuOption.EXIT.value(),GameMenuOption.EXIT.description());
    }

    //rozbudować o aktualizacje z enuma.
//    public GameMenuItem getMenuIndex(int index) {
//        return items.get(index);
//    }
//
//    public int getItemCount() {
//        return items.size();
//    }

    public GameMenuItem getMenuIndex(int index) {
        return items[index];
    }

    public int getItemCount() {
        return items.length;
    }
}
