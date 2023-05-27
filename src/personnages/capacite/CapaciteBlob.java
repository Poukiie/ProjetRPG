package personnages.capacite;

import personnages.Personnage;

public class CapaciteBlob implements Capacite {
    private final Personnage blob;
    private final Personnage allie;

    public CapaciteBlob(Personnage blob, Personnage allie) {
        this.blob = blob;
        this.allie = allie;
    }

    // Les blobs n'ont pas de capacité spéciale, ils attaquent normalement
    @Override
    public void utiliser() {
        blob.attaquer(allie);
    }
}
