/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada;

import estruturadedadosavancada.AVLTree.AVLNode;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Matheus Nunes
 */
public interface AVLBinarySearchTree<Index extends Comparable<Index>,E> {
        // Retorna a quantidade de n�s da �rvore
	public int size();
	//retorna se a �rvore est� vazia
	public boolean isEmpty();
        // Retorna um interador sobre os elementos armazenados da �rvore
	public Iterator<AVLNode<Index,E>> iterator();
	// Substitui o elemento armazenado em determinado n�
	public E replace(AVLNode<Index,E> node, E v) throws InvalidNodeException,EmptyTreeException;
	// Retorna a raiz da �rvore
	public AVLNode<Index,E> root() throws EmptyTreeException;
	// retorna o pai de um n�
	public AVLNode<Index,E> parent(AVLNode<Index,E> node) throws InvalidNodeException, EmptyTreeException;
	// retorna lista de filhos
	public Iterable<AVLNode<Index,E>> children(AVLNode<Index,E> node) throws InvalidNodeException,EmptyTreeException;
	// retorna verdadeiro se o n� � interno
	public boolean isInternal(AVLNode<Index,E> node) throws InvalidNodeException,EmptyTreeException;
	// retorna verdadeiro se o n� � externo
	public boolean isExternal(AVLNode<Index,E> node) throws InvalidNodeException,EmptyTreeException;
	// retorna verdadeiro se o n� � raiz
	public boolean isRoot(AVLNode<Index,E> node) throws EmptyTreeException;
        //insere no na arvore
        public void insert(AVLNode<Index,E> new_node) throws InvalidNodeException;
        //Remove no da arvore
        public boolean remove(Index chave);
        //Limpar arvore
        public void limparArvore();
        //procura no na arvore de forma iterativa
        public AVLNode<Index,E> find_iterativo(Index index) throws EmptyTreeException;
        //procura no na arvore de forma recursiva
        public AVLNode<Index,E> find_recursivo(Index index) throws EmptyTreeException;
        //Algoritimos de navegacao
        public List<AVLNode<Index,E>> pre_ordem();
        public List<AVLNode<Index,E>> pos_ordem();
        public List<AVLNode<Index,E>> em_ordem();
        //Retorna maior e menor valor
        public AVLNode<Index,E> retornaMaior();
        public AVLNode<Index,E> retornaMenor();
        //Retorna media dos valores da arvore baseado no hash code de cada chave
        public int retornaMedia();
        //Retorna numero de folhas
        public int retornaNumeroDeFolhas();
        //Retorna altura da arvore
        public int retornaAltura();

}
