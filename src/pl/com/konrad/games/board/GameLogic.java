package pl.com.konrad.games.board;
/*to do:
- metoda move dla dwoch graczy/dwa kierunki?
- metoda move dla damki?
- metoda kick/ban/score? dla damki oddzielna?
- metoda zmiany pionka w damke.
- metoda rejestrowania logow.

*/
public class GameLogic {

    public Figure move(Player player, Figure figure, int newRow, int newCol) {

        return new Figure(figure.getType(),figure.getMark(), figure.getColor(), newRow, newCol);
    }


}
