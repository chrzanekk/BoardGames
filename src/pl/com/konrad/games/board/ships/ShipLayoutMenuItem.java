package pl.com.konrad.games.board.ships;

public class ShipLayoutMenuItem {

        private int index;
        private String description;

        public ShipLayoutMenuItem(int index, String description) {
            this.index = index;
            this.description = description;
        }

        public int getIndex() {
            return index;
        }

        public String getDescription() {
            return description;
        }
    }

