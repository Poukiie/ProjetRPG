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

        if (energie < 10) {
            System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
            return;
        }
        this.soigneur.setEnergie(energie - 10);
        int pvRestaures = (int) (cible.getPVMax() * 0.2);
        cible.setPV(cible.getPV() + pvRestaures);
    }
}
