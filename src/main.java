import algorithme.MCTordi;
import jeu.Board;
import jeu.Etat;

import java.util.Scanner;

public class main {

    public static void main(String [] args){
        // init
        Board b = new Board();
        // etat init
        Etat etat = new Etat(b.getPlateau());
        // creation de joueur machine
        MCTordi mcts = new MCTordi(b);
        //creation de coip courant
        String coup ;

        System.out.println("Qui commence (0 : humain, 1 : ordinateur) ? ");
        Scanner scanIn = new Scanner(System.in);
        String s;
        s = scanIn.nextLine();
        etat.setJoueurNo(Integer.valueOf(s));

        do {
            b.afficherJeu();
            // joueur humaine
            if (etat.getJoueurNo() == 0){
                do {
                    coup = b.demanderCoup();
                } while ( !b.jouerCoup(etat, coup) );
            }else {
                // joueur machine
                mcts.playCoup(etat);
            }
        }while( b.testFinDeJeu() == 2);

        scanIn.close();
        b.afficherJeu();
    }
}
