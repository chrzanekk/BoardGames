package pl.com.konrad.games.board;

import java.util.ArrayList;
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

        gameNotification.showWelcomeMessage();

        boolean shouldPlay = true;
        do {
            gameMenuPrinter.print();
            int playerMenuChoice = getPlayerMenuChoice(scanner, gameNotification, validator, gameMenuPrinter);
            switch (GameMenuOption.menuOption(playerMenuChoice)) {
                case CHECKERS: {
                    Player playerOne = preparePlayer(scanner,
                            gameNotification, Colors.WHITE.Description());
                    Player playerTwo = preparePlayer(scanner,
                            gameNotification, Colors.BLACK.Description());

                    CheckerGameBoard checkerGameBoard = new CheckerGameBoard(playerOne, playerTwo);
                    GameBoardPrinter printer = new GameBoardPrinter(checkerGameBoard);

                    printer.print();
                    System.out.println();
                    checkerGameBoard.pawnChangePosition(playerOne,2,1,3,2);
                    printer.print();
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

    private static Player preparePlayer(Scanner scanner,
                                        GameNotification gameNotification, String playerColor) {
        ArrayList<Figure> playerSet = new ArrayList<>();
        gameNotification.showInputName(playerColor);

        return new Player(scanner.next(), playerSet);//wymyslic jak sprawdzic dublowanie imion graczy.
    }
}
