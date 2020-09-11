package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.GameMenuItem;

public class ShipLayoutMenu {
    private ShipLayoutMenuItem layouts[];
    public ShipLayoutMenu(){
        layouts = new ShipLayoutMenuItem[ShipLayoutOption.values().length];

        layouts[0] = new ShipLayoutMenuItem(ShipLayoutOption.HORIZONTAL.value(), ShipLayoutOption.HORIZONTAL.description());
        layouts[1] = new ShipLayoutMenuItem(ShipLayoutOption.VERTICAL.value(), ShipLayoutOption.VERTICAL.description());
    }

    public ShipLayoutMenuItem getMenuIndex(int index) {
        return layouts[index];
    }

    public int getItemCount() {
        return layouts.length;
    }
}
