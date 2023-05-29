package personnages.capacite;

import personnages.Personnage;
import personnages.Personnages;

public class CapaciteMage implements Capacite {
    private final Personnage mage;
    private final Personnages ennemis;

    public CapaciteMage(Personnage mage, Personnages ennemis) {
        this.mage = mage;
        this.ennemis = ennemis;
    }

    @Override
    public void utiliser() {
        int energie = this.mage.getEnergie();

        if (energie >= 10) {
            this.mage.setEnergie(energie - 10);

            for (Personnage e : ennemis) {
                int valeurAttaque = (this.mage.getATK() - e.getDEF()) / 2;
                // Vérifier qu'on ne set pas les PV à un nb négatif
                // TODO vérifier que c'est bien e.returnNewPVSoins ou mage.
                int newPV = e.returnNewPV(valeurAttaque, e);
                e.setPV(newPV);
                System.out.println(this.mage.getNom() + " utilise sa magie et inflige " + valeurAttaque
                        + " dégâts à " + e.getNom() + " (" + newPV + "/" + e.getPVMax() + "PV)");
            }
            System.out.println("--------");
        }

        System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
    }
}
