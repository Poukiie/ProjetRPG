package personnages.ennemis;

import personnages.CapaciteSpeciale;
import personnages.Personnage;

import java.util.List;

public class Boss extends Ennemi implements CapaciteSpeciale<List<Personnage>> {
    public Boss(String nom) {
        super(nom, 400, 400, 100, 80, 75, 60, 50, 50);
    }

    // Capacite: attaque tous les héros (valeurAttaque / 2)
    @Override
    public void utiliserCapacite(List<Personnage> allies) {
        if (!(this.getEnergie() < 10)) {
            this.setEnergie(this.getEnergie() - 10);

            for (Personnage a : allies) {
                int valeurAttaque = (this.getATK() - a.getDEF()) / 2;
                a.setPV(a.getPV() - valeurAttaque);
            }
        }
    }

    @Override
    public boolean estMulticible() {
        return false;
    }
}
