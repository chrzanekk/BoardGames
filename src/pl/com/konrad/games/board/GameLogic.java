package pl.com.konrad.games.board;

import java.util.List;

/*to do:
- metoda move dla dwoch graczy/dwa kierunki?
- metoda move dla damki?
- metoda kick/ban/score? dla damki oddzielna?
- metoda zmiany pionka w damke.


*/
public class GameLogic {

    public Figure move(List<Figure> figureSet, int currentRow, int currentCol, int newRow, int newCol) {
        int index = PlayerLogic.getIndexByRowCol(figureSet, currentRow, currentCol);
        Figure figure = getFigure(figureSet, newRow, newCol, index);
        figureSet.add(figure);
        GameLogic.clearField(figureSet, index);
        return figure;
    }

    //do klasy PlayerLogic?
    private Figure getFigure(List<Figure> figureSet, int newRow, int newCol, int index) {
        return new Figure(getType(figureSet, index), getMark(figureSet, index),
                getColor(figureSet, index), newRow,
                newCol);
    }

    private static void clearField(List<Figure> figureSet, int index) {
        figureSet.remove(index);
    }

    //do klasy PlayerLogic?
    private Colors getColor(List<Figure> figureSet, int index) {
        return figureSet.get(index).getColor();
    }

    //do klasy PlayerLogic?
    private GameBoardMark getMark(List<Figure> figureSet, int index) {
        return figureSet.get(index).getMark();
    }

    //do klasy PlayerLogic?
    private PawnType getType(List<Figure> figureSet, int index) {
        return figureSet.get(index).getType();
    }


}
