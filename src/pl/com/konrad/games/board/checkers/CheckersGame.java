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
    private static CheckersGameText checkersGameText = new CheckersGameText();
    private List<CheckersFigure> figures = new ArrayList<>();


    @Override
    public void play() {
        CheckersGameLogic gameLogic = new CheckersGameLogic(figures);
        Player playerOne = preparePlayer(scanner, validator, checkersGameText, Color.WHITE, null);
        Player currentPlayer = playerOne;
        Player playerTwo = preparePlayer(scanner, validator, checkersGameText, Color.BLACK, playerOne.getName());


        CheckersGameBoard checkersGameBoard = new CheckersGameBoard(playerOne, playerTwo, figures);
        TreeMap<Character, Integer> lettersAndDigits = lettersAndDigits(checkersGameBoard);
        checkersGameBoard.print();
        System.out.println(checkersGameText.getMessage("show.witch.player.move", currentPlayer.getName()));
        boolean isCurrentPawnPositionInputCorrect;
        do {
            isCurrentPawnPositionInputCorrect = true;
            System.out.println(checkersGameText.getMessage("show.choose.current.pawn.to.move"));
            System.out.println(checkersGameText.getMessage("show.input.row", Integer.toString(checkersGameBoard.getLength())));

            int userRowChoice = getPlayerRowChoice(scanner, validator, checkersGameBoard);
            System.out.println(checkersGameText.getMessage("show.input.col", Character.toString(checkersGameBoard.generateLastLetterOfColumn('A',
                    checkersGameBoard.getLength()))));
            char userColChoiceByChar = getPlayerColChoice(scanner, validator, lettersAndDigits, checkersGameBoard);
            int userColChoice = convertLetterToDigit(lettersAndDigits, userColChoiceByChar);

            System.out.println("***************************");
            System.out.println("Checking what player choose");
            System.out.println("row: " + userRowChoice + "; col: (char)" + userColChoiceByChar + "/(int)" + userColChoice);
            System.out.println(gameLogic.getFigureByRowCol(userRowChoice, userColChoice).getMark().pawn());
            System.out.println("***************************");

            //check is pawn to move exist - working
            if (!gameLogic.isFigureExistByRowCol(userRowChoice, userColChoice)) {
                System.out.println(checkersGameText.getMessage("show.empty.row.col"));
                isCurrentPawnPositionInputCorrect = false;
                continue;
            }

//        check for correct player pawn choose - working
            if (!gameLogic.isFigureBelongToPlayer(userRowChoice, userColChoice, currentPlayer.getName())) {
                System.out.println(checkersGameText.getMessage("show.pawn.does.not.belong.to.current.player"));
                isCurrentPawnPositionInputCorrect = false;
                continue;
            }

//            check if player can move current pawn
            if (gameLogic.isPlayerCanMovePawn(currentPlayer, playerOne, playerTwo, userRowChoice, userColChoice,
                    checkersGameBoard.getLength())) {
                System.out.println(checkersGameText.getMessage("show.player.cant.move.pawn"));
                isCurrentPawnPositionInputCorrect = false;
            }

            //check  if player can beat other pawn - in developement

        } while (!isCurrentPawnPositionInputCorrect);

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
                System.out.println(ValidatorWarning.getMessage("show.invalid.row.user.input"));
                scanner.next();
            }
            playerRowChoice = scanner.nextInt();
            if (validator.validateRowColInput(playerRowChoice, gameBoard)) {
                System.out.println(ValidatorWarning.getMessage("show.invalid.row.user.input"));
            }
        } while (validator.validateRowColInput(playerRowChoice, gameBoard));
        return playerRowChoice - 1;
    }

    private static char getPlayerColChoice(Scanner scanner, Validator validator, TreeMap<Character, Integer> lettersAndDigits, CheckersGameBoard checkersGameBoard) {
        String playerColChoiceByString;
        char playerColChoiceByChar;
        boolean isColInputCorrect;
        do {
            isColInputCorrect = true;
            playerColChoiceByString = scanner.next().toUpperCase();
            if (isStringIsLongerThanOne(playerColChoiceByString)) {
                System.out.println(ValidatorWarning.getMessage("show.string.to.long"));
                isColInputCorrect = false;
            }
            if (isStringHasDigit(playerColChoiceByString)) {
                System.out.println(ValidatorWarning.getMessage("show.digit.in.string"));
                isColInputCorrect = false;
            }
            if (!validator.validateColInput(playerColChoiceByString.charAt(0), lettersAndDigits)) {
                System.out.println(ValidatorWarning.getMessage("show.invalid.col.user.input"));
                isColInputCorrect = false;
            }
        } while (!isColInputCorrect);
        playerColChoiceByChar = playerColChoiceByString.charAt(0);
        return playerColChoiceByChar;
    }

    private static TreeMap<Character, Integer> lettersAndDigits(GameBoard gameBoard) {
        TreeMap<Character, Integer> lettersAndDigits = new TreeMap<>();
        Character firstChar = 'A';
        Integer fistDigit = 0;
        for (int i = fistDigit; i <= gameBoard.getLength(); i++) {
            lettersAndDigits.put(firstChar, fistDigit);
            firstChar++;
            fistDigit++;
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
