package pl.com.konrad.games.board;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameNotification gameNotification = new GameNotification();
        GameMenu gameMenu = new GameMenu();
        GameMenuPrinter gameMenuPrinter = new GameMenuPrinter(gameMenu);
        Validator validator = new Validator();

        gameNotification.showWelcomeMessage();

        boolean shouldPlay = true;
        do {
            gameMenuPrinter.print();
            int playerMenuChoice = getPlayerMenuChoice(scanner, gameNotification, validator, gameMenuPrinter);
            switch (GameMenuOption.menuOption(playerMenuChoice)) {
                case CHECKERS: {
                    CheckersGame checkersGame = new CheckersGame();
                    checkersGame.play();
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
}
