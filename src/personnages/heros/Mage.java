package personnages.heros;

import personnages.Personnage;
import personnages.Personnages;
import personnages.capacite.Capacite;
import personnages.capacite.CapaciteMage;

public class Mage extends Personnage {
    public Mage(String nom) {
        super(nom, 100, 100, 70, 55, 80, 40, 60, 60);
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

    @Override
    public boolean cibleEnnemis() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + getClassName();
    }
}
