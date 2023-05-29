import donjon.Donjon;
import partie.Partie;
import personnages.heros.*;
import personnages.*;

import java.util.Scanner;

public class Appli {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        Personnages personnages = new Personnages();
        Personnages allies = new Personnages();
        boolean continuerJeu = true;

        // Afficher le menu en boucle tant que le joueur ne quitte pas
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
                    // Vérifier qu'il y a au moins un personnage
                    if (personnages.size() == 0) {
                        System.out.println("Ça va être compliqué sans personnage... Créez-en un d'abord !\n" + "--------");
                        break;
                    }
                    // Afficher le menu de choix du donjon
                    Donjon donjonChoisi = showDonjons(sc);
                    // Choix de l'équipe de 3 personnages pour le donjon
                    choisirEquipe(personnages, allies, sc);
                    // Lancer la partie
                    Partie partie = new Partie(allies, donjonChoisi);
                    partie.jouer();
                    break;

                // 3. Voir mes personnages (compteur, nom - classe)
                case "3":
                    System.out.println("Vous avez créé " + Personnage.getCounter() + " personnages en tout.\n" + "--------");
                    System.out.print(personnages);
                    System.out.println("--------");
                    break;

                // 4. Quitter
                case "4":
                    continuerJeu = false;
            }
        }
    }

    /**
     * Affiche le menu pour choisir le mode de jeu ou quitter
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
     * Création de personnage avec nom + classe
     * Ajout du personnage dans la liste des personnages
     */
    private static void creerPersonnage(Personnages personnages, Scanner sc) {
        System.out.print("Nom du personnage :\n" + "> ");
        String nom = sc.nextLine();

        System.out.print("Choisissez une classe :\n" + "1. Guerrier\n" + "2. Mage\n"
                        + "3. Tank\n" + "4. Soigneur\n" + "5. Voleur\n" + "> ");
        String classe = sc.nextLine();

        while(!(classe.equals("1") || classe.equals("2")
                || classe.equals("3") || classe.equals("4")
                || classe.equals("5"))) {
            System.out.print("Veuillez rentrer un numéro correct :\n" + "> ");
            classe = sc.nextLine();
        }

        Personnage p;
        switch(classe) {
            case "1": p = new Guerrier(nom); break;
            case "2": p = new Mage(nom); break;
            case "3": p = new Tank(nom); break;
            case "4": p = new Soigneur(nom); break;
            case "5": p = new Voleur(nom); break;
            default: throw new IllegalArgumentException();
        }

        personnages.add(p);
        System.out.println("Personnage créé : " + nom + " - " + p.getClassName() + "\n" +
                "PV: " + p.getPV() + "\n" + "Energie: " + p.getEnergie() + "\n" + "ATK: " + p.getATK() + "\n"
                + "DEF: " + p.getDEF() + "\n" + "Précision: " + p.getPrecision() + "\n"
                + "Esquive: " + p.getEsquive() + "\n--------"
        );
    }

    /**
     * Affiche le menu pour choisir le donjon
     */
    private static Donjon showDonjons(Scanner sc) {
        Donjon d1 = new Donjon("Le donjon facile", 1);
        Donjon d2 = new Donjon("Le second donjon", 2);
        Donjon d3 = new Donjon("Le donjon final", 3);

        String listeDonjons = "Choisissez un donjon :\n"
                + "1. " + d1.getNomDonjon() + "\n"
                + "2. " + d2.getNomDonjon() + "\n"
                + "3. " + d3.getNomDonjon() + "\n"
                + "> ";
        System.out.print(listeDonjons);
        String donjonChoisi = sc.nextLine();

        while(!(donjonChoisi.equals("1") || donjonChoisi.equals("2") || donjonChoisi.equals("3"))) {
            System.out.print("Y'a pas de donjon caché, désolé :p\n" + "> ");
            donjonChoisi = sc.nextLine();
        }

        // Stocker le donjon choisi dans une variable
        Donjon donjon = null;
        switch(donjonChoisi) {
            case "1": donjon = d1; break;
            case "2": donjon = d2; break;
            case "3": donjon = d3; break;
        }
        return donjon;
    }

    /**
     * Affiche le menu pour choisir l'équipe de 3 personnages
     */
    private static void choisirEquipe(Personnages personnages, Personnages allies, Scanner sc) {
        System.out.println("Choisissez 3 personnages pour votre équipe :\n" + "--------");

        // Affichage des personnages
        System.out.println(personnages);

        // Choix des alliés
        System.out.print("Entrez les indices des personnages choisis, séparés par des espaces"
                + " (ex : 1 3 4) : \n" + "> ");
        String choixUtilisateur = sc.nextLine();
        String[] indicesChoisis = choixUtilisateur.split(" ");

        // Ajout des alliés dans la liste des alliés selon les indices choisis
        for (String indiceStr : indicesChoisis) {
            int indice = Integer.parseInt(indiceStr);

            // Vérifier que l'indice est valide
            while (!(indice >= 1 && indice <= personnages.size())) {
                System.out.println("Indice invalide : " + indice);
                System.out.print("Veuillez entrer un indice valide :\n" + "> ");
                indice = sc.nextInt();
            }
            // On affiche à partir de 1 mais le perso est en fait à l'indice i - 1
            Personnage choisi = personnages.get(indice - 1);
            allies.add(choisi);
            System.out.println(choisi.getNom() + " a rejoint votre équipe !");
        }
        System.out.println(">>> Votre équipe est prête ! Lancement du donjon........");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // "Clear" console
        for (int i = 0; i < 30; ++i) System.out.println();
    }
}
