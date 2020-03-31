package pl.com.konrad.checkers;

import java.util.Scanner;

/*
to do:
- menu
- wprowadzenie nazw graczy
- log historii ruchow (ale ilość ruchów czy wspolrzedne)
- pionowe litery + indeksy w enum?
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
            int playerMenuChoice = scanner.nextInt();

            switch (playerMenuChoice) {
                case 1: {
                    GameBoard gameBoard = new GameBoard();
                    GameBoardPrinter printer = new GameBoardPrinter();
                    printer.print(gameBoard);
                    System.out.println();
                    break;
                }

                case 2:
                    shouldPlay = false;
                    break;
            }
        } while (shouldPlay);


    }
}
