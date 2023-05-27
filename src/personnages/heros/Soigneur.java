package personnages.heros;

import personnages.Personnage;
import personnages.Personnages;
import personnages.capacite.Capacite;
import personnages.capacite.CapaciteSoigneur;

public class Soigneur extends Heros {

    public Soigneur(String nom) {
        super(nom, 150, 150, 25, 60, 60, 50, 60, 60);
    }

    // Capacité de soin (choix d'UN perso à heal, restaure selon 20% des PV max du healer)
    @Override
    public Capacite capacite(Personnage cible, Personnages cibles) {
        return new CapaciteSoigneur(this, cible);
    }

    @Override
    public boolean estMulticible() {
        return false;
    }
}