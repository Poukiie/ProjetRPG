package partie;

import donjon.Donjon;
import donjon.Salle;
import personnages.Personnage;
import personnages.Personnages;
import recompenses.Objet;

import java.util.*;

public class Partie {
    private final Personnages allies;
    // Pour les stocker qq part en cas de réanimation plus tard?
    private final Personnages alliesMorts = new Personnages();
    private final Donjon donjon;
    private final List<Salle> salles;
    private int salleActuelle;
    private Personnages ennemis;
    private final List<Objet> objets = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    private static final int CHANCE_CAPACITE = 30;

    public Partie(Personnages allies, Donjon donjon) {
        this.allies = allies;
        this.donjon = donjon;
        this.salles = donjon.getSalles();
        this.salleActuelle = 0;
    }

    public void jouer() throws InterruptedException {
        while (!donjon.isCompleted(salleActuelle)) {
            System.out.println("-------- Salle " + (salleActuelle + 1) + " --------");
            if (salleActuelle == 2) {
                System.out.println("Vous allez affronter le boss du donjon...");
            }
            this.ennemis = salles.get(salleActuelle).getEnnemis();

            // Tant que l'équipe n'est pas morte et que la salle n'est pas terminée
            while ((!allies.isEmpty()) && (!salles.get(salleActuelle).isCompleted())) {
                // Tant que l'équipe n'a pas tué tous les ennemis
                 alliesAttaquent();
                 Thread.sleep(2000);
                if (!(ennemis.isEmpty())) {
                    ennemisAttaquent();
                    Thread.sleep(2000);
                }
                reinitialiserEsquive(allies);
            }

            if (allies.isEmpty()) {
                System.out.println(">>> Défaite... <<<\n");
                return;
            }
            else {
                System.out.println(">>> Victoire ! Salle " + (salleActuelle + 1) + " terminée ! <<<\n");
                if (salleActuelle < 2) {
                    salleActuelle++;
                }

                // TODO Gérer les récompenses
                // créer deux objets aléatoires
                // les ajouter à la liste des objets
//                Objet o1 = new Objet();
            }
        }
        System.out.println(">>> Donjon terminé ! <<<\n");
    }

    private void alliesAttaquent() {
        System.out.println("\n-------- Tour de l'équipe --------");
        for (Personnage heros : allies) {
            if (ennemis.isEmpty()) return;

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

                int choix = sc.nextInt();
                Personnage cible;
                switch (choix) {
                    // Attaquer un ennemi
                    case 1:
                        cible = demanderCible(true);
                        heros.attaquer(cible);

                        // Si l'ennemi est mort, le supprimer de la liste
                        if (cible.estMort()) {
                            System.out.println(">>> " + cible.getNom() + " est éliminé !\n--------");
                            ennemis.remove(cible);
                        }
                        break;

                    // Utiliser la capacité spéciale
                    case 2:
                        // Pour le mage et le tank, capacité AoE
                        if (heros.estMulticible()) {
                            if (heros.cibleEnnemis()) {
                                heros.capacite(null, ennemis).utiliser();
                                // Vérifier si les ennemis sont morts
                                // Iterator sur ennemis pour éviter ConcurrentModificationException
                                Iterator<Personnage> iterator = ennemis.iterator();
                                // Boucler sur les ennemis tant qu'il y en a encore
                                while (iterator.hasNext()) {
                                    Personnage ennemi = iterator.next();
                                    // Et les supprimer de la liste s'ils sont morts
                                    if (ennemi.estMort()) {
                                        System.out.println(">>> " + ennemi.getNom() + " est éliminé !\n--------");
                                        iterator.remove();
                                    }
                                }
                            } else {
                                heros.capacite(null, allies).utiliser();
                            }
                        }
                        else {
                            // Pour les autres, choisir une cible
                            // Affichage de la description de la capacité avant le choix
                            System.out.println(heros.capacite(null, null).getDescription());
                            cible = demanderCible(heros.cibleEnnemis());
                            heros.capacite(cible, null).utiliser();
                            if (cible.estMort()) {
                                System.out.println(">>> " + cible.getNom() + " est éliminé !\n--------");
                                ennemis.remove(cible);
                            }
                        }
                        break;

                    // Utiliser un objet
                    case 3:
                        // TODO: utiliser un objet
                        if (objets.isEmpty()) {
                            System.out.println("Vous n'avez aucun objet dans votre inventaire.");
                        }
                        else {
                            System.out.println("Quel objet voulez-vous utiliser ?");
                        }
                        break;
                }
            }
        }
    }

    private void ennemisAttaquent() {
        System.out.println("\n-------- Tour des ennemis --------");
        for (Personnage ennemi : ennemis) {
            // Entre temps si tous les allies sont morts on arrête
            if (allies.size() == 0) {
                break;
            }
            // Allié aléatoire pour les attaques monocibles
            int index = new Random().nextInt(allies.size());
            Personnage cible = allies.get(index);
            int roll = new Random().nextInt(100);

            // Capacité
            if (CHANCE_CAPACITE < roll) {
                if (ennemi.getEnergie() <= 0) {
                    ennemi.attaquer(cible);
                    continue;
                }
                ennemi.capacite(cible, allies).utiliser();
            }
            // Attaque normale
            else {
                ennemi.attaquer(cible);
            }

            Iterator<Personnage> iterator = allies.iterator();
            // Boucler sur les allies tant qu'il y en a encore
            while (iterator.hasNext()) {
                Personnage allie = iterator.next();
                // Et les supprimer de la liste s'ils sont morts
                if (allie.estMort()) {
                    System.out.println(">>> " + allie.getNom() + " est éliminé :(\n--------");
                    iterator.remove();
                    alliesMorts.add(allie);
                }
            }

            for (Personnage p : allies) {
                if (p.estMort()) {
                    System.out.println(">>> " + p.getNom() + " est éliminé :(\n--------");
                    allies.remove(p);
                }
            }
        }
    }

    private Personnage demanderCible(boolean cibleEnnemis) {
        Personnages cibles = cibleEnnemis ? ennemis : allies;

        System.out.println("Saisissez le numéro de votre cible :");
        System.out.print(cibles);
        System.out.print("> ");
        int indice = sc.nextInt();
        while (!(indice >= 1 && indice <= cibles.size())) {
            System.out.println("Indice invalide : " + indice);
            System.out.print("Veuillez entrer un indice valide :\n" + "> ");
            indice = sc.nextInt();
        }

        int index = indice - 1;

        return cibles.get(index);
    }

    private void reinitialiserEsquive(Personnages allies) {
        for (Personnage p : allies) {
            p.setEsquive(p.getEsquiveMax());
        }
    }
}
