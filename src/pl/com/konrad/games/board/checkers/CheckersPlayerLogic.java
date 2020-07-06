package pl.com.konrad.games.board.checkers;

import pl.com.konrad.games.board.Player;

import java.util.List;

class CheckersPlayerLogic {

    static char getMarkByRowCol(List<CheckersFigure> figures, int row, int col) {
        char mark = 0;
        for (CheckersFigure figure : figures) {
            if (figure.getCurrentRow() == row && figure.getCurrentCol() == col)
                mark = figure.getMark().pawn();
        }
        return mark;
    }

    static boolean isFigureExistByRowCol(List<CheckersFigure> figures, int row, int col) {
        for (CheckersFigure figure : figures) {
            if (figure.getCurrentRow() == row && figure.getCurrentCol() == col)
                return true;
        }
        return false;
    }

    static boolean isFigureBelongToPlayer(List<CheckersFigure> figures, int row, int col,
                                          String currentPlayerName) {
        for (CheckersFigure figure : figures) {
            if (currentPlayerName.equals(figure.getPlayer().getName()) && figure.getCurrentRow() == row && figure.getCurrentCol() == col)
                return true;
        }
        return false;
    }



   

}
