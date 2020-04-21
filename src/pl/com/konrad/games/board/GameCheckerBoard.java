package pl.com.konrad.games.board;

public class GameCheckerBoard implements GameBoard {
    private Figure[][] gameBoard;
    private Player playerOne;
    private Player playerTwo;

    public GameCheckerBoard(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        GameBoardDimension boardDimension = GameBoardDimension.SIZE_8X8;
        gameBoard = new Figure[boardDimension.size()][boardDimension.size()];
        setup();
    }

    @Override
    public void setup() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {
                if ((isEvenRowOddCol(row, col) && isTopGameBoard(row)) || (isOddRowEvenCol(row, col) && isTopGameBoard(row))) {
                    playerOne.addFigure(gameBoard[row][col] = new Figure(CheckersType.MEN.type(),
                            CheckersMark.WHITE_MEN.pawn(),
                            Colors.WHITE.Description(), row, col));

                }
                if ((isEvenRowOddCol(row, col) && isBottomGameBoard(row)) || (isOddRowEvenCol(row, col) && isBottomGameBoard(row))) {
                    playerTwo.addFigure(gameBoard[row][col] = new Figure(CheckersType.MEN.type(),
                            CheckersMark.BLACK_MEN.pawn(),
                            Colors.BLACK.Description(), row, col));
                }
            }
        }
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

    public void pawnChangePosition(Player player, Figure figure, int currentRow, int currentCol, int newRow,
                                   int newCol) {
        gameBoard[newRow][newCol].move(newRow,newCol);
        gameBoard[currentRow][currentCol] = null;
        //brakuje sprawdzenia poprawnosci ruchu (bicie lub ruch przez swoj pionek).
    }


    @Override
    public Figure[][] getGameBoard() {
        return gameBoard;
    }

    @Override
    public Figure getPosition(int row, int col) {
        return gameBoard[row][col];
    }


    @Override
    public int getLength() {
        return gameBoard.length;
    }


}
