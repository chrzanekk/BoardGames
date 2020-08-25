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

    private ShipsFigure[] ship = new ShipsFigure[3];
//    przemyslec jak rozwiazac problem dwoch list dla dwoch graczy i parametru dla ShipsGameLogic.
    private List<ShipsFigure[]> playerOneFleet = new ArrayList();
    private List<ShipsFigure[]> playerTwoFleet = new ArrayList();

    private ShipsGameLogic shipsGameLogic = new ShipsGameLogic(playerOneFleet);

    public void play() {
        Player playerOne = preparePlayer(getUserName(scanner, validator, shipsGameText.getMessage("show.player.one"), null));
        ShipsGameBoard playerOneGameBoard = new ShipsGameBoard(playerOne, playerOneFleet);
        Player currentPlayer = playerOne;
        // tu setup statkow na planszy gracza nr 1 (gracz podaje trzy wspolrzedne -> sprawdzenie czy "maszty" do
        // siebie przylegaja bokami a nie rogami + sprawdzenie czy statki nie stykaja sie rogami lub bokami)
        TreeMap<Character, Integer> lettersAndDigits = lettersAndDigits(playerOneGameBoard);
        int shipMast = 1;
        do {
            boolean isInputCorrect;
            do {
                isInputCorrect = true;
                int userRowChoice = getPlayerRowChoice(scanner, validator, playerOneGameBoard.getLength());
                char userColChoiceByChar = getPlayerColChoice(scanner, validator, lettersAndDigits);
                int userColChoiceByInt = convertLetterToDigit(lettersAndDigits, userColChoiceByChar);
//                przykladowy warunek metody bez logicznego ciala.
                if (!shipsGameLogic.isMastAreSideWays(userRowChoice,userColChoiceByInt)) {
                    isInputCorrect = false;
                }
            }
            while(!isInputCorrect);
            shipMast++;
        }while(shipMast<ship.length);





        Player playerTwo = preparePlayer(getUserName(scanner, validator, shipsGameText.getMessage("show.player.two"), playerOne.getName()));
// tu setup statkow na planszy gracza nr 2 (jak wyżej dla gracza 1 - jedna metoda to setupu statkow)

        ShipsGameBoard playerTwoGameBoard = new ShipsGameBoard(playerTwo, playerTwoFleet);



        playerOneGameBoard.print();


    }


    public String getUserName(Scanner scanner, Validator validator,
                              String playerDescription, String existingName) {
        String name;
        boolean shouldInputNameAgain = true;
        do {
            System.out.println(GameText.getMessage("show.input.name", playerDescription));
            name = scanner.next();
            if (!validator.isNameDuplicated(existingName, name)) {
                shouldInputNameAgain = false;
            } else {
                System.out.println(ValidatorWarning.getMessage("show.wrong.name.input"));
                System.out.println(ValidatorWarning.getMessage("show.try.again"));
            }
        } while (shouldInputNameAgain);
        return name;
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

}
