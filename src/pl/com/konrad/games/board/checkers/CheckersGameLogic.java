package pl.com.konrad.games.board.checkers;


import pl.com.konrad.games.board.Figure;
import pl.com.konrad.games.board.Player;

import java.util.List;

public class CheckersGameLogic {

    //w trakcie opracowania logiki sprawdzania mozliwosci ruchu w danym kierunku (gora lub dol)
//    potrzeba opisac sprawdzenie ruchu po skosie w lewo i w prawo oraz sprawdzenia czy pionek jest na skraju planszy
//    (lewym lub prawym) lub na koncu (na dole lub gorze)

    //lista figur w logice + operacje na figurach(sprawdzanie itp)
    public static boolean isMoveCorrect(List<Figure> figures, int row,int col) {
        for (Figure figure : figures) {
            if (figure.getCurrentCol()==col && figure.getCurrentRow()==row) {
                return false;
            }
        }
        return true;
    }

    static boolean isPlayerCanMovePawn(List<CheckersFigure> figures, Player playerOne, Player playerTwo, int row,
                                       int col) {
        return isPlayerCanMovePawnBottom(figures, playerOne, playerTwo, row, col) || isPlayerCanMovePawnTop(playerOne,
                playerTwo, row, col);
    }
    static boolean isPlayerCanMovePawnBottom(List<CheckersFigure> figures, Player playerOne, Player playerTwo, int row,
                                             int col) {

        //
        //sprawdzanie ruchu po skosie - w odpowiednim kierunki (dla pionka) + zabezpieczenie przed wyjściem poza zakres
        //blokowanie ruchu w bok i na wprost biorac pod uwagę kierunek i pionki ktorymi gra dany gracz
        //
        return true;
    }

    static boolean isPlayerCanMovePawnTop(Player playerOne, Player playerTwo, int row, int col) {

        //
        //sprawdzanie ruchu po skosie - w odpowiednim kierunki (dla pionka) + zabezpieczenie przed wyjściem poza zakres
        //blokowanie ruchu w bok i na wprost biorac pod uwagę kierunek i pionki ktorymi gra dany gracz
        //
        return true;
    }

}




