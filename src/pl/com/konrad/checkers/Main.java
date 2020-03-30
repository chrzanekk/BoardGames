package pl.com.konrad.checkers;

public class Main {

    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        GameBoardPrinter printer = new GameBoardPrinter();
	    printer.print(gameBoard);

    }
}
