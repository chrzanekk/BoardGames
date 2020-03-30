package pl.com.konrad.checkers;

public class GameBoard {
    private char[][] gameBoard;
    private GameBoardDimension Size8X8 = GameBoardDimension.SIZE_8X8;
    private PlayerPawns black = PlayerPawns.BLACK_MEN;
    private PlayerPawns white = PlayerPawns.WHITE_MEN;
    private PlayerPawns blackKing = PlayerPawns.BLACK_KING;
    private PlayerPawns whiteKing = PlayerPawns.WHITE_KING;

    public GameBoard() {
        gameBoard = new char[Size8X8.size()][Size8X8.size()];
        for (int row = 0; row< gameBoard.length; row++) {
            for (int col = 0; col<gameBoard.length; col++) {
                if((row%2==0 && col%2!=0 && row < gameBoard.length/2-1) || (row%2!=0 && col%2==0 && row < gameBoard.length/2-1)) {
                    gameBoard[row][col] = white.pawn();
                }
                if((row%2==0 && col%2!=0 && row > gameBoard.length/2) || (row%2!=0 && col%2==0 && row > gameBoard.length/2)) {
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
