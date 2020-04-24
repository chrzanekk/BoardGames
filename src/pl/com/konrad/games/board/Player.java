package pl.com.konrad.games.board;


import java.util.List;

public class Player {
    private String name;
    private List<Figure> figureSet;

    public Player(String name, List<Figure> figureSet) {
        this.name = name;
        this.figureSet = figureSet;
    }

    public String getName() {
        return name;
    }

    public List<Figure> getFigureSet() {
        return figureSet;
    }

    public void addFigure(Figure figure) {
        figureSet.add(figure);
    }

    public void removeFigure(Figure figure) {
        figureSet.remove(figure);
    }


}
