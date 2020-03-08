/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.GenericTree;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 *
 * @author Matheus Nunes
 */
public class GenericTreeIterator<Index, E> implements  Iterator<GenericNode<Index,E>> {

    private int quantidadeTotal;
    private int elementosPercorridos;
    private GenericNode<Index, E> cursor;
    private int ultRetornado;
    private Stack<GenericNode<Index,E>> pilhaDeNos;

    public GenericTreeIterator(int quantidadeDeElementos, GenericNode<Index, E> root) {
        this.elementosPercorridos = 0;
        this.cursor = root;
        this.ultRetornado = -1;
        this.pilhaDeNos = new Stack<>();
        if (this.cursor != null){
            this.pilhaDeNos.push(this.cursor);
        }
        this.quantidadeTotal = quantidadeDeElementos;
    }

    @Override
    public boolean hasNext() {
        return !this.pilhaDeNos.isEmpty();
    }

    @Override
    public GenericNode<Index,E> next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        GenericNode<Index,E> no_atual = this.pilhaDeNos.pop();
        for (int i = no_atual.children.size()-1; i >= 0; i--) {
            this.pilhaDeNos.push(no_atual.children.get(i));
        }

        return no_atual;
    }
}
