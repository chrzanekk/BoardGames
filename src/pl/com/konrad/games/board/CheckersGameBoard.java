package pl.com.konrad.games.board;

public class CheckersGameBoard implements GameBoard {
    private char[][] gameBoard;
    private Player playerOne;
    private Player playerTwo;
    private CheckersGameText checkersGameText = new CheckersGameText();


    public CheckersGameBoard(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        GameBoardDimension boardDimension = GameBoardDimension.SIZE_8X8;
        gameBoard = new char[boardDimension.size()][boardDimension.size()];
        setup();

    }

    @Override
    public void setup() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {
                if (isaTopGameBoard(row, col)) {
                    addFigure(playerOne, CheckersPawnType.MEN,
                            GameBoardMark.WHITE_MEN,
                            Color.WHITE, row, col);
                }
                if (isaBottomGameBoard(row, col)) {
                    addFigure(playerTwo, CheckersPawnType.MEN,
                            GameBoardMark.BLACK_MEN,
                            Color.BLACK, row, col);
                }
            }
        }
    }

    private void addFigure(Player player, CheckersPawnType checkersPawnType, GameBoardMark gameBoardMark, Color color, int row,
                           int col) {
        player.addFigure(new Figure(checkersPawnType, gameBoardMark, color, row, col));
    }

    private boolean isaBottomGameBoard(int row, int col) {
        return (isEvenRowOddCol(row, col) && isBottomGameBoard(row)) || (isOddRowEvenCol(row, col) && isBottomGameBoard(row));
    }

    private boolean isaTopGameBoard(int row, int col) {
        return (isEvenRowOddCol(row, col) && isTopGameBoard(row)) || (isOddRowEvenCol(row, col) && isTopGameBoard(row));
    }

    @Override
    public void print() {
        checkersGameText.showActualBoard();
        int verticalIndex = 1;

        for (int row = 0; row < gameBoard.length; row++) {
            printHorizontalLine();
            System.out.print("|");
            for (int col = 0; col < gameBoard.length; col++) {
                if (isFigureByRowCol(row, col, playerOne)) {
                    System.out.print(" " + CheckersPlayerLogic.getMarkByRowCol(playerOne.getFigures(), row, col) + " |");
                } else if (isFigureByRowCol(row, col, playerTwo)) {
                    System.out.print(" " + CheckersPlayerLogic.getMarkByRowCol(playerTwo.getFigures(), row, col) + " |");
                } else System.out.print("   |");
            }
            System.out.println(verticalIndex++ + " ");
        }
        printHorizontalLine();
        printUnderRow();
    }


    private boolean isFigureByRowCol(int row, int col, Player player) {
        return CheckersPlayerLogic.isFigureExistByRowCol(player.getFigures(), row, col);
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

    private boolean isBottomGameBoard(int row) {
        return row > gameBoard.length / 2;
    }

    private boolean isTopGameBoard(int row) {
        return row < gameBoard.length / 2 - 1;
    }

    private boolean isOddRowEvenCol(int row, int col) {
        return row % 2 != 0 && col % 2 == 0;
    }

    private boolean isEvenRowOddCol(int row, int col) {
        return row % 2 == 0 && col % 2 != 0;
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
