package pl.com.konrad.games.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame implements Game {
    private Scanner scanner = new Scanner(System.in);

    private TicTacToePlayer playerX;
    private TicTacToePlayer playerO;
    private TicTacToePlayer currentPlayer;

    private Validator validator = new Validator();
    private TicTacToeText ticTacToeText = new TicTacToeText();

    private TicTacToeMenu ticTacToeMenu = new TicTacToeMenu();
    private TicTacToeMenuPrinter ticTacToeMenuPrinter = new TicTacToeMenuPrinter(ticTacToeMenu);


    @Override
    public void play() {
        playerX = preparePlayer(scanner, validator, ticTacToeText, TicTacToePawnType.CROSS, null);
        currentPlayer = playerX;
        playerO = preparePlayer(scanner, validator, ticTacToeText, TicTacToePawnType.CIRCLE, playerX.getName());
        ticTacToeText.showWelcomeMessage();
        ticTacToeMenuPrinter.print();
        boolean shouldPlayGame = true;
        do {

            int playerChoice = getPlayerMenuChoice(scanner, validator, ticTacToeMenuPrinter);

            switch (TicTacToeSizeOption.sizeOption(playerChoice)) {
                case SIZE_3X3: {
                    TicTacToeGameBoard ticTacToeGameBoard = new TicTacToeGameBoard(playerX, playerO,
                            GameBoardDimension.SIZE_3X3);
                    runGame(ticTacToeGameBoard);
                    break;
                }
                case SIZE_4X4: {
                    TicTacToeGameBoard ticTacToeGameBoard = new TicTacToeGameBoard(playerX, playerO,
                            GameBoardDimension.SIZE_4X4);
                    runGame(ticTacToeGameBoard);
                    break;
                }
                case SIZE_5X5: {
                    TicTacToeGameBoard ticTacToeGameBoard = new TicTacToeGameBoard(playerX, playerO,
                            GameBoardDimension.SIZE_5X5);
                    runGame(ticTacToeGameBoard);
                    break;
                }
                case BACK: {
                    shouldPlayGame = false;
                    break;
                }
            }
        } while (shouldPlayGame);
    }


    private void runGame(TicTacToeGameBoard ticTacToeGameBoard) {

        do {
            ticTacToeText.showActualGameBoard();
            ticTacToeGameBoard.print();

            ticTacToeText.showWhichPlayerMove(currentPlayer.getPlayerMark().mark());
            boolean isInputIncorrect = false;
            do {
                ticTacToeText.showRowInput(ticTacToeGameBoard.getLength());
                int userRowChoice = getPlayerRowColChoice(scanner, validator, ticTacToeGameBoard);
//                try {
//                    validator.validateCorrectRowColInput(userRowChoice, ticTacToeGameBoard.getLength());
//                } catch (InvalidParameterValueException e) {
//                    validatorWarning.showMessage(validatorWarning.getShowInvalidUserInput());
//                    isInputIncorrect = true;
//                }
                ticTacToeText.showColInput(ticTacToeGameBoard.getLength());
                int userColumnChoice = getPlayerRowColChoice(scanner, validator, ticTacToeGameBoard);
//                try {
//                    validator.validateCorrectRowColInput(userColumnChoice,
//                            ticTacToeGameBoard.getLength());
//                } catch (InvalidParameterValueException e) {
//                    validatorWarning.showMessage(validatorWarning.getShowInvalidUserInput());
//                    isInputIncorrect = true;
//                }

                if (!TicTacToeGameLogic.placeMark(userRowChoice, userColumnChoice, currentPlayer,
                        ticTacToeGameBoard)) {
                    ValidatorWarning.getMessage("show.not.empty.row.col");
                    continue;
                } else
                    TicTacToeGameLogic.placeMark(userRowChoice, userColumnChoice, currentPlayer,
                            ticTacToeGameBoard);
                if (TicTacToeGameLogic.checkWinner(ticTacToeGameBoard, playerX, playerO)) {
                    ticTacToeText.showWinner(currentPlayer.getPlayerMark().mark());
                    ticTacToeGameBoard.print();

                }
                if (TicTacToeGameLogic.checkIsFull(ticTacToeGameBoard)) {
                    ticTacToeText.showDraw();
                    ticTacToeGameBoard.print();

                }
            }
            while (isInputIncorrect);
            currentPlayer = TicTacToeGameLogic.swapPlayer(currentPlayer, playerX, playerO);
        } while (!TicTacToeGameLogic.isGameBoardFullOrIsaWinner(ticTacToeGameBoard, playerX, playerO));
        ticTacToeMenuPrinter.print();
    }


    private static int getPlayerMenuChoice(Scanner scanner,
                                           Validator validator,
                                           TicTacToeMenuPrinter ticTacToeMenuPrinter) {
        int playerMenuChoice;
        do {
            while (!scanner.hasNextInt()) {
                ValidatorWarning.getMessage("show.invalid.user.input");
                ticTacToeMenuPrinter.print();
                scanner.next();
            }
            playerMenuChoice = scanner.nextInt();
            if (validator.validateMainMenuOption(playerMenuChoice)) {
                ValidatorWarning.getMessage("show.invalid.user.input");
                ticTacToeMenuPrinter.print();
            }
        } while (validator.validateMainMenuOption(playerMenuChoice));
        return playerMenuChoice;
    }

    private static int getPlayerRowColChoice(Scanner scanner,
                                             Validator validator,
                                             GameBoard gameBoard) {
        int playerRowColChoice;
        do {
            while (!scanner.hasNextInt()) {
                ValidatorWarning.getMessage("show.invalid.user.input");
                scanner.next();
            }
            playerRowColChoice = scanner.nextInt();
            if (validator.validateRowColInput(playerRowColChoice, gameBoard)) {
                ValidatorWarning.getMessage("show.invalid.user.input");

            }
        } while (validator.validateRowColInput(playerRowColChoice, gameBoard));
        return playerRowColChoice - 1;
    }

    private static TicTacToePlayer preparePlayer(Scanner scanner, Validator validator,

                                                 TicTacToeText ticTacToeText, TicTacToePawnType ticTacToePawnType, String existingName) {
        List<Figure> playerFigures = new ArrayList<>();
        String name = validateUserName(scanner, validator, ticTacToeText, ticTacToePawnType,
                existingName);
        return new TicTacToePlayer(name, playerFigures, ticTacToePawnType);
    }

    private static String validateUserName(Scanner scanner, Validator validator,
                                           TicTacToeText ticTacToeText,
                                           TicTacToePawnType ticTacToePawnType,
                                           String existingName) {
        String name;
        boolean shouldInputNameAgain = true;
        do {
//            ticTacToeText.showInputName(ticTacToePawnType);
            ticTacToeText.getMessage("show.input.name");
            name = scanner.next();
            if (!validator.isNameDuplicated(existingName, name)) {
                shouldInputNameAgain = false;
            } else {
                ValidatorWarning.getMessage("show.wrong.name.input");
            }
        } while (shouldInputNameAgain);
        return name;
    }
}
