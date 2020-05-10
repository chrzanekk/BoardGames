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
    private ValidatorWarning validatorWarning = new ValidatorWarning();
    private TicTacToeGameLogic ticTacToeGameLogic = new TicTacToeGameLogic();

    private TicTacToeMenu ticTacToeMenu = new TicTacToeMenu();
    private TicTacToeMenuPrinter ticTacToeMenuPrinter = new TicTacToeMenuPrinter(ticTacToeMenu);


    @Override
    public void play() {
        playerX = preparePlayer(scanner, validator, validatorWarning, ticTacToeText, TicTacToePawnType.CROSS, null);
        currentPlayer = playerX;
        playerO = preparePlayer(scanner, validator, validatorWarning, ticTacToeText, TicTacToePawnType.CIRCLE, playerX.getName());
        ticTacToeText.showWelcomeMessage();
        ticTacToeMenuPrinter.print();
        boolean shouldPlayGame = true;
        do {

            int playerChoice = getPlayerChoice(scanner, validatorWarning, validator, ticTacToeMenuPrinter);

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
                short userRowChoice = (short) (scanner.nextShort() - 1);
                try {
                    validator.validateCorrectRowColInput(userRowChoice, ticTacToeGameBoard.getLength());
                } catch (InvalidParameterValueException e) {
                    validatorWarning.showInvalidUserInput();
                    isInputIncorrect = true;
                }
                ticTacToeText.showColInput(ticTacToeGameBoard.getLength());
                short userColumnChoice = (short) (scanner.nextShort() - 1);
                try {
                    validator.validateCorrectRowColInput(userColumnChoice,
                            ticTacToeGameBoard.getLength());
                } catch (InvalidParameterValueException e) {
                    validatorWarning.showInvalidUserInput();
                    isInputIncorrect = true;
                }

                if (!TicTacToeGameLogic.placeMark(userRowChoice, userColumnChoice, currentPlayer,
                        ticTacToeGameBoard)) {
                    validatorWarning.showNotEmptyRowCol();
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


    private static int getPlayerChoice(Scanner scanner,
                                       ValidatorWarning validatorWarning, Validator validator,
                                       TicTacToeMenuPrinter ticTacToeMenuPrinter) {
        int playerMenuChoice;
        do {
            while (!scanner.hasNextInt()) {
                validatorWarning.showInvalidUserInput();
                ticTacToeMenuPrinter.print();
                scanner.next();
            }
            playerMenuChoice = scanner.nextInt();
            if (validator.validateMainMenuOption(playerMenuChoice)) {
                validatorWarning.showInvalidUserInput();
                ticTacToeMenuPrinter.print();
            }
        } while (validator.validateMainMenuOption(playerMenuChoice));
        return playerMenuChoice;
    }

    private static TicTacToePlayer preparePlayer(Scanner scanner, Validator validator,
                                                 ValidatorWarning validatorWarning,
                                                 TicTacToeText ticTacToeText, TicTacToePawnType ticTacToePawnType, String existingName) {
        List<Figure> playerFigures = new ArrayList<>();
        String name = validateUserName(scanner, validator, validatorWarning, ticTacToeText, ticTacToePawnType,
                existingName);
        return new TicTacToePlayer(name, playerFigures, ticTacToePawnType);
    }

    private static String validateUserName(Scanner scanner, Validator validator,
                                           ValidatorWarning validatorWarning, TicTacToeText ticTacToeText,
                                           TicTacToePawnType ticTacToePawnType,
                                           String existingName) {
        String name;
        boolean shouldInputNameAgain = true;
        do {
            ticTacToeText.showInputName(ticTacToePawnType);
            name = scanner.next();
            if (!validator.isNameDuplicated(existingName, name)) {
                shouldInputNameAgain = false;
            } else {
                validatorWarning.showWrongNameInput(existingName);
            }
        } while (shouldInputNameAgain);
        return name;
    }
}
