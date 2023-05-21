package classes;

import personnages.Heros;
import personnages.Personnage;

public class Voleur extends Heros {
    public Voleur(String nom) {
        super(nom, 100, 80, 40, 10);
        // TODO set esquive (40? 50?)
    }

    @Override
    public void utiliserCapacite(Personnage p) {

    }
}
