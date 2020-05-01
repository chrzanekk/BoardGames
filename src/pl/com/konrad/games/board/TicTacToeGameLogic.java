package pl.com.konrad.games.board;

public class TicTacToeGameLogic {
//    public boolean placeMark(int setNumberOfRow, int setNumberOfColumn, char playerMark, char[][] gameBoard) {
//        int numberOfRows = gameBoard.length;
//        if (setNumberOfRow >= 0 && setNumberOfRow < numberOfRows) {
//            if (gameBoard[setNumberOfRow][setNumberOfColumn] == '-') {
//                gameBoard[setNumberOfRow][setNumberOfColumn] = playerMark;
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean checkIsFull(char[][] gameBoard) {
//        for (char[] chars : gameBoard) {
//            for (int j = 0; j < gameBoard[0].length; j++) {
//                if (chars[j] == '-') {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    public boolean checkCharInRow(GameBoard gameBoard, char playerMark) {
//        int charCount = 0;
//        for (int row = 0; row < gameBoard.getLength(); row++) {
//            for (int col = 0; col < gameBoard.getLength(); col++) {
//                if (gameBoard.getPosition(row, col) == playerMark) {
//                    charCount++;
//                    if (charCount == gameBoard.getLength()) {
//                        return true;
//                    }
//                }
//            }
//            charCount = 0;
//        }
//        return false;
//    }
//
//    public boolean checkCharInCol(GameBoard gameBoard, char playerMark) {
//        for (int col = 0; col < gameBoard.getLength(); col++) {
//            int charCount = 0;
//            for (int row = 0; row < gameBoard.getLength(); row++) {
//                if (gameBoard.getPosition(row, col) == playerMark) {
//                    charCount++;
//                }
//            }
//            if (charCount == gameBoard.getLength()) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean checkCharInForwardDiagonal(GameBoard gameBoard, char playerMark) {
//        int charCount = 0;
//        int col = 0;
//        for (int row = 0; row < gameBoard.getLength(); row++) {
//            if (gameBoard.getPosition(row, col) == playerMark) {
//                charCount++;
//            }
//            col++;
//        }
//        return charCount == gameBoard.getLength();
//    }
//
//    public boolean checkCharInBackwardDiagonal(GameBoard gameBoard, char playerMark) {
//        int charCount = 0;
//        int row = gameBoard.getLength() - 1;
//        for (int col = 0; col < gameBoard.getLength(); col++) {
//            if (gameBoard.getPosition(row, col) == playerMark) {
//                charCount++;
//            }
//            row--;
//        }
//        return charCount == gameBoard.getLength();
//    }
//
//    public boolean checkWinnerInRow(GameBoard gameBoard, Player playerX, Player playerO) {
//        return (checkCharInRow(gameBoard, playerX.getCurrentPlayerMark()) || checkCharInRow(gameBoard,
//                playerO.getCurrentPlayerMark()));
//    }
//
//    public boolean checkWinnerInCol(GameBoard gameBoard, Player playerX, Player playerO) {
//        return (checkCharInCol(gameBoard, playerX.getCurrentPlayerMark()) || checkCharInCol(gameBoard,
//                playerO.getCurrentPlayerMark()));
//    }
//
//    public boolean checkWinnerInForwardDiagonal(GameBoard gameBoard, Player playerX, Player playerO) {
//        return (checkCharInForwardDiagonal(gameBoard, playerX.getCurrentPlayerMark()) || checkCharInForwardDiagonal(gameBoard,
//                playerO.getCurrentPlayerMark()));
//    }
//
//    public boolean checkWinnerInBackwardDiagonal(GameBoard gameBoard, Player playerX, Player playerO) {
//        return (checkCharInBackwardDiagonal(gameBoard, playerX.getCurrentPlayerMark()) || checkCharInBackwardDiagonal(gameBoard,
//                playerO.getCurrentPlayerMark()));
//    }
//
//
//    public boolean checkWinner(GameBoard gameBoard, Player playerX, Player playerO) {
//        return (checkWinnerInRow(gameBoard, playerX, playerO) || checkWinnerInCol(gameBoard, playerX, playerO) || checkWinnerInForwardDiagonal(gameBoard, playerX, playerO) || checkWinnerInBackwardDiagonal(gameBoard, playerX, playerO));
//    }
//
//    public boolean isGameBoardFullOrIsaWinner(GameBoard gameBoard, Player playerX, Player playerO) {
//        return checkIsFull(gameBoard.getGameBoard()) || checkWinner(gameBoard, playerX, playerO);
//    }
}
