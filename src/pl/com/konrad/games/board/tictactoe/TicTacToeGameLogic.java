package pl.com.konrad.games.board.tictactoe;

import pl.com.konrad.games.board.GameBoard;

class TicTacToeGameLogic {
    static TicTacToePlayer swapPlayer(TicTacToePlayer currentPlayer, TicTacToePlayer playerOne,
                                             TicTacToePlayer playerTwo) {
        if (currentPlayer.getPlayerMark() == playerOne.getPlayerMark()) {
            return playerTwo;
        }
        return playerOne;
    }

    static boolean placeMark(int setNumberOfRow, int setNumberOfColumn, TicTacToePlayer currentPlayer,
                                    GameBoard gameBoard) {
        int numberOfRows = gameBoard.getLength();
        if (setNumberOfRow >= 0 && setNumberOfRow < numberOfRows) {
            if (gameBoard.getPosition(setNumberOfRow, setNumberOfColumn) == '-') {
                gameBoard.getGameBoard()[setNumberOfRow][setNumberOfColumn] = currentPlayer.getPlayerMark().mark();
                return true;
            }
        }
        return false;
    }

    static boolean isFigureExistByRowCol(TicTacToePlayer player, int row, int col, char[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++)
            for (int j = 0; j < gameBoard.length; j++) {
                if (gameBoard[row][col] == player.getPlayerMark().mark())
                    return true;
            }
        return false;
    }


    static boolean checkIsFull(GameBoard gameBoard) {
        for (int i = 0; i < gameBoard.getLength(); i++) {
            for (int j = 0; j < gameBoard.getLength(); j++) {
                if (gameBoard.getPosition(i, j) == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkCharInRow(GameBoard gameBoard, char playerMark) {
        int charCount = 0;
        for (int row = 0; row < gameBoard.getLength(); row++) {
            for (int col = 0; col < gameBoard.getLength(); col++) {
                if (gameBoard.getPosition(row, col) == playerMark) {
                    charCount++;
                    if (charCount == gameBoard.getLength()) {
                        return true;
                    }
                }
            }
            charCount = 0;
        }
        return false;
    }

    static boolean checkCharInCol(GameBoard gameBoard, char playerMark) {
        for (int col = 0; col < gameBoard.getLength(); col++) {
            int charCount = 0;
            for (int row = 0; row < gameBoard.getLength(); row++) {
                if (gameBoard.getPosition(row, col) == playerMark) {
                    charCount++;
                }
            }
            if (charCount == gameBoard.getLength()) {
                return true;
            }
        }
        return false;
    }

    static boolean checkCharInForwardDiagonal(GameBoard gameBoard, char playerMark) {
        int charCount = 0;
        int col = 0;
        for (int row = 0; row < gameBoard.getLength(); row++) {
            if (gameBoard.getPosition(row, col) == playerMark) {
                charCount++;
            }
            col++;
        }
        return charCount == gameBoard.getLength();
    }

    static boolean checkCharInBackwardDiagonal(GameBoard gameBoard, char playerMark) {
        int charCount = 0;
        int row = gameBoard.getLength() - 1;
        for (int col = 0; col < gameBoard.getLength(); col++) {
            if (gameBoard.getPosition(row, col) == playerMark) {
                charCount++;
            }
            row--;
        }
        return charCount == gameBoard.getLength();
    }

    static boolean checkWinnerInRow(GameBoard gameBoard, TicTacToePlayer playerX, TicTacToePlayer playerO) {
        return (checkCharInRow(gameBoard, playerX.getPlayerMark().mark()) || checkCharInRow(gameBoard,
                playerO.getPlayerMark().mark()));
    }

    static boolean checkWinnerInCol(GameBoard gameBoard, TicTacToePlayer playerX, TicTacToePlayer playerO) {
        return (checkCharInCol(gameBoard, playerX.getPlayerMark().mark()) || checkCharInCol(gameBoard,
                playerO.getPlayerMark().mark()));
    }

    static boolean checkWinnerInForwardDiagonal(GameBoard gameBoard, TicTacToePlayer playerX, TicTacToePlayer playerO) {
        return (checkCharInForwardDiagonal(gameBoard, playerX.getPlayerMark().mark()) || checkCharInForwardDiagonal(gameBoard,
                playerO.getPlayerMark().mark()));
    }

    static boolean checkWinnerInBackwardDiagonal(GameBoard gameBoard, TicTacToePlayer playerX, TicTacToePlayer playerO) {
        return (checkCharInBackwardDiagonal(gameBoard, playerX.getPlayerMark().mark()) || checkCharInBackwardDiagonal(gameBoard,
                playerO.getPlayerMark().mark()));
    }


    static boolean checkWinner(GameBoard gameBoard, TicTacToePlayer playerX, TicTacToePlayer playerO) {
        return (checkWinnerInRow(gameBoard, playerX, playerO) || checkWinnerInCol(gameBoard, playerX, playerO) || checkWinnerInForwardDiagonal(gameBoard, playerX, playerO) || checkWinnerInBackwardDiagonal(gameBoard, playerX, playerO));
    }

    static boolean isGameBoardFullOrIsaWinner(GameBoard gameBoard, TicTacToePlayer playerX, TicTacToePlayer playerO) {
        return checkIsFull(gameBoard) || checkWinner(gameBoard, playerX, playerO);
    }
}
