package personnages;

public class Ennemi extends Personnage {
    public Ennemi(String nom, int pv, int atq, int def, int energie) {
        super(nom, pv, atq, def, energie);
    }

    public void attaquer(Personnage perso) {
        int persoPV = perso.getPV();
        if (persoPV > 0) {
            if (perso.getDEF() > this.getATK()) {
                System.out.println(this.getNom() + " n'inflige aucun dégât à " + perso.getNom()
                        + " (" + (persoPV) + "PV)");
            }
            else {
                persoPV = persoPV - this.getATK() + perso.getDEF();
                if (persoPV < 0) {
                    persoPV = 0;
                }
                System.out.println(this.getNom() + " inflige " + (this.getATK() - perso.getDEF()) + " dégâts à " + perso.getNom()
                        + " (" + (persoPV) + "PV)");
            }
        }
        else {
            System.out.println("Arrete il est déjà mort...");
        }
    }
}
