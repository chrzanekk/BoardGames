package pl.com.konrad.checkers;

/*
to do:
- walidacja wyboru menu
- walidacja wprowadzenia nazwy gracza
- walidacja ruchu
- walidacja wprowadzania pozycji pionka gracza(ruch)
- walidacja bicia(zabezpieczyc przed "przeskakiwaniem" swoich pionkow)

 */
public class Validator {
    public static final int START_GAME = 1;
    public static final int EXIT_GAME = 2;

    public boolean validateMainMenuOption(int userChoice) {
        return userChoice < START_GAME || userChoice > EXIT_GAME;
    }
}
