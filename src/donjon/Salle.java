package donjon;

import personnages.ennemis.Blob;
import personnages.ennemis.Boss;
import personnages.ennemis.Ennemi;
import personnages.Personnages;

public class Salle {
    private final Personnages personnages = new Personnages();

    public Salle(int numSalle, int numDonjon) {
        // Créer une liste de 4 ou 5 blobs
        Ennemi ennemi;
        if (numSalle != 3) {
            // (int) (Math.random() * 2) génère un nombre aléatoire entre 0 et 1
            // 4 + ce nombre = 4 ou 5
            for (int i = 0; i < 4 + (int) (Math.random() * 2); i++) {
                ennemi = new Blob("Blob " + (i + 1));
                this.personnages.add(ennemi);
            }
        } else {
            // Créer un boss si c'est la dernière salle
            ennemi = new Boss("Boss");
            this.personnages.add(ennemi);
            // Créer 2 blobs en plus si c'est la salle 3 du donjon 3
            if (numDonjon == 3) {
                for (int j = 0; j < 2; j++) {
                    ennemi = new Blob("Blob " + (j + 1));
                    this.personnages.add(ennemi);
                }
            }
        }
    }

    public boolean isCompleted() {
        return personnages.size() == 0;
    }

    public Personnages getEnnemis() {
        return personnages;
    }

}
