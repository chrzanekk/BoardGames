package pl.com.konrad.checkers;

public class GameChessBoard implements GameBoard{
    private char[][] gameBoard;
    private CheckerPawn blackKing = CheckerPawn.BLACK_KING;
    private CheckerPawn whiteKing = CheckerPawn.WHITE_KING;

    public GameChessBoard() {
        GameBoardDimension size8X8 = GameBoardDimension.SIZE_8X8;
        gameBoard = new char[size8X8.size()][size8X8.size()];
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {
                if ((row % 2 == 0 && col % 2 != 0 && row < gameBoard.length / 2 - 1) || (row % 2 != 0 && col % 2 == 0 && row < gameBoard.length / 2 - 1)) {
                    CheckerPawn white = CheckerPawn.WHITE_MEN;
                    gameBoard[row][col] = white.pawn();
                }
                if ((row % 2 == 0 && col % 2 != 0 && row > gameBoard.length / 2) || (row % 2 != 0 && col % 2 == 0 && row > gameBoard.length / 2)) {
                    CheckerPawn black = CheckerPawn.BLACK_MEN;
                    gameBoard[row][col] = black.pawn();
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
