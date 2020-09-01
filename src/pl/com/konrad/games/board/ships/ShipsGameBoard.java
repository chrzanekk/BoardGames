package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.GameBoard;
import pl.com.konrad.games.board.GameBoardDimension;
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
    private ShipsGameText shipsGameText = new ShipsGameText();
    private List<Ship> fleet;
    private ShipsGameLogic shipsGameLogic;

    public ShipsGameBoard(Player player, List<Ship> fleet) {
        this.player = player;
        this.fleet = fleet;
        GameBoardDimension boardDimension = GameBoardDimension.SIZE_8X8;
        shipsGameLogic = new ShipsGameLogic(fleet);
        gameBoard = new char[boardDimension.size()][boardDimension.size()];

    }

    @Override
    public void setup() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {
//nie bardzo wiem jak zorganizowac setup. kazdy gracz powinien miec podglad jak rozstawia statki i ich maszty.
//                nie mam na to pomyslu.
            }
        }
    }
    @Override
    public void print() {
        int verticalIndex = 1;
        for (int row = 0; row < gameBoard.length; row++) {
            printHorizontalLine();
            System.out.print("|");
            for (int col = 0; col < gameBoard.length; col++) {
                if (fleet.isEmpty()) {
                    System.out.print("   |");
                }
                else {
//                    w jaki sposob pobrac z listy Flota konkretny statek i masz?
                }
            }
            System.out.println(verticalIndex++ + " ");
        }
        printHorizontalLine();
        printUnderRow();
    }


    private void printHorizontalLine() {
        char minus = '-';
        System.out.print(minus);
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j <= 3; j++)
                System.out.print(minus);
        }
        System.out.println();
    }

    private void printUnderRow() {
        char underRowChar = 'A';
        for (int underRow = 0; underRow < gameBoard.length; underRow++) {
            System.out.print("  " + underRowChar + " ");
            underRowChar++;
        }
        System.out.println();
    }

    @Override
    public char[][] getGameBoard() {
        return gameBoard;
    }

    @Override
    public char getPosition(int row, int col) {
        return gameBoard[row][col];
    }

    @Override
    public int getLength() {
        return gameBoard.length;
    }
}
