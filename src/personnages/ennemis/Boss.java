package personnages.ennemis;

import personnages.CapaciteSpeciale;

public class Boss extends Ennemi implements CapaciteSpeciale {
    public Boss(String nom) {
        super(nom, 400, 400, 100, 80, 75, 60, 50);
    }

    @Override
    public void utiliserCapacite() {
        
    }
}
