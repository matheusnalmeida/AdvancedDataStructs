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
  
        /* Constructing tree given in the above figure */
        tree.insert(new AVLNode(10, 10)); 
        tree.insert(new AVLNode(20, 20)); 
        tree.insert(new AVLNode(30, 30)); 
        tree.insert(new AVLNode(40, 40)); 
        tree.remove(10);
        tree.limparArvore();
        tree.insert(new AVLNode(10, 10)); 
        tree.insert(new AVLNode(20, 20)); 
        tree.insert(new AVLNode(30, 30)); 
        tree.insert(new AVLNode(40, 40)); 
        tree.remove(10);
        //tree.insert(new AVLNode(50, 50)); 
        //tree.insert(new AVLNode(60, 60)); 
        //tree.insert(new AVLNode<>(70,70));
        //printArr(tree.pre_ordem());
        System.out.println(tree.printarArvore());
    }
    
    public static void printArr(List<AVLNode<Integer,Integer>> arr){
        for (AVLNode node: arr){
            System.out.print(node.getChave() + " - ");
        }
    }
    
}
