package pl.com.konrad.games.board;

public class CheckersPawn extends Figure {
    private char pawnMark;

    public CheckersPawn(String description, char mark, String color, int currentRow, int currentCol, char pawnMark) {
        super(description, mark, color, currentRow, currentCol);
        this.pawnMark = pawnMark;
    }

    public char getPawnMark() {
        return pawnMark;
    }


}
