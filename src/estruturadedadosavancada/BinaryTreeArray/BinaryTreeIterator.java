/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinaryTreeArray;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 *
 * @author Matheus Nunes
 */
public class BinaryTreeIterator<Index, E> implements Iterator<BinaryNodeVector<Index, E>> {

    private List<BinaryNodeVector<Index, E>> arvore;
    private int posicaoAtual;
    private Queue<BinaryNodeVector<Index, E>> filaDeNos;

    public BinaryTreeIterator( List<BinaryNodeVector<Index, E>> arvore) {
        this.arvore = arvore;
        this.filaDeNos = new LinkedList<>();
        if (!this.arvore.isEmpty()) {
            this.filaDeNos.add(this.arvore.get(0));
            this.posicaoAtual = 0;
        }
    }

    @Override
    public boolean hasNext() {
        return !this.filaDeNos.isEmpty();
    }

    @Override
    public BinaryNodeVector<Index, E> next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        BinaryNodeVector<Index, E> no_atual = this.filaDeNos.poll();
        //Adicionando elemento da esquerda e da direita do no atual
        int posicaoEsquerda = 2 * (this.posicaoAtual + 1) - 1;
        int posicaoDireita = 2 * (this.posicaoAtual + 1);
        if (posicaoEsquerda < this.arvore.size() && this.arvore.get(posicaoEsquerda) != null) {
            this.filaDeNos.add(this.arvore.get(posicaoEsquerda));
        }
        if (posicaoDireita < this.arvore.size() && this.arvore.get(posicaoDireita) != null) {
            this.filaDeNos.add(this.arvore.get(posicaoDireita));
        }
        this.posicaoAtual = this.arvore.indexOf(this.filaDeNos.peek());
        
        return no_atual;
    }
}
