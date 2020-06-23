package pl.com.konrad.games.board;

public class CheckersPlayerLogic {

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

    public static boolean isFigureBelongToPlayer(Player currentPlayer, Player ownerOne, Player ownerTwo) {
        if (currentPlayer.equals(ownerOne)) {
            for (Figure ownerFigure : ownerOne.getFigures()) {
                for (Figure currentPlayerFigure : currentPlayer.getFigures()) {
                    if (ownerFigure.getColor().equals(currentPlayerFigure.getColor()))
                        return true;
                    break;
                }
            }
        }
        else {
            for (Figure ownerFigure : ownerTwo.getFigures()) {
                for (Figure currentPlayerFigure : currentPlayer.getFigures()) {
                    if (ownerFigure.getColor().equals(currentPlayerFigure.getColor()))
                        return true;
                    break;
                }
            }
        }
        return false;
    }

    public static boolean isPlayerCanMovePawn(Player player, int row, int col) {
        //coś tu muszę wymyślić.
        return true;
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
