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
        if (currentPlayer.equals(ownerOne)) {//czy potrzebna jest petla, czy mozna uzyc tylko equals.
            for (Figure ownerFigure : ownerOne.getFigures()) {
                for (Figure currentPlayerFigure : currentPlayer.getFigures()) {
                    if (ownerFigure.getColor().equals(currentPlayerFigure.getColor()))
                        return true;
                    break;
                }
            }
        } else {
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

    public static boolean isPlayerCanMovePawn(Player playerOne, Player playerTwo, int row, int col) {
        return isPlayerCanMovePawnBottom(playerOne, playerTwo, row, col) || isPlayerCanMovePawnTop(playerOne, playerTwo, row, col);
    }

    public static boolean isPlayerCanMovePawnBottom(Player playerOne, Player playerTwo, int row, int col) {
        int rowToCheck = row+1;
        int colToCheckOne = col-1;
        int colToCheckTwo = col+1;
        return (!isFigureExistByRowCol(playerOne, rowToCheck, colToCheckOne) && !isFigureExistByRowCol(playerTwo, rowToCheck, colToCheckOne)) || ((!isFigureExistByRowCol(playerOne, rowToCheck, colToCheckTwo) && !isFigureExistByRowCol(playerTwo, rowToCheck, colToCheckTwo)));
        //
        //sprawdzanie ruchu po skosie - w odpowiednim kierunki (dla pionka) + zabezpieczenie przed wyjściem poza zakres
        //blokowanie ruchu w bok i na wprost biorac pod uwagę kierunek i pionki ktorymi gra dany gracz
        //

    }

    public static boolean isPlayerCanMovePawnTop(Player playerOne, Player playerTwo, int row, int col) {

        //
        //sprawdzanie ruchu po skosie - w odpowiednim kierunki (dla pionka) + zabezpieczenie przed wyjściem poza zakres
        //blokowanie ruchu w bok i na wprost biorac pod uwagę kierunek i pionki ktorymi gra dany gracz
        //
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
