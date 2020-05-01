package pl.com.konrad.games.board;


import java.util.List;

public class Player {
    private String name;
    private List<Figure> figures;

    public Player(String name, List<Figure> figures) {
        this.name = name;
        this.figures = figures;
    }

    public String getName() {
        return name;
    }

    public List<Figure> getFigures() {
        return figures;
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
    }

    public void removeFigure(Figure figure) {
        figures.remove(figure);
    }

}
