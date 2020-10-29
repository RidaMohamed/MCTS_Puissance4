package arbres;

import jeu.Etat;

import java.util.List;

public class Noeud {

    Etat etat ; // l'etat de borad pour chaque neoud
    Noeud parent ; // le noeud parent
    List<Noeud> enfants ; // les noeuds fils

    /**
     * Simple constructor
     * @param parent
     * @param enfants
     */
    public Noeud(Etat etat, Noeud parent, List<Noeud> enfants) {
        this.etat = etat;
        this.parent = parent;
        this.enfants = enfants;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Noeud getParent() {
        return parent;
    }

    public void setParent(Noeud parent) {
        this.parent = parent;
    }

    public List<Noeud> getEnfants() {
        return enfants;
    }

    public void setEnfants(List<Noeud> enfants) {
        this.enfants = enfants;
    }
}
