package personnages;

public interface CapaciteSpeciale<T> {

    // Classe générique pour préciser le type du param dans chaque classe
    void utiliserCapacite(T personnage);

    // Permet de savoir si la capacité spéciale est multi-cible ou non
    boolean estMulticible();
}
