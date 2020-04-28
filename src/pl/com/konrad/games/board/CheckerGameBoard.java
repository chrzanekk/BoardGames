package pl.com.konrad.games.board;

public class CheckerGameBoard implements GameBoard {
    private char[][] gameBoard;
    private Player playerOne;
    private Player playerTwo;
    private GameNotification gameNotification = new GameNotification();


    public CheckerGameBoard(Player playerOne, Player playerTwo) {
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
                    playerOne.addFigure(new Figure(PawnType.MEN,
                            GameBoardMark.WHITE_MEN,
                            Colors.WHITE, row, col));
                    //wyekstrachować metody (ify i ciało ifa)
                }
                if (isaBottomGameBoard(row, col)) {
                    playerTwo.addFigure(new Figure(PawnType.MEN,
                            GameBoardMark.BLACK_MEN,
                            Colors.BLACK, row, col));
                    //wyekstrachować metody (ify i ciało ifa)
                }
            }
        }
    }

    private boolean isaBottomGameBoard(int row, int col) {
        return (isEvenRowOddCol(row, col) && isBottomGameBoard(row)) || (isOddRowEvenCol(row, col) && isBottomGameBoard(row));
    }

    private boolean isaTopGameBoard(int row, int col) {
        return (isEvenRowOddCol(row, col) && isTopGameBoard(row)) || (isOddRowEvenCol(row, col) && isTopGameBoard(row));
    }

    @Override
    public void print() {
        gameNotification.showActualBoard();
        int verticalIndex = 1;

        for (int row = 0; row < gameBoard.length; row++) {
            printHorizontalLine();
            System.out.print("|");
            for (int col = 0; col < gameBoard.length; col++) {
                if (isFigureByRowCol(row, col, playerOne)) {
                    System.out.print(" " + PlayerLogic.getMarkByRowCol(playerOne.getFigureSet(), row, col) + " |");
                } else if (isFigureByRowCol(row, col, playerTwo)) {
                    System.out.print(" " + PlayerLogic.getMarkByRowCol(playerTwo.getFigureSet(), row, col) + " |");
                } else System.out.print("   |");
            }
            System.out.println(verticalIndex++ + " ");
        }
        printHorizontalLine();
        printUnderRow();
    }


    private boolean isFigureByRowCol(int row, int col, Player player) {
        return PlayerLogic.isFigureExistByRowCol(player.getFigureSet(), row, col);
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
