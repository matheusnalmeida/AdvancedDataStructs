/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada;

import estruturadedadosavancada.BinaryTreeArray.BinaryNodeVector;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 1181123221
 */
public interface BinaryTreeVector<Index,E> {
    	// Retorna a quantidade de n�s da �rvore
	public int size();
	//retorna se a �rvore est� vazia
	public boolean isEmpty();
	// Retorna um interador sobre os elementos armazenados da �rvore
	public Iterator<BinaryNodeVector<Index,E>> iterator();
	// Retorna um cole��o inter�vel de n�s
	public Iterable<BinaryNodeVector<Index,E>> nodes();
	// Substitui o elemento armazenado em determinado n�
	public E replace(BinaryNodeVector<Index,E> node, E v) throws InvalidNodeException,EmptyTreeException;
	// Retorna a raiz da �rvore
	public BinaryNodeVector<Index,E> root() throws EmptyTreeException;
	// retorna o pai de um n�
	public BinaryNodeVector<Index,E> parent(BinaryNodeVector<Index,E> node) throws InvalidNodeException, EmptyTreeException;
	// retorna lista de filhos
	public Iterable<BinaryNodeVector<Index,E>> children(BinaryNodeVector<Index,E> node) throws InvalidNodeException,EmptyTreeException;
	// retorna verdadeiro se o n� � interno
	public boolean isInternal(BinaryNodeVector<Index,E> node) throws InvalidNodeException;
	// retorna verdadeiro se o n� � externo
	public boolean isExternal(BinaryNodeVector<Index,E> node) throws InvalidNodeException;
	// retorna verdadeiro se o n� � raiz
	public boolean isRoot(BinaryNodeVector<Index,E> node) throws EmptyTreeException;
        //insere no na arvore
        public void insert(BinaryNodeVector<Index,E> node_father,BinaryNodeVector<Index,E> new_father) throws InvalidNodeException;
        //procura no na arvore
        public List<BinaryNodeVector<Index,E>> find(Index index) throws InvalidNodeException,EmptyTreeException;
}
