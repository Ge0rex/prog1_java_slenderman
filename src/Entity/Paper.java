package Entity;

/**
 * A játékosnál és a térképen lévő papírok számát lehet vele módosítani.
 * @author Nagy Dominik - V9PBRB
 * @version 1.0
 */
public class Paper {
    int paperinventory;
    int paperleft;

    /**
     * Sima konstruktor.
     * @param paperinventory Játékosnál lévő papírok száma.
     * @param paperleft A térképen lévő papírok száma.
     */
    public Paper(int paperinventory, int paperleft) {
        this.paperinventory = paperinventory;
        this.paperleft = paperleft;
    }

    public int getPaperinventory() {
        return paperinventory;
    }

    public int getPaperleft() {
        return paperleft;
    }

    public void setPaperinventory(int paperinventory) {
        this.paperinventory = paperinventory;
    }

    public void setPaperleft(int paperleft) {
        this.paperleft = paperleft;
    }
}
