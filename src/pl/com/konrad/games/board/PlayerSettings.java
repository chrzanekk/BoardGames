package pl.com.konrad.games.board;

import java.util.Scanner;

public class PlayerSettings {
    public String setName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
