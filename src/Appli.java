import personnages.heros.*;
import personnages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Appli {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        List<Personnage> personnages = new ArrayList<>();
        List<Personnage> ennemis = new ArrayList<>();

        while (true) {
            showMenu();
            System.out.print("> ");
            input = sc.nextLine();

            switch(input) {
                // 1. Créer un personnage
                case "1":
                    creerPersonnage(sc);
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

                    for (int i = 0; i < Personnage.getPersonnages().size(); i++) {
                        System.out.println(Personnage.getPersonnages().get(i).getNom());
                    }
                    break;
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
        s += "3. Voir mes personnages";
        System.out.println(s);
    }

    /**
     * Création de personnage
     */
    private static void creerPersonnage(Scanner sc) {
        System.out.print("Choisissez une classe entre Guerrier, Mage, Tank, Soigneur, Voleur\n" + "> ");
        String classe = sc.nextLine();

        while(!(classe.equals("Guerrier") || classe.equals("Mage") || classe.equals("Tank") ||
                classe.equals("Soigneur") || classe.equals("Voleur"))) {
            System.out.print("Veuillez rentrer un classe correcte :\n" + "> ");
            classe = sc.nextLine();
        }

        System.out.print("Nom du personnage :\n" + "> ");
        String nom = sc.nextLine();

        switch(classe) {
            case "Guerrier": Personnage g1 = new Guerrier(nom); break;
            case "Mage": Personnage m1 = new Mage(nom); break;
            case "Tank": Personnage t1 = new Tank(nom); break;
            case "Soigneur": Personnage s1 = new Soigneur(nom); break;
            case "Voleur": Personnage v1 = new Voleur(nom); break;
            default: throw new IllegalArgumentException();
        }

        // TODO: ajouter le personnage créé à la liste personnages
        System.out.println("Personnage créé : " + nom + " - " + classe);
    }
}
