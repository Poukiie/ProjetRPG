import classes.*;
import personnages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Appli {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextLine();

        Personnage p1 = new Mage("Klee");
        Personnage p2 = new Tank("Tuka");
        Personnage p3 = new Guerrier("Cloud");
        Personnage p4 = new Soigneur("Nana");

        Personnage e1 = new Blob("Monmon");
        Personnage e2 = new Blob("Pika");

        List<Personnage> personnages = new ArrayList<>();
        personnages.add(p1);
        personnages.add(p2);
        personnages.add(p3);
        personnages.add(p4);

        List<Personnage> ennemis = new ArrayList<>();
        ennemis.add(e1);

        p1.attaquer(e1);
        e1.attaquer(p1);
        e1.attaquer(e2);

        System.out.println("Vous avez créé " + Personnage.getCounter() + " personnages en tout.");
        Personnage.creerPersonnage("Mimi", 100, 50, 20, 30);
        Personnage.creerPersonnage("Mimi2", 100, 50, 20, 30);
        System.out.println("--------");

        for (int i = 0; i < Personnage.getPersonnages().size(); i++) {
            System.out.println(Personnage.getPersonnages().get(i).getNom());
        }
    }
}
