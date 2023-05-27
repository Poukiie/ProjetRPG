package personnages.heros;

import personnages.Personnage;
import personnages.Personnages;
import personnages.capacite.Capacite;
import personnages.capacite.CapaciteGuerrier;

public class Guerrier extends Heros {
    public Guerrier(String nom) {
        super(nom, 85, 85, 90, 30, 85, 30, 30, 30);
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
}
