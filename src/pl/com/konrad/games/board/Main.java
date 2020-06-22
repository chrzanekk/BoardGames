package pl.com.konrad.games.board;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CheckersGameText checkersGameText = new CheckersGameText();

        GameMenu gameMenu = new GameMenu();
        GameMenuPrinter gameMenuPrinter = new GameMenuPrinter(gameMenu);
        Validator validator = new Validator();
        ValidatorWarning validatorWarning = new ValidatorWarning();
        Game game = null;

        boolean shouldPlay = true;
        do {
            System.out.println(checkersGameText.getMessage("show.welcome.message"));
            gameMenuPrinter.print();
            int playerMenuChoice = getPlayerChoice(scanner, validatorWarning, validator, gameMenuPrinter);
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
            if (game != null) {
                game.play();
            }
        } while (shouldPlay);
    }

    private static int getPlayerChoice(Scanner scanner,
                                       ValidatorWarning validatorWarning, Validator validator,
                                       GameMenuPrinter gameMenuPrinter) {
        int playerMenuChoice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println(ValidatorWarning.getMessage("show.invalid.user.input"));
                gameMenuPrinter.print();
                scanner.next();
            }
            playerMenuChoice = scanner.nextInt();
            if (validator.validateMainMenuOption(playerMenuChoice)) {
                System.out.println(ValidatorWarning.getMessage("show.invalid.user.input"));
                gameMenuPrinter.print();
            }
        } while (validator.validateMainMenuOption(playerMenuChoice));
        return playerMenuChoice;
    }
}
