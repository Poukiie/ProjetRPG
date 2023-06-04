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
        int newPV = 0;

        if (energie >= 10) {
            this.mage.setEnergie(energie - 10);

            for (Personnage e : ennemis) {
                int valeurAttaque = (this.mage.getATK() - e.getDEF()) / 2;
                if (valeurAttaque > 0) {
                    // Vérifier qu'on ne set pas les PV à un nb négatif
                    newPV = e.returnNewPV(valeurAttaque, e);
                    e.setPV(newPV);
                    System.out.println(this.mage.getNom() + " utilise sa magie et inflige " + valeurAttaque
                            + " dégâts à " + e.getNom() + " (" + newPV + "/" + e.getPVMax() + "PV)");
                }
                // Pour éviter que le perso inflige 0 dégât
                else {
                    valeurAttaque = (int) (this.mage.getATK() * 0.2);
                    newPV = e.returnNewPV(valeurAttaque, e);
                    e.setPV(newPV);
                    System.out.println(this.mage.getNom() + " utilise sa magie et n'inflige que " + valeurAttaque
                            + " dégâts à " + e.getNom() + " (" + newPV + "/" + e.getPVMax() + "PV)");
                }
            }
            System.out.println("--------");
        }
        else {
            System.out.println("Pas assez d'énergie pour utiliser la capacité spéciale.");
        }
    }

    @Override
    public String getDescription() {
        return null;
    }
}
