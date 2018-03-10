import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Daniel on 2017-05-16.
 */
public class PanelTrasy extends JPanel {
    public Random rand = new Random();
    Trasa trasa = new Trasa();
    Pociag pociagNiebieski = new PociagNiebieski(rand, trasa.trasaPelna, 15, trasa.trasaNiebieska, Color.cyan, this, trasa.gornyOdcinek, trasa.srodek, trasa.dolnyOdcinek, trasa.gornyOdcinek);
    Pociag pociagZolty = new PociagZolty(rand, trasa.trasaPelna, 25, trasa.trasaZolta, Color.yellow, this, trasa.gornyOdcinek, trasa.srodek, null, null);
    Pociag pociagRozowy = new PociagRozowy(rand, trasa.trasaPelna, 35, trasa.trasaRozowa, Color.pink, this, null, trasa.srodek, trasa.dolnyOdcinek, null);


    public PanelTrasy() {
        setSize(WIDTH, HEIGHT);

        new Thread(pociagNiebieski).start();
        new Thread(pociagZolty).start();
        new Thread(pociagRozowy).start();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        //Rysuje calosc
        for (Punkt pt : trasa.trasaPelna) {
            g.setColor(Color.WHITE);
            g.fillRect(pt.getX() * pt.getSzerokosc(), pt.getY() * pt.getWysokosc(), pt.getSzerokosc(), pt.getWysokosc());
            g.setColor(Color.black);
            g.drawRect(pt.getX() * pt.getSzerokosc(), pt.getY() * pt.getWysokosc(), pt.getSzerokosc(), pt.getWysokosc());
        }

        //Rysuje stacje
        g.setColor(Color.RED);
        g.fillRect(trasa.trasaPelna.get(0).getX() * trasa.trasaPelna.get(0).getSzerokosc(),
                trasa.trasaPelna.get(0).getY() * trasa.trasaPelna.get(0).getWysokosc(), trasa.trasaPelna.get(0).getSzerokosc(),
                trasa.trasaPelna.get(0).getWysokosc());
        g.setColor(Color.black);
        g.drawString("S1", 15, 25);
        g.setColor(Color.RED);
        g.fillRect(trasa.trasaPelna.get(45).getX() * trasa.trasaPelna.get(45).getSzerokosc(),
                trasa.trasaPelna.get(45).getY() * trasa.trasaPelna.get(45).getWysokosc(), trasa.trasaPelna.get(45).getSzerokosc(),
                trasa.trasaPelna.get(45).getWysokosc());
        g.setColor(Color.black);
        g.drawString("S2", 15 + trasa.trasaPelna.get(45).getX() * trasa.trasaPelna.get(45).getSzerokosc(),
                trasa.trasaPelna.get(45).getY() * trasa.trasaPelna.get(45).getWysokosc() + 25);
        g.setColor(Color.RED);
        g.fillRect(trasa.trasaPelna.get(55).getX() * trasa.trasaPelna.get(55).getSzerokosc(),
                trasa.trasaPelna.get(55).getY() * trasa.trasaPelna.get(55).getWysokosc(), trasa.trasaPelna.get(55).getSzerokosc(),
                trasa.trasaPelna.get(55).getWysokosc());
        g.setColor(Color.black);
        g.drawString("S3", 15 + trasa.trasaPelna.get(55).getX() * trasa.trasaPelna.get(55).getSzerokosc(),
                trasa.trasaPelna.get(55).getY() * trasa.trasaPelna.get(55).getWysokosc() + 25);


        //Rysowanie pociagów

        for (Punkt p : pociagNiebieski.pociagPunkty) {
            g.setColor(pociagNiebieski.getColor());
            g.fillRect(p.getX() * p.getSzerokosc(), p.getY() * p.getWysokosc(), p.getSzerokosc(), p.getWysokosc());
            g.setColor(Color.black);
            g.drawRect(p.getX() * p.getSzerokosc(), p.getY() * p.getWysokosc(), p.getSzerokosc(), p.getWysokosc());

        }

        for (Punkt p : pociagZolty.pociagPunkty) {
            g.setColor(pociagZolty.getColor());
            g.fillRect(p.getX() * p.getSzerokosc(), p.getY() * p.getWysokosc(), p.getSzerokosc(), p.getWysokosc());
            g.setColor(Color.black);
            g.drawRect(p.getX() * p.getSzerokosc(), p.getY() * p.getWysokosc(), p.getSzerokosc(), p.getWysokosc());

        }

        for (Punkt p : pociagRozowy.pociagPunkty) {
            g.setColor(pociagRozowy.getColor());
            g.fillRect(p.getX() * p.getSzerokosc(), p.getY() * p.getWysokosc(), p.getSzerokosc(), p.getWysokosc());
            g.setColor(Color.black);
            g.drawRect(p.getX() * p.getSzerokosc(), p.getY() * p.getWysokosc(), p.getSzerokosc(), p.getWysokosc());
        }

        //Sygnalizacja świetlna
        if (trasa.gornyOdcinek.zajete)
            g.setColor(Color.RED);
        else g.setColor(Color.GREEN);
        g.fillRect(this.getWidth() - 100, 50, 50, 50);
        g.setColor(Color.black);
        g.drawRect(this.getWidth() - 100, 50, 50, 50);

        if (trasa.srodek.zajete)
            g.setColor(Color.RED);
        else g.setColor(Color.GREEN);
        g.fillRect(this.getWidth() - 100, 100, 50, 50);
        g.setColor(Color.black);
        g.drawRect(this.getWidth() - 100, 100, 50, 50);

        if (trasa.dolnyOdcinek.zajete)
            g.setColor(Color.RED);
        else g.setColor(Color.GREEN);
        g.fillRect(this.getWidth() - 100, 150, 50, 50);
        g.setColor(Color.black);
        g.drawRect(this.getWidth() - 100, 150, 50, 50);

        repaint();
    }

}



