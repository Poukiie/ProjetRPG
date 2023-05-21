import personnages.ennemis.Blob;
import personnages.heros.*;
import personnages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Appli {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "tmp";
        List<Personnage> personnages = new ArrayList<>();
        List<Personnage> ennemis = new ArrayList<>();

        System.out.println(toStringMenu());
        while(!(input.equals("1") || input.equals("2")) || input.equals("3")) {
            System.out.print("> ");
            input = sc.nextLine();
        }

        switch(input) {
            // 1. Créer un personnage
            case "1":
                System.out.println("Choississez une classe entre Guerrier, Mage, Tank, Soigneur, Voleur\n" + "> ");
                String classe = sc.nextLine();
                System.out.println("Nom du personnage :\n" + "> ");
                String nom = sc.nextLine();

                switch(classe) {
                    case "Guerrier": Personnage g1 = new Guerrier(nom);
                    case "Mage": Personnage m1 = new Mage(nom);
                    case "Tank": Personnage t1 = new Tank(nom);
                    case "Soigneur": Personnage s1 = new Soigneur(nom);
                    case "Voleur": Personnage v1 = new Voleur(nom);
                }

                // TODO: ajouter le personnage créé à la liste personnages
                toStringMenu();

            // 2. Jouer
            case "2":
                // TODO: Instancier les donjons
                String donjons = "Choississez un donjon :\n"
                        + "nomDonjon1    " + "nomDonjon2    " + "nomDonjon3\n"
                        + "> ";
                System.out.println(donjons);
                String donjonChoisi = sc.nextLine();
                // TODO: choix de l'équipe (4 persos) pour le donjon

            // 3. Voir mes personnages
            case "3":
                System.out.println("Vous avez créé " + Personnage.getCounter() + " personnages en tout.\n" + "--------");

                for (int i = 0; i < Personnage.getPersonnages().size(); i++) {
                    System.out.println(Personnage.getPersonnages().get(i).getNom());
                }

                toStringMenu();

            default: // TODO: compléter si besoin
        }

        // brouillon
        Personnage p1 = new Mage("Klee");
        Personnage p2 = new Tank("Tuka");
        Personnage p3 = new Guerrier("Cloud");
        Personnage p4 = new Soigneur("Nana");
        Personnage p5 = new Voleur("Le voleur");

        Personnage e1 = new Blob("Monmon");
        Personnage e2 = new Blob("Pika");

        personnages.add(p1);
        personnages.add(p2);
        personnages.add(p3);
        personnages.add(p4);

        ennemis.add(e1);

        p1.attaquer(e1);
        e1.attaquer(p1);
        e1.attaquer(e2);
    }

    /**
     * Affiche le menu pour choisir le mode de jeu
     * @return s le menu
     */
    private static String toStringMenu() {
        String s = "Forest of Savior\n" +
                "Menu\n" +
                "Saisissez un chiffre selon l'action souhaitée :\n";
        s += "1. Créer un personnage\n";
        s += "2. Jouer\n";
        s += "3. Voir mes personnages\n";
        return s;
    }
}
