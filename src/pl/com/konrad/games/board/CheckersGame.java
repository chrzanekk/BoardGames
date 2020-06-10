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

    private Validator validator = new Validator();
    private CheckersGameText checkersGameText = new CheckersGameText();
    private CheckersGameLogic checkersGameLogic = new CheckersGameLogic();
    private ValidatorWarning validatorWarning = new ValidatorWarning();

    @Override
    public void play() {
        playerOne = preparePlayer(scanner, validator, validatorWarning,
                checkersGameText, Color.WHITE,null);
        currentPlayer = playerOne;
        playerTwo = preparePlayer(scanner, validator, validatorWarning,
                checkersGameText, Color.BLACK, playerOne.getName());

        CheckersGameBoard checkersGameBoard = new CheckersGameBoard(playerOne, playerTwo);
        checkersGameBoard.print();
        boolean isInputIncorrect = false;
        do {
            checkersGameText.showWhichPlayerMove(currentPlayer.getName());
            checkersGameText.showCurrentPawnToMove();
            checkersGameText.showInputRow(checkersGameBoard.getLength());
            checkersGameText.showInputCol(checkersGameBoard.getLength());
            checkersGameText.showNewPawnPosition();
            checkersGameText.showInputRow(checkersGameBoard.getLength());
            checkersGameText.showInputCol(checkersGameBoard.getLength());
            System.out.println();
        }while (isInputIncorrect);
    }
    private static Player preparePlayer(Scanner scanner, Validator validator, ValidatorWarning validatorWarning,
                                        CheckersGameText checkersGameText, Color playerColor, String existingName) {
        List<Figure> playerSet = new ArrayList<>();
        String name = validateUserName(scanner, validator, validatorWarning ,checkersGameText, playerColor,
                existingName);
        return new Player(name, playerSet);
    }

    private static String validateUserName(Scanner scanner, Validator validator,
                                           ValidatorWarning validatorWarning, CheckersGameText checkersGameText,
                                           Color playerColor, String existingName) {
        String name;
        boolean shouldInputNameAgain = true;
        do {
            checkersGameText.showInputName(playerColor);
            name = scanner.next();
            if(!validator.isNameDuplicated(existingName, name)){
                shouldInputNameAgain = false;
            }
            else {
                validatorWarning.showMessage(validatorWarning.getShowWrongNameInput());
            }
        } while (shouldInputNameAgain);
        return name;
    }
}
