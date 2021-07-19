package Mező;
/**
 * A szikla típusú (Block gyerekosztálya) blokkok, mely a mapon van elhelyezve.
 * @author Nagy Dominik - V9PBRB
 * @version 1.0
 */
public class Szikla extends Block{
    /**
     * A szülő osztály konstruktorát előhívja.
     */
    public Szikla() {
        super("S", true, true, false,false);
    }
    /**
     * Egy négyszöget a térképen feltölt szikla tipusú blokkokkal.
     * @param i1 for ciklus kezdete
     * @param i2 for ciklus vége
     * @param j1 beágyazott for ciklus kezdete
     * @param j2 beágyazott for ciklus vége
     * @param map Maga a 15*15-ös térkép ami az akadályokat tartalmazza.
     * @param id leftover

     */
    public void createszikla(int i1,int i2,int j1,int j2,Block[][]map,int id)
    {
        for(int i=i1;i<=i2;i++)
        {
            for(int j=j1;j<=j2;j++) {
                map[i][j]=new Szikla();
            }
        }
    }
}
