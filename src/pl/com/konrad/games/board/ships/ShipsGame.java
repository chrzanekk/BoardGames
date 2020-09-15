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

    private static final int NUMBER_OF_SHIPS = 4;

    private List<Ship> playerOneFleet = new ArrayList();
    private List<Ship> playerTwoFleet = new ArrayList();
    private List<Ship> playerOneFleetToHit = new ArrayList();
    private List<Ship> playerTwoFleetToHit = new ArrayList();

    private ShipsGameLogic playerOneShipsGameLogic = new ShipsGameLogic(playerOneFleet);
    private ShipsGameLogic playerTwoShipsGameLogic = new ShipsGameLogic(playerTwoFleet);
    private ShipsGameLogic playerOneShipsGameLogicToHit = new ShipsGameLogic(playerOneFleetToHit);
    private ShipsGameLogic playerTwoShipsGameLogicToHit = new ShipsGameLogic(playerTwoFleetToHit);

    public void play() {

        Player playerOne = preparePlayer(getUserName(scanner, validator, shipsGameText.getMessage("show.player.one"), null));
        ShipsGameBoard playerOneGameBoard = new ShipsGameBoard(playerOne, playerOneFleet);
        ShipsGameBoard playerOneGameBoardToHit = new ShipsGameBoard(playerOne, playerOneFleetToHit);
        playerOneGameBoardToHit.setup();
        Player currentPlayer = playerOne;
        playerOneGameBoardToHit.print();
        TreeMap<Character, Integer> lettersAndDigits = lettersAndDigits(playerOneGameBoard);
        ShipCreator shipFactoryThreeMast = new ShipCreator(3,
                Color.WHITE,
                playerOne,
                ShipGameBoardMark.THREE_MASTS,
                playerOneGameBoard,
                playerOneShipsGameLogic);
        int shipNumber = 0;
        do {
            playerOneGameBoard.print();
            layoutMenuPrinter.print();
            System.out.println(shipsGameText.getMessage("show.layout.option"));
            int layoutOption = getPlayerChoice(scanner, validator, layoutMenuPrinter);
            int userCurrentRowChoice;
            int userCurrentColChoice;
            System.out.println(shipsGameText.getMessage("show.input.row", Integer.toString(playerOneGameBoard.getLength())));
            userCurrentRowChoice = getPlayerRowChoice(scanner, validator, playerOneGameBoard.getLength());
            System.out.println(shipsGameText.getMessage("show.input.col", Character.toString(playerOneGameBoard.generateLastLetterOfColumn('A',
                    playerOneGameBoard.getLength()))));
            char userColChoiceByChar = getPlayerColChoice(scanner, validator, lettersAndDigits);
            userCurrentColChoice = convertLetterToDigit(lettersAndDigits, userColChoiceByChar);

            if (layoutOption == ShipLayoutOption.HORIZONTAL.value()) {
                if(!playerOneShipsGameLogic.isMastsCollideForHorizontal(userCurrentRowChoice,
                        userCurrentColChoice,
                        shipFactoryThreeMast.getShipSize(),
                        playerOneGameBoard)) {
                    playerOneFleet.add(shipFactoryThreeMast.horizontalShip(userCurrentRowChoice, userCurrentColChoice));
                    shipNumber++;
                }
                else{
                    shipsGameText.getMessage("show,wrong.coordinates");
                    shipsGameText.getMessage("show.try.again");
                    continue;
                }
            } else if (layoutOption == ShipLayoutOption.VERTICAL.value()) {
                if(!playerOneShipsGameLogic.isMastsCollideForVertical(userCurrentRowChoice,
                        userCurrentColChoice,
                        shipFactoryThreeMast.getShipSize(),
                        playerOneGameBoard)) {
                    playerOneFleet.add(shipFactoryThreeMast.verticalShip(userCurrentRowChoice, userCurrentColChoice));
                    shipNumber++;
                }
                else {
                    shipsGameText.getMessage("show,wrong.coordinates");
                    shipsGameText.getMessage("show.try.again");
                    continue;
                }
            } else {
                shipsGameText.getMessage("show.wrong.layout.option");
                shipsGameText.getMessage("show.try.again");
            }
            playerOneGameBoard.print();

        }while(shipNumber<NUMBER_OF_SHIPS);




    }

    private static Player preparePlayer(String playerName) {
        return new Player(playerName);
    }

    private static TreeMap<Character, Integer> lettersAndDigits(GameBoard gameBoard) {
        TreeMap<Character, Integer> lettersAndDigits = new TreeMap<>();
        Character firstChar = 'A';
        Integer firstDigit = 0;
        for (int i = firstDigit; i <= gameBoard.getLength(); i++) {
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

    private static int getPlayerChoice(Scanner scanner,
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
}
