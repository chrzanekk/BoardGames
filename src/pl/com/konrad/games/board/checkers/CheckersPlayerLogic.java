package pl.com.konrad.games.board.checkers;



import java.util.List;

class CheckersPlayerLogic {

    static void showPlayerInput(int userCurrentRowChoice, char userColChoiceByChar, int userCurrentColChoice,
                         CheckersGameLogic gameLogic) {
        System.out.println("***************************");
        System.out.println("Checking what player choose");
        System.out.println("row: " + userCurrentRowChoice + "; col: (char)" + userColChoiceByChar + "/(int)" + userCurrentColChoice);
        if (gameLogic.isFigureExist(userCurrentRowChoice, userCurrentColChoice)) {
            System.out.println(gameLogic.getFigureByRowCol(userCurrentRowChoice, userCurrentColChoice).getMark().pawn());
        } else {
            System.out.println("no pawn");
        }
        System.out.println("***************************");
    }
}
