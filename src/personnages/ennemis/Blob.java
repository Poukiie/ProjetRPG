package personnages.ennemis;

import personnages.Personnage;
import personnages.Personnages;
import personnages.capacite.Capacite;
import personnages.capacite.CapaciteBlob;

public class Blob extends Personnage {
    public Blob(String nom) {
        super(nom, 55, 55, 70, 30, 70, 20, 0, 0);
    }

    @Override
    public Capacite capacite(Personnage cible, Personnages cibles) {
        return new CapaciteBlob(this, cible);
    }

    @Override
    public boolean estMulticible() {
        return false;
    }

    @Override
    public boolean cibleEnnemis() {
        return true;
    }
}
