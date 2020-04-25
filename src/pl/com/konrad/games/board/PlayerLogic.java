package pl.com.konrad.games.board;

public class PlayerLogic {

    public static boolean isNamesEquals(String existingName, String newName) {
        return existingName.equals(newName);
    }

    public static boolean findFigureByRow (Player player, int row) {
        for (int i = 0; i < player.getFigureSet().size(); i++) {
            if (player.getFigureSet().get(i).getCurrentRow()==row)
            return true;
        }
        return false;
    }

    public static boolean findFigureByCol (Player player, int col) {
        for (int i = 0; i < player.getFigureSet().size(); i++) {
            if (player.getFigureSet().get(i).getCurrentCol()==col)
                return true;
        }
        return false;
    }

    public static char getMarkByRowCol (Player player, int row, int col) {
        char mark = 0;
        for (int i = 0; i < player.getFigureSet().size(); i++) {
            if (player.getFigureSet().get(i).getCurrentRow()==row && player.getFigureSet().get(i).getCurrentCol()==col)
                mark = player.getFigureSet().get(i).getMark().pawn();
        }
        return mark;
    }



}
