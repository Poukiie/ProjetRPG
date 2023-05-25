import donjon.Donjon;
import donjon.Salle;
import personnages.Personnage;
import personnages.ennemis.Ennemi;
import personnages.ennemis.Ennemis;

import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Partie {
    private List<Personnage> allies;
    private int salleActuelle;
    private List<Personnage> personnagesMorts;
    private List<Salle> salles;
    private Ennemis ennemis;
    private Scanner sc = new Scanner(System.in);

    public Partie(List<Personnage> allies, Donjon donjon) {
        this.allies = allies;
        this.salles = donjon.getSalles();
        this.ennemis = salles.get(salleActuelle).getEnnemis();
    }

    public void lancerDonjon() {
        // Tant que le donjon n'est pas terminé
        System.out.println("-------- Salle " + salleActuelle + 1 + " --------");
        while (!salles.get(salleActuelle).isCompleted()) {
            // Tant que l'équipe n'est pas morte
            while (allies.size() > 0) {
                // Tant que l'équipe n'a pas tué tous les ennemis
                while (ennemis.size() > 0) {
                    // L'équipe attaque
                    System.out.println("-------- Tour de l'équipe --------");
                    for (Personnage personnage : allies) {
                        // Vérifier que le personnage n'est pas mort
                        if (personnage.getPV() > 0) {
                            System.out.println("Que doit faire " + personnage.getNom() + " ?\n" +
                                    "PV : " + personnage.getPV() + "\n" +
                                    "Energie : " + personnage.getEnergie() + "\n"
                            );
                            System.out.println("1. Attaquer un ennemi");
                            System.out.println("2. Utiliser sa capacité spéciale");
                            System.out.println("3. Utiliser un objet");
                            System.out.println();

                            int choice = Integer.parseInt(sc.nextLine());
                            switch (choice) {
                                case 1:
                                    System.out.println("Quel ennemi souhaitez-vous attaquer ?");
                                    System.out.println(ennemis);

                                    // TODO vérifier saisie
                                    int ennemiCible = Integer.parseInt(sc.nextLine());
                                    personnage.attaquer(ennemis.get(ennemiCible - 1));

                                    // Si l'ennemi est mort, le supprimer de la liste
                                    if (ennemis.get(ennemiCible).getPV() <= 0) {
                                        ennemis.remove(ennemiCible);
                                    }
                                    break;

                                case 2:

                            }
                        }
                    }

                    // Les ennemis attaquent
                    for (Ennemi ennemi : ennemis) {
                        // Attaquer un personnage aléatoire
                        int personnageCible = new Random().nextInt(allies.size());
                        ennemi.attaquer(allies.get(personnageCible));
                        // Si le personnage est mort, le supprimer de la liste
                        if (allies.get(personnageCible).getPV() <= 0) {
                            personnagesMorts.add(allies.get(personnageCible));
                            allies.remove(personnageCible);
                        }
                    }

                }
            }
        }
    }
}
