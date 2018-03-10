import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Daniel on 2017-05-16.
 */
public class Pociag extends Thread {
    public ArrayList<Punkt> kolorTrasy;
    public ArrayList<Punkt> pociagPunkty = new ArrayList<Punkt>();
    public JPanel panel;

    public WspolnaCzesc gornyOdcinek;
    public WspolnaCzesc srodek;
    public WspolnaCzesc dolnyOdcinek;
    public ArrayList<Punkt> trasaPelna = new ArrayList<Punkt>();
    public WspolnaCzesc wspoldzielonaNaKtorejZaczynam;
    Random rand;
    private Color color;
    private int predkosc;

    public Pociag(Random rand, ArrayList<Punkt> trasaPelna, int predkosc, ArrayList<Punkt> kolorTrasy, Color color, JPanel panel,
                  WspolnaCzesc gornyOdcinek, WspolnaCzesc srodek,
                  WspolnaCzesc dolnyOdcinek, WspolnaCzesc wspoldzielonaNaKtorejZaczynam) {
        this.rand = rand;
        this.predkosc = predkosc;
        this.kolorTrasy = kolorTrasy;
        this.color = color;
        this.panel = panel;
        dodajPunkty();
        this.gornyOdcinek = gornyOdcinek;
        this.srodek = srodek;
        this.dolnyOdcinek = dolnyOdcinek;
        this.trasaPelna = trasaPelna;

        this.wspoldzielonaNaKtorejZaczynam = wspoldzielonaNaKtorejZaczynam;
    }

    public void dodajPunkty() {
        for (int i = 1; i < 4; i++)
            pociagPunkty.add(new Punkt(kolorTrasy.get(i).getX(), kolorTrasy.get(i).getY()));


    }

    public Punkt nastepnyPunkt() {

        Punkt nastepny = new Punkt(0, 0);
        for (int i = 0; i < kolorTrasy.size() - 1; i++) {
            if (pociagPunkty.get(0).getX() == kolorTrasy.get(i).getX() && pociagPunkty.get(0).getY() == kolorTrasy.get(i).getY()) {
                nastepny = kolorTrasy.get(i + 1);
                nastepny.setX(kolorTrasy.get(i + 1).getX());
                nastepny.setY(kolorTrasy.get(i + 1).getY());
            }
        }
        return nastepny;
    }

    public Punkt nastepnyPunktParametr(int n) {
        Punkt next = this.kolorTrasy.get(0);
        for (int i = 0; i < kolorTrasy.size(); i++) {
            if (this.pociagPunkty.get(0).getX() == kolorTrasy.get(i).getX() && this.pociagPunkty.get(0).getY() == kolorTrasy.get(i).getY())
                if ((i + 1 + n) >= 0) {
                    next = kolorTrasy.get((i + 1 + n) % (kolorTrasy.size()));
                    return next;
                } else {
                    next = kolorTrasy.get((i + 1 + n) + (kolorTrasy.size()));
                    return next;
                }
        }
        return next;
    }


    public void czyStacja(Punkt nastepny) {
        if (kolorTrasy.get(kolorTrasy.size() - 1).getX() == nastepny.getX()
                && kolorTrasy.get(kolorTrasy.size() - 1).getY() == nastepny.getY()) {
            try {
                TimeUnit.MILLISECONDS.sleep(500 + rand.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Collections.reverse(this.pociagPunkty);
            Collections.reverse(this.kolorTrasy);
        }
    }

    public void jazdaPociagu(Punkt nastepny) {
        //Rysuje calosc
        try {
            Thread.sleep(1000 / predkosc);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = pociagPunkty.size() - 1; i > 0; i--) {
            pociagPunkty.get(i).setY(pociagPunkty.get(i - 1).getY());
            pociagPunkty.get(i).setX(pociagPunkty.get(i - 1).getX());

        }
        pociagPunkty.get(0).setY(nastepny.getY());
        pociagPunkty.get(0).setX(nastepny.getX());

        czyStacja(nastepnyPunktParametr(0));
    }

    public synchronized void jazdaZsynchronizowana() {
    }


    public Color getColor() {
        return color;
    }

    public void gdzieStart() {
        if (wspoldzielonaNaKtorejZaczynam != null) {
            wspoldzielonaNaKtorejZaczynam.zajete = true;
            for (int i = 0; i < wspoldzielonaNaKtorejZaczynam.wspolnaTrasa.size() - 2; i++) {
                jazdaPociagu(nastepnyPunktParametr(0));
            }
        }
    }

    // @Override
    public void run() {

        gdzieStart();

        while (true) {
            if (nastepnyPunkt().isWspoldzielony()) {
                jazdaZsynchronizowana();
            } else {
                jazdaPociagu(nastepnyPunktParametr(0));
            }
        }
    }
}



