package pl.com.konrad.checkers;

public class CheckersPawn extends Figure {
    private char pawnMark;

    public CheckersPawn(char pawnMark) {
        this.pawnMark = pawnMark;
    }


    public char getPawnMark() {
        return pawnMark;
    }


}
