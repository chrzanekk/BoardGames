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
//        Game game = null;

        boolean shouldPlay = true;
        do {
            Game game = null;
            checkersGameText.showWelcomeMessage();
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
            game.play(); // tu jest problem z nullpointerem. gdy inicjuje gre w linii 16 to po zakończeniu
            // jakiejkolwiek gry, wracajac do menu wyzej ponownie ta gra sie uruchamia (tictactoe - przygotowanie
            // gracza) i dopiero wtedy glowne menu sie pojawia i mozna wyjsc z gry. gdy przerzuce inicjacje gry do
            // linii 20 tak jak jest teraz to nie inicjuje sie nowa gra i menu dziala dobrze ale po wyjsciu z gry
            // wali mi nullpointerem. jak to rozwiazac poprawnie?

        } while (shouldPlay);
    }

    private static int getPlayerChoice(Scanner scanner,
                                       ValidatorWarning validatorWarning, Validator validator,
                                       GameMenuPrinter gameMenuPrinter) {
        int playerMenuChoice;
        do {
            while (!scanner.hasNextInt()) {
                validatorWarning.showInvalidUserInput();
                gameMenuPrinter.print();
                scanner.next();
            }
            playerMenuChoice = scanner.nextInt();
            if (validator.validateMainMenuOption(playerMenuChoice)) {
                validatorWarning.showInvalidUserInput();
                gameMenuPrinter.print();
            }
        } while (validator.validateMainMenuOption(playerMenuChoice));
        return playerMenuChoice;
    }
}
