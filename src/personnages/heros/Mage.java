package personnages.heros;

import personnages.Personnage;
import personnages.Personnages;
import personnages.capacite.Capacite;
import personnages.capacite.CapaciteMage;

public class Mage extends Heros {
    public Mage(String nom) {
        super(nom, 100, 100, 70, 50, 80, 50, 70, 70);
    }

    // Capacité: attaquer tous les ennemis en même temps (valeurAttaque / 2)
    @Override
    public Capacite capacite(Personnage cible, Personnages cibles) {
        return new CapaciteMage(this, cibles);
    }

    @Override
    public boolean estMulticible() {
        return true;
    }
}
