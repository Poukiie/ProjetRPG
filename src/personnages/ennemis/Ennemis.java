package personnages.ennemis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ennemis implements Iterable<Ennemi> {
    private final List<Ennemi> ennemis;

    public Ennemis() {
        this.ennemis = new ArrayList<>();
    }

    public void add(Ennemi e) {
        this.ennemis.add(e);
    }

    public Ennemi get(int index) {
        return this.ennemis.get(index);
    }

    public void remove(int index) {
        this.ennemis.remove(index);
    }

    public int size() {
        return this.ennemis.size();
    }

    /**
     * Permet de boucler sur la classe Ennemis avec un foreach
     */
    @Override
    public Iterator<Ennemi> iterator() {
        return ennemis.iterator();
    }

    /**
     * Permet d'afficher la liste des ennemis
     * @return la liste des ennemis
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Ennemi e : this.ennemis) {
            // e: implicitement le toString() de Ennemi
            sb.append(i++).append(". ").append(e).append("\n");
        }
        return sb.toString();
    }
}
