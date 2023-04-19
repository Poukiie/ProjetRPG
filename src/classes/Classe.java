package classes;

public class Classe {
    private int pv;
    private int atq;
    private int def; // 5 de DEF, l’ennemi tape 12, je me prends 7 de DGT, différence
    private int energie; // pour utiliser des capacités

    public Classe(int pv, int atq, int def, int energie) {
        this.pv = pv;
        this.atq = atq;
        this.def = def;
        this.energie = energie;
    }

}
