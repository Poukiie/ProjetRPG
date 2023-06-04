package donjon;

import java.util.ArrayList;
import java.util.List;

public class Donjon {
    private String nomDonjon;
    private final int numDonjon;
    private boolean completed = false;
    private final List<Salle> salles = new ArrayList<>();

    public Donjon(String nomDonjon, int numDonjon) {
        this.nomDonjon = nomDonjon;
        this.numDonjon = numDonjon;

        // Créer trois salles par donjon
        Salle salle;
        for (int i = 1; i <= 3; i++) {
            salle = new Salle(i, numDonjon);
            this.salles.add(salle);
        }
    }

    public int getNumDonjon() {
        return numDonjon;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getNomDonjon() {
        return nomDonjon;
    }

    public void setNomDonjon(String nomDonjon) {
        this.nomDonjon = nomDonjon;
    }

    public boolean isCompleted(int salleActuelle) {
        return salleActuelle == 2 && salles.get(salleActuelle).isCompleted();
    }

    public List<Salle> getSalles() {
        return salles;
    }
}
