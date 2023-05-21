package personnages.ennemis;

import personnages.Personnage;
import personnages.CapaciteSpeciale;

public abstract class Ennemi extends Personnage implements CapaciteSpeciale {
    public Ennemi(String nom, int pv, int pvMax, int atq, int def, int precision, int esquive, int energie) {
        super(nom, pv, pvMax, atq, def, precision, esquive, energie);
    }

    @Override
    public abstract void utiliserCapacite();
}
