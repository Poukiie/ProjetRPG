package personnages.heros;

import personnages.ennemis.Ennemi;

public class Guerrier extends Heros<Ennemi> {
    public Guerrier(String nom) {
        super(nom, 85, 85, 90, 30, 85, 30, 30);
    }

    // Capacité attaquer deux fois de suite (double valeurAttaque)
    @Override
    public void utiliserCapacite(Ennemi p) {
        if (this.getEnergie() < 10) {
            System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
            return;
        }
        this.setEnergie(this.getEnergie() - 10);
        // TODO: code de la capacité spéciale
    }
}
