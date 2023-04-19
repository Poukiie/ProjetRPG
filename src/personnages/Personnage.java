package personnages;

import java.util.ArrayList;

public class Personnage {
    private String nom;
    private int PV;
    private int ATK;
    private int DEF; // 5 de DEF, l’ennemi tape 12, je me prends 7 de DGT, différence
    private int energie; // pour utiliser des capacités
    public static int counter = 0;
    public static ArrayList<Personnage> personnages = new ArrayList<>();

    public Personnage() {}

    public Personnage(String nom, int pv, int atq, int def, int energie) {
        this.nom = nom;
        this.PV = pv;
        this.ATK = atq;
        this.DEF = def;
        this.energie = energie;
        this.counter += 1;
    }

    public String getNom() {
        return nom;
    }

    public int getPV() {
        return PV;
    }

    public int getATK() {
        return ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public int getEnergie() {
        return energie;
    }

    public static void creerPersonnage(String nom, int pv, int atq, int def, int energie) {
        personnages.add(new Personnage(nom, pv, atq, def, energie));
    }

    public void attaquer(Personnage p) {
        if (this instanceof Heros && p instanceof Ennemi) {
            ((Heros)this).attaquer((Ennemi)p);
        }
        if (this instanceof Ennemi && p instanceof Heros) {
            ((Ennemi)this).attaquer((Heros)p);
        }
    }

    public void utiliserCapacite(Personnage p) {
        if (this instanceof Heros && p instanceof Ennemi) {
            ((Heros)this).utiliserCapacite((Ennemi)p);
        }
        if (this instanceof Ennemi && p instanceof Heros) {
            ((Ennemi)this).utiliserCapacite((Heros)p);
        }
    }
}
