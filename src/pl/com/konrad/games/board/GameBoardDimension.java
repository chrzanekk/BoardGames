package pl.com.konrad.games.board;

public enum GameBoardDimension {
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
