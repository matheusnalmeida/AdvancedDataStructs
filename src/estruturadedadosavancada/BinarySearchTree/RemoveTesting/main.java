/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.RemoveTesting;

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
        arvore.insert(new BinaryNodeSearchTree<>(38,38));
        arvore.insert(new BinaryNodeSearchTree<>(26,26));
        arvore.insert(new BinaryNodeSearchTree<>(72,72));
        arvore.insert(new BinaryNodeSearchTree<>(55,55));
        arvore.insert(new BinaryNodeSearchTree<>(90,90));
        arvore.insert(new BinaryNodeSearchTree<>(41,41));
        arvore.insert(new BinaryNodeSearchTree<>(60,60));
        arvore.insert(new BinaryNodeSearchTree<>(78,78));
        arvore.insert(new BinaryNodeSearchTree<>(92,92));
        arvore.insert(new BinaryNodeSearchTree<>(43,43));
        arvore.insert(new BinaryNodeSearchTree<>(74,74));
        System.out.println("------------------------------Arvore antes da remocao------------------------------");
        System.out.println(arvore.printarArvoreSimples());
        System.out.println("Removendo no folha");
        arvore.remove(43);
        System.out.println("Removendo no com uma sub_arvore");
        arvore.remove(38);
        System.out.println("Removendo no com duas sub_arvores");
        arvore.remove(72);
        System.out.println(arvore.printarArvoreSimples());
        
    }
    
}
