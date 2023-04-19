package personnages;

public abstract class Heros extends Personnage {

    public Heros(String nom, int pv, int atq, int def, int energie) {
        super(nom, pv, atq, def, energie);
    }

    public void attaquer(Ennemi ennemi) {
        int ennemiPV = ennemi.getPV();
        if (ennemiPV > 0) {
            if (ennemi.getDEF() > this.getATK()) {
                System.out.println(this.getNom() + "n'inflige aucun dégât à " + ennemi.getNom()
                        + " (" + (ennemiPV) + "PV)");
            }
            ennemiPV = ennemiPV - this.getATK() + ennemi.getDEF();
            if (ennemiPV < 0) {
                ennemiPV = 0;
            }
            System.out.println(this.getNom() + " inflige " + (this.getATK() - ennemi.getDEF()) + " dégâts à " + ennemi.getNom()
                    + " (" + (ennemiPV) + "PV)");
        }
        else {
            System.out.println("Arrête il est déjà mort, espèce de monstre...");
        }
    }

    public abstract void utiliserCapacite(Personnage p);
}
