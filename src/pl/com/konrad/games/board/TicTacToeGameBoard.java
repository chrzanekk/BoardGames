package pl.com.konrad.games.board;

public class TicTacToeGameBoard implements GameBoard{
    public static final int GAME_BOARD_SIZE_3X3 = 3;
    public static final int GAME_BOARD_SIZE_4X4 = 4;
    public static final int GAME_BOARD_SIZE_5X5 = 5;

    private char gameBoard[][];
    private Player playerOne;
    private Player playerTwo;
    private GameBoardDimension gameBoardDimension;
    TicTacToeNotifications ticTacToeNotifications = new TicTacToeNotifications();

    public TicTacToeGameBoard(Player playerOne, Player playerTwo, GameBoardDimension gameBoardDimension) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.gameBoardDimension = gameBoardDimension;
        gameBoard = new char[gameBoardDimension.size()][gameBoardDimension.size()];
        setup();
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

    @Override
    public void setup() {

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                gameBoard[i][j] = '-';
            }
        }
    }

    @Override
    public void print() {

        ticTacToeNotifications.showActualGameBoard();
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
        int  horizontalIndex = 1;
        for (int underRow = 0; underRow < gameBoard.length; underRow++) {
            System.out.print("  " + horizontalIndex + " ");
            horizontalIndex++;
        }
        System.out.println();
    }

    private boolean isFigureByRowCol(int row, int col, Player player) {
        return CheckersPlayerLogic.isFigureExistByRowCol(player.getFigures(), row, col);
    }
//        if (gameBoard.length == GAME_BOARD_SIZE_3X3) {
//            System.out.println("-------------");
//            for (int i = 0; i < gameBoard.length; i++) {
//                System.out.print("| ");
//                for (int j = 0; j < gameBoard.length; j++) {
//                    System.out.print(getPosition(i,j) + " | ");
//                }
//                System.out.println();
//                System.out.println("-------------");
//            }
//        } else if (gameBoard.length == GAME_BOARD_SIZE_4X4) {
//            System.out.println("-----------------");
//            for (int i = 0; i < gameBoard.length; i++) {
//                System.out.print("| ");
//                for (int j = 0; j < gameBoard.length; j++) {
//                    System.out.print(getPosition(i,j)  + " | ");
//                }
//                System.out.println();
//                System.out.println("-----------------");
//            }
//        } else if (gameBoard.length == GAME_BOARD_SIZE_5X5){
//            System.out.println("---------------------");
//            for (int i = 0; i < gameBoard.length; i++) {
//                System.out.print("| ");
//                for (int j = 0; j < gameBoard.length; j++) {
//                    System.out.print(getPosition(i,j) + " | ");
//                }
//                System.out.println();
//                System.out.println("---------------------");
//            }
//        }
    }

