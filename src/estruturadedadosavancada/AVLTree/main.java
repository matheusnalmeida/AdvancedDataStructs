/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.AVLTree;

import estruturadedadosavancada.InvalidNodeException;
import java.util.List;

/**
 *
 * @author Matheus Nunes
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidNodeException {
        AVLTree<Integer,Integer> tree = new AVLTree(); 
  
        tree.insert(new AVLNode(7, 7)); 
        tree.insert(new AVLNode(6, 6)); 
        tree.insert(new AVLNode(8, 8)); 
        tree.insert(new AVLNode(2, 2)); 
        tree.print2D();
        System.out.println("-----------------------------------------------------------");
        tree.insert(new AVLNode(3, 3)); 
        //tree.insert(new AVLNode(50, 50)); 
        //tree.insert(new AVLNode(60, 60)); 
        //tree.insert(new AVLNode<>(70,70));
        //printArr(tree.pre_ordem());
        tree.remove(6);
        tree.remove(8);
        tree.print2D();
    }
    
    public static void printArr(List<AVLNode<Integer,Integer>> arr){
        for (AVLNode node: arr){
            System.out.print(node.getChave() + " - ");
        }
    }
    
}
