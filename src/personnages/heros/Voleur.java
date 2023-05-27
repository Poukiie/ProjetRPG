package personnages.heros;

import personnages.Personnage;
import personnages.Personnages;
import personnages.capacite.Capacite;
import personnages.capacite.CapaciteVoleur;

public class Voleur extends Heros {
    public Voleur(String nom) {
        super(nom, 125, 125, 30, 60, 70, 90, 55, 55);
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
}
