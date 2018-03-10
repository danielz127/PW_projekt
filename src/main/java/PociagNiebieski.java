import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Daniel on 2017-05-24.
 */
public class PociagNiebieski extends Pociag {
    public PociagNiebieski(Random rand, ArrayList<Punkt> trasaPelna, int predkosc, ArrayList<Punkt> kolorTrasy, Color color, JPanel panel, WspolnaCzesc gornyOdcinek, WspolnaCzesc srodek, WspolnaCzesc dolnyOdcinek, WspolnaCzesc wspoldzielonaNaKtorejZaczynam) {
        super(rand, trasaPelna, predkosc, kolorTrasy, color, panel, gornyOdcinek, srodek, dolnyOdcinek, wspoldzielonaNaKtorejZaczynam);
    }

    public synchronized void jazdaZsynchronizowana() {
        //od gory srodek
        if (nastepnyPunkt().wspolnaCzesc == srodek && nastepnyPunktParametr(1).wspolnaCzesc == dolnyOdcinek) {
            if (nastepnyPunkt().wspolnaCzesc.zajete == false && nastepnyPunktParametr(1).wspolnaCzesc.zajete == false) {
                nastepnyPunkt().wspolnaCzesc.zajete = true;  //zajmuje srodek
                nastepnyPunktParametr(1).wspolnaCzesc.zajete = true;  //zajmuje doł
                for (int i = 0; i <= pociagPunkty.size(); i++) {
                    jazdaPociagu(nastepnyPunkt());
                    if (i == 3) {
                        gornyOdcinek.zajete = false;
                    }
                }
                srodek.zajete = false;
                while (nastepnyPunkt().wspolnaCzesc != null)
                    jazdaPociagu(nastepnyPunkt());
                for (int i = 0; i < pociagPunkty.size(); i++) {
                    jazdaPociagu(nastepnyPunkt());
                }
                dolnyOdcinek.zajete = false;
            }


        }
        //teraz jade od dołu
        if (nastepnyPunkt().wspolnaCzesc == dolnyOdcinek
                && this.pociagPunkty.get(0).wspolnaCzesc == null && nastepnyPunkt().wspolnaCzesc.zajete == false) {
            nastepnyPunkt().wspolnaCzesc.zajete = true;  //zajmuje dół
            while (nastepnyPunkt().wspolnaCzesc != srodek)
                jazdaPociagu(nastepnyPunkt());


        }
        //Jade od dołu
        if (nastepnyPunkt().wspolnaCzesc == srodek && nastepnyPunktParametr(1).wspolnaCzesc == gornyOdcinek) {
            if (nastepnyPunkt().wspolnaCzesc.zajete == false && nastepnyPunktParametr(1).wspolnaCzesc.zajete == false) {
                nastepnyPunkt().wspolnaCzesc.zajete = true;  //zajmuje srodek
                nastepnyPunktParametr(1).wspolnaCzesc.zajete = true; //zajmij góre
                for (int i = 0; i <= pociagPunkty.size(); i++) {
                    if (i == 3)
                        dolnyOdcinek.zajete = false;
                    jazdaPociagu(nastepnyPunkt());
                }
                srodek.zajete = false;
                nastepnyPunkt().wspolnaCzesc.zajete = true;
                while (nastepnyPunkt().wspolnaCzesc != srodek)
                    jazdaPociagu(nastepnyPunkt());
            }

        }
    }

}
