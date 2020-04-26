package pl.com.konrad.games.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
to do:
- log historii ruchow (ale ilość ruchów czy wspolrzedne)

 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameNotification gameNotification = new GameNotification();
        GameMenu gameMenu = new GameMenu();
        GameMenuPrinter gameMenuPrinter = new GameMenuPrinter(gameMenu);
        Validator validator = new Validator();
        GameLogic gameLogic = new GameLogic();

        gameNotification.showWelcomeMessage();

        boolean shouldPlay = true;
        do {
            gameMenuPrinter.print();
            int playerMenuChoice = getPlayerMenuChoice(scanner, gameNotification, validator, gameMenuPrinter);
            switch (GameMenuOption.menuOption(playerMenuChoice)) {
                case CHECKERS: {
                    Player playerOne = preparePlayer(scanner, validator,
                            gameNotification, Colors.WHITE,null);

                    Player playerTwo = preparePlayer(scanner, validator,
                            gameNotification, Colors.BLACK, playerOne.getName());

                    CheckerGameBoard checkerGameBoard = new CheckerGameBoard(playerOne, playerTwo);
                    checkerGameBoard.print();
                    gameLogic.move(playerOne.getFigureSet(),2,1,3,2);

                    checkerGameBoard.print();
                    System.out.println();
                    break;
                }

                case EXIT:
                    shouldPlay = false;
                    break;
            }
        } while (shouldPlay);
    }

    private static int getPlayerMenuChoice(Scanner scanner, GameNotification gameNotification, Validator validator,
                                           GameMenuPrinter gameMenuPrinter) {
        int playerMenuChoice;
        do {
            while (!scanner.hasNextInt()) {
                gameNotification.showInvalidUserInput();
                gameMenuPrinter.print();
                scanner.next();
            }
            playerMenuChoice = scanner.nextInt();
            if (validator.validateMainMenuOption(playerMenuChoice)) {
                gameNotification.showInvalidUserInput();
                gameMenuPrinter.print();
            }
        } while (validator.validateMainMenuOption(playerMenuChoice));
        return playerMenuChoice;
    }

    private static Player preparePlayer(Scanner scanner, Validator validator,
                                        GameNotification gameNotification, Colors playerColor, String existingName) {
        List<Figure> playerSet = new ArrayList<>();
        String name = validateUserName(scanner, validator, gameNotification, playerColor, existingName);
        return new Player(name, playerSet);
    }

    private static String validateUserName(Scanner scanner, Validator validator, GameNotification gameNotification, Colors playerColor, String existingName) {
        String name;
        boolean shouldInputNameAgain = true;
        do {
            gameNotification.showInputName(playerColor);
            name = scanner.next();
            if(!validator.isNameDuplicated(existingName, name)){
                shouldInputNameAgain = false;
            }
            else {
                gameNotification.showWrongNameInput(existingName);
            }
        } while (shouldInputNameAgain);
        return name;
    }
}
