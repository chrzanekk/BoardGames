package pl.com.konrad.games.board;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CheckersGameNotification checkersGameNotification = new CheckersGameNotification();

        GameMenu gameMenu = new GameMenu();
        GameMenuPrinter gameMenuPrinter = new GameMenuPrinter(gameMenu);
        CheckersValidator checkersValidator = new CheckersValidator();
        Game game = null;

        checkersGameNotification.showWelcomeMessage();

        boolean shouldPlay = true;
        do {
            gameMenuPrinter.print();
            int playerMenuChoice = getPlayerMenuChoice(scanner, checkersGameNotification, checkersValidator, gameMenuPrinter);
            switch (GameMenuOption.menuOption(playerMenuChoice)) {
                case CHECKERS: {
                    game = new CheckersGame();
                    break;
                }
                case CHESS: {
                    game = new ChessGame();
                    break;
                }

                case TIC_TAC_TOE: {
                    game = new TicTacToeGame();
                    break;
                }

                case EXIT:
                    shouldPlay = false;
                    break;
            }
            game.play();
        } while (shouldPlay);
    }

    private static int getPlayerMenuChoice(Scanner scanner, CheckersGameNotification checkersGameNotification, CheckersValidator checkersValidator,
                                           GameMenuPrinter gameMenuPrinter) {
        int playerMenuChoice;
        do {
            while (!scanner.hasNextInt()) {
                checkersGameNotification.showInvalidUserInput();
                gameMenuPrinter.print();
                scanner.next();
            }
            playerMenuChoice = scanner.nextInt();
            if (checkersValidator.validateMainMenuOption(playerMenuChoice)) {
                checkersGameNotification.showInvalidUserInput();
                gameMenuPrinter.print();
            }
        } while (checkersValidator.validateMainMenuOption(playerMenuChoice));
        return playerMenuChoice;
    }
}
