package personnages.heros;

import personnages.Personnage;
import personnages.Personnages;
import personnages.capacite.Capacite;
import personnages.capacite.CapaciteTank;

public class Tank extends Personnage {
    public Tank(String nom) {
        super(nom, 185, 185, 45, 100, 40, 50, 45, 45);
    }

    // Capacité bouclier : Son esquive passe à 100 et celle de ses alliés à 100 aussi pendant 1 tour
    // L'attaque de l'ennemi est ratée puisque elle est forcément esquivée (protection)
    // Ou bien augmente considérablement leur DEF
    @Override
    public Capacite capacite(Personnage cible, Personnages cibles) {
        return new CapaciteTank(this ,cibles);
    }

    @Override
    public boolean estMulticible() {
        return true;
    }

    @Override
    public boolean cibleEnnemis() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + getClass().getSimpleName();
    }
}
