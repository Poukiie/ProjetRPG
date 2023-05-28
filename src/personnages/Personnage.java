package personnages;

import personnages.capacite.Capacite;

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
    private int energieMax;
    private static int counter = 0;
    private static final ArrayList<Personnage> personnages = new ArrayList<>();

    public Personnage(String nom, int pv, int pvMax, int atq, int def, int precision, int esquive, int energie, int energieMax) {
        this.nom = nom;
        this.PV = pv;
        this.PVMax = pvMax;
        this.ATK = atq;
        this.DEF = def;
        this.precision = precision;
        this.esquive = esquive;
        this.energie = energie;
        this.energieMax = energieMax;
        Personnage.counter += 1;
    }

    public abstract Capacite capacite(Personnage cible, Personnages cibles);
    public abstract boolean estMulticible();
    public abstract boolean cibleEnnemis();

    public String getNom() {
        return nom;
    }

    public int getPV() {
        return PV;
    }

    public void setPV(int PV) {
        this.PV = PV;
    }

    public int getPVMax() {
        return PVMax;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public int getEsquive() {
        return esquive;
    }

    public void setEsquive(int esquive) {
        this.esquive = esquive;
    }

    public int getEnergie() {
        return energie;
    }

    public void setEnergie(int energie) {
        this.energie = energie;
    }

    public int getEnergieMax() {
        return energieMax;
    }

    public static int getCounter() {
        return counter;
    }

    public static ArrayList<Personnage> getPersonnages() {
        return personnages;
    }

    // Roll un nombre entre 1 et 100
    // Stat précision : si roll <= stat, alors attaque réussie
    // Stat esquive : si roll <= stat, alors attaque esquivée
    private boolean roll(int stat) {
        return new Random().nextInt(100) + 1 <= stat;
    }

    public void attaquer(Personnage p) {
        int valeurAttaque = this.ATK - p.getDEF();
        int newPV;

        // Si ATK > DEF
        if (valeurAttaque > 0) {
            // Check précision
            boolean attaquePrecise = this.roll(this.precision);
            if (attaquePrecise) {
                // Check esquive adversaire
                boolean attaqueEsquivee = p.roll(p.getEsquive());
                if (!attaqueEsquivee) {
                    newPV = returnNewPV(valeurAttaque, p);
                    p.setPV(newPV);
                    System.out.println(this.nom + " inflige " + valeurAttaque + " dégâts à " + p.getNom()
                            + " (" + newPV + "/" + p.getPVMax() + "PV)");
                    return;
                }
                else {
                    System.out.println(p.getNom() + " a esquivé l'attaque de " + this.nom + " ("
                            + p.getPV() + "/" + p.getPVMax() + "PV)");
                    return;
                }
            }
            else {
                System.out.println(this.nom + " a raté son attaque sur " + p.getNom() + " ("
                        + p.getPV() + "/" + p.getPVMax() + "PV)");
                return;
            }
        }

        // Pour éviter que le perso inflige 0 dégât (combat interminable)
        valeurAttaque = (int) (this.ATK * 0.2);
        newPV = returnNewPV(valeurAttaque, p);
        p.setPV(newPV);
        System.out.println(this.nom + " n'inflige que " + valeurAttaque + " dégâts à " + p.getNom()
                + " (" + newPV + "/" + p.getPVMax() + "PV)");
    }

    private int returnNewPV(int valeurAttaque, Personnage p) {
        int diff = p.getPV() - valeurAttaque;
        return Math.max(diff, 0);
    }

    @Override
    public String toString() {
        return getNom() + " (" + getPV() + "/" + getPVMax() + " PV)";
    }
}
