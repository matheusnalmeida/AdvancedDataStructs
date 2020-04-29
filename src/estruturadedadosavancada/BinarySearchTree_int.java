/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada;

import estruturadedadosavancada.BinarySearchTree.BinaryNodeSearchTree;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 1181123221
 * @param <Index>
 * @param <E>
 */
public interface BinarySearchTree_int<Index extends Comparable<Index>,E> {
        // Retorna a quantidade de n�s da �rvore
	public int size();
	//retorna se a �rvore est� vazia
	public boolean isEmpty();
        // Retorna um interador sobre os elementos armazenados da �rvore
	public Iterator<BinaryNodeSearchTree<Index,E>> iterator();
        // Retorna um cole��o inter�vel de n�s
	public Iterable<BinaryNodeSearchTree<Index,E>> nodes();
	// Substitui o elemento armazenado em determinado n�
	public E replace(BinaryNodeSearchTree<Index,E> node, E v) throws InvalidNodeException,EmptyTreeException;
	// Retorna a raiz da �rvore
	public BinaryNodeSearchTree<Index,E> root() throws EmptyTreeException;
	// retorna o pai de um n�
	public BinaryNodeSearchTree<Index,E> parent(BinaryNodeSearchTree<Index,E> node) throws InvalidNodeException, EmptyTreeException;
	// retorna lista de filhos
	public Iterable<BinaryNodeSearchTree<Index,E>> children(BinaryNodeSearchTree<Index,E> node) throws InvalidNodeException,EmptyTreeException;
	// retorna verdadeiro se o n� � interno
	public boolean isInternal(BinaryNodeSearchTree<Index,E> node) throws InvalidNodeException,EmptyTreeException;
	// retorna verdadeiro se o n� � externo
	public boolean isExternal(BinaryNodeSearchTree<Index,E> node) throws InvalidNodeException,EmptyTreeException;
	// retorna verdadeiro se o n� � raiz
	public boolean isRoot(BinaryNodeSearchTree<Index,E> node) throws EmptyTreeException;
        //insere no na arvore
        public void insert(BinaryNodeSearchTree<Index,E> new_node) throws InvalidNodeException;
        //Remove no da arvore
        public boolean remove(Index chave);
        //procura no na arvore de forma iterativa
        public BinaryNodeSearchTree<Index,E> find_iterativo(Index index) throws InvalidNodeException,EmptyTreeException;
        //procura no na arvore de forma recursiva
        public BinaryNodeSearchTree<Index,E> find_recursivo(Index index) throws InvalidNodeException,EmptyTreeException;
        //Algoritimos de navegacao
        public List<BinaryNodeSearchTree<Index,E>> pre_ordem();
        public List<BinaryNodeSearchTree<Index,E>> pos_ordem();
        public List<BinaryNodeSearchTree<Index,E>> em_ordem();
        //Retorna maior e menor valor
        public BinaryNodeSearchTree<Index,E> retornaMaior();
        public BinaryNodeSearchTree<Index,E> retornaMenor();
        //Retorna media dos valores da arvore baseado no hash code de cada chave
        public int retornaMedia();
        //Retorna numero de folhas
        public int retornaNumeroDeFolhas();
        //Retorna altura da arvore
        public int retornaAltura();
        
}
