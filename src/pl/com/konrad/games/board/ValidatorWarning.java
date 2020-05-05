package pl.com.konrad.games.board;

public class ValidatorWarning {
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
