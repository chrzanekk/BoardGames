package pl.com.konrad.checkers;

public class GameBoard {
    private char[][] gameBoard;
    private PlayerPawn blackKing = PlayerPawn.BLACK_KING;
    private PlayerPawn whiteKing = PlayerPawn.WHITE_KING;

    public GameBoard() {
        GameBoardDimension size8X8 = GameBoardDimension.SIZE_8X8;
        gameBoard = new char[size8X8.size()][size8X8.size()];
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {
                if ((row % 2 == 0 && col % 2 != 0 && row < gameBoard.length / 2 - 1) || (row % 2 != 0 && col % 2 == 0 && row < gameBoard.length / 2 - 1)) {
                    PlayerPawn white = PlayerPawn.WHITE_MEN;
                    gameBoard[row][col] = white.pawn();
                }
                if ((row % 2 == 0 && col % 2 != 0 && row > gameBoard.length / 2) || (row % 2 != 0 && col % 2 == 0 && row > gameBoard.length / 2)) {
                    PlayerPawn black = PlayerPawn.BLACK_MEN;
                    gameBoard[row][col] = black.pawn();
                }

            }
        }
    }

    public char[][] getGameBoard() {
        return gameBoard;
    }

    public char getPosition(int row, int col) {
        return gameBoard[row][col];
    }

    public int getLength() {
        return gameBoard.length;
    }
}
