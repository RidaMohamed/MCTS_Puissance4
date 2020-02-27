package jeu;

public class Board {

    static final int LARGEUR_MAX = 7 ;// nb max de fils pour un noeud (= nb max de coups possibles)
    static final int NB_COL = 7 ;
    static final int NB_LIGNE = 6 ;
    static final int TEMPS = 5 ;	// temps de calcul pour un coup avec MCTS (en secondes)

    //
    private String board[][];

    public Board(){
        initialiserBoard();
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
                System.out.print(this.board[i][j]+ "  |");
            System.out.print("\n");
            System.out.print("---------------------------------");
            System.out.print("\n");
        }
    }

    /**
     * fonction pour linitialisation de plateau de jeu
     */
    public void initialiserBoard(){
        this.board = new String[NB_LIGNE][NB_COL];
        //
        for (int i = 0 ; i < NB_LIGNE ; i++){
            for (int j = 0 ; j < NB_COL; j++){
                this.board[i][j] = " ";
            }
        }
    }
}
