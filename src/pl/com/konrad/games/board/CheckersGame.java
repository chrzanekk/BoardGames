package pl.com.konrad.games.board;
/*
to do:
- log historii ruchow (ale ilość ruchów czy wspolrzedne)

 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckersGame implements Game{
    private Scanner scanner = new Scanner(System.in);

    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;

    private CheckersValidator checkersValidator = new CheckersValidator();
    private CheckersGameNotification checkersGameNotification = new CheckersGameNotification();
    private CheckersGameLogic checkersGameLogic = new CheckersGameLogic();

    @Override
    public void play() {
        playerOne = preparePlayer(scanner, checkersValidator,
                checkersGameNotification, Color.WHITE,null);
        currentPlayer = playerOne;
        playerTwo = preparePlayer(scanner, checkersValidator,
                checkersGameNotification, Color.BLACK, playerOne.getName());

        CheckersGameBoard checkersGameBoard = new CheckersGameBoard(playerOne, playerTwo);
        checkersGameBoard.print();
        boolean isInputIncorrect = false;
        do {
            checkersGameNotification.showWhichPlayerMove(currentPlayer.getName());
            checkersGameNotification.showCurrentPawnToMove();
            checkersGameNotification.showInputRow(checkersGameBoard.getLength());
            checkersGameNotification.showInputCol(checkersGameBoard.getLength());
            checkersGameNotification.showNewPawnPosition();
            checkersGameNotification.showInputRow(checkersGameBoard.getLength());
            checkersGameNotification.showInputCol(checkersGameBoard.getLength());
            System.out.println();
        }while (isInputIncorrect);
    }
    private static Player preparePlayer(Scanner scanner, CheckersValidator checkersValidator,
                                        CheckersGameNotification checkersGameNotification, Color playerColor, String existingName) {
        List<Figure> playerSet = new ArrayList<>();
        String name = validateUserName(scanner, checkersValidator, checkersGameNotification, playerColor, existingName);
        return new Player(name, playerSet);
    }

    private static String validateUserName(Scanner scanner, CheckersValidator checkersValidator, CheckersGameNotification checkersGameNotification, Color playerColor, String existingName) {
        String name;
        boolean shouldInputNameAgain = true;
        do {
            checkersGameNotification.showInputName(playerColor);
            name = scanner.next();
            if(!checkersValidator.isNameDuplicated(existingName, name)){
                shouldInputNameAgain = false;
            }
            else {
                checkersGameNotification.showWrongNameInput(existingName);
            }
        } while (shouldInputNameAgain);
        return name;
    }
}
