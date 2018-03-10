import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Daniel on 2017-05-24.
 */
public class PociagZolty extends Pociag {
    public PociagZolty(Random rand, ArrayList<Punkt> trasaPelna, int predkosc, ArrayList<Punkt> kolorTrasy, Color color, JPanel panel, WspolnaCzesc gornyOdcinek, WspolnaCzesc srodek, WspolnaCzesc dolnyOdcinek, WspolnaCzesc wspoldzielonaNaKtorejZaczynam) {
        super(rand, trasaPelna, predkosc, kolorTrasy, color, panel, gornyOdcinek, srodek, dolnyOdcinek, wspoldzielonaNaKtorejZaczynam);
    }

    public synchronized void jazdaZsynchronizowana() {
        //od dolu jade
        if (nastepnyPunkt().wspolnaCzesc == srodek && nastepnyPunktParametr(1).wspolnaCzesc != null
                && nastepnyPunkt().wspolnaCzesc.zajete == false && nastepnyPunktParametr(1).wspolnaCzesc.zajete == false) {
            nastepnyPunkt().wspolnaCzesc.zajete = true;  //zajmuje srodek
            nastepnyPunktParametr(1).wspolnaCzesc.zajete = true; //zajmuje gore
            for (int i = 0; i <= pociagPunkty.size(); i++)
                jazdaPociagu(nastepnyPunkt());
            srodek.zajete = false;
            while (nastepnyPunktParametr(1).wspolnaCzesc != null)
                jazdaPociagu(nastepnyPunkt());
        }

        if (nastepnyPunkt().wspolnaCzesc == srodek && nastepnyPunktParametr(1).wspolnaCzesc == null
                && nastepnyPunkt().wspolnaCzesc.zajete == false) {

            nastepnyPunkt().wspolnaCzesc.zajete = true;  //zajmij srodek
            for (int i = 0; i <= pociagPunkty.size(); i++) {
                if (i == 3) {
                    gornyOdcinek.zajete = false;
                }
                jazdaPociagu(nastepnyPunkt());
            }
            srodek.zajete = false;
        }
    }
}

