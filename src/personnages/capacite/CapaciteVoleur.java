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
            // TODO vérifier si newPVEnnemi peut-être en dessous de 0 ou non
            int newPVEnnemi = ennemi.getPV() - pvVoles;
            int newPVVoleur = this.voleur.returnNewPVSupp(pvVoles, this.voleur);
            ennemi.setPV(newPVEnnemi);
            this.voleur.setPV(newPVVoleur);

            System.out.println(this.voleur.getNom() + " vole " + pvVoles + " PV à " + ennemi.getNom()
                    + " (" + newPVEnnemi + "/" + ennemi.getPVMax() + "PV)");
            System.out.println(this.voleur.getNom() + " (" + newPVVoleur + "/" + this.voleur.getPVMax() + "PV)");
        }

        System.out.println("Vous n'avez pas assez d'énergie pour utiliser votre capacité spéciale.");
    }
}
