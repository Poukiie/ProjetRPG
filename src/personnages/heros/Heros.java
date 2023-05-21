package personnages.heros;

import personnages.CapaciteSpeciale;
import personnages.Personnage;

public abstract class Heros extends Personnage implements CapaciteSpeciale {

    public Heros(String nom, int pv, int pvMax, int atq, int def, int precision, int esquive, int energie) {
        super(nom, pv, pvMax, atq, def, precision, esquive, energie);
    }

    @Override
    public abstract void utiliserCapacite();
}
