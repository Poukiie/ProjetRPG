package personnages.heros;

import personnages.Personnage;
import personnages.Personnages;
import personnages.capacite.Capacite;

public abstract class Heros extends Personnage {

    public Heros(String nom, int pv, int pvMax, int atq, int def, int precision, int esquive, int energie, int energieMax) {
        super(nom, pv, pvMax, atq, def, precision, esquive, energie, energieMax);
    }

    public abstract Capacite capacite(Personnage cible, Personnages cibles);
    public abstract boolean estMulticible();
}
