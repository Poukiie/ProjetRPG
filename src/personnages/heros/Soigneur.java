package personnages.heros;

import personnages.CapaciteSpeciale;
import personnages.Personnage;

public class Soigneur extends Heros<Personnage> implements CapaciteSpeciale<Personnage> {

    public Soigneur(String nom) {
        super(nom, 150, 150, 25, 60, 60, 50, 60);
    }

    // Capacité de soin (choix d'UN perso à heal, restaure selon 20% des PV max du healer)
    @Override
    public void utiliserCapacite(Personnage p) {
        if (this.getEnergie() < 10) {
            System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
            return;
        }
        this.setEnergie(this.getEnergie() - 10);
        int pvRestaures = (int) (p.getPVMax() * 0.2);
        p.setPV(p.getPV() + pvRestaures);
    }

    @Override
    public boolean isMultiTarget() {
        return false;
    }
}