package jeu;

import java.util.Scanner;

public class Board {

    static final int LARGEUR_MAX = 7 ;// nb max de fils pour un noeud (= nb max de coups possibles)
    static final int NB_COL = 7 ;
    static final int NB_LIGNE = 6 ;
    static final int TEMPS = 5 ;	// temps de calcul pour un coup avec MCTS (en secondes)
    static final int ORDI_GAGNE = 1;
    static final int HUMAIN_GAGNE = -1;
    static final int MATCHNUL = 0;
    static final int NON = 2;
    int joueurCourant ;

    //
    private String plateau[][];

    public Board(){
        initialiserPlateau();
    }

    public Board(String[][] plateau) {
        this.plateau = plateau;
    }

    /**
     * fonction d'affichage de plateau de jeu
     */
    public void afficherJeu(){
        int i,j;
        System.out.print("    |");
        for ( j = 0; j < NB_COL; j++)
            System.out.print(" "+ j+ " |");
        System.out.print("\n");
        System.out.print("---------------------------------");
        System.out.print("\n");

        for(i=0; i < NB_LIGNE; i++) {
            System.out.print(i);
            for ( j = 0; j < NB_COL; j++)
                System.out.print(this.plateau[i][j]+ "  |");
            System.out.print("\n");
            System.out.print("---------------------------------");
            System.out.print("\n");
        }
    }

    /**
     * fonction pour linitialisation de plateau de jeu
     */
    public void initialiserPlateau(){
        this.plateau = new String[NB_LIGNE][NB_COL];
        //
        for (int i = 0 ; i < NB_LIGNE ; i++){
            for (int j = 0 ; j < NB_COL; j++){
                this.plateau[i][j] = " ";
            }
        }
    }

    /**
     * Test de fin de jeu
     * @return
     */
    public int testFinDeJeu(){

        // tester si un joueur a gagné
        int i,j,k,n = 0;
        for ( i=0;i < 3; i++) {
            for(j=0; j < 3; j++) {
                if ( !plateau[i][j].equals(" ") ) {
                    n++;	// nb coups joués
                    // lignes
                    k=0;
                    while ( k < 4 && i+k < NB_LIGNE && plateau[i+k][j] == plateau[i][j] )
                        k++;
                    if ( k == 4 )
                        return plateau[i][j].equals('O')? ORDI_GAGNE : HUMAIN_GAGNE;

                    // colonnes
                    k=0;
                    while ( k < 4 && j+k < NB_COL && plateau[i][j+k] == plateau[i][j] )
                        k++;
                    if ( k == 4 )
                        return plateau[i][j].equals('O') ? ORDI_GAGNE : HUMAIN_GAGNE;

                    // diagonales
                    k=0;
                    while ( k < 4 && i+k < NB_COL && j+k < NB_COL && plateau[i+k][j+k] == plateau[i][j] )
                        k++;
                    if ( k == 4 )
                        return plateau[i][j].equals('O')? ORDI_GAGNE : HUMAIN_GAGNE;

                    k=0;
                    while ( k < 4 && i+k < NB_COL && j-k >= 0 && plateau[i+k][j-k] == plateau[i][j] )
                        k++;
                    if ( k == 4 )
                        return plateau[i][j].equals('O')? ORDI_GAGNE : HUMAIN_GAGNE;
                }
            }
        }

        // et sinon tester le match nul
        if ( n == NB_LIGNE*NB_COL )
            return MATCHNUL;

        return NON;
    }

    /**
     * Demander un colonne au joueur humaine
     * @return
     */
    public String demanderCoup (){
        System.out.println("quelle colonne ? ") ;
        Scanner scanIn = new Scanner(System.in);
        String s;
        s = scanIn.nextLine();
        return s;
    }

    /**
     * verfier le coup du joueur donnee
     * @return
     */
    public boolean jouerCoup(Etat etat, String s){
        int i = 0;

        while (i < NB_LIGNE && plateau[i][Integer.valueOf(s)].equals(" ") ){
            i++;
        }
        if ( !plateau[i-1][Integer.valueOf(s)].equals(" ") )
            return false;
        else {
            plateau[i-1][Integer.valueOf(s)] = String.valueOf(etat.getJoueurNo()==0 ? " O "  : " X " );
            // à l'autre joueur de jouer
            etat.setJoueurNo(autreJoueur(etat.getJoueurNo()));
            etat.setPlateau(this.getPlateau());
            return true;
        }
    }

    public int autreJoueur(int i){
        if(i == 0 )
            return 1;
        else
            return 0;
    }

    public int getJoueurCourant() {
        return joueurCourant;
    }

    public void setJoueurCourant(int joueurCourant) {
        this.joueurCourant = joueurCourant;
    }

    public String[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(String[][] plateau) {
        this.plateau = plateau;
    }
}
