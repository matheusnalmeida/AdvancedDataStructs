/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.AVLTree;

/**
 *
 * @author 1181123221
 */
public class AVLNode<Index extends Comparable,E> {
    
    private AVLNode<Index,E> father;
    private Index chave;
    private E valor;
    private int balanco;
    private int altura;
    private AVLNode<Index,E> esquerda;
    private AVLNode<Index,E> direita;

    public AVLNode(Index chave, E valor) {
        this.chave = chave;
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.balanco = 0;
        this.altura = 0;
    }

    public AVLNode<Index,E> getFather() {
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

    public AVLNode<Index,E> getEsquerda() {
        return esquerda;
    }

    public AVLNode<Index,E> getDireita() {
        return direita;
    }

    public void setValor(E valor) {
        this.valor = valor;
    }

    public void setEsquerda(AVLNode<Index,E> esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(AVLNode<Index,E> direita) {
        this.direita = direita;
    }

    public void setFather(AVLNode<Index, E> father) {
        this.father = father;
    }

    public void setBalanco(int balanco) {
        this.balanco = balanco;
    }
    
    public int getBalanco(){
        return this.balanco;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return this.chave.toString();
    }    
}
