package pl.com.konrad.games.board;

public class ValidatorWarning {
    private String showNotEmptyRowCol = "There is already a mark here. Try again.";
    private String showInvalidUserInput = "Invalid choice. Try again.";
    private String showWrongMove = "You cannot move here. Try again.";
    private String showWrongBeat = "You cannot beat this pawn. Try again.";
    private String showWrongNameInput = "Name is already exists. Try different name.";

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String getShowNotEmptyRowCol() {
        return showNotEmptyRowCol;
    }

    public String getShowInvalidUserInput() {
        return showInvalidUserInput;
    }

    public String getShowWrongMove() {
        return showWrongMove;
    }

    public String getShowWrongBeat() {
        return showWrongBeat;
    }

    public String getShowWrongNameInput() {
        return showWrongNameInput;
    }


    //getMessage -> return string (show.not.empty.row.col).
    //showMessage(String text) -> sout(text). (Map)
    public void showNotEmptyRowCol() {
        System.out.println("There is already a mark here. Try again.");
    }

    public void showInvalidUserInput() {
        System.out.println("Invalid choice. Try again.");
    }

    public void showWrongMove() {
        System.out.println("You cannot move here. Try again.");
    }

    public void showWrongBeat() {
        System.out.println("You cannot beat this pawn. Try again.");
    }

    public void showWrongNameInput(String existingName) {
        System.out.println("Name " + existingName + " already exists. Try different name.");
    }


}
