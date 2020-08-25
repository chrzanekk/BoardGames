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

//    nie wiem czy w dobrym miejscu będzie ta tablica i lista - ale chyba tutaj w momencie przygotowania gracza.
//    statek trzymasztowy stad tablica z trzema indeksami
    private ShipsFigure[] ship = new ShipsFigure[3];
//    flota gracza - limit 3 statki dla planszy 10x10? w zaleznosci od tablicy na jakiej przyjdzie grac
    private List<ShipsFigure[]> playerOneFleet = new ArrayList();
    private List<ShipsFigure[]> playerTwoFleet = new ArrayList();

    public void play() {
        Player playerOne = preparePlayer(getUserName(scanner, validator, "Player One", null));
        Player currentPlayer = playerOne;
        // tu setup statkow na planszy gracza nr 1

        ShipsGameBoard playerOneGameBoard = new ShipsGameBoard(playerOne, playerOneFleet);



        Player playerTwo = preparePlayer(getUserName(scanner, validator, "Player Two", playerOne.getName()));
// tu setup statkow na planszy gracza nr 2

        ShipsGameBoard playerTwoGameBoard = new ShipsGameBoard(playerTwo, playerTwoFleet);


        TreeMap<Character, Integer> lettersAndDigits = lettersAndDigits(playerOneGameBoard);
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

}
