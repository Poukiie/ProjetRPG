package personnages.capacite;

import personnages.Personnage;

public class CapaciteSoigneur implements Capacite {
    private final Personnage soigneur;
    private final Personnage cible;

    public CapaciteSoigneur(Personnage soigneur, Personnage cible) {
        this.soigneur = soigneur;
        this.cible = cible;
    }

    @Override
    public void utiliser() {
        int energie = this.soigneur.getEnergie();

        if (energie >= 10) {
            this.soigneur.setEnergie(energie - 10);
            int pvRestaures = (int) (this.cible.getPVMax() * 0.2);
            // Vérifier qu'on ne dépasse pas les PV max
            // TODO vérifier que c'est bien cible.returnNewPVSoins ou soigneur.
            int newPV = this.cible.returnNewPVSupp(pvRestaures, this.cible);
            System.out.println(this.soigneur.getNom() + " restaure " + pvRestaures + " PV à " + this.cible.getNom()
                    + " (" + newPV + "/" + this.cible.getPVMax() + "PV)\n" + "--------");
        }
        System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
    }
}
