package personnages.capacite;

import personnages.Personnage;

public class CapaciteVoleur implements Capacite {
    private final Personnage voleur;
    private final Personnage ennemi;

    public CapaciteVoleur(Personnage voleur, Personnage ennemi) {
        this.voleur = voleur;
        this.ennemi = ennemi;
    }

    @Override
    public void utiliser() {
        int energie = this.voleur.getEnergie();

        if (energie >= 10) {
            this.voleur.setEnergie(energie - 10);
            int pvVoles = (int) (ennemi.getPV() * 0.2);
            // Vérifier que newPVEnnemi n'est pas < 0
            int newPVEnnemi = this.ennemi.returnNewPV(pvVoles, this.ennemi);
            // Vérifier que newPVVoleur n'est pas > PVMax
            int newPVVoleur = this.voleur.returnNewPVSupp(pvVoles, this.voleur);
            ennemi.setPV(newPVEnnemi);
            this.voleur.setPV(newPVVoleur);

            System.out.println(this.voleur.getNom() + " vole " + pvVoles + " PV à " + ennemi.getNom()
                    + " (" + newPVEnnemi + "/" + ennemi.getPVMax() + "PV)");
            System.out.println(this.voleur.getNom() + " (" + newPVVoleur + "/" + this.voleur.getPVMax() + "PV)");
        }

        System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
    }

    @Override
    public String getDescription() {
        return "A qui souhaitez-vous voler des PV ? (Vol: 20% des PV de la cible)";
    }
}
