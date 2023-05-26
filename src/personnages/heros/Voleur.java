package personnages.heros;

import personnages.ennemis.Ennemi;

public class Voleur extends Heros<Ennemi> {
    public Voleur(String nom) {
        super(nom, 125, 125, 30, 60, 70, 90, 55, 55);
    }

    // Capacité: voler 20% des PV à un ennemi
    @Override
    public void utiliserCapacite(Ennemi p) {
        if (this.getEnergie() < 10) {
            System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
            return;
        }
        this.setEnergie(this.getEnergie() - 10);
        int pvVoles = (int) (p.getPV() * 0.2);
        p.setPV(p.getPV() - pvVoles);
        this.setPV(this.getPV() + pvVoles);
    }

    @Override
    public boolean estMulticible() {
        return false;
    }
}
