package pl.com.konrad.games.board;

public class ExitGame implements Game {
    @Override
    public void play() {
        boolean shouldPlay;
        do{
            shouldPlay = false;
        }
        while (shouldPlay);
    }
}
