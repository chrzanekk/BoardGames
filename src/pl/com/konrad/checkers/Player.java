package pl.com.konrad.checkers;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Figure> figureSet;

    public Player(String name, ArrayList<Figure> figureSet) {
        this.name = name;
        this.figureSet = figureSet;
    }


    public String getName() {
        return name;
    }

    public ArrayList<Figure> getFigureSet() {
        return figureSet;
    }


    public void addFigure(Figure figure) {
        figureSet.add(figure);

    }

    public void removeFigure(Figure figure) {
        figureSet.remove(figure);
    }


}
