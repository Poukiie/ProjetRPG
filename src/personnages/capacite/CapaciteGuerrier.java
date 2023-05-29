package personnages.capacite;

import personnages.Personnage;

public class CapaciteGuerrier implements Capacite {
    private final Personnage guerrier;
    private final Personnage ennemi;

    public CapaciteGuerrier(Personnage guerrier, Personnage ennemi) {
        this.guerrier = guerrier;
        this.ennemi = ennemi;
    }

    @Override
    public void utiliser() {
        int energie = this.guerrier.getEnergie();

        if (energie >= 10) {
            this.guerrier.setEnergie(energie - 10);
            this.guerrier.attaquer(ennemi);
            this.guerrier.attaquer(ennemi);
        }
        System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
    }
}
