/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.Prova_1_Unidade;

import estruturadedadosavancada.BinarySearchTree.BinaryNodeSearchTree;
import estruturadedadosavancada.BinarySearchTree.BinarySearchTree;
import estruturadedadosavancada.InvalidNodeException;

/**
 *
 * @author Matheus Nunes
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidNodeException {
        BinarySearchTree<Integer,Integer> arvore = new BinarySearchTree<>();
        arvore.insert(new BinaryNodeSearchTree<>(4,4));
        arvore.insert(new BinaryNodeSearchTree<>(2,2));
        arvore.insert(new BinaryNodeSearchTree<>(6,6));
        arvore.insert(new BinaryNodeSearchTree<>(1,1));
        arvore.insert(new BinaryNodeSearchTree<>(3,3));
        arvore.insert(new BinaryNodeSearchTree<>(5,5));
        arvore.insert(new BinaryNodeSearchTree<>(7,7));

        
        System.out.println(arvore.retornaAltura());
        System.out.println(arvore.printarArvore());
   
    }
    
}
