package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.GameMenu;
import pl.com.konrad.games.board.GameMenuItem;

public class ShipLayoutMenuPrinter {
    private ShipLayoutMenu shipLayoutMenu;

    public ShipLayoutMenuPrinter(ShipLayoutMenu shipLayoutMenu) {
        this.shipLayoutMenu = shipLayoutMenu;
    }

    public void print() {
        for (int i = 0; i < shipLayoutMenu.getItemCount(); i++) {
            ShipLayoutMenuItem shipLayoutMenuItem = shipLayoutMenu.getMenuIndex(i);
            System.out.println(shipLayoutMenuItem.getIndex() + " " + shipLayoutMenuItem.getDescription());
        }
    }
}
