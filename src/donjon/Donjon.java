package donjon;

import java.util.ArrayList;
import java.util.List;

public class Donjon {
    private final String nomDonjon;
    private final List<Salle> salles = new ArrayList<>();

    public Donjon(String nomDonjon, int numDonjon) {
        this.nomDonjon = nomDonjon;

        // Créer trois salles par donjon
        Salle salle;
        for (int i = 1; i <= 3; i++) {
            salle = new Salle(i, numDonjon);
            this.salles.add(salle);
        }
    }

    public String getNomDonjon() {
        return nomDonjon;
    }

    public boolean isCompleted(int salleActuelle) {
        return salleActuelle == 3 && salles.get(salleActuelle).isCompleted();
    }

    public List<Salle> getSalles() {
        return salles;
    }
}
