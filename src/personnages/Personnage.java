package personnages;

import java.util.ArrayList;
import java.util.Random;

public abstract class Personnage {
    private String nom;
    private int PV;
    private int PVMax;
    private int ATK;
    private int DEF;
    private int precision;
    private int esquive;
    private int energie; // pour utiliser des capacités
    private static int counter = 0;
    private static final ArrayList<Personnage> personnages = new ArrayList<>();

    public Personnage(String nom, int pv, int pvMax, int atq, int def, int precision, int esquive, int energie) {
        this.nom = nom;
        this.PV = pv;
        this.PVMax = pvMax;
        this.ATK = atq;
        this.DEF = def;
        this.precision = precision;
        this.esquive = esquive;
        this.energie = energie;
        Personnage.counter += 1;
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

    public int getPrecision() {
        return precision;
    }

    public int getEsquive() {
        return esquive;
    }

    public int getEnergie() {
        return energie;
    }

    public static int getCounter() {
        return counter;
    }

    public static ArrayList<Personnage> getPersonnages() {
        return personnages;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    private boolean roll(int stat) {
        return new Random().nextInt(100) + 1 <= stat;
    }

    public void attaquer(Personnage p) {
        int valeurAttaque = this.ATK - p.getDEF();
        if (valeurAttaque > 0) {
            // Check précision
            boolean attaquePrecise = this.roll(this.precision);
            if (attaquePrecise) {
                // Check esquive adversaire
                boolean attaqueEsquivee = p.roll(p.getEsquive());
                if (!attaqueEsquivee) {
                    int diff = p.getPV() - valeurAttaque;
                    int newPV = Math.max(diff, 0);
                    p.setPV(newPV);
                    System.out.println(this.nom + " inflige " + valeurAttaque + " dégâts à " + p.getNom()
                            + " (" + (newPV) + "PV)");
                    return;
                }
            }
        }

        System.out.println(this.nom + " n'inflige aucun dégât à " + p.getNom()
                + " (" + (p.getPV()) + "PV)");
    }
}
