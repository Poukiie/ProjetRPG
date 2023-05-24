package donjon;

import java.util.ArrayList;
import java.util.List;

public class Donjon {
    private final String nomDonjon;
    private boolean isCompleted;
    private List<Salle> salles;
    private static final ArrayList<Donjon> donjons = new ArrayList<>();

    public Donjon(String nomDonjon) {
        this.nomDonjon = nomDonjon;
        this.isCompleted = false;

        // Créer trois salles
        Salle salle;
        for (int i = 1; i >= 3; i++) {
            salle = new Salle(i);
            this.salles.add(salle);
        }
    }

    public String getNomDonjon() {
        return nomDonjon;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public List<Salle> getSalles() {
        return salles;
    }

    public static ArrayList<Donjon> getDonjons() {
        return donjons;
    }
}
