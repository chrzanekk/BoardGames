package pl.com.konrad.games.board;

public enum GameMenuOption {
    CHECKERS(1,"Warcaby."),
    CHESS(2, "Szachy."),
    TIC_TAC_TOE(3, "Kółko i krzyżyk."),
    EXIT(4,"Wyjście.");
    private final int value;
    private final String description;

    GameMenuOption(int value, String description) {
        this.value = value;
        this.description = description;
    }

    int value() {
        return value;
    }

    String description() {return description;}

    public static GameMenuOption menuOption(int playerChoice) {
        for (GameMenuOption gameMenuOption : GameMenuOption.values()) {
            if (gameMenuOption.value == playerChoice) {
                return gameMenuOption;
            }
        }
        return EXIT;
    }
}
