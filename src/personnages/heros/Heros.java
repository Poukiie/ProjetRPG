package personnages.heros;

import personnages.CapaciteSpeciale;
import personnages.Personnage;
import recompenses.Consommable;

public abstract class Heros<T> extends Personnage implements CapaciteSpeciale<T> {

    public Heros(String nom, int pv, int pvMax, int atq, int def, int precision, int esquive, int energie, int energieMax) {
        super(nom, pv, pvMax, atq, def, precision, esquive, energie, energieMax);
    }

    @Override
    public abstract void utiliserCapacite(T p);

    @Override
    public abstract boolean estMulticible();

    public void utiliserObjet(Consommable c) {

    }
}
