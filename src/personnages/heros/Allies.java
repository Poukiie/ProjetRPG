package personnages.heros;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Allies implements Iterable<Heros>{
    private final List<Heros> allies;

    public Allies() {
        this.allies = new ArrayList<>();
    }

    @Override
    public Iterator<Heros> iterator() {
        return allies.iterator();
    }
}
