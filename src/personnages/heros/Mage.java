package personnages.heros;

import personnages.Personnage;

public class Mage extends Heros<Personnage> {
    public Mage(String nom) {
        super(nom, 100, 100, 70, 50, 80, 50, 70);
    }

    // Capacité à redéfinir
    @Override
    public void utiliserCapacite(Personnage p) {
        if (this.getEnergie() < 10) {
            System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
            return;
        }
        this.setEnergie(this.getEnergie() - 10);
        // TODO: code de la capacité spéciale
    }
}
