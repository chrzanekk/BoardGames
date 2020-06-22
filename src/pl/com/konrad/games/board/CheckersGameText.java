package pl.com.konrad.games.board;

import java.util.HashMap;
import java.util.Map;

public class CheckersGameText {

    private Map<String, String> messages = new HashMap<>();

    {
        messages.put("show.welcome.message", "Welcome in Game Boards. Have fun. \n MAIN MENU: \n Choose option: ");
        messages.put("show.input.name", "Please set name of player who plays {0}.");
        messages.put("show.actual.game.board", "ACTUAL GAME BOARD");
        messages.put("show.witch.player.move", "Player {0} move");
        messages.put("show.current.pawn.to.move", "Choose current pawn to move: ");
        messages.put("show.new.pawn.position", "Choose new pawn position: ");
        messages.put("show.input.row", "Input number of row (from 1 to {0} ): ");
        messages.put("show.input.col", "Input letter of col (from A to {0} ): ");
        messages.put("show.winner", "We have a winner! \n Player {0} wins.");
        messages.put("show.draw", "No one wins. We have a draw");
    }

    public String getMessage(String key) {
        return messages.get(key);
    }

    public String getMessage(String key, String... params) {
        String message = messages.get(key);
        for (int i = 0; i < params.length; i++) {
            message = message.replace("{" + i + "}", params[i]);
        }
        return message;
    }

//    poprzednia wersja
    public void showWelcomeMessage() {
        System.out.println("Welcome in Game Boards. Have fun.");
        System.out.println("MAIN MENU");
        System.out.println("Choose option:");
    }

    public void showInputName(Color color) {
        System.out.println("Please set name of player who plays " + color + ":");
    }

    public void showActualBoard() {
        System.out.println("ACTUAL GAME BOARD");
    }

    public void showWhichPlayerMove(String playerName) {
        System.out.println("Player \"" + playerName + "\" move.");
    }

    public void showCurrentPawnToMove() {
        System.out.println("Choose current pawn to move:");
    }

    public void showInputRow(int gameBoardSize) {
        System.out.println("Input number of row (form 1 to " + gameBoardSize + "): ");
    }

    public void showInputCol(int gameBoardSize) {
        char firstChar = 'A';

        System.out.println("Input letter of col (form " + firstChar + " to " + lastLetterOfCol(firstChar,
                gameBoardSize) + "): ");
    }

    public void showNewPawnPosition() {
        System.out.println("Choose new pawn position: ");
    }

    public char lastLetterOfCol(char firstChar, int gameBoardLength) {
        int lastCharByInt = (int) firstChar + gameBoardLength - 1;
        return (char) lastCharByInt;
    }


}
