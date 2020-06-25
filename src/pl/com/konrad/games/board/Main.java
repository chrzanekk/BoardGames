package pl.com.konrad.games.board;

import pl.com.konrad.games.board.checkers.CheckersGame;
import pl.com.konrad.games.board.chess.ChessGame;
import pl.com.konrad.games.board.tictactoe.TicTacToeGame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GameMenu gameMenu = new GameMenu();
        GameMenuPrinter gameMenuPrinter = new GameMenuPrinter(gameMenu);
        Validator validator = new Validator();
        Game game = null;

        boolean shouldPlay = true;
        do {
            System.out.println(GameText.getMessage("show.welcome.message"));
            gameMenuPrinter.print();
            int playerMenuChoice = getPlayerChoice(scanner, validator, gameMenuPrinter);
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
            if (game != null && shouldPlay) {
                game.play();
            }
        } while (shouldPlay);
    }

    private static int getPlayerChoice(Scanner scanner,
                                       Validator validator,
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
