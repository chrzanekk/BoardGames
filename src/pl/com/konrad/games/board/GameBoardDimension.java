package pl.com.konrad.games.board;

public enum GameBoardDimension {
    BACK(0),
    SIZE_3X3(3),
    SIZE_4X4(4),
    SIZE_5X5(5),
    SIZE_8X8 (8),
    SIZE_10X10 (10);

    private final int size;

    GameBoardDimension(int size) {
        this.size = size;
    }

    int size() {
        return size;
    }

    public static GameBoardDimension dimension(int playerChoice) {
        for (GameBoardDimension gameBoardDimension : GameBoardDimension.values()) {
            if (gameBoardDimension.size == playerChoice) {
                return gameBoardDimension;
            }
        }
        return BACK;
    }
}
