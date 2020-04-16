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

    //metoda dodaj pionek do tablicy
    public void addPawn(Figure figure) {

    }
}
