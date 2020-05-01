package pl.com.konrad.games.board;

import java.util.Scanner;

public class TicTacToeGame implements Game{
    @Override
    public void play() {
//        private PlayerMark cross = PlayerMark.CROSS;
//        private PlayerMark circle = PlayerMark.CIRCLE;
//
//        private Scanner scan = new Scanner(System.in);
//        private Player playerX = new Player(cross.mark());
//        private Player playerO = new Player(circle.mark());
//        private Player currentPlayer = playerX;
//
//        private GameLogic gameLogic = new GameLogic();
//        private PlayerLogic playerLogic = new PlayerLogic();
//        private GameNotifications gameNotifications = new GameNotifications();
//        private GameBoardPrinter print = new GameBoardPrinter();
//        private Validator validator = new Validator();
//
//        public void play(GameBoard gameBoard) {
//            do {
//                gameNotifications.showActualGameBoard();
//                print.print(gameBoard);
//
//                gameNotifications.showWhichPlayerMove(currentPlayer.getCurrentPlayerMark());
//                boolean isInputIncorrect = false;
//                do {
//                    gameNotifications.showRowInput(gameBoard.getLength());
//                    short userRowChoice = (short) (scan.nextShort() - 1);
//                    try {
//                        validator.validateCorrectRowColInput(userRowChoice, gameBoard.getLength());
//                    } catch (InvalidParameterValueException e) {
//                        gameNotifications.showInvalidUserInput();
//                        isInputIncorrect = true;
//                    }
//                    gameNotifications.showColInput(gameBoard.getLength());
//                    short userColumnChoice = (short) (scan.nextShort() - 1);
//                    try {
//                        validator.validateCorrectRowColInput(userColumnChoice,
//                                gameBoard.getLength());
//                    } catch (InvalidParameterValueException e) {
//                        gameNotifications.showInvalidUserInput();
//                        isInputIncorrect = true;
//                    }
//
//                    if (!gameLogic.placeMark(userRowChoice, userColumnChoice, currentPlayer.getCurrentPlayerMark(),
//                            gameBoard.getGameBoard())) {
//                        gameNotifications.showNotEmptyRowCol();
//                        continue;
//                    } else
//                        gameLogic.placeMark(userRowChoice, userColumnChoice, currentPlayer.getCurrentPlayerMark(),
//                                gameBoard.getGameBoard());
//                    if (gameLogic.checkWinner(gameBoard,playerX, playerO)) {
//                        gameNotifications.showWinner(currentPlayer.getCurrentPlayerMark());
//                        print.print(gameBoard);
//                    }
//                    if (gameLogic.checkIsFull(gameBoard.getGameBoard())) {
//                        gameNotifications.showDraw();
//                        print.print(gameBoard);
//                    }
//                }
//                while (isInputIncorrect);
//                currentPlayer = playerLogic.swapPlayerMark(playerX, playerO, currentPlayer);
//            } while (!gameLogic.isGameBoardFullOrIsaWinner(gameBoard, playerX, playerO));
//        }
    }
}
