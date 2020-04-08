package pl.com.konrad.checkers;

public class GameCheckerBoard implements GameBoard {
    private char[][] gameBoard;

    public GameCheckerBoard(CheckersPlayer playerOne, CheckersPlayer playerTwo) {
        GameBoardDimension boardDimension = GameBoardDimension.SIZE_8X8;
        gameBoard = new char[boardDimension.size()][boardDimension.size()];
        generateNewGameBoard(playerOne,playerTwo);
    }

    private void generateNewGameBoard(CheckersPlayer playerOne, CheckersPlayer playerTwo) {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {
                if ((row % 2 == 0 && col % 2 != 0 && row < gameBoard.length / 2 - 1) || (row % 2 != 0 && col % 2 == 0 && row < gameBoard.length / 2 - 1)) {
//                    gameBoard[row][col] = new CheckersPawn(CheckersPawnTypes.WHITE_MEN.description(),
//                            CheckersPawnTypes.WHITE_MEN.pawn()).getPawnMark();
                    gameBoard[row][col] = playerOne.getPlayerPawn();
                }
                if ((row % 2 == 0 && col % 2 != 0 && row > gameBoard.length / 2) || (row % 2 != 0 && col % 2 == 0 && row > gameBoard.length / 2)) {
                    gameBoard[row][col] = new CheckersPawn(CheckersPawnTypes.BLACK_MEN.description(),
                            CheckersPawnTypes.BLACK_MEN.pawn()).getPawnMark();
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
