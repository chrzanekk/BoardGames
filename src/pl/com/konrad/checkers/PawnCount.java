package pl.com.konrad.checkers;

public enum PawnCount {
    CHECKERS (12),
    TIC_TAC_TOE (1),
    CHESS (16);
    private final int quantity;

    PawnCount(int quantity) {
        this.quantity = quantity;
    }

    int count() {
        return quantity;
    }
}
