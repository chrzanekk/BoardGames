package pl.com.konrad.checkers;

public class GameCheckerBoard implements GameBoard {
    private Figure[][] gameBoard;
    private Player playerOne;
    private Player playerTwo;

    public GameCheckerBoard(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        GameBoardDimension boardDimension = GameBoardDimension.SIZE_10X10;
        gameBoard = new Figure[boardDimension.size()][boardDimension.size()];
        setup();
    }

    @Override
    public void setup() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {
                if ((row % 2 == 0 && col % 2 != 0 && row < gameBoard.length / 2 - 1) || (row % 2 != 0 && col % 2 == 0 && row < gameBoard.length / 2 - 1)) {
                    playerOne.addFigure(gameBoard[row][col] = new Figure(CheckersType.MEN.type(),
                            CheckersMark.WHITE_MEN.pawn(),
                            Colors.WHITE.Description(),row,col));

                }
                if ((row % 2 == 0 && col % 2 != 0 && row > gameBoard.length / 2) || (row % 2 != 0 && col % 2 == 0 && row > gameBoard.length / 2)) {
                    playerTwo.addFigure(gameBoard[row][col] = new Figure(CheckersType.MEN.type(),
                            CheckersMark.BLACK_MEN.pawn(),
                            Colors.BLACK.Description(),row,col));
                }
            }
        }
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
