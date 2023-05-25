package personnages.heros;

import personnages.Personnage;

import java.util.List;

public class Tank extends Heros<List<Personnage>> {
    public Tank(String nom) {
        super(nom, 185, 185, 45, 100, 40, 50, 45);
    }

    // Capacité bouclier : Son esquive passe à 100 et celle de ses alliés à 100 aussi pendant 1 tour
    // L'attaque de l'ennemi est ratée puisque elle est forcément esquivée (protection)
    // Ou bien augmente considérablement leur DEF
    @Override
    public void utiliserCapacite(List<Personnage> allies) {
        if (this.getEnergie() < 10) {
            System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
            return;
        }

        this.setEnergie(this.getEnergie() - 10);
        this.setEsquive(100);
        for (Personnage p : allies)
            p.setEsquive(100);

        // TODO: gérer le tour suivant pour remettre l'esquive à la normale
    }
}
