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


    @Override
    public void play() {
        playerOne = preparePlayer(scanner, validator, checkersGameText, Color.WHITE,null);
        currentPlayer = playerOne;
        playerTwo = preparePlayer(scanner, validator, checkersGameText, Color.BLACK, playerOne.getName());

        CheckersGameBoard checkersGameBoard = new CheckersGameBoard(playerOne, playerTwo);
        checkersGameBoard.print();
//        boolean isInputIncorrect = false;
//        do {
            System.out.println(checkersGameText.getMessage("show.witch.player.move",currentPlayer.getName()));
            System.out.println(checkersGameText.getMessage("show.current.pawn.to.move"));
            System.out.println(checkersGameText.getMessage("show.input.row", Integer.toString(checkersGameBoard.getLength())));
            System.out.println(checkersGameText.getMessage("show.input.col", Character.toString(checkersGameBoard.lastLetterOfCol('A',
                    checkersGameBoard.getLength()))));
            System.out.println(checkersGameText.getMessage("show.new.pawn.position"));
            System.out.println(checkersGameText.getMessage("show.input.row", Integer.toString(checkersGameBoard.getLength())));
            System.out.println(checkersGameText.getMessage("show.input.col", Character.toString(checkersGameBoard.lastLetterOfCol('A',
                    checkersGameBoard.getLength()))));
            System.out.println();
//        }while (isInputIncorrect);
    }

    private static Player preparePlayer(Scanner scanner, Validator validator,
                                        CheckersGameText checkersGameText, Color playerColor, String existingName) {
        List<Figure> playerSet = new ArrayList<>();
        String name = validateUserName(scanner, validator, checkersGameText, playerColor,
                existingName);
        return new Player(name, playerSet);
    }

    private static String validateUserName(Scanner scanner, Validator validator,
                                            CheckersGameText checkersGameText,
                                           Color playerColor, String existingName) {
        String name;
        boolean shouldInputNameAgain = true;
        do {
            System.out.println(checkersGameText.getMessage("show.input.name",playerColor.Description()));
            name = scanner.next();
            if(!validator.isNameDuplicated(existingName, name)){
                shouldInputNameAgain = false;
            }
            else {
                System.out.println(ValidatorWarning.getMessage("show.wrong.name.input"));
            }
        } while (shouldInputNameAgain);
        return name;
    }
}
