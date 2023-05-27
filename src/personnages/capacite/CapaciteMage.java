package personnages.capacite;

import personnages.Personnage;
import personnages.Personnages;
import personnages.heros.Heros;

public class CapaciteMage implements Capacite {
    private final Heros mage;
    private final Personnages ennemis;

    public CapaciteMage(Heros mage, Personnages ennemis) {
        this.mage = mage;
        this.ennemis = ennemis;
    }

    @Override
    public void utiliser() {
        int energie = this.mage.getEnergie();

        if (energie < 10) {
            System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
            return;
        }
        this.mage.setEnergie(energie - 10);

        for (Personnage e : ennemis) {
            int valeurAttaque = (this.mage.getATK() - e.getDEF()) / 2;
            e.setPV(e.getPV() - valeurAttaque);
        }
    }
}
