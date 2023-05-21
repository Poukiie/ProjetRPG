package personnages.ennemis;

import personnages.Personnage;

public abstract class Ennemi extends Personnage {
    public Ennemi(String nom, int pv, int pvMax, int atq, int def, int precision, int esquive, int energie) {
        super(nom, pv, pvMax, atq, def, precision, esquive, energie);
    }
}
