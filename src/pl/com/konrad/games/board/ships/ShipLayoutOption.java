package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.GameMenuOption;

public enum ShipLayoutOption {
    HORIZONTAL(1,"Horizontal layout.\"_\""),
    VERTICAL(2, "Vertical layout.\"|\"");
    private final int value;
    private final String description;

    ShipLayoutOption(int value, String description) {
        this.value = value;
        this.description = description;
    }
    int value() {
        return value;
    }

    String description() {return description;}

    public static ShipLayoutOption shipLayoutOption(int playerChoice) {

        for (ShipLayoutOption shipLayoutOption : ShipLayoutOption.values()) {
            if (shipLayoutOption.value == playerChoice) {
                return shipLayoutOption;
            }
        }
        return null;
    }
}
