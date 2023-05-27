import donjon.Donjon;
import donjon.Salle;
import personnages.Personnage;
import personnages.ennemis.Ennemi;
import personnages.ennemis.Ennemis;
import personnages.heros.Heros;
import recompenses.Consommable;

import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Partie {
    private final List<Heros<?>> allies;
    private final Donjon donjon;
    private final List<Salle> salles;
    private int salleActuelle;
    private final Ennemis ennemis;
//    private final Consommable consommables;
    private final Scanner sc = new Scanner(System.in);

    public Partie(List<Heros<?>> allies, Donjon donjon) {
        this.allies = allies;
        this.donjon = donjon;
        this.salles = donjon.getSalles();
        this.salleActuelle = 1;
        this.ennemis = salles.get(salleActuelle).getEnnemis();
    }

    // TODO: diviser la méthode en plusieurs méthodes
    public void lancerDonjon() {
        while (!donjon.isCompleted(salleActuelle)) {
            System.out.println("-------- Salle " + salleActuelle + " --------");
            while (!salles.get(salleActuelle - 1).isCompleted()) {
                // Tant que l'équipe n'est pas morte
                while (allies.size() > 0) {
                    // Tant que l'équipe n'a pas tué tous les ennemis
                    while (ennemis.size() > 0) {
                        System.out.println("-------- Tour de l'équipe --------");
                        for (Heros<?> personnage : allies) {
                            // Vérifier que le personnage n'est pas mort
                            if (personnage.getPV() > 0) {
                                System.out.println("Que doit faire " + personnage.getNom() + " ?\n"
                                        + "PV: " + personnage.getPV() + "/" + personnage.getPVMax() + "\n"
                                        + "Energie: " + personnage.getEnergie() + "/" + personnage.getEnergieMax() + "\n"
                                );
                                System.out.println("1. Attaquer un ennemi\n"
                                        + "2. Utiliser sa capacité spéciale\n"
                                        + "3. Utiliser un objet");
                                System.out.print("> ");

                                int choix = Integer.parseInt(sc.nextLine());
                                int ennemiCible;
                                switch (choix) {
                                    // Attaquer un ennemi
                                    case 1:
                                        ennemiCible = demanderCible();
                                        personnage.attaquer(ennemis.get(ennemiCible));

                                        // Si l'ennemi est mort, le supprimer de la liste
                                        if (ennemis.get(ennemiCible).getPV() <= 0) {
                                            ennemis.remove(ennemiCible);
                                        }
                                        break;

                                    // Utiliser la capacité spéciale
                                    case 2:
                                        // Pour le mage et le tank, AoE dmg
                                        if (personnage.estMulticible())
                                            personnage.utiliserCapacite(ennemis);
                                        else {
                                            // Pour les autres, choisir un ennemi
                                            ennemiCible = demanderCible();
                                            personnage.utiliserCapacite(ennemiCible);
                                        }
                                        break;

                                    // Utiliser un objet
                                    case 3:
                                        // TODO: utiliser un objet
                                        System.out.println("Quel objet voulez-vous utiliser ?");
                                        break;
                                }
                            }
                        }

                        // Les ennemis attaquent
                        System.out.println("-------- Tour des ennemis --------");
                        for (Ennemi ennemi : ennemis) {
                            // Attaquer un personnage aléatoire
                            int personnageCible = new Random().nextInt(allies.size());
                            // TODO: algorithme d'attaques pour l'ennemi
                            ennemi.attaquer(allies.get(personnageCible));
                            // Si le personnage est mort, le supprimer de la liste
                            if (allies.get(personnageCible).getPV() <= 0) {
                                allies.remove(personnageCible);
                            }
                        }

                    }
                }
            }
            salleActuelle++;
        }
    }

    private int demanderCible() {
        System.out.println("Quel ennemi souhaitez-vous attaquer ?");
        System.out.println(ennemis);
        // TODO vérifier saisie
        System.out.print("> ");
        int indice = sc.nextInt();
        while (!(indice >= 1 && indice <= ennemis.size())) {
            System.out.println("Indice invalide : " + indice);
            System.out.println("Veuillez entrer un indice valide :\n" + "> ");
            indice = sc.nextInt();
        }
        return Integer.parseInt(sc.nextLine()) - 1;
    }
}
