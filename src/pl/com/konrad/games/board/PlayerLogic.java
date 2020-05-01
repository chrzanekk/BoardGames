package pl.com.konrad.games.board;

public class PlayerLogic {

    public static Player swapPlayer(Player currentPlayer, Player playerOne, Player playerTwo) {
        if (currentPlayer.equals(playerOne)) {
            return playerTwo;
        }
        return playerOne;
    }

    public Figure getFigure(int userRow, int userCol, Player player) {
        int index = 0;
        for (int i = 0; i < player.getFigures().size(); i++) {
            if (player.getFigures().get(i).getCurrentRow() == userRow && player.getFigures().get(i).getCurrentCol() == userCol)
                index = i;
        }
        return new Figure(player.getFigures().get(index).getType(), player.getFigures().get(index).getMark(), player.getFigures().get(index).getColor(),
                userRow, userCol);
    }
}
