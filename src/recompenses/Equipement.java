package recompenses;

public class Equipement extends Objet {
    private int bonusAttaque;
    private int bonusDefense;
    private int bonusPrecision;
    private int bonusEsquive;
    private int bonusEnergie;

    public Equipement(String nom, int bonusAttaque, int bonusDefense, int bonusPrecision, int bonusEsquive, int bonusEnergie) {
        super(nom);
        this.bonusAttaque = bonusAttaque;
        this.bonusDefense = bonusDefense;
        this.bonusPrecision = bonusPrecision;
        this.bonusEsquive = bonusEsquive;
        this.bonusEnergie = bonusEnergie;
    }

    public int getBonusAttaque() {
        return bonusAttaque;
    }

    public int getBonusDefense() {
        return bonusDefense;
    }

    public int getBonusPrecision() {
        return bonusPrecision;
    }

    public int getBonusEsquive() {
        return bonusEsquive;
    }

    public int getBonusEnergie() {
        return bonusEnergie;
    }

}
