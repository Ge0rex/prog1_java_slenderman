package Entity;

/**
 * A játékos koordinátáit és a megjelenítéskor használt betűt tároló osztály.
 * @author Nagy Dominik - V9PBRB
 * @version 1.0
 */
public class Player {
 int x=0;
 int y=0;
 String betű;

    /**
     * Sima konstruktor.
     * @param x X koordináta.
     * @param y Y koordináta.
     */
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.betű = "+";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getBetű() {
        return betű;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setBetű(String betű) {
        this.betű = betű;
    }
}
