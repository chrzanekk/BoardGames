package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.GameBoard;
import pl.com.konrad.games.board.Player;

import java.util.List;


/* to do
- 4 tablice (dwie do wyswietlania wynikow ruchow oraz dwie do podgladu swojego rozstawienia statkow(jesli bedzie potrzebne)
- zastanowic sie jak przechowywac statki danego gracza - jako cale obiekty w liscie?
- obiekt statek - wlasciwosci: mapa: klucz:numer masztu lub znak  + wartosc tablica ze wspolrzednymi
- trafienie aktualizuje mape zmniejszajac wielkosc - gdy mapa bedzie pusta nastepuje zatopienie
 */


public class ShipsGameBoard implements GameBoard {
    private char[][] gameBoard;
    private Player player;
    private List<ShipsFigure> shipsFigureList;




    @Override
    public void setup(){

    }

    public void print(){}

    @Override
    public char[][] getGameBoard() {
        return new char[0][];
    }

    @Override
    public char getPosition(int row, int col) {
        return 0;
    }

    @Override
    public int getLength() {
        return 0;
    }
}
