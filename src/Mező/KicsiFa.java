package Mező;

/**
 * A "kicsi fa" típusú (Block gyerekosztálya) blokkok, mely a mapon van elhelyezve.
 * @author Nagy Dominik - V9PBRB
 * @version 1.0

 */
public class KicsiFa extends Block {
    /**
     * A szülő osztály konstruktorát előhívja.
     */
    public KicsiFa() {
        super("O", false, false, false,false);
    }
    /**
     * Egy mezőt megváltoztat "kicsi fa" típusra a térképen.
     * @param i1 x koordináta
     * @param j1 y koordináta
     * @param map Maga a 15*15-ös térkép ami az akadályokat tartalmazza.
     */
    public void createfa(int i1,int j1,Block[][]map)
    {
        map[i1][j1]=new KicsiFa();
    }
}
