package personnages;

public abstract class Heros extends Personnage {

    public Heros(String nom, int pv, int atq, int def, int energie) {
        super(nom, pv, atq, def, energie);
    }

    public abstract void utiliserCapacite(Personnage p);
}
