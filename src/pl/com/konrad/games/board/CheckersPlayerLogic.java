package pl.com.konrad.games.board;

import java.util.List;

public class CheckersPlayerLogic {
    //Liste na Player.
    public static char getMarkByRowCol(Player player, int row, int col) {
        char mark = 0;
        for (Figure figure : player.getFigures()) {
            if (figure.getCurrentRow() == row && figure.getCurrentCol() == col)
                mark = figure.getMark().pawn();
        }
        return mark;
    }

    public static boolean isFigureExistByRowCol(Player player, int row, int col) {
        for (Figure figure : player.getFigures()) {
            if (figure.getCurrentRow() == row && figure.getCurrentCol() == col)
                return true;
        }
        return false;
    }

    public static int getIndexByRowCol(Player player, int row, int col) {
        int index = 0;
        for (int i = 0; i < player.getFigures().size(); i++) {
            if (player.getFigures().get(i).getCurrentRow() == row && player.getFigures().get(i).getCurrentCol() == col)
                index = i;
        }
        return index;
    }


}
