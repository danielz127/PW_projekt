import java.util.ArrayList;

/**
 * Created by Daniel on 2017-05-22.
 */
public class WspolnaCzesc {
    public volatile boolean zajete = false;
    public ArrayList<Punkt> wspolnaTrasa;

    public WspolnaCzesc(ArrayList<Punkt> wspolnaTrasa) {
        this.wspolnaTrasa = wspolnaTrasa;
    }

}
