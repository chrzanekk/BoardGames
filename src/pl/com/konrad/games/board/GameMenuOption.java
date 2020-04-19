package pl.com.konrad.games.board;

public enum GameMenuOption {
    CHECKERS(1),
    EXIT(2);
    private final int value;

    GameMenuOption(int value) {
        this.value = value;
    }

    int value() {
        return value;
    }

    public static GameMenuOption menuOption(int playerChoice) {
        for (GameMenuOption gameMenuOption : GameMenuOption.values()) {
            if (gameMenuOption.value == playerChoice) {
                return gameMenuOption;
            }
        }
        return EXIT;
    }
}
