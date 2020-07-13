package pl.com.konrad.games.board.checkers;



import java.util.List;

class CheckersPlayerLogic {

    static char getMarkByRowCol(List<CheckersFigure> figures, int row, int col) {
        char mark =CheckersGameBoardMark.PROHIBITED_FIELD.pawn();
        for (CheckersFigure figure : figures) {
            if (figure.getCurrentRow() == row && figure.getCurrentCol() == col)
                mark = figure.getMark().pawn();
        }
        return mark;
    }
}
