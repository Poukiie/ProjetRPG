package personnages.capacite;

import personnages.Personnage;
import personnages.Personnages;
import personnages.heros.Heros;

public class CapaciteTank implements Capacite {
    private final Heros tank;
    private final Personnages allies;

    public CapaciteTank(Heros tank, Personnages allies) {
        this.tank = tank;
        this.allies = allies;
    }

    @Override
    public void utiliser() {
        int energie = this.tank.getEnergie();

        if (energie < 10) {
            System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
            return;
        }

        this.tank.setEnergie(energie - 10);
        this.tank.setEsquive(100);
        for (Personnage p : allies)
            p.setEsquive(100);

        // TODO: gérer le tour suivant pour remettre l'esquive à la normale
    }
}
