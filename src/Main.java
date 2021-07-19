import Entity.*;
import Mező.*;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import javax.swing.text.html.parser.Entity;

/**
 * Slenderman beadandó
 * 4.feladat
 * @author Nagy Dominik - V9PBRB
 * @version 1.0
 */
public class Main {
    static boolean end=false;
    static boolean victory=false;
    static boolean defeat=false;
    static int posx=0;
    static int posy=0;
    static boolean rosszinput=false;
    static int steps=0;
    static int spawnsteps=0;
    static boolean spawncheck=false;
    static boolean teleport=false;
    static Szikla rock = new Szikla();
    static Szikla rock2 = new Szikla();
    static KicsiFa smoltree = new KicsiFa();
    static Autó car = new Autó();
    static Autó car2 = new Autó();
    static Hordó barrel = new Hordó();
    static Teherautó truck = new Teherautó();
    static NagyFa bigtree = new NagyFa();
    static NagyFa bigtree2 = new NagyFa();
    static NagyFa bigtree3 = new NagyFa();
    static NagyFa bigtree4 = new NagyFa();
    static Paper papirusz = new Paper(0,8);
    static Slenderman boogeyman = new Slenderman(false,false);
    static int supx;
    static int supy;
    static Player játékos = new Player(posx,posy);
    static boolean firstteleport=false;
    static boolean firsttelecheck=false;
    static int telecserex;
    static int telecserey;
    static int firstx;
    static int firsty;
    static int teleportx;
    static int teleporty;
    static int harom=0;

    /**
     * A main függvény.
     * A Block 15*15-ös mátrix a map-nak felel meg.
     * A slendermap mátrix ugyan ez, csak mindegyik mező-n egy "slenderman van", visibility változóval ellátva
     * ezért mindig csak 1 db látszódik.
     * A "tomb"-be random számok vannak generálva, amik különbözőek, ezek majd a papírokhoz kellenek.
     * @param args nem használatos
     */

