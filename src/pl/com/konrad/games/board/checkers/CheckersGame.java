package pl.com.konrad.games.board.checkers;
/*
to do:
- log historii ruchow (ale ilość ruchów czy wspolrzedne)
- metoda move dla dwoch graczy/dwa kierunki?
- metoda move dla damki?
- metoda kick/ban/score? dla damki oddzielna?
- metoda zmiany pionka w damke.

*/


import pl.com.konrad.games.board.*;

import java.util.*;

public class CheckersGame implements Game {
    private Scanner scanner = new Scanner(System.in);

    private Validator validator = new Validator();
    private CheckersGameText checkersGameText = new CheckersGameText();
    private List<CheckersFigure> figures = new ArrayList<>();
    private TreeMap<Character, Integer> lettersAndDigits;


    @Override
    public void play() {
        CheckersGameLogic gameLogic = new CheckersGameLogic(figures);
        Player playerOne = preparePlayer(scanner, validator, checkersGameText, Color.WHITE, null);
        Player currentPlayer = playerOne;
        Player playerTwo = preparePlayer(scanner, validator, checkersGameText, Color.BLACK, playerOne.getName());


        CheckersGameBoard checkersGameBoard = new CheckersGameBoard(playerOne, playerTwo, figures);
        lettersAndDigits = lettersAndDigits(checkersGameBoard);
        checkersGameBoard.print();
        System.out.println(checkersGameText.getMessage("show.witch.player.move", currentPlayer.getName()));
        boolean isCurrentPawnPositionCorrect = true;
        do {

            System.out.println(checkersGameText.getMessage("show.choose.current.pawn.to.move"));
            System.out.println(checkersGameText.getMessage("show.input.row", Integer.toString(checkersGameBoard.getLength())));

            int userRowChoice = getPlayerRowChoice(scanner, validator, checkersGameBoard);
            boolean isInputColCorrect = true;

            System.out.println(checkersGameText.getMessage("show.input.col", Character.toString(checkersGameBoard.generateLastLetterOfColumn('A',
                    checkersGameBoard.getLength()))));
            int userColChoice = getPlayerColChoice(scanner, validator, checkersGameBoard, lettersAndDigits);
            System.out.println(userRowChoice + " " + userColChoice);
            //check is pawn to move exist
//            if (!gameLogic.isFigureExistByRowCol(userRowChoice, userColChoice)) {
//                System.out.println(checkersGameText.getMessage("show.empty.row.col"));
//                isCurrentPawnPositionCorrect = false;
//
//            }

            //check for correct player pawn choose (do sprawdzenia)
//            if (gameLogic.isFigureBelongToPlayer(userRowChoice, userColChoice, currentPlayer.getName())) {
//                System.out.println(checkersGameText.getMessage("show.pawn.doesnt.belong.to.current.player"));
//                isCurrentPawnPositionCorrect = false;
//            }
            //check if player can move current pawn
            if (!gameLogic.isPlayerCanMovePawn(currentPlayer, playerOne, playerTwo, userRowChoice, userColChoice,
                    checkersGameBoard.getLength())) {
                System.out.println(checkersGameText.getMessage("show.player.cant.move.pawn"));
                isCurrentPawnPositionCorrect = false;
            }
            //check  if player can beat other pawn


        } while (!isCurrentPawnPositionCorrect);

        boolean isNewPawnPositionCorrect = false;
        do {
            System.out.println(checkersGameText.getMessage("show.new.pawn.position"));
            System.out.println(checkersGameText.getMessage("show.input.row", Integer.toString(checkersGameBoard.getLength())));
            System.out.println(checkersGameText.getMessage("show.input.col", Character.toString(checkersGameBoard.generateLastLetterOfColumn('A',
                    checkersGameBoard.getLength()))));
            System.out.println();
        } while (isNewPawnPositionCorrect);
    }

    private static Player preparePlayer(Scanner scanner, Validator validator,
                                        CheckersGameText checkersGameText, Color playerColor, String existingName) {
        String name = validateUserName(scanner, validator, checkersGameText, playerColor,
                existingName);
        return new Player(name);
    }

    private static String validateUserName(Scanner scanner, Validator validator,
                                           CheckersGameText checkersGameText,
                                           Color playerColor, String existingName) {
        String name;
        boolean shouldInputNameAgain = true;
        do {
            System.out.println(checkersGameText.getMessage("show.input.name", playerColor.description()));
            name = scanner.next();
            if (!validator.isNameDuplicated(existingName, name)) {
                shouldInputNameAgain = false;
            } else {
                System.out.println(ValidatorWarning.getMessage("show.wrong.name.input"));
            }
        } while (shouldInputNameAgain);
        return name;
    }

    private static int getPlayerRowChoice(Scanner scanner,
                                          Validator validator,
                                          GameBoard gameBoard) {
        int playerRowChoice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println(ValidatorWarning.getMessage("show.invalid.user.input"));
                scanner.next();
            }
            playerRowChoice = scanner.nextInt();
            if (validator.validateRowColInput(playerRowChoice, gameBoard)) {
                System.out.println(ValidatorWarning.getMessage("show.invalid.user.input"));
            }
        } while (validator.validateRowColInput(playerRowChoice, gameBoard));
        return playerRowChoice - 1;
    }

    private static int getPlayerColChoice(Scanner scanner, Validator validator, GameBoard gameBoard, TreeMap<Character, Integer> lettersAndDigits) {
        int playerColChoiceByInt;
        String playerColChoiceByString;
        char playerColChoiceByChar;
        do {
            playerColChoiceByString = scanner.next().toUpperCase();
            if (!checkStringLength(playerColChoiceByString)) {
                System.out.println(ValidatorWarning.getMessage("show.string.to.long"));
            }
            if (!isStringHasDigit(playerColChoiceByString)){
                System.out.println(ValidatorWarning.getMessage("show.digit.in.string"));
            }

        }while (!checkStringLength(playerColChoiceByString) && !isStringHasDigit(playerColChoiceByString));
        playerColChoiceByChar = playerColChoiceByString.charAt(0);
        playerColChoiceByInt = convertLetterToDigit(lettersAndDigits,playerColChoiceByChar);
        do {
            if (validator.validateRowColInput(playerColChoiceByInt, gameBoard)) {
                System.out.println(ValidatorWarning.getMessage("show.invalid.user.input"));
            }

        } while (validator.validateRowColInput(playerColChoiceByInt, gameBoard));
        return playerColChoiceByInt;
    }

    private static TreeMap<Character, Integer> lettersAndDigits(GameBoard gameBoard) {
        TreeMap<Character, Integer> lettersAndDigits = new TreeMap<>();
        Character firstChar = 'A';
        Integer fistDigit = 1;
        for (int i = fistDigit; i < gameBoard.getLength(); i++) {
            lettersAndDigits.put(firstChar, fistDigit);
            firstChar++;
            fistDigit++;
        }
        return lettersAndDigits;
    }

    private static int convertLetterToDigit(TreeMap<Character, Integer> lettersAndDigits, Character userInput) {
        int convertedValue = 1;
        for (Map.Entry<Character, Integer> entry : lettersAndDigits.entrySet()) {
            if (entry.getKey().equals(userInput)) {
                convertedValue = entry.getValue();
            }
        }
        return convertedValue;
    }

    private static boolean checkStringLength(String inputString) {
        if (inputString.length() == 1) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isStringHasDigit(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
