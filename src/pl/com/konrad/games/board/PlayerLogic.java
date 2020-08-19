package pl.com.konrad.games.board;

import java.util.List;

public class PlayerLogic {

    public static Player swapPlayer(Player currentPlayer, Player playerOne, Player playerTwo) {
        if (currentPlayer.equals(playerOne)) {
            return playerTwo;
        }
        return playerOne;
    }
}



