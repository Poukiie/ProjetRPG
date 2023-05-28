package recompenses;

public class Equipement extends Objet {
    private final int bonusAttaque;
    private final int bonusDefense;
    private final int bonusPrecision;
    private final int bonusEsquive;
    private final int bonusEnergie;

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
