package jeu;

import java.util.List;

public class Etat {

    String plateau[][];
    int joueurNo;
    int visitCompt;
    double score;

    public Etat(String[][] plateau) {
        this.plateau = plateau;
    }

    public List<Etat> getAllPossibleStates() {
        // constructs a list of all possible states from current state
        return null;
    }
    public void randomPlay() {
        /* get a list of all possible positions on the board and
           play a random move */
    }

    public String[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(String[][] plateau) {
        this.plateau = plateau;
    }

    public int getJoueurNo() {
        return joueurNo;
    }

    public void setJoueurNo(int joueurNo) {
        this.joueurNo = joueurNo;
    }

    public int getVisitCompt() {
        return visitCompt;
    }

    public void setVisitCompt(int visitCompt) {
        this.visitCompt = visitCompt;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
