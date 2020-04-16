package pl.com.konrad.checkers;

import java.util.Scanner;

/*
to do:
- menu
- wprowadzenie nazw graczy
- log historii ruchow (ale ilość ruchów czy wspolrzedne)

 */
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
                    CheckersPlayer playerOne = preparePlayer(new CheckersPawn(
                                    CheckersMark.WHITE_MEN.pawn()), scanner,
                            gameNotification, Colors.WHITE.Description());
                    CheckersPlayer playerTwo = preparePlayer(new CheckersPawn(
                                    CheckersMark.BLACK_MEN.pawn()), scanner,
                            gameNotification, Colors.BLACK.Description());

                    GameCheckerBoard gameCheckerBoard = new GameCheckerBoard(playerOne, playerTwo);
                    GameBoardPrinter printer = new GameBoardPrinter(gameCheckerBoard);

                    printer.print();
                    System.out.println();
                    break;
                }

                case EXIT:
                    shouldPlay = false;
                    break;
            }
        } while (shouldPlay);


    }

    private static int getPlayerMenuChoice(Scanner scan, GameNotification gameNotification, Validator validator,
                                           GameMenuPrinter gameMenuPrinter) {
        int playerMenuChoice;
        do {
            while (!scan.hasNextInt()) {
                gameNotification.showInvalidUserInput();
                gameMenuPrinter.print();
                scan.next();
            }
            playerMenuChoice = scan.nextInt();
            if (validator.validateMainMenuOption(playerMenuChoice)) {
                gameNotification.showInvalidUserInput();
                gameMenuPrinter.print();
            }
        } while (validator.validateMainMenuOption(playerMenuChoice));
        return playerMenuChoice;
    }

    private static CheckersPlayer preparePlayer(CheckersPawn pawn, Scanner scanner,
                                                GameNotification gameNotification, String description) {
        gameNotification.showInputName(description);
        return new CheckersPlayer(scanner.next(), pawn.getPawnMark());
    }
}
