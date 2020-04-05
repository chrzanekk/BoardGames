package pl.com.konrad.checkers;

public class CheckersPawn extends Figure{
    private char pawnMark;

    public CheckersPawn(int startCol, int startRow, String description, char pawnMark) {
        super(startCol, startRow, description);
        this.pawnMark = pawnMark;
    }

    public char getPawnMark() {
        return pawnMark;
    }


}