    public static void main(String[] args) {

        Block[][] map = new Block[15][15];
        Slenderman[][]slendermap=new Slenderman[15][15];
        boogeyman.slenderrelfeltölt(slendermap);
        Random rand = new Random();
        int[]tomb=new int[8];
        int MAX = 11;
        for (int i = 1; i <= MAX; i++)
        {
            tomb[0] = (int)(Math.random()*MAX)+1;
            tomb[1] = (int)(Math.random()*MAX)+1;
            tomb[2] = (int)(Math.random()*MAX)+1;
            tomb[3] = (int)(Math.random()*MAX)+1;
            tomb[4] = (int)(Math.random()*MAX)+1;
            tomb[5] = (int)(Math.random()*MAX)+1;
            tomb[6] = (int)(Math.random()*MAX)+1;
            tomb[7] = (int)(Math.random()*MAX)+1;
            while (tomb[1] == tomb[0])
            {
                tomb[1] = (int)(Math.random()*MAX)+1;
            }
            while ((tomb[2] == tomb[0]) || (tomb[2] == tomb[1]) )
            {
                tomb[2] = (int)(Math.random()*MAX)+1;
            }
            while ((tomb[3] == tomb[0]) || (tomb[3] == tomb[1]) || (tomb[3] == tomb[2]) )
            {
                tomb[3] = (int)(Math.random()*MAX)+1;
            }
            while ((tomb[4] == tomb[0]) ||
                    (tomb[4] == tomb[1]) ||
                    (tomb[4] == tomb[2]) ||
                    (tomb[4] == tomb[3]) )
            {
                tomb[4] = (int)(Math.random()*MAX)+1;
            }
            while ((tomb[5] == tomb[0]) ||
                    (tomb[5] == tomb[1]) ||
                    (tomb[5] == tomb[2]) ||
                    (tomb[5] == tomb[3]) ||
                    (tomb[5]==tomb[4]) )
            {
                tomb[5] = (int)(Math.random()*MAX)+1;
            }
            while ((tomb[6] == tomb[0]) ||
                    (tomb[6] == tomb[1]) ||
                    (tomb[6] == tomb[2]) ||
                    (tomb[6] == tomb[3]) ||
                    (tomb[6]==tomb[4]) ||
                    (tomb[6]==tomb[5]))
            {
                tomb[6] = (int)(Math.random()*MAX)+1;
            }
            while ((tomb[7] == tomb[0]) ||
                    (tomb[7] == tomb[1]) ||
                    (tomb[7] == tomb[2]) ||
                    (tomb[7] == tomb[3]) ||
                    (tomb[7]==tomb[4]) ||
                    (tomb[7]==tomb[5]) ||
                    (tomb[7]==tomb[6]))
            {
                tomb[7] = (int)(Math.random()*MAX)+1;
            }
        }
        for(int i=0;i<15;i++)
        {
            for(int j=0;j<15;j++) {
                map[i][j]=new Fű();
            }
        }
        /**
         * A Block tömböt feltölti különböző akadályokkal.
         */
        //szikla1
        rock.createszikla(0,2,1,3,map,1);
        //szikla2
        rock2.createszikla(7,9,0,2,map,2);
        //kicsifák
        smoltree.createfa(4,0,map);
        smoltree.createfa(10,2,map);
        smoltree.createfa(12,3,map);
        smoltree.createfa(0,10,map);
        smoltree.createfa(1,12,map);
        //autó1
        car.createautó(0,1,5,7,map, 3);
        //autó2
        car2.createautó(6,8,7,8,map,4);
        //hordó
        barrel.createhordó(3,6,4,5,map);
        //teherautó
        truck.createteherautó(10,14,9,11,map);
        //nagyfa1
        bigtree.createnagyfa(13,14,0,1,map,5);
        //nagyfa2
        bigtree2.createnagyfa(13,14,3,4,map,6);
        //nagyfa3
        bigtree3.createnagyfa(10,11,4,5,map,7);
        //nagyfa4
        bigtree4.createnagyfa(10,11,13,14,map,8);
        //ház
            for(int j=9;j<=14;j++) {
                map[2][j]=new Ház();
            }
            for(int i=3;i<=8;i++)
            {
                map[i][14]=new Ház();
            }
            for(int i=4;i<=8;i++)
            {
                map[i][9]=new Ház();
            }
            map[3][11]=new Ház();
            map[4][11]=new Ház();
            map[5][11]=new Ház();
            map[7][11]=new Ház();
            map[8][10]=new Ház();
            map[8][11]=new Ház();
            map[8][12]=new Ház();


        /**
         * Elhelyezi a papírokat az előbb generált random számok alapján.
         */
        System.out.println("Üdvözöllek a kísértett erdőben! Az + jelöli a helyedet. Légyszíves a mellékelt README-t olvasd el, ha még nem tetted.");
       for(int i=0;i<tomb.length;i++)
       {
           switch (tomb[i]) {
               case 1:
                   map[2][2].setHaspapír(true);
                   break;
               case 2:
                   map[1][6].setHaspapír(true);
                   break;
               case 3:
                   map[4][5].setHaspapír(true);
                   break;
               case 4:
                   map[4][14].setHaspapír(true);
                   break;
               case 5:
                   map[7][1].setHaspapír(true);
                   break;
               case 6:
                   map[7][7].setHaspapír(true);
                   break;
               case 7:
                   map[10][5].setHaspapír(true);
                   break;
               case 8:
                   map[10][14].setHaspapír(true);
                   break;
               case 9:
                   map[13][1].setHaspapír(true);
                   break;
               case 10:
                   map[13][4].setHaspapír(true);
                   break;
               case 11:
                   map[12][9].setHaspapír(true);
                   break;

           }
       }
        /**
         * Megjeleníti terminálban a játékot és figyeli, hogy a játéknak vége-e van, illetve a játékos nyert vagy vesztett.
         * Figyeli a játékosnál lévő papírok mennyiségét és ettől függően a feladatban megadott szabályok szerint megjeleníti a slenderman-t
         * és kezeli a lépéseit.
         * Az előző pozícióját megjegyzi, így ha a játékos abba belelép akkor a következő lépésnél game over-t kap.
         */
        do {
            display(posx, posy,map,slendermap);
            if(papirusz.getPaperleft()==7 && papirusz.getPaperinventory()==1)
            {spawncheck=true;}
            //slenderman
            Random random = new Random();
            if(spawncheck==true && firstteleport==false)
            { firstx = random.nextInt(15);
                firsty = random.nextInt(15);
                slendermap[firstx][firsty].setVisibility(true);
                firstteleport=true;
            }
            if(firsttelecheck==false) {
                telecserex = firstx;
                telecserey = firsty;
                supx=firstx;
                supy=firsty;

            }
            if(spawncheck==true && teleport==true)
            {
                if(firsttelecheck==false) { slendermap[firstx][firsty].setVisibility(false); slendermap[firstx][firsty].setWasvisible(true); firsttelecheck=true;}
                caught(slendermap);
                slendermap[supx][supy].setWasvisible(false);
                slendermap[telecserex][telecserey].setVisibility(false);
                slendermap[telecserex][telecserey].setWasvisible(true);
                teleportx = random.nextInt(15);
                teleporty = random.nextInt(15);
                supx=telecserex;
                supy=telecserey;
                telecserex=teleportx;
                telecserey=teleporty;
                caught(slendermap);
                slendermap[teleportx][teleporty].setVisibility(true);

                if(spawncheck==true && papirusz.getPaperinventory()>=2 && papirusz.getPaperinventory()<4) {
                    if ((játékos.getX() + játékos.getY()) - (teleportx + teleporty) <= 1 && (játékos.getX() + játékos.getY()) - (teleportx + teleporty) >= -1) {
                        harom++;
                    } else {
                        harom = 0;
                    }
                    if (harom >= 3) {
                        int rng = random.nextInt(3);
                        if (rng == 1) {
                            end = true;
                            defeat = true;
                        }
                    }
                }

                if(spawncheck==true && papirusz.getPaperinventory()>=4 && papirusz.getPaperinventory()<6) {
                    if ((játékos.getX() + játékos.getY()) - (teleportx + teleporty) <= 1 && (játékos.getX() + játékos.getY()) - (teleportx + teleporty) >= -1) {
                        harom++;
                    } else {
                        harom = 0;
                    }
                    if (harom >= 3) {
                        int rng = random.nextInt(2);
                        if (rng == 1) {
                            end = true;
                            defeat = true;
                        }
                    }
                }
                if(spawncheck==true && papirusz.getPaperinventory()>=6) {
                    if ((játékos.getX() + játékos.getY()) - (teleportx + teleporty) <= 1 && (játékos.getX() + játékos.getY()) - (teleportx + teleporty) >= -1) {
                        harom++;
                    } else {
                        harom = 0;
                    }
                    if (harom >= 3) {
                        int rng = random.nextInt(3);
                        if (rng == 1 || rng == 2) {
                            end = true;
                            defeat = true;
                        }
                    }
                }

                teleport=false;
            }


            if(spawncheck==true && spawnsteps!=0 && papirusz.getPaperinventory()<2)
            {
                if(firsttelecheck==false) { slendermap[firstx][firsty].setVisibility(false);  slendermap[firstx][firsty].setWasvisible(true); firsttelecheck=true;}
                caught(slendermap);
                slendermap[supx][supy].setWasvisible(false);
                slendermap[telecserex][telecserey].setVisibility(false);
                slendermap[telecserex][telecserey].setWasvisible(true);

                do{teleportx = random.nextInt(15);
                teleporty = random.nextInt(15);
                }
                while(((játékos.getX()+játékos.getY())-(teleportx+teleporty))<=5 && ((játékos.getX()+játékos.getY())-(teleportx+teleporty))>=-5 );
                supx=telecserex;
                supy=telecserey;
                telecserex=teleportx;
                telecserey=teleporty;
                caught(slendermap);
                slendermap[teleportx][teleporty].setVisibility(true);

            }
            if(spawncheck==true && spawnsteps!=0 && papirusz.getPaperinventory()>=2 && papirusz.getPaperinventory()<4)
            {
                if(firsttelecheck==false) { slendermap[firstx][firsty].setVisibility(false); slendermap[firstx][firsty].setWasvisible(true); firsttelecheck=true;}
                caught(slendermap);
                slendermap[supx][supy].setWasvisible(false);
                slendermap[telecserex][telecserey].setVisibility(false);
                slendermap[telecserex][telecserey].setWasvisible(true);

                do{teleportx = random.nextInt(15);
                    teleporty = random.nextInt(15);
                }
                while(((játékos.getX()+játékos.getY())-(teleportx+teleporty))>=5 || ((játékos.getX()+játékos.getY())-(teleportx+teleporty))<=-5 );
                supx=telecserex;
                supy=telecserey;
                telecserex=teleportx;
                telecserey=teleporty;
                caught(slendermap);
                slendermap[teleportx][teleporty].setVisibility(true);
                if((játékos.getX()+játékos.getY())-(teleportx+teleporty)<=1 && (játékos.getX()+játékos.getY())-(teleportx+teleporty)>=-1)
                { harom++; }
                else{harom=0;}
                if(harom>=3)
                {
                    int rng = random.nextInt(3);
                    if(rng==1)
                    {end=true;defeat=true;}
                }

            }
            if(spawncheck==true && spawnsteps!=0 && papirusz.getPaperinventory()>=4 && papirusz.getPaperinventory()<6)
            {
                if(firsttelecheck==false) { slendermap[firstx][firsty].setVisibility(false); slendermap[firstx][firsty].setWasvisible(true); firsttelecheck=true;}
                caught(slendermap);
                slendermap[supx][supy].setWasvisible(false);
                slendermap[telecserex][telecserey].setVisibility(false);
                slendermap[telecserex][telecserey].setWasvisible(true);

                do{teleportx = random.nextInt(15);
                    teleporty = random.nextInt(15);
                }
                while(((játékos.getX()+játékos.getY())-(teleportx+teleporty))>=4 || ((játékos.getX()+játékos.getY())-(teleportx+teleporty))<=-4 );
                supx=telecserex;
                supy=telecserey;
                telecserex=teleportx;
                telecserey=teleporty;
                caught(slendermap);
                slendermap[teleportx][teleporty].setVisibility(true);
                if((játékos.getX()+játékos.getY())-(teleportx+teleporty)<=1 && (játékos.getX()+játékos.getY())-(teleportx+teleporty)>=-1)
                { harom++; }
                else{harom=0;}
                if(harom>=3)
                {
                    int rng = random.nextInt(2);
                    if(rng==1)
                    {end=true;defeat=true;}
                }

            }

            if(spawncheck==true && spawnsteps!=0 && papirusz.getPaperinventory()>=6)
            {
                if(firsttelecheck==false) { slendermap[firstx][firsty].setVisibility(false); slendermap[firstx][firsty].setWasvisible(true); firsttelecheck=true;}
                caught(slendermap);
                slendermap[supx][supy].setWasvisible(false);
                slendermap[telecserex][telecserey].setVisibility(false);
                slendermap[telecserex][telecserey].setWasvisible(true);

                do{teleportx = random.nextInt(15);
                    teleporty = random.nextInt(15);
                }
                while(((játékos.getX()+játékos.getY())-(teleportx+teleporty))>=3 || ((játékos.getX()+játékos.getY())-(teleportx+teleporty))<=-3 );
                supx=telecserex;
                supy=telecserey;
                telecserex=teleportx;
                telecserey=teleporty;
                caught(slendermap);
                slendermap[teleportx][teleporty].setVisibility(true);
                if((játékos.getX()+játékos.getY())-(teleportx+teleporty)<=1 && (játékos.getX()+játékos.getY())-(teleportx+teleporty)>=-1)
                { harom++; }
                else{harom=0;}
                if(harom>=3)
                {
                    int rng = random.nextInt(3);
                    if(rng==1 || rng==2)
                    {end=true;defeat=true;}
                }

            }

            //slenderman
            if(papirusz.getPaperleft()==0 && papirusz.getPaperinventory()==8)
            {end=true;victory=true;}


        }while(end==false);
        if(end==true && victory==true)
        {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Megszerezted mind a 8 papírt!");
            System.out.println("Nyertél!");
            System.out.println("Összesen "+steps+" lépést tettél.");
        }
        if(end==true && defeat==true)
        {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Slenderman elkapott!");
            System.out.println("Game Over");
            System.out.println("Összesen "+steps+" lépést tettél.");
        }
        System.out.println("-------------------------------");

    }

