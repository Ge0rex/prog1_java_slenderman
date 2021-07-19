package Entity;

/**
 * A slenderman jelenlegi és előző koordinátáit, illetve megjelenítéskor használt betűjét tároló osztály.
 * @author Nagy Dominik - V9PBRB
 * @version 1.0
 */
public class Slenderman {
   boolean visibility;
   boolean wasvisible;
   String betű;

    /**
     * Sima konstruktor.
     * @param visibility Látható-e?
     * @param wasvisible Az előző lépésben látható-e volt
     */
    public Slenderman(boolean visibility, boolean wasvisible) {
        this.visibility = visibility;
        this.wasvisible=wasvisible;
        this.betű = "#";
    }

    public boolean isWasvisible() {
        return wasvisible;
    }

    public void setWasvisible(boolean wasvisible) {
        this.wasvisible = wasvisible;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public String getBetű() {
        return betű;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public void setBetű(String betű) {
        this.betű = betű;
    }

    /**
     * Ez tölti fel a slendermap-et "slenderman" tipusú mezőkkel.
     * @param slendermap A 15*15-ös mátrix, ami "slendermanekből" áll.
     */
    public void slenderrelfeltölt(Slenderman slendermap[][])
    {
        for(int i=0;i<15;i++)
        {
            for (int j=0;j<15;j++)
            {
                slendermap[i][j]=new Slenderman(false,false);
            }
        }
    }
}
