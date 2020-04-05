package pl.com.konrad.checkers;

public class GameBoardPrinter {
    public void print(GameBoard gameBoard) {
        int verticalIndex = 1;
        for (int row = 0; row < gameBoard.getLength(); row++) {
            horizontalLinePrinter(gameBoard);

            System.out.print("| ");
            for (int col = 0; col < gameBoard.getLength(); col++) {

                System.out.print(gameBoard.getPosition(row, col) + " | ");
            }
            System.out.print(verticalIndex + " ");
            verticalIndex++;
            System.out.println();

        }
        horizontalLinePrinter(gameBoard);
        underRowPrinter(gameBoard);

    }

    private void horizontalLinePrinter(GameBoard gameBoard) {
        System.out.print("-");
        for(int i =0; i<gameBoard.getLength();i++){
            System.out.print("----");
        }
        System.out.println();
    }

    private void underRowPrinter(GameBoard gameBoard) {
        char underRowChar = 'A';
        for (int underRow = 0; underRow < gameBoard.getLength(); underRow++) {
            System.out.print("  " + underRowChar + " ");
            underRowChar++;
        }
    }
}
