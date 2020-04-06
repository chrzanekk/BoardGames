package pl.com.konrad.checkers;

public class GameCheckerBoard implements GameBoard {
    private char[][] gameBoard;

    public GameCheckerBoard() {
        GameBoardDimension boardDimension = GameBoardDimension.SIZE_10X10;
        gameBoard = new char[boardDimension.size()][boardDimension.size()];
        generateNewGameBoard();
    }

    private void generateNewGameBoard() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {
                if ((row % 2 == 0 && col % 2 != 0 && row < gameBoard.length / 2 - 1) || (row % 2 != 0 && col % 2 == 0 && row < gameBoard.length / 2 - 1)) {
                    gameBoard[row][col] = new CheckersPawn(col, row, CheckersPawnTypes.WHITE_MEN.description(),
                            CheckersPawnTypes.WHITE_KING.pawn()).getPawnMark();
                }
                if ((row % 2 == 0 && col % 2 != 0 && row > gameBoard.length / 2) || (row % 2 != 0 && col % 2 == 0 && row > gameBoard.length / 2)) {
                    gameBoard[row][col] = new CheckersPawn(col, row, CheckersPawnTypes.BLACK_MEN.description(),
                            CheckersPawnTypes.BLACK_KING.pawn()).getPawnMark();
                }
            }
        }
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
