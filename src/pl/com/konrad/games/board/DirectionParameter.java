package pl.com.konrad.games.board;

public enum DirectionParameter {
    MOVE_BOTTOM (1),
    MOVE_TOP(-1),
    CAPTURE_BOTTOM(2),
    CAPTURE_TOP (-2);
    private final int value;

    DirectionParameter(int value) {
        this.value = value;
    }

    int value() {
        return value;
    }
}
