package classes;

import personnages.Heros;
import personnages.Personnage;

public class Tank extends Heros {
    public Tank(String nom) {
        super(nom, 220, 40, 100, 40);
    }

    @Override
    public void utiliserCapacite(Personnage p) {

    }
}
