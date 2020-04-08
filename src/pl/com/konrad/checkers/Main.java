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
                    CheckersPlayer playerOne = setNewPlayer(new CheckersPawn(CheckersPawnTypes.WHITE_MEN.description(),
                                    CheckersPawnTypes.WHITE_MEN.pawn()), scanner,
                            gameNotification);
                    CheckersPlayer playerTwo = setNewPlayer(new CheckersPawn(CheckersPawnTypes.BLACK_MEN.description(),
                                    CheckersPawnTypes.BLACK_MEN.pawn()), scanner,
                            gameNotification);

                    GameCheckerBoard gameCheckerBoard = new GameCheckerBoard(playerOne, playerTwo);
                    GameBoardPrinter printer = new GameBoardPrinter();

                    printer.print(gameCheckerBoard);
                    System.out.println();
                    System.out.println(gameCheckerBoard.getPosition(2, 1));

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

    private static CheckersPlayer setNewPlayer(CheckersPawn pawn, Scanner scanner,
                                               GameNotification gameNotification) {
        gameNotification.showInputName(pawn.getDescription());
        return new CheckersPlayer(scanner.next(), pawn.getPawnMark());
    }
}
