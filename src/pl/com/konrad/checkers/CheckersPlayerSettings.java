package pl.com.konrad.checkers;

import java.util.Scanner;

public class CheckersPlayerSettings {
    public String setName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

}
