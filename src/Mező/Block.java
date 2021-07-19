package Mező;

/**
 * Az összes mappon elhelyezhető akadály szülőosztálya.
 * @author Nagy Dominik - V9PBRB
 * @version 1.0
 */
public class Block {
    String betu;
    boolean akadály;
    boolean papír;
    boolean haspapír;
    boolean megesz;

    /**
     * @param betu Betű ami, majd megjelenik az adott akadály helyén.
     * @param akadály Tud-e a játékos belelépni ebbe a blokkba?
     * @param papír Tud-e papírt tárolni ez a tipusú blokk?
     * @param haspapír Van-e papír ezen a blokkon?
     * @param megesz leftover
     */
    public Block(String betu, boolean akadály, boolean papír, boolean haspapír, boolean megesz) {
        this.betu = betu;
        this.akadály = akadály;
        this.papír = papír;
        this.haspapír = haspapír;
        this.megesz=megesz;
    }

    public boolean isMegesz() {
        return megesz;
    }

    public void setMegesz(boolean megesz) {
        this.megesz = megesz;
    }
    public String getBetu() {
        return betu;
    }

    public boolean isHaspapír() {
        return haspapír;
    }

    public void setHaspapír(boolean haspapír) {
        this.haspapír = haspapír;
    }

    public boolean isAkadály() {
        return akadály;
    }

    public boolean isPapír() {
        return papír;
    }

    public void setBetu(String betu) {
        this.betu = betu;
    }

    public void setAkadály(boolean akadály) {
        this.akadály = akadály;
    }

    public void setPapír(boolean papír) {
        this.papír = papír;
    }
}
