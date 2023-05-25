package donjon;

import personnages.ennemis.Blob;
import personnages.ennemis.Boss;
import personnages.ennemis.Ennemi;

import java.util.ArrayList;
import java.util.List;

public class Salle {
    private int numSalle;
    private List<Ennemi> ennemis = new ArrayList<>();
    private boolean isCompleted;

    public Salle(int numSalle) {
        this.numSalle = numSalle;
        this.isCompleted = false;
        // Créer une liste de blobs random, entre 4 et 5 blobs
        Ennemi ennemi;
        if (numSalle != 3) {
            // (int) (Math.random() * 2) génère un nombre aléatoire entre 0 et 1
            // En ajoutant 4 à ce nombre, nous obtenons un nombre aléatoire entre 4 et 5.
            for (int i = 0; i < 4 + (int) (Math.random() * 2); i++) {
                ennemi = new Blob("Blob " + (i + 1));
                this.ennemis.add(ennemi);
            }
        } else {
            // Créer un boss si c'est la dernière salle
            ennemi = new Boss("Boss");
            this.ennemis.add(ennemi);
        }
    }

    public int getNumSalle() {
        return numSalle;
    }

    public boolean isCompleted() { return isCompleted; }

    public List<Ennemi> getEnnemis() {
        return ennemis;
    }

}
