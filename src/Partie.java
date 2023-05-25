import donjon.Donjon;
import donjon.Salle;
import personnages.Personnage;
import personnages.ennemis.Ennemi;
import personnages.ennemis.Ennemis;

import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Partie {
    private final List<Personnage> allies;
    private final Donjon donjon;
    private final List<Salle> salles;
    private int salleActuelle;
    private final Ennemis ennemis;
    private final Scanner sc = new Scanner(System.in);

    public Partie(List<Personnage> allies, Donjon donjon) {
        this.allies = allies;
        this.donjon = donjon;
        this.salles = donjon.getSalles();
        this.salleActuelle = 1;
        this.ennemis = salles.get(salleActuelle).getEnnemis();
    }

    public void lancerDonjon() {
        while (!donjon.isCompleted(salleActuelle)) {
            System.out.println("-------- Salle " + salleActuelle + " --------");
            while (!salles.get(salleActuelle - 1).isCompleted()) {
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
                                        int ennemiCible = Integer.parseInt(sc.nextLine()) -1;
                                        personnage.attaquer(ennemis.get(ennemiCible));

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
                                allies.remove(personnageCible);
                            }
                        }

                    }
                }
            }
            salleActuelle++;
        }
    }
}
