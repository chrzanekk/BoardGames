package pl.com.konrad.games.board;

import java.util.List;

public class PlayerLogic {

    public static char getMarkByRowCol (List<Figure> figureList, int row, int col) {
        char mark = 0;
        for (Figure figure : figureList) {
            if (figure.getCurrentRow() == row && figure.getCurrentCol() == col)
                mark = figure.getMark().pawn();
        }
        return mark;
    }

    public static boolean findFigureByRowCol(List<Figure> figureList, int row, int col) {
        for (Figure figure : figureList) {
            if (figure.getCurrentRow() == row && figure.getCurrentCol() == col)
                return true;
        }
        return false;
    }
}