    /**
     * Figyeli a játékos és a slenderman pozícióját, ha megegyezik (slenderman a játkosra teleportált), akkor játék vége és vesztett.
     * Figyeli a játékos és a slenderman előző pozícióját, ha megegyezik (a játékos slenderman karjaiba lépett), akkor játék vége és vesztett.
     * @param slendermap A 15*15-ös mátrix, ami "slendermanekből" áll.
     */
    public static void caught(Slenderman[][]slendermap)
    {
        if(slendermap[játékos.getX()][játékos.getY()].isVisibility()==true)
        {end=true;defeat=true;}
        if(slendermap[játékos.getX()][játékos.getY()].isWasvisible()==true)
        {end=true;defeat=true;}
    }

    /**
     * Megnézi, hogy a játékos az adott mezőre léphet-e.
     * @param x A térképen az X koordináta.
     * @param y A térképen az Y koordináta.
     * @param map Maga a 15*15-ös térkép ami az akadályokat tartalmazza.
     * @return Ha az adott helyen olyan akadály van, amibe nem lehet lépni akkor true-t ad vissza, másik esetben false-t.
     */
    public static Boolean ütközés(int x, int y, Block[][]map)
    {
        if(map[x][y].isAkadály()==true)
        {
            return true;
        }
        else {return false;}
    }

