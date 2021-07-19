package Mező;

/**
 * A jármű típusú (Block gyerekosztálya) blokkok, mely a mapon van elhelyezve.
 * @author Nagy Dominik - V9PBRB
 * @version 1.0
 */
public class Jármű extends Block{
    /**
     * @param betu Betű ami, majd megjelenik az adott akadály helyén.
     * @param akadály Tud-e a játékos belelépni ebbe a blokkba?
     * @param papír Tud-e papírt tárolni ez a tipusú blokk?
     * @param haspapír Van-e papír ezen a blokkon?
     * @param megesz leftover
     */
    public Jármű(String betu, boolean akadály, boolean papír, boolean haspapír, boolean megesz) {
        super(betu, akadály, papír, haspapír, megesz);
    }
}
