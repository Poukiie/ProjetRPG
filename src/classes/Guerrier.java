package classes;

import personnages.Heros;
import personnages.Personnage;

public class Guerrier extends Heros {
    public Guerrier(String nom) {
        super(nom,110, 90, 60, 20);
    }

    @Override
    public void utiliserCapacite(Personnage p) {

    }
}
