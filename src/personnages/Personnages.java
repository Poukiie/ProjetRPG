package personnages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Personnages implements Iterable<Personnage> {
    private final List<Personnage> personnages;

    public Personnages() {
        this.personnages = new ArrayList<>();
    }

    public void add(Personnage p) {
        this.personnages.add(p);
    }

    public Personnage get(int index) {
        return this.personnages.get(index);
    }

    public void remove(Personnage p) {
        this.personnages.remove(p);
    }

    public int size() {
        return this.personnages.size();
    }

    public boolean isEmpty() {
        return this.personnages.isEmpty();
    }

    /**
     * Permet de boucler sur la liste de cette classe avec un foreach
     */
    @Override
    public Iterator<Personnage> iterator() {
        return personnages.iterator();
    }

    /**
     * Permet d'afficher la liste des personnages (alliés ou ennemis)
     * @return la liste des personnages
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Personnage p : this.personnages) {
            // p: implicitement le toString() de Personnage
            sb.append(i++).append(". ").append(p).append("\n");
        }
        return sb.toString();
    }
}
