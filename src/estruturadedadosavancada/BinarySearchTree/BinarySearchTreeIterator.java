/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 *
 * @author Matheus Nunes
 */
public class BinarySearchTreeIterator<Index extends Comparable,E> implements Iterator<BinaryNodeSearchTree<Index,E>>{
    
    private BinaryNodeSearchTree<Index, E> root;
    private Queue<BinaryNodeSearchTree<Index, E>> filaDeNos;

    public BinarySearchTreeIterator(BinaryNodeSearchTree<Index, E> root) {
        this.root = root;
        this.filaDeNos = new LinkedList<>();
        if (this.root != null) {
            this.filaDeNos.add(this.root);
        }
    }

    @Override
    public boolean hasNext() {
        return !this.filaDeNos.isEmpty();
    }

    @Override
    public BinaryNodeSearchTree<Index, E> next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        BinaryNodeSearchTree<Index, E> no_atual = this.filaDeNos.poll();
        //Adicionando elemento da esquerda e da direita do no atual

        if (no_atual.getEsquerda() != null) {
            this.filaDeNos.add(no_atual.getEsquerda());
        }
        if (no_atual.getDireita() != null) {
            this.filaDeNos.add(no_atual.getDireita());
        }
        
        return no_atual;
    }
}
