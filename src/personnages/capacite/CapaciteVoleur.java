package personnages.capacite;

import personnages.Personnage;

public class CapaciteVoleur implements Capacite {
    private final Personnage voleur;
    private final Personnage cible;

    public CapaciteVoleur(Personnage voleur, Personnage cible) {
        this.voleur = voleur;
        this.cible = cible;
    }

    @Override
    public void utiliser() {
        int energie = this.voleur.getEnergie();

        if (energie < 10) {
            System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
            return;
        }
        this.voleur.setEnergie(energie - 10);
        int pvVoles = (int) (cible.getPV() * 0.2);
        cible.setPV(cible.getPV() - pvVoles);
        this.voleur.setPV(this.voleur.getPV() + pvVoles);
    }
}
