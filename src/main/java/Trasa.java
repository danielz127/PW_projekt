import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Daniel on 2017-05-16.
 */
public class Trasa {
    public ArrayList<Punkt> trasaPelna = new ArrayList<Punkt>();
    public ArrayList<Punkt> trasaZolta = new ArrayList<Punkt>();
    public ArrayList<Punkt> trasaNiebieska = new ArrayList<Punkt>();
    public ArrayList<Punkt> trasaRozowa = new ArrayList<Punkt>();

    public ArrayList<Punkt> niebieskaZolta = new ArrayList<Punkt>();
    public ArrayList<Punkt> niebieskaRozowa = new ArrayList<Punkt>();
    public ArrayList<Punkt> srodkowyPunkt = new ArrayList<Punkt>();


    public WspolnaCzesc gornyOdcinek = new WspolnaCzesc(niebieskaZolta);
    public WspolnaCzesc srodek = new WspolnaCzesc(srodkowyPunkt);
    public WspolnaCzesc dolnyOdcinek = new WspolnaCzesc(niebieskaRozowa);


    public int[][] punktyTrasy = {
            {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
    private int dlugoscTras;
    private int szerokoscTras;


    public Trasa() {
        dlugoscTras = punktyTrasy.length;
        szerokoscTras = punktyTrasy[dlugoscTras - 1].length;
        przypiszPunktyTras();
        trasaZolta();
        trasaNiebieska();
        trasaRozowa();
        setNiebieskaZolta();
        setNiebieskaRozowa();
        setSrodkowyPunkt();
    }

    void przypiszPunktyTras() {
        for (int i = 0; i < dlugoscTras; i++)
            for (int j = 0; j < szerokoscTras; j++)
                if (punktyTrasy[i][j] == 1)
                    trasaPelna.add(new Punkt(j, i));
    }

    public void trasaZolta() {
        for (int i = 0; i <= 5; i++)
            trasaZolta.add(trasaPelna.get(i));
        for (int i = 7; i <= 19; i++, i++)
            trasaZolta.add(trasaPelna.get(i));
        for (int i = 25; i <= 30; i++)
            trasaZolta.add(trasaPelna.get(i));
        for (int i = 32; i <= 44; i++, i++)
            trasaZolta.add(trasaPelna.get(i));
        trasaZolta.add(trasaPelna.get(55));
        Collections.reverse(trasaZolta);
    }

    public void trasaNiebieska() {
        for (int i = 0; i <= 5; i++)
            trasaNiebieska.add(trasaPelna.get(i));
        for (int i = 7; i <= 19; i++, i++)
            trasaNiebieska.add(trasaPelna.get(i));
        trasaNiebieska.add(trasaPelna.get(25));
        for (int i = 31; i <= 43; i++, i++)
            trasaNiebieska.add(trasaPelna.get(i));
        for (int i = 50; i <= 55; i++)
            trasaNiebieska.add(trasaPelna.get(i));
    }

    public void trasaRozowa() {
        trasaRozowa.add(trasaPelna.get(0));
        for (int i = 6; i <= 18; i++, i++)
            trasaRozowa.add(trasaPelna.get(i));
        for (int i = 20; i <= 25; i++)
            trasaRozowa.add(trasaPelna.get(i));
        for (int i = 31; i <= 43; i++, i++)
            trasaRozowa.add(trasaPelna.get(i));
        for (int i = 50; i >= 45; i--)
            trasaRozowa.add(trasaPelna.get(i));
        Collections.reverse(trasaRozowa);
    }

    public void setNiebieskaZolta() {
        for (int i = 0; i <= 5; i++) {
            niebieskaZolta.add(trasaPelna.get(i));
            trasaPelna.get(i).setWspoldzielony(true);
            trasaPelna.get(i).wspolnaCzesc = gornyOdcinek;
        }
        for (int i = 7; i <= 19; i++, i++) {
            niebieskaZolta.add(trasaPelna.get(i));
            trasaPelna.get(i).setWspoldzielony(true);
            trasaPelna.get(i).wspolnaCzesc = gornyOdcinek;
        }
    }

    public void setNiebieskaRozowa() {
        for (int i = 31; i <= 43; i++, i++) {
            niebieskaRozowa.add(trasaPelna.get(i));
            trasaPelna.get(i).setWspoldzielony(true);
            trasaPelna.get(i).wspolnaCzesc = dolnyOdcinek;
        }
        niebieskaRozowa.add(trasaPelna.get(50));
        trasaPelna.get(50).setWspoldzielony(true);
        trasaPelna.get(50).wspolnaCzesc = dolnyOdcinek;
    }

    public void setSrodkowyPunkt() {
        srodkowyPunkt.add(trasaPelna.get(25));
        trasaPelna.get(25).setWspoldzielony(true);
        trasaPelna.get(25).wspolnaCzesc = srodek;
    }

}

