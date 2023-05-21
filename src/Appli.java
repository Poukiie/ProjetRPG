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

        System.out.println(toStringMenu(sc, input));
        // System.out.println(checkInputMenu(sc, input));
        while(!(input.equals("1") || input.equals("2") || input.equals("3"))) {
            System.out.print("> ");
            input = sc.nextLine();
        }

        switch(input) {
            // 1. Créer un personnage
            case "1":
                creerPersonnage(sc);
                System.out.print("Créer un autre personnage ? (oui/non)\n");
                while(!(input.equals("oui") || input.equals("non"))) {
                    System.out.print("> ");
                    input = sc.nextLine();
                }
                if (input.equals("oui")) {
                    creerPersonnage(sc);
                }
                else {
                    System.out.println(toStringMenu(sc, input));
                    // System.out.println(checkInputMenu(sc, input));
                    while(!(input.equals("1") || input.equals("2") || input.equals("3"))) {
                        System.out.print("> ");
                        input = sc.nextLine();
                    }
                }
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

                System.out.println(toStringMenu(sc, input));
                // System.out.println(checkInputMenu(sc, input));
                break;

            // 3. Voir mes personnages
            case "3":
                System.out.println("Vous avez créé " + Personnage.getCounter() + " personnages en tout.\n" + "--------");

                for (int i = 0; i < Personnage.getPersonnages().size(); i++) {
                    System.out.println(Personnage.getPersonnages().get(i).getNom());
                }
                System.out.println(toStringMenu(sc, input));
                // System.out.println(checkInputMenu(sc, input));
                break;

            default: throw new IllegalArgumentException();
        }

        // brouillon
//        Personnage p1 = new Mage("Klee");
//        Personnage p2 = new Tank("Tuka");
//        Personnage p3 = new Guerrier("Cloud");
//        Personnage p4 = new Soigneur("Nana");
//        Personnage p5 = new Voleur("Le voleur");
//
//        Personnage e1 = new Blob("Monmon");
//        Personnage e2 = new Blob("Pika");
//
//        personnages.add(p1);
//        personnages.add(p2);
//        personnages.add(p3);
//        personnages.add(p4);
//
//        ennemis.add(e1);
//
//        p1.attaquer(e1);
//        e1.attaquer(p1);
//        e1.attaquer(e2);
    }

    /**
     * Affiche le menu pour choisir le mode de jeu
     * @return s le menu
     */
    private static String toStringMenu(Scanner sc, String input) {
        String s = "Forest of Savior\n" +
                "Menu\n" +
                "Saisissez un chiffre selon l'action souhaitée :\n";
        s += "1. Créer un personnage\n";
        s += "2. Jouer\n";
        s += "3. Voir mes personnages";
        return s;
    }

    /**
     * Vérifie l'input de l'utilisateur sur le menu
     * @return true si l'input est correct
     */
    private static boolean checkInputMenu(Scanner sc, String input) {
        while(!(input.equals("1") || input.equals("2") || input.equals("3"))) {
            System.out.print("> ");
            input = sc.nextLine();
        }
        return true;
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