    /**
     * Megnézi, hogy a játékos jelenlegi pozíciója fölött, allatta vagy mellette van-e papír (tehát érintkezik vele)
     * és kezeli a papírok mennyiségét.
     * @param x A térképen az X koordináta.
     * @param y A térképen az Y koordináta.
     * @param map Maga a 15*15-ös térkép ami az akadályokat tartalmazza.
     */
    public static void papírcheck(int x, int y, Block[][]map)
    {
        if(x>0) {
            if (map[x - 1][y].isHaspapír() == true) {
                map[x - 1][y].setHaspapír(false);
                papirusz.setPaperleft(papirusz.getPaperleft() - 1);
                papirusz.setPaperinventory(papirusz.getPaperinventory() + 1);
            }
        } else if(x==0)
        {
            if (map[0][y].isHaspapír() == true) {
                map[0][y].setHaspapír(false);
                papirusz.setPaperleft(papirusz.getPaperleft() - 1);
                papirusz.setPaperinventory(papirusz.getPaperinventory() + 1);
            }
        }
        if(x<14) {
            if (map[x + 1][y].isHaspapír() == true) {
                map[x + 1][y].setHaspapír(false);
                papirusz.setPaperleft(papirusz.getPaperleft() - 1);
                papirusz.setPaperinventory(papirusz.getPaperinventory() + 1);
            }
        } else if(x==14)
        {
            if (map[14][y].isHaspapír() == true) {
                map[14][y].setHaspapír(false);
                papirusz.setPaperleft(papirusz.getPaperleft() - 1);
                papirusz.setPaperinventory(papirusz.getPaperinventory() + 1);
            }
        }
        if(y>0) {
            if (map[x][y-1].isHaspapír() == true) {
                map[x][y-1].setHaspapír(false);
                papirusz.setPaperleft(papirusz.getPaperleft() - 1);
                papirusz.setPaperinventory(papirusz.getPaperinventory() + 1);
            }
        } else if(y==0)
        {
            if (map[x][0].isHaspapír() == true) {
                map[x][0].setHaspapír(false);
                papirusz.setPaperleft(papirusz.getPaperleft() - 1);
                papirusz.setPaperinventory(papirusz.getPaperinventory() + 1);
            }
        }
        if(y<14) {
            if (map[x][y+1].isHaspapír() == true) {
                map[x][y+1].setHaspapír(false);
                papirusz.setPaperleft(papirusz.getPaperleft() - 1);
                papirusz.setPaperinventory(papirusz.getPaperinventory() + 1);
            }
        } else if(y==14)
        {
            if (map[x][14].isHaspapír() == true) {
                map[x][14].setHaspapír(false);
                papirusz.setPaperleft(papirusz.getPaperleft() - 1);
                papirusz.setPaperinventory(papirusz.getPaperinventory() + 1);
            }
        }

    }

