package pl.com.konrad.games.board;

import java.util.List;

public class PlayerLogic {

    public static Player swapPlayer(Player currentPlayer, Player playerOne, Player playerTwo) {
        if (currentPlayer.equals(playerOne)) {
            return playerTwo;
        }
        return playerOne;
    }


    public static Figure getFigure(Player player, int row, int col) {
        int index = 0;
        for (int i = 0; i < player.getFigures().size(); i++) {
            if (player.getFigures().get(i).getCurrentRow() == row && player.getFigures().get(i).getCurrentCol() == col)
                index = i;
        }
        return new Figure(player.getFigures().get(index).getType(), player.getFigures().get(index).getMark(), player.getFigures().get(index).getColor(),
                row, col);
    }

    private static void removeFigure(List<Figure> figureSet, int index) {
        figureSet.remove(index);
    }

}



