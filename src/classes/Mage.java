package classes;

import personnages.Heros;
import personnages.Personnage;

public class Mage extends Heros {
    public Mage(String nom) {
        super(nom,140, 70, 50, 70);
    }

    @Override
    public void utiliserCapacite(Personnage p) {

    }
}
