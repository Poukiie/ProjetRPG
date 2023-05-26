package personnages.heros;

import personnages.ennemis.Ennemi;
import personnages.ennemis.Ennemis;

public class Mage extends Heros<Ennemis> {
    public Mage(String nom) {
        super(nom, 100, 100, 70, 50, 80, 50, 70, 70);
    }

    // Capacité: attaquer tous les ennemis en même temps (valeurAttaque / 2)
    @Override
    public void utiliserCapacite(Ennemis ennemis) {
        if (this.getEnergie() < 10) {
            System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
            return;
        }
        this.setEnergie(this.getEnergie() - 10);

        for (Ennemi e : ennemis) {
            int valeurAttaque = (this.getATK() - e.getDEF()) / 2;
            e.setPV(e.getPV() - valeurAttaque);
        }
    }

    @Override
    public boolean estMulticible() {
        return true;
    }
}
