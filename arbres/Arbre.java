package arbres;

public class Arbre {
    Noeud racine ;

    /**
     * Simple consrtuteur
     * @param racine
     */
    public Arbre(Noeud racine) {
        this.racine = racine;
    }

    public Noeud getRacine() {
        return racine;
    }

    public void setRacine(Noeud racine) {
        this.racine = racine;
    }
}
