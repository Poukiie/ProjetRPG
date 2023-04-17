package classes;

import capacites.Capacite;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    private int pv;
    private int atq;
    private int def; // 5 de DEF, l’ennemi tape 12, je me prends 7 de DGT, différence
    private int energie; // pour utiliser des capacités
    private List<Capacite> capacites; // soigner, boost atq, boost esquive, précision, bouclier…
    // mage a plus d'énergie
    // tank plus de def et de pv
    // healer plus de pv
    // guerrier plus d'atq

    public Classe(int pv, int atq, int def, int energie) {
        this.pv = pv;
        this.atq = atq;
        this.def = def;
        this.energie = energie;
        this.capacites = new ArrayList<>();
    }

    public void utiliserCapacite() {

    }
}
