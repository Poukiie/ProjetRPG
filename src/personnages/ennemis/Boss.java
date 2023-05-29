package personnages.ennemis;

import personnages.Personnage;
import personnages.Personnages;
import personnages.capacite.Capacite;
import personnages.capacite.CapaciteMage;

public class Boss extends Personnage {
    public Boss(String nom) {
        super(nom, 250, 250, 80, 70, 75, 60, 50, 50);
    }

    @Override
    public Capacite capacite(Personnage cible, Personnages cibles) {
        return new CapaciteMage(this, cibles);
    }

    @Override
    public boolean estMulticible() {
        return true;
    }

    @Override
    public boolean cibleEnnemis() {
        return true;
    }
}