    /**
     * A játék megjelenítéséért felel. Végig fut a mátrix tömbökön és, ha az x,y koordináta megegyezik a játékossal akkor azon a helyen megjeleníti.
     * Ugyan ezt elvégzi a slenderman-nel, csak neki a láthatóságát nézi (Visibility) és csak akkor jeleníti meg, ha a játékostól számítva 3 egységen belül van.
     * Ha egyik sem, lett megjelenítve az adott ponton, akkor a jelen pozicióban lévő elem (fű, kő, fa stb..) betűjét jeleníti meg.
     * @param x A térképen az X koordináta.
     * @param y A térképen az Y koordináta.
     * @param map Maga a 15*15-ös térkép ami az akadályokat tartalmazza.
     * @param slendermap A 15*15-ös mátrix, ami "slendermanekből" áll.
     */
    public static void display(int x, int y, Block[][]map, Slenderman[][]slendermap)
    {   System.out.println("-------------------------------");
        boolean trigger=false;
        int sor=0;
        for(int i=0;i<15;i++)
        {
            for(int j=0;j<15;j++) {
                if(i==x && j==y)
                {
                    játékos.setX(i);játékos.setY(j);
                    if(slendermap[i][j].isVisibility()==true || slendermap[i][j].isWasvisible()==true)
                    {
                        end=true;defeat=true;
                    }
                    System.out.print(játékos.getBetű()+" ");

                }
                else if(slendermap[i][j].isVisibility()==true)
                    {   if( (játékos.getX()-i)<=3 && (játékos.getX()-i)>=-3 && (játékos.getY()-j)<=3 && (játékos.getY()-j)>=-3)
                        {System.out.print(slendermap[i][j].getBetű()+" ");}
                        else{System.out.print(map[i][j].getBetu()+" ");}
                    }
                else if(slendermap[i][j].isVisibility()==false)
                {System.out.print(map[i][j].getBetu()+" ");}
                sor++;
                if(sor==15)
                {
                    System.out.println(" ");
                    sor=0;
                }
            }
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------");
        /**
         * A térképen lévő mozgást teszi lehetővé.
         * Kér egy inputot, ami W A S D lehet és, ha az egyik a négy közül, akkor az ütközést megnézi és odalépteti a játékost,
         * ellenkező esetben közli vele, hogy ide nem tud lépni.
         * Ha a játékos rossz inputot ad meg, akkor közli vele és újra lefut, amíg nem ad egy korrektet.
         */
        do {
            System.out.println("Hova szeretnél lépni? Eddig "+papirusz.getPaperinventory()+" papír van nálad. "+papirusz.getPaperleft()+" db van hátra.");
            String lepes = sc.nextLine();
            switch(lepes) {
                case "w":
                        posx--;
                        if(posx<0 || ütközés(posx,posy,map)==true){
                            posx++;
                            rosszinput=true;
                            System.out.println("Ide nem léphetsz.");
                            break;
                        }else{
                        rosszinput=false;
                        papírcheck(posx,posy,map);
                        steps++;
                        if(spawncheck==true)
                        {
                            if(spawnsteps<4)
                            {spawnsteps++;}
                            else{spawnsteps=0;teleport=true;}
                        }
                        break;}
                case "s":
                        posx++;
                    if(posx>14 || ütközés(posx,posy,map)==true){
                        posx--;
                        rosszinput=true;
                        System.out.println("Ide nem léphetsz.");
                        break;
                    }else{
                        rosszinput=false;
                        papírcheck(posx,posy,map);
                        steps++;
                        if(spawncheck==true)
                        {
                            if(spawnsteps<4)
                            {spawnsteps++;}
                            else{spawnsteps=0;teleport=true;}
                        }
                        break;}
                case "a":
                        posy--;
                    if(posy<0 || ütközés(posx,posy,map)==true){
                        posy++;
                        rosszinput=true;
                        System.out.println("Ide nem léphetsz.");
                        break;
                    }else{
                        rosszinput=false;
                        papírcheck(posx,posy,map);
                        steps++;
                        if(spawncheck==true)
                        {
                            if(spawnsteps<4)
                            {spawnsteps++;}
                            else{spawnsteps=0;teleport=true;}
                        }
                        break;}
                case "d":
                        posy++;
                    if(posy>14 || ütközés(posx,posy,map)==true){
                        posy--;
                        rosszinput=true;
                        System.out.println("Ide nem léphetsz.");
                        break;
                    }else{
                        rosszinput=false;
                        papírcheck(posx,posy,map);
                        steps++;
                        if(spawncheck==true)
                        {
                            if(spawnsteps<4)
                            {spawnsteps++;}
                            else{spawnsteps=0;teleport=true;}
                        }
                        break;}
                default:
                    rosszinput=true;
                    System.out.println("Rossz input.");
            }
        }while(rosszinput==true);

    }

}
