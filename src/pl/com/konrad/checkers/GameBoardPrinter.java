package pl.com.konrad.checkers;

public class GameBoardPrinter {
    public void print(GameBoard gameBoard) {
        System.out.println("  ---------------------------------");
        char verticalChar = 'A';
        for (int row = 0; row < gameBoard.getLength(); row++) {
            System.out.print(verticalChar + " ");
            verticalChar++;
            System.out.print("| ");
            for (int col = 0; col < gameBoard.getLength(); col++) {
                System.out.print(gameBoard.getPosition(row, col) + " | ");
            }
            System.out.println();
            System.out.println("  ---------------------------------");
        }

        int underRowCount = 1;
        System.out.print(" ");
        for (int underRow = 0; underRow < gameBoard.getLength(); underRow++) {
            System.out.print("   " + underRowCount);
            underRowCount++;
        }

    }
}
