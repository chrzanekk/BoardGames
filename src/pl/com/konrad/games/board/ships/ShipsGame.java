package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class ShipsGame implements Game {
    private final Scanner scanner = new Scanner(System.in);
    private final Validator validator = new Validator();
    private final ShipsGameText shipsGameText = new ShipsGameText();
    private ShipLayoutMenu shipLayoutMenu = new ShipLayoutMenu();
    private ShipLayoutMenuPrinter layoutMenuPrinter = new ShipLayoutMenuPrinter(shipLayoutMenu);

    private static final int NUMBER_OF_SHIPS = 1;
    private static final int THREE_MASTS_SHIP = 3;

    private List<Ship> playerOneFleet = new ArrayList();
    private List<Ship> playerTwoFleet = new ArrayList();
    private List<Ship> playerOneFleetToCheck = new ArrayList();
    private List<Ship> playerTwoFleetToCheck = new ArrayList();

    private ShipsGameLogic playerOneShipsGameLogic = new ShipsGameLogic(playerOneFleet);
    private ShipsGameLogic playerTwoShipsGameLogic = new ShipsGameLogic(playerTwoFleet);
    private ShipsGameLogic playerOneShipsGameLogicToCheck = new ShipsGameLogic(playerOneFleetToCheck);
    private ShipsGameLogic playerTwoShipsGameLogicToCheck = new ShipsGameLogic(playerTwoFleetToCheck);


    public void play() {
/** ship deployment phase
 * 4 pieces of 3-mast ships deploy each player at private shipboard.
 */
        Player playerOne = preparePlayer(getUserName(scanner, validator, shipsGameText.getMessage("show.player.one"), null));
        Player currentPlayer = playerOne;
        ShipsGameBoard playerOneGameBoard = new ShipsGameBoard(playerOne, playerOneFleet);
        ShipsGameBoard playerOneCheckBoard = new ShipsGameBoard(playerOne, playerOneFleetToCheck);
        playerOneCheckBoard.setup();

        TreeMap<Character, Integer> lettersAndDigits = lettersAndDigits(playerOneGameBoard.getLength());
        ShipCreator threeMastShipCreatorPlayerOne = new ShipCreator(THREE_MASTS_SHIP,
                null,
                playerOne,
                ShipGameBoardMark.THREE_MASTS,
                playerOneGameBoard,
                playerOneShipsGameLogic);

        playerOneGameBoard.print();
        shipsDeployment(playerOneGameBoard,
                lettersAndDigits,
                threeMastShipCreatorPlayerOne,
                playerOneShipsGameLogic,
                playerOneFleet,
                NUMBER_OF_SHIPS);

//        playerOneShipsGameLogic.clearConsole();

        Player playerTwo = preparePlayer(getUserName(scanner, validator, shipsGameText.getMessage("show.player.two"), playerOne.getName()));
        ShipsGameBoard playerTwoGameBoard = new ShipsGameBoard(playerTwo, playerTwoFleet);
        ShipsGameBoard playerTwoCheckBoard = new ShipsGameBoard(playerTwo, playerTwoFleetToCheck);
        playerTwoCheckBoard.setup();

        ShipCreator threeMastShipCreatorPlayerTwo = new ShipCreator(THREE_MASTS_SHIP,
                null,
                playerTwo,
                ShipGameBoardMark.THREE_MASTS,
                playerTwoGameBoard,
                playerTwoShipsGameLogic);

        playerTwoGameBoard.print();
        shipsDeployment(playerTwoGameBoard,
                lettersAndDigits,
                threeMastShipCreatorPlayerTwo,
                playerTwoShipsGameLogic,
                playerTwoFleet,
                NUMBER_OF_SHIPS);


/** main flow of the game
 */
        boolean isAWinner = false;
        do {
            int userRow;
            int userCol;
            playerOneShipsGameLogic.clearConsole();
            showCurrentPlayerBoards(playerOne, currentPlayer, playerOneGameBoard, playerTwoGameBoard, playerOneCheckBoard,
                    playerTwoCheckBoard, shipsGameText);
            System.out.println(shipsGameText.getMessage("show.witch.player.move", currentPlayer.getName()));

            System.out.println(shipsGameText.getMessage("show.input.row", Integer.toString(playerOneGameBoard.getLength())));
            userRow = getPlayerRowChoice(scanner, validator, playerOneGameBoard.getLength());

            System.out.println(shipsGameText.getMessage("show.input.col",
                    Character.toString(playerOneGameBoard.generateLastLetterOfColumn('A', playerOneGameBoard.getLength()))));
            userCol = convertLetterToDigit(lettersAndDigits, getPlayerColChoice(scanner, validator,
                    lettersAndDigits));

//do przemyślenia logika instrukcji warunkowej.
            if (currentPlayer.equals(playerOne)) {

                if (isPlayerTwoHitAndNotSunk(userRow, userCol, playerTwoShipsGameLogic)) {
                    System.out.println(shipsGameText.getMessage("show.player.hit.ship", playerOne.getName()));

                    playerOneShipsGameLogicToCheck.changeMastStatus(userRow, userCol, playerOne, ShipGameBoardMark.HIT_BUT_NOT_SUNK);
                    playerTwoShipsGameLogic.changeMastStatus(userRow, userCol, playerTwo, ShipGameBoardMark.HIT_BUT_NOT_SUNK);
                } else if (isPlayerTwoHitAndSunk(userRow, userCol, playerTwoShipsGameLogic)) {
                    System.out.println(shipsGameText.getMessage("show.player.hit.ship", playerOne.getName()));
                    System.out.println(shipsGameText.getMessage("show.player.sunk.ship"));

                    playerOneShipsGameLogicToCheck.changeMastStatus(userRow, userCol, playerOne, ShipGameBoardMark.HIT_AND_SUNK);
                    playerOneShipsGameLogicToCheck.changeShipStatusToSink(userRow,userCol,playerOne);
                    playerTwoShipsGameLogic.changeMastStatus(userRow, userCol, playerTwo, ShipGameBoardMark.HIT_AND_SUNK);
                    playerTwoShipsGameLogic.changeShipStatusToSink(userRow,userCol,playerTwo);

                } else {
                    playerOneShipsGameLogicToCheck.changeMastStatus(userRow, userCol, playerOne, ShipGameBoardMark.MISS);
                    playerTwoShipsGameLogic.changeMastStatus(userRow,userCol,playerTwo,ShipGameBoardMark.MISS);
                    System.out.println(shipsGameText.getMessage("show.player.miss"));
                }

                if (playerTwoShipsGameLogic.isPlayerLoose()) {
                    System.out.println(shipsGameText.getMessage("show.player.win", playerOne.getName()));
                    isAWinner = true;
                }
            } else {
                if (isPlayerOneHitAndNotSunk(userRow, userCol, playerOneShipsGameLogic)) {
                    System.out.println(shipsGameText.getMessage("show.player.hit.ship", playerTwo.getName()));

                    playerTwoShipsGameLogicToCheck.changeMastStatus(userRow, userCol, playerTwo, ShipGameBoardMark.HIT_BUT_NOT_SUNK);
                    playerOneShipsGameLogic.changeMastStatus(userRow, userCol, playerOne, ShipGameBoardMark.HIT_BUT_NOT_SUNK);

                } else if (isPlayerOneHitAndSunk(userRow, userCol, playerOneShipsGameLogic)) {
                    System.out.println(shipsGameText.getMessage("show.player.hit.ship", playerTwo.getName()));
                    System.out.println(shipsGameText.getMessage("show.player.sunk.ship"));

                    playerTwoShipsGameLogicToCheck.changeMastStatus(userRow, userCol, playerTwo, ShipGameBoardMark.HIT_AND_SUNK);
                    playerTwoShipsGameLogic.changeShipStatusToSink(userRow,userCol,playerTwo);
                    playerOneShipsGameLogic.changeMastStatus(userRow, userCol, playerOne, ShipGameBoardMark.HIT_AND_SUNK);
                    playerOneShipsGameLogic.changeShipStatusToSink(userRow,userCol,playerOne);
                } else {
                    playerTwoShipsGameLogicToCheck.changeMastStatus(userRow, userCol, playerOne, ShipGameBoardMark.MISS);
                    playerOneShipsGameLogic.changeMastStatus(userRow,userCol,playerOne,ShipGameBoardMark.MISS);
                    System.out.println(shipsGameText.getMessage("show.player.miss"));
                }

                if (playerOneShipsGameLogic.isPlayerLoose()) {
                    System.out.println(shipsGameText.getMessage("show.player.win", playerTwo.getName()));
                    isAWinner = true;
                }
            }

            currentPlayer = swapPlayers(playerOne, currentPlayer, playerTwo);
        }
        while (!isAWinner);
    }

    private Player swapPlayers(Player playerOne, Player currentPlayer, Player playerTwo) {
        if (currentPlayer.equals(playerOne)) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
        return currentPlayer;
    }

    private boolean isPlayerOneHitAndSunk(int userRow, int userCol, ShipsGameLogic playerOneShipsGameLogic) {
        return playerOneShipsGameLogic.isMastExists(userRow, userCol) &&
                (playerOneShipsGameLogic.checkForHitAndSunk(userRow, userCol));
    }

    private boolean isPlayerOneHitAndNotSunk(int userRow, int userCol, ShipsGameLogic playerOneShipsGameLogic) {
        return playerOneShipsGameLogic.checkForHit(userRow, userCol) &&
                (!playerOneShipsGameLogic.checkForHitAndSunk(userRow, userCol));
    }

    private boolean isPlayerTwoHitAndSunk(int userRow, int userCol, ShipsGameLogic playerTwoShipsGameLogic) {
        return playerTwoShipsGameLogic.isMastExists(userRow, userCol) &&
                (playerTwoShipsGameLogic.checkForHitAndSunk(userRow, userCol));
    }

    private boolean isPlayerTwoHitAndNotSunk(int userRow, int userCol, ShipsGameLogic playerTwoShipsGameLogic) {
        return playerTwoShipsGameLogic.checkForHit(userRow, userCol) &&
                (!playerTwoShipsGameLogic.checkForHitAndSunk(userRow, userCol));
    }


    private void shipsDeployment(ShipsGameBoard shipsGameBoard,
                                 TreeMap<Character, Integer> lettersAndDigits,
                                 ShipCreator shipCreator,
                                 ShipsGameLogic shipsGameLogic,
                                 List<Ship> playerFleet,
                                 int numberOfShips) {
        int shipNumber = 1;
        do {
            System.out.println(shipsGameText.getMessage("show.setup.ship", Integer.toString(shipNumber), Integer.toString(NUMBER_OF_SHIPS)));
            System.out.println(shipsGameText.getMessage("show.layout.option"));
            layoutMenuPrinter.print();
            int layoutOption = getLayoutOption(scanner, validator, layoutMenuPrinter);
            int userCurrentRowChoice;
            int userCurrentColChoice;
            System.out.println(shipsGameText.getMessage("show.input.row", Integer.toString(shipsGameBoard.getLength())));
            userCurrentRowChoice = getPlayerRowChoice(scanner, validator, shipsGameBoard.getLength());
            System.out.println(shipsGameText.getMessage("show.input.col", Character.toString(shipsGameBoard.generateLastLetterOfColumn('A',
                    shipsGameBoard.getLength()))));
            char userColChoiceByChar = getPlayerColChoice(scanner, validator, lettersAndDigits);
            userCurrentColChoice = convertLetterToDigit(lettersAndDigits, userColChoiceByChar);

            if (layoutOption == ShipLayoutOption.HORIZONTAL.value()) {
                if (shipsGameLogic.checkPlaceForHorizontalShip(userCurrentRowChoice,
                        userCurrentColChoice,
                        THREE_MASTS_SHIP,
                        shipsGameBoard)) {
                    playerFleet.add(shipCreator.horizontalShip(userCurrentRowChoice, userCurrentColChoice));
                    shipNumber++;
                } else {
                    System.out.println(shipsGameText.getMessage("show,wrong.coordinates"));
                    System.out.println(shipsGameText.getMessage("show.try.again"));
                }
            } else if (layoutOption == ShipLayoutOption.VERTICAL.value()) {
                if (shipsGameLogic.checkPlaceForVerticalShip(userCurrentRowChoice,
                        userCurrentColChoice,
                        THREE_MASTS_SHIP,
                        shipsGameBoard)) {
                    playerFleet.add(shipCreator.verticalShip(userCurrentRowChoice, userCurrentColChoice));
                    shipNumber++;
                } else {
                    System.out.println(shipsGameText.getMessage("show,wrong.coordinates"));
                    System.out.println(shipsGameText.getMessage("show.try.again"));
                }
            } else {
                shipsGameText.getMessage("show.wrong.layout.option");
                shipsGameText.getMessage("show.try.again");
            }

            shipsGameBoard.print();
        } while (shipNumber <= numberOfShips);
    }

    private static Player preparePlayer(String playerName) {
        return new Player(playerName);
    }

    private static TreeMap<Character, Integer> lettersAndDigits(int gameBoardSize) {
        TreeMap<Character, Integer> lettersAndDigits = new TreeMap<>();
        Character firstChar = 'A';
        Integer firstDigit = 0;
        for (int i = firstDigit; i <= gameBoardSize; i++) {
            lettersAndDigits.put(firstChar, firstDigit);
            firstChar++;
            firstDigit++;
        }
        return lettersAndDigits;
    }

    private static int convertLetterToDigit(TreeMap<Character, Integer> lettersAndDigits, Character userInput) {
        return lettersAndDigits.get(userInput);
    }

    private static boolean isStringIsLongerThanOne(String inputString) {
        if (inputString.length() > 1) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isStringHasDigit(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static int getPlayerRowChoice(Scanner scanner,
                                          Validator validator,
                                          int gameBoardSize) {
        int playerRowChoice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println(ValidatorWarning.getMessage("show.invalid.row.user.input"));
                System.out.println(ValidatorWarning.getMessage("show.try.again"));
                scanner.next();
            }
            playerRowChoice = scanner.nextInt();
            if (validator.validateRowColInput(playerRowChoice, gameBoardSize)) {
                System.out.println(ValidatorWarning.getMessage("show.invalid.row.user.input"));
                System.out.println(ValidatorWarning.getMessage("show.try.again"));
            }
        } while (validator.validateRowColInput(playerRowChoice, gameBoardSize));
        return playerRowChoice - 1;
    }
//przemyśleć unifikacje podawania wspolrzednych z klawiatury (litery i cyfry)

    private static char getPlayerColChoice(Scanner scanner, Validator validator, TreeMap<Character, Integer> lettersAndDigits) {
        String playerColChoiceByString;
        char playerColChoiceByChar;
        boolean isColInputCorrect;
        do {
            isColInputCorrect = true;
            playerColChoiceByString = scanner.next().toUpperCase();
            if (isStringIsLongerThanOne(playerColChoiceByString)) {
                System.out.println(ValidatorWarning.getMessage("show.string.to.long"));
                System.out.println(ValidatorWarning.getMessage("show.try.again"));
                isColInputCorrect = false;
            }
            if (isStringHasDigit(playerColChoiceByString)) {
                System.out.println(ValidatorWarning.getMessage("show.digit.in.string"));
                System.out.println(ValidatorWarning.getMessage("show.try.again"));
                isColInputCorrect = false;
            }
            if (!validator.validateColInput(playerColChoiceByString.charAt(0), lettersAndDigits)) {
                System.out.println(ValidatorWarning.getMessage("show.invalid.col.user.input"));
                System.out.println(ValidatorWarning.getMessage("show.try.again"));
                isColInputCorrect = false;
            }
        } while (!isColInputCorrect);
        playerColChoiceByChar = playerColChoiceByString.charAt(0);
        return playerColChoiceByChar;
    }

    private static int getLayoutOption(Scanner scanner,
                                       Validator validator,
                                       ShipLayoutMenuPrinter shipLayoutMenuPrinter) {
        int playerMenuChoice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println(ValidatorWarning.getMessage("show.invalid.user.input"));
                System.out.println(ValidatorWarning.getMessage("show.try.again"));
                shipLayoutMenuPrinter.print();
                scanner.next();
            }
            playerMenuChoice = scanner.nextInt();
            if (validator.validateMainMenuOption(playerMenuChoice)) {
                System.out.println(ValidatorWarning.getMessage("show.invalid.user.input"));
                System.out.println(ValidatorWarning.getMessage("show.try.again"));
                shipLayoutMenuPrinter.print();
            }
        } while (validator.validateMainMenuOption(playerMenuChoice));
        return playerMenuChoice;
    }

    private static void showCurrentPlayerBoards(Player playerOne,
                                                Player currentPlayer,
                                                GameBoard playerOneGameBoard,
                                                GameBoard playerTwoGameBoard,
                                                GameBoard playerOneCheckBoard,
                                                GameBoard playerTwoCheckBoard, ShipsGameText shipsGameText) {
        if (currentPlayer.equals(playerOne)) {
            System.out.println(shipsGameText.getMessage("show.player.checkboard",currentPlayer.getName()));
            playerOneCheckBoard.print();
            System.out.println(shipsGameText.getMessage("show.player.gameboard", currentPlayer.getName()));
            playerOneGameBoard.print();
        } else {
            System.out.println(shipsGameText.getMessage("show.player.checkboard",currentPlayer.getName()));
            playerTwoCheckBoard.print();
            System.out.println(shipsGameText.getMessage("show.player.gameboard", currentPlayer.getName()));
            playerTwoGameBoard.print();
        }
    }
}
