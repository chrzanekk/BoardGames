package pl.com.konrad.games.board.ships;

import pl.com.konrad.games.board.Game;
import pl.com.konrad.games.board.GameText;
import pl.com.konrad.games.board.Validator;
import pl.com.konrad.games.board.ValidatorWarning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShipsGame implements Game {
    private final Scanner scanner = new Scanner(System.in);
    private final Validator validator = new Validator();
    private final ShipsGameText shipsGameText = new ShipsGameText();

//    nie wiem czy w dobrym miejscu będzie ta tablica i lista - ale chyba tutaj w momencie przygotowania gracza.
//    statek trzymasztowy stad tablica z trzema indeksami
    private ShipsFigure[] ship = new ShipsFigure[3];
//    flota gracza - limit 3 statki dla planszy 10x10? w zaleznosci od tablicy na jakiej przyjdzie grac
    private List<ShipsFigure[]> fleet = new ArrayList();

//przygotowanie gracza (imie oraz metoda rozstawiania statkow wraz z logika sprawdzania poprawnosci rozstawienia)





    public void play() {

    }

    public String getUserName(Scanner scanner, Validator validator,
                              String playerDescription, String existingName) {
        String name;
        boolean shouldInputNameAgain = true;
        do {
            System.out.println(GameText.getMessage("show.input.name", playerDescription));
            name = scanner.next();
            if (!validator.isNameDuplicated(existingName, name)) {
                shouldInputNameAgain = false;
            } else {
                System.out.println(ValidatorWarning.getMessage("show.wrong.name.input"));
                System.out.println(ValidatorWarning.getMessage("show.try.again"));
            }
        } while (shouldInputNameAgain);
        return name;
    }

}
