package personnages.capacite;

import personnages.Personnage;
import personnages.Personnages;

public class CapaciteTank implements Capacite {
    private final Personnage tank;
    private final Personnages allies;

    public CapaciteTank(Personnage tank, Personnages allies) {
        this.tank = tank;
        this.allies = allies;
    }

    @Override
    public void utiliser() {
        int energie = this.tank.getEnergie();

        if (energie >= 10) {
            this.tank.setEnergie(energie - 10);
            this.tank.setEsquive(100);
            for (Personnage p : allies)
                p.setEsquive(100);
            System.out.println(this.tank.getNom() + " crée un bouclier pour tous vos alliés.\n --------");
            // TODO: gérer le tour suivant pour remettre l'esquive à la normale (variable tmp)
        }
        System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
    }

    @Override
    public String getDescription() {
        return null;
    }
}
