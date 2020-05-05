package pl.com.konrad.games.board;

public class CheckersGameText {
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

    private char lastLetterOfCol(char firstChar, int gameBoardLength) {
        int lastCharByInt = (int) firstChar + gameBoardLength - 1;
        return (char) lastCharByInt;
    }


}
