/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree;

/**
 *
 * @author 1181123221
 */
public class BinaryNodeSearchTree<Index extends Comparable,E> {
    
    private BinaryNodeSearchTree<Index,E> father;
    private Index chave;
    private E valor;
    private BinaryNodeSearchTree<Index,E> esquerda;
    private BinaryNodeSearchTree<Index,E> direita;

    public BinaryNodeSearchTree(Index chave, E valor) {
        this.chave = chave;
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public BinaryNodeSearchTree<Index,E> getFather() {
        return father;
    }

    public Index getChave() {
        return chave;
    }

    public void setChave(Index chave) {
        this.chave = chave;
    }

    public E getValor() {
        return valor;
    }

    public BinaryNodeSearchTree<Index,E> getEsquerda() {
        return esquerda;
    }

    public BinaryNodeSearchTree<Index,E> getDireita() {
        return direita;
    }

    public void setValor(E valor) {
        this.valor = valor;
    }

    public void setEsquerda(BinaryNodeSearchTree<Index,E> esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(BinaryNodeSearchTree<Index,E> direita) {
        this.direita = direita;
    }

    public void setFather(BinaryNodeSearchTree<Index, E> father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return this.chave.toString();
    }
    
    
    
}
