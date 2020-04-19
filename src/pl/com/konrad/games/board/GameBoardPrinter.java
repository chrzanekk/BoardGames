package pl.com.konrad.games.board;

public class GameBoardPrinter {
    private GameNotification gameNotification = new GameNotification();
    private GameBoard gameBoard;

    public GameBoardPrinter(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void print() {
        gameNotification.showActualBoard();
        int verticalIndex = 1;
        for (int row = 0; row < gameBoard.getLength(); row++) {
            printHorizontalLine();
            System.out.print("|");
            for (int col = 0; col < gameBoard.getLength(); col++) {
                if (gameBoard.getPosition(row,col) != null) {
                    System.out.print(" "+ gameBoard.getPosition(row, col).getMark() + " |");
                }
                else {
                    System.out.print("   |");
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
        for (int i = 0; i < gameBoard.getLength(); i++) {
            for (int j = 0; j <= 3; j++)
                System.out.print(minus);
        }
        System.out.println();
    }

    private void printUnderRow() {
        char underRowChar = 'A';
        for (int underRow = 0; underRow < gameBoard.getLength(); underRow++) {
            System.out.print("  " + underRowChar + " ");
            underRowChar++;
        }
    }
}
