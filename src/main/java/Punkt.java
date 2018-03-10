/**
 * Created by Daniel on 2017-05-16.
 */
public class Punkt {
    public final int szerokosc = 50;
    public final int wysokosc = 40;
    public WspolnaCzesc wspolnaCzesc;
    private int x, y; //Wspołrzędne punktów
    private volatile boolean wspoldzielony;

    public Punkt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isWspoldzielony() {
        return wspoldzielony;
    }

    public void setWspoldzielony(boolean wspoldzielony) {
        this.wspoldzielony = wspoldzielony;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getSzerokosc() {
        return szerokosc;
    }

    public int getWysokosc() {
        return wysokosc;
    }
}
