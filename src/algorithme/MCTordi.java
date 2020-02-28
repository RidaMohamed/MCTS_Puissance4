package algorithme;

import jeu.Board;
import jeu.Etat;

import java.util.Random;

public class MCTordi {

    int level;
    int adversaire;
    Etat etat;
    Board b ;
    Random r = new Random();

    public MCTordi(Board b) {
        this.b = b;
    }

    public void playCoup(Etat etat){
        int valeur;
        do {
             valeur = 0 + r.nextInt(6 - 0);
        } while ( !b.jouerCoup(etat, String.valueOf(valeur)) );
    }


//    public Board findNextMove(Board board, int playerNo) {
//        // define an end time which will act as a terminating condition
//
//        adversaire = 3 - playerNo;
//        Tree tree = new Tree();
//        Node rootNode = tree.getRoot();
//        rootNode.getState().setBoard(board);
//        rootNode.getState().setPlayerNo(adversaire);
//
//        while (System.currentTimeMillis() < end) {
//            Node promisingNode = selectPromisingNode(rootNode);
//            if (promisingNode.getState().getBoard().checkStatus()
//                    == Board.IN_PROGRESS) {
//                expandNode(promisingNode);
//            }
//            Node nodeToExplore = promisingNode;
//            if (promisingNode.getChildArray().size() > 0) {
//                nodeToExplore = promisingNode.getRandomChildNode();
//            }
//            int playoutResult = simulateRandomPlayout(nodeToExplore);
//            backPropogation(nodeToExplore, playoutResult);
//        }
//
//        Node winnerNode = rootNode.getChildWithMaxScore();
//        tree.setRoot(winnerNode);
//        return winnerNode.getState().getBoard();
//    }
}
