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
        int userCurrentRowChoice;
        int userCurrentColChoice;
        boolean isGameFinished;
        do {
            isGameFinished = false;
            System.out.println(checkersGameText.getMessage("show.witch.player.move", currentPlayer.getName()));
            boolean isCurrentPawnPositionInputCorrect;
            do {
                isCurrentPawnPositionInputCorrect = true;
                System.out.println(checkersGameText.getMessage("show.choose.current.pawn.to.move"));
                System.out.println(checkersGameText.getMessage("show.input.row", Integer.toString(checkersGameBoard.getLength())));

                userCurrentRowChoice = getPlayerRowChoice(scanner, validator, checkersGameBoard);
                System.out.println(checkersGameText.getMessage("show.input.col", Character.toString(checkersGameBoard.generateLastLetterOfColumn('A',
                        checkersGameBoard.getLength()))));
                char userColChoiceByChar = getPlayerColChoice(scanner, validator, lettersAndDigits);
                userCurrentColChoice = convertLetterToDigit(lettersAndDigits, userColChoiceByChar);

                CheckersPlayerLogic.showPlayerInput(userCurrentRowChoice,userColChoiceByChar,userCurrentColChoice,gameLogic);

                //check is pawn to move exist - working
                if (!gameLogic.isFigureExist(userCurrentRowChoice, userCurrentColChoice)) {
                    System.out.println(checkersGameText.getMessage("show.empty.row.col"));
                    System.out.println(checkersGameText.getMessage("show.try.again"));
                    isCurrentPawnPositionInputCorrect = false;
                    continue;
                }

//        check for correct player pawn choose - working
                if (!gameLogic.isFigureBelongToPlayer(userCurrentRowChoice, userCurrentColChoice, currentPlayer.getName())) {
                    System.out.println(checkersGameText.getMessage("show.pawn.does.not.belong.to.current.player"));
                    System.out.println(checkersGameText.getMessage("show.choose.another"));
                    isCurrentPawnPositionInputCorrect = false;
                    continue;
                }

//            check if player can move current pawn - working but need some improvements.
//            check if player can move and capture pawn - in development
//                tu jest problem - sprawdzanie miejsca dla koordynatow (3,F) konczy sie informacja o braku
//                mozliwosci ruchu mimo iz mozliwosc bicia istnieje.
                if (!gameLogic.isPlayerCanMovePawn(currentPlayer, playerOne, userCurrentRowChoice, userCurrentColChoice,
                        checkersGameBoard.getLength()) || !gameLogic.isPlayerCanCapturePawn(currentPlayer, playerOne,
                        userCurrentRowChoice, userCurrentColChoice, checkersGameBoard.getLength())) {
                    System.out.println(checkersGameText.getMessage("show.player.cant.move.pawn") + " or " + checkersGameText.getMessage("show.capture.unavailable"));
                    System.out.println(checkersGameText.getMessage("show.choose.another"));
                    isCurrentPawnPositionInputCorrect = false;
                }

                //check if player can capture other pawn - in development

            } while (!isCurrentPawnPositionInputCorrect);

            boolean isNewPawnPositionCorrect;
            do {
                isNewPawnPositionCorrect = true;
                System.out.println(checkersGameText.getMessage("show.new.pawn.position"));
                System.out.println(checkersGameText.getMessage("show.input.row", Integer.toString(checkersGameBoard.getLength())));
                int userNewRowChoice = getPlayerRowChoice(scanner, validator, checkersGameBoard);
                System.out.println(checkersGameText.getMessage("show.input.col", Character.toString(checkersGameBoard.generateLastLetterOfColumn('A',
                        checkersGameBoard.getLength()))));
                char userColChoiceByChar = getPlayerColChoice(scanner, validator, lettersAndDigits);
                int userNewColChoice = convertLetterToDigit(lettersAndDigits, userColChoiceByChar);
                System.out.println();

//            check if new position is available
                if (gameLogic.isFigureExist(userNewRowChoice, userNewColChoice)) {
                    System.out.println(checkersGameText.getMessage("show.field.not.available"));
                    System.out.println(checkersGameText.getMessage("show.try.again"));
                    isNewPawnPositionCorrect = false;
                    continue;
                }

                if (gameLogic.isPlayerCanMovePawn(currentPlayer, playerOne, userNewRowChoice, userNewColChoice,
                        checkersGameBoard.getLength())) {
                    gameLogic.movePawn(currentPlayer, gameLogic.getFigureByRowCol(userCurrentRowChoice,
                            userCurrentColChoice).getType(), gameLogic.getFigureByRowCol(userCurrentRowChoice,
                            userCurrentColChoice).getMark(), gameLogic.getFigureByRowCol(userCurrentRowChoice,
                            userCurrentColChoice).getColor(), userNewRowChoice, userNewColChoice, userCurrentRowChoice, userCurrentColChoice);
                    checkersGameBoard.print();
                    gameLogic.swapPlayer(currentPlayer, playerOne, playerTwo);
                    continue;


                } else {
                    isNewPawnPositionCorrect = false;
                }

                checkersGameBoard.print();


                //check if player can capture other pawn + check if next capture is possible - in development


//
            } while (!isNewPawnPositionCorrect);
            isGameFinished = true;
        } while (isGameFinished);
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
                System.out.println(checkersGameText.getMessage("show.try.again"));
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
                System.out.println(checkersGameText.getMessage("show.try.again"));
                scanner.next();
            }
            playerRowChoice = scanner.nextInt();
            if (validator.validateRowColInput(playerRowChoice, gameBoard)) {
                System.out.println(ValidatorWarning.getMessage("show.invalid.row.user.input"));
                System.out.println(checkersGameText.getMessage("show.try.again"));
            }
        } while (validator.validateRowColInput(playerRowChoice, gameBoard));
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
                System.out.println(checkersGameText.getMessage("show.try.again"));
                isColInputCorrect = false;
            }
            if (isStringHasDigit(playerColChoiceByString)) {
                System.out.println(ValidatorWarning.getMessage("show.digit.in.string"));
                System.out.println(checkersGameText.getMessage("show.try.again"));
                isColInputCorrect = false;
            }
            if (!validator.validateColInput(playerColChoiceByString.charAt(0), lettersAndDigits)) {
                System.out.println(ValidatorWarning.getMessage("show.invalid.col.user.input"));
                System.out.println(checkersGameText.getMessage("show.try.again"));
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
