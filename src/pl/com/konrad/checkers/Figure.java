package pl.com.konrad.checkers;

public class Figure {

    //biezaca pozycja row
    //biezaca pozycja col
    //color
    //typ
    //znaczek
    public Figure() {
    }


    public char[][] move(int newRow, int newCol) {
        return new char[newRow][newCol];
    }

}
