package personnages.heros;

import personnages.Personnage;
import personnages.Personnages;
import personnages.capacite.Capacite;
import personnages.capacite.CapaciteGuerrier;

public class Guerrier extends Personnage {
    public Guerrier(String nom) {
        super(nom, 90, 90, 80, 40, 85, 30, 30, 30, 30);
    }

    // Capacité: attaquer deux fois de suite
    @Override
    public Capacite capacite(Personnage cible, Personnages cibles) {
        return new CapaciteGuerrier(this, cible);
    }

    @Override
    public boolean estMulticible() {
        return false;
    }

    @Override
    public boolean cibleEnnemis() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + getClassName();
    }
}
