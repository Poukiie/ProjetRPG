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

    @Override
    public Iterator<Ennemi> iterator() {
        return ennemis.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Ennemi e : this.ennemis) {
            sb.append(i++).append(". ").append(e).append("\n");
        }
        return sb.toString();
    }
}
