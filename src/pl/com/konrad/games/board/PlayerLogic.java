package pl.com.konrad.games.board;

import java.util.List;

public class PlayerLogic {

    public static char getMarkByRowCol(List<Figure> figureList, int row, int col) {
        char mark = 0;
        for (Figure figure : figureList) {
            if (figure.getCurrentRow() == row && figure.getCurrentCol() == col)
                mark = figure.getMark().pawn();
        }
        return mark;
    }

    public static boolean isFigureExistByRowCol(List<Figure> figureList, int row, int col) {
        for (Figure figure : figureList) {
            if (figure.getCurrentRow() == row && figure.getCurrentCol() == col)
                return true;
        }
        return false;
    }

    public static int getIndexByRowCol(List<Figure> figuresList, int row, int col) {
        int index = 0;
        for (int i = 0; i < figuresList.size(); i++) {
            if (figuresList.get(i).getCurrentRow() == row && figuresList.get(i).getCurrentCol() == col)
                index = i;
        }
        return index;
    }
}
