package personnages;

public abstract class Personnage {

    private String nom;

    public Personnage(String nom) {
        this.nom = nom;
    }

    public void attaquer() {
        // inflige des dgt à l'ennemi
    }

    public void utiliserCapacite() {
        // cout de l'energie suffisant
    }
}
