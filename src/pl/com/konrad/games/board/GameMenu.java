package pl.com.konrad.games.board;


public class GameMenu {
    private GameMenuItem items[];

    GameMenuOption gameMenuOption;

    public GameMenu() {

        items = new GameMenuItem[4];
        items[0] = new GameMenuItem(GameMenuOption.CHECKERS.value(), GameMenuOption.CHECKERS.description());
        items[1] = new GameMenuItem(GameMenuOption.CHESS.value(), GameMenuOption.CHESS.description());
        items[2] = new GameMenuItem(GameMenuOption.TIC_TAC_TOE.value(), GameMenuOption.TIC_TAC_TOE.description());
        items[3] = new GameMenuItem(GameMenuOption.EXIT.value(), GameMenuOption.EXIT.description());
    }


    public GameMenuItem getMenuIndex(int index) {
        return items[index];
    }

    public int getItemCount() {
        return items.length;
    }
}
