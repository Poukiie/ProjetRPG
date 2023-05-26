package personnages.ennemis;

import personnages.Personnage;

public abstract class Ennemi extends Personnage {
    public Ennemi(String nom, int pv, int pvMax, int atq, int def, int precision, int esquive, int energie, int energieMax) {
        super(nom, pv, pvMax, atq, def, precision, esquive, energie, energieMax);
    }

    /**
     * String pour afficher les infos d'un ennemi en combat
     * @return les infos de l'ennemi (nom, PV/PVMax)
     */
    @Override
    public String toString() {
        return getNom() + " (" + getPV() + "/" + getPVMax() + " PV)";
    }
}
