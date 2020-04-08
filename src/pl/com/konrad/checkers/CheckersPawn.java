package pl.com.konrad.checkers;

public class CheckersPawn extends Figure{
    private char pawnMark;

    public CheckersPawn(String description, char pawnMark) {
        super(description);
        this.pawnMark = pawnMark;
    }


    public char getPawnMark() {
        return pawnMark;
    }




}
