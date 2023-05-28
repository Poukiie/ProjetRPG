package partie;

import donjon.Donjon;
import donjon.Salle;
import personnages.Personnage;
import personnages.Personnages;

import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Partie {
    private final Personnages allies;
    private final Donjon donjon;
    private final List<Salle> salles;
    private int salleActuelle;
    private final Personnages ennemis;
    private final Scanner sc = new Scanner(System.in);
    private static final int CHANCE_CAPACITE = 30;

    public Partie(Personnages allies, Donjon donjon) {
        this.allies = allies;
        this.donjon = donjon;
        this.salles = donjon.getSalles();
        this.salleActuelle = 1;
        this.ennemis = salles.get(salleActuelle).getEnnemis();
    }

    public void jouer() {
        while (!donjon.isCompleted(salleActuelle)) {
            System.out.println("-------- Salle " + salleActuelle + " --------");
            while (!salles.get(salleActuelle - 1).isCompleted()) {
                // Tant que l'équipe n'est pas morte
                while (allies.size() > 0) {
                    // Tant que l'équipe n'a pas tué tous les ennemis
                    while (ennemis.size() > 0) {
                        alliesAttaquent();
                        ennemisAttaquent();
                    }
                }
            }
            salleActuelle++;
        }
    }

    private void alliesAttaquent() {
        System.out.println("-------- Tour de l'équipe --------");
        for (Personnage heros : allies) {
            // Vérifier que le heros n'est pas mort
            if (!heros.estMort()) {
                System.out.println("Que doit faire " + heros.getNom() + " ?\n"
                        + "PV: " + heros.getPV() + "/" + heros.getPVMax() + "\n"
                        + "Energie: " + heros.getEnergie() + "/" + heros.getEnergieMax() + "\n"
                );
                System.out.println("1. Attaquer un ennemi\n"
                        + "2. Utiliser sa capacité spéciale\n"
                        + "3. Utiliser un objet");
                System.out.print("> ");

                int choix = Integer.parseInt(sc.nextLine());
                Personnage cible;
                switch (choix) {
                    // Attaquer un ennemi
                    case 1:
                        cible = demanderCible(true);
                        heros.attaquer(cible);

                        // Si l'ennemi est mort, le supprimer de la liste
                        if (cible.getPV() <= 0) {
                            ennemis.remove(cible);
                        }
                        break;

                    // Utiliser la capacité spéciale
                    case 2:
                        // Pour le mage et le tank, capacité AoE
                        if (heros.estMulticible())
                            if (heros.cibleEnnemis()) {
                                heros.capacite(null, ennemis).utiliser();
                            }
                            else {
                                heros.capacite(null, allies).utiliser();
                            }
                        else {
                            // Pour les autres, choisir une cible
                            cible = demanderCible(heros.cibleEnnemis());
                            heros.capacite(cible, null).utiliser();
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
    }

    private void ennemisAttaquent() {
        System.out.println("-------- Tour des ennemis --------");
        for (Personnage ennemi : ennemis) {
            // Allié aléatoire pour les attaques monocibles
            int index = new Random().nextInt(allies.size());
            Personnage cible = allies.get(index);
            int roll = new Random().nextInt(100);

            // Capacité
            if (CHANCE_CAPACITE < roll) {
                ennemi.capacite(cible, allies).utiliser();
            }
            // Attaque normale
            else {
                ennemi.attaquer(cible);
            }

            for (Personnage p : allies) {
                if (p.estMort()) {
                    allies.remove(p);
                }
            }
        }
    }

    private Personnage demanderCible(boolean cibleEnnemis) {
        Personnages cibles = cibleEnnemis ? ennemis : allies;

        // TODO Afficher une description de la capacité
        System.out.println("Saisir le numéro de votre cible :");
        System.out.println(cibles);
        System.out.print("> ");
        int indice = sc.nextInt();
        while (!(indice >= 1 && indice <= cibles.size())) {
            System.out.println("Indice invalide : " + indice);
            System.out.println("Veuillez entrer un indice valide :\n" + "> ");
            indice = sc.nextInt();
        }

        int index = Integer.parseInt(sc.nextLine()) - 1;

        return cibles.get(index);
    }
}
