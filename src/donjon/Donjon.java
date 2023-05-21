package donjon;

import java.util.List;

public class Donjon {
    private String numDonjon;
    private boolean isCompleted;
    private List<Salle> salles;

    public Donjon(String numDonjon, boolean isCompleted, List<Salle> salles) {
        this.numDonjon = numDonjon;
        this.isCompleted = isCompleted;
        this.salles = salles;
    }
}
