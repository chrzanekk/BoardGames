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

    static boolean isPlayerCanMovePawn(List<CheckersFigure> figures, Player playerOne, Player playerTwo, int row,
                                       int col) {
        return isPlayerCanMovePawnBottom(figures, playerOne, playerTwo, row, col) || isPlayerCanMovePawnTop(playerOne,
                playerTwo, row, col);
    }

    //w trakcie opracowania logiki sprawdzania mozliwosci ruchu w danym kierunku (gora lub dol)
//    potrzeba opisac sprawdzenie ruchu po skosie w lewo i w prawo oraz sprawdzenia czy pionek jest na skraju planszy
//    (lewym lub prawym) lub na koncu (na dole lub gorze)
    static boolean isPlayerCanMovePawnBottom(List<CheckersFigure> figures, Player playerOne, Player playerTwo, int row,
                                             int col) {
        int rowToCheck = row + 1;
        int colToCheckOne = col - 1;
        int colToCheckTwo = col + 1;
        return (!isFigureExistByRowCol(figures, rowToCheck, colToCheckOne));
        //
        //sprawdzanie ruchu po skosie - w odpowiednim kierunki (dla pionka) + zabezpieczenie przed wyjściem poza zakres
        //blokowanie ruchu w bok i na wprost biorac pod uwagę kierunek i pionki ktorymi gra dany gracz
        //

    }

    static boolean isPlayerCanMovePawnTop(Player playerOne, Player playerTwo, int row, int col) {

        //
        //sprawdzanie ruchu po skosie - w odpowiednim kierunki (dla pionka) + zabezpieczenie przed wyjściem poza zakres
        //blokowanie ruchu w bok i na wprost biorac pod uwagę kierunek i pionki ktorymi gra dany gracz
        //
        return true;
    }

}
