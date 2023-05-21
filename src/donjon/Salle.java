package donjon;

import personnages.ennemis.Ennemi;

import java.util.List;

public class Salle {
    private int numSalle;
    private List<Ennemi> ennemis;

    public Salle(int numSalle, List<Ennemi> ennemis) {
        this.numSalle = numSalle;
        this.ennemis = ennemis;
    }
}
