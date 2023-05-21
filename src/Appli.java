import personnages.heros.*;
import personnages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Appli {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        List<Personnage> personnages = Personnage.getPersonnages();
        List<Personnage> ennemis = new ArrayList<>();
        boolean continuerJeu = true;

        while (continuerJeu) {
            showMenu();
            System.out.print("> ");
            input = sc.nextLine();

            switch(input) {
                // 1. Créer un personnage
                case "1":
                    creerPersonnage(personnages, sc);
                    break;

                // 2. Jouer
                case "2":
                    // TODO: Instancier les donjons
                    String donjons = "Choississez un donjon :\n"
                            + "nomDonjon1    " + "nomDonjon2    " + "nomDonjon3\n"
                            + "> ";
                    System.out.println(donjons);
                    String donjonChoisi = sc.nextLine();
                    // TODO: choix de l'équipe (4 persos) pour le donjon
                    break;

                // 3. Voir mes personnages
                case "3":
                    System.out.println("Vous avez créé " + Personnage.getCounter() + " personnages en tout.\n" + "--------");

                    for (Personnage p : personnages) {
                        // TODO Une belle toString pour la classe
                        System.out.println(p.getNom());
                    }
                    break;
                case "4":
                    continuerJeu = false;
            }
        }
    }

    /**
     * Affiche le menu pour choisir le mode de jeu
     */
    private static void showMenu() {
        String s = "Forest of Savior\n" +
                "Menu\n" +
                "Saisissez un chiffre selon l'action souhaitée :\n";
        s += "1. Créer un personnage\n";
        s += "2. Jouer\n";
        s += "3. Voir mes personnages\n";
        s += "4. Quitter";
        System.out.println(s);
    }

    /**
     * Création de personnage
     */
    private static void creerPersonnage(List<Personnage> personnages, Scanner sc) {
        System.out.print("Choisissez une classe entre Guerrier, Mage, Tank, Soigneur, Voleur\n" + "> ");
        String classe = sc.nextLine();

        while(!(classe.equals("Guerrier") || classe.equals("Mage") || classe.equals("Tank") ||
                classe.equals("Soigneur") || classe.equals("Voleur"))) {
            System.out.print("Veuillez rentrer un classe correcte :\n" + "> ");
            classe = sc.nextLine();
        }

        System.out.print("Nom du personnage :\n" + "> ");
        String nom = sc.nextLine();

        Personnage p;
        switch(classe) {
            case "Guerrier": p = new Guerrier(nom); break;
            case "Mage": p = new Mage(nom); break;
            case "Tank": p = new Tank(nom); break;
            case "Soigneur": p = new Soigneur(nom); break;
            case "Voleur": p = new Voleur(nom); break;
            default: throw new IllegalArgumentException();
        }

        personnages.add(p);
        System.out.println("Personnage créé : " + nom + " - " + classe);
    }
}
