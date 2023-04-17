package personnages;

import classes.Classe;
import classes.Mage;
import classes.Soigneur;

public class Heros extends Personnage {
    private Classe classe; // (Tank, Mage, Guerrier, Soigneur etc.) (Enum ?)

    public Heros(String nom, String classe) {
        super(nom);
        switch(classe) {
            case "Soigneur": this.classe = new Soigneur(200, 20, 60, 50);
            case "Mage": this.classe = new Mage(140, 60, 50, 70);
        }

    }
}
