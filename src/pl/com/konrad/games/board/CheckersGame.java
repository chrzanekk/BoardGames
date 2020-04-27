package pl.com.konrad.games.board;
/*
to do:
- log historii ruchow (ale ilość ruchów czy wspolrzedne)

 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckersGame implements Game{
    Scanner scanner = new Scanner(System.in);


    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;

    private Validator validator = new Validator();
    private GameNotification gameNotification = new GameNotification();
    private GameLogic gameLogic = new GameLogic();

    @Override
    public void play() {
        playerOne = preparePlayer(scanner, validator,
                gameNotification, Colors.WHITE,null);

        playerTwo = preparePlayer(scanner, validator,
                gameNotification, Colors.BLACK, playerOne.getName());

        CheckerGameBoard checkerGameBoard = new CheckerGameBoard(playerOne, playerTwo);
        checkerGameBoard.print();
        gameLogic.move(playerOne.getFigureSet(),2,1,3,2);

        checkerGameBoard.print();
        System.out.println();

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
