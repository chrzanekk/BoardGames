package pl.com.konrad.games.board.tictactoe;

import pl.com.konrad.games.board.GameBoardDimension;

enum TicTacToeSizeOption {
    SIZE_OPTION_3X3(1,"3x3 board", GameBoardDimension.SIZE_3X3),
    SIZE_OPTION_4X4(2, "4x4 board", GameBoardDimension.SIZE_4X4),
    SIZE_OPTION_5X5(3, "5x5 board", GameBoardDimension.SIZE_5X5),
    EXIT(4,"EXIT", GameBoardDimension.BACK);
    private final int index;
    private final String description;
    private final GameBoardDimension size;

    TicTacToeSizeOption(int index, String description, GameBoardDimension size) {
        this.index = index;
        this.description = description;
        this.size = size;
    }

    int index() {
        return index;
    }

    String description() {
        return description;
    }

    GameBoardDimension size() {
        return size;
    }

    static GameBoardDimension sizeOption(int playerChoice) {
        for (TicTacToeSizeOption sizeOption : TicTacToeSizeOption.values()) {
            if (sizeOption.index == playerChoice) {
                return sizeOption.size;
            }
        }
        return GameBoardDimension.BACK;
    }
}
