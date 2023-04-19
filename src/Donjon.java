import java.util.List;

public class Donjon {
    private String numero;
    private boolean isCompleted;
    private List<Salle> salles;

    public Donjon(String numero, boolean isCompleted, List<Salle> salles) {
        this.numero = numero;
        this.isCompleted = isCompleted;
        this.salles = salles;
    }
}
