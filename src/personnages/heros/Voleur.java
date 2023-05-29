package personnages.heros;

import personnages.Personnage;
import personnages.Personnages;
import personnages.capacite.Capacite;
import personnages.capacite.CapaciteVoleur;

public class Voleur extends Personnage {
    public Voleur(String nom) {
        super(nom, 125, 125, 35, 60, 70, 90, 40, 40);
    }

    // Capacité: voler 20% des PV à un ennemi
    @Override
    public Capacite capacite(Personnage cible, Personnages cibles) {
        return new CapaciteVoleur(this, cible);
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
