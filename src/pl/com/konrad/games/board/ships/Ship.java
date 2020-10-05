package pl.com.konrad.games.board.ships;



import java.util.List;

public class Ship {
    private List<Mast> masts;

    public Ship(List<Mast> masts) {
        this.masts = masts;
    }

    public int getNumberOfMasts() {
        return masts.size();
    }

    public int getNumberMasts(){
        int sumOfMasts = 0;
        for (Mast mast : masts) {
            if(masts.contains(mast)){
                sumOfMasts++;
            }
        }
        return sumOfMasts;
    }

    public List<Mast> getMasts() {
        return masts;
    }



}
//https://devcave.pl/effective-java/wzorzec-projektowy-builder
//https://javadeveloper.pl/wzorzec-projektowy-fabryka/