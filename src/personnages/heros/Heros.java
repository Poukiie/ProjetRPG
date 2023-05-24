package personnages.heros;

import personnages.CapaciteSpeciale;
import personnages.Personnage;
import recompenses.Consommable;

public abstract class Heros<T> extends Personnage implements CapaciteSpeciale<T> {

    public Heros(String nom, int pv, int pvMax, int atq, int def, int precision, int esquive, int energie) {
        super(nom, pv, pvMax, atq, def, precision, esquive, energie);
    }

    @Override
    public abstract void utiliserCapacite(T p);

    public void utiliserObjet(Consommable c) {

    }
}
