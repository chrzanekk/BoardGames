package pl.com.konrad.games.board;

public enum GameBoardDimension {
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
}
