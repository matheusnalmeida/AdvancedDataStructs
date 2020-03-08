package estruturadedadosavancada;

import estruturadedadosavancada.GenericTree.GenericNode;
import java.util.Iterator;

import estruturadedadosavancada.EmptyTreeException;
import estruturadedadosavancada.InvalidNodeException;
import java.util.List;


public interface Tree<Index, E> {
	// Retorna a quantidade de n�s da �rvore
	public int size();
	//retorna se a �rvore est� vazia
	public boolean isEmpty();
	// Retorna um interador sobre os elementos armazenados da �rvore
	public Iterator<GenericNode<Index,E>> iterator();
	// Retorna um cole��o inter�vel de n�s
	public Iterable<GenericNode<Index,E>> nodes();
	// Substitui o elemento armazenado em determinado n�
	public E replace(GenericNode<Index,E> node, E v) throws InvalidNodeException;
	// Retorna a raiz da �rvore
	public GenericNode<Index,E> root() throws EmptyTreeException;
	// retorna o pai de um n�
	public GenericNode<Index,E> parent(GenericNode<Index,E> node) throws InvalidNodeException, EmptyTreeException;
	// retorna lista de filhos
	public Iterable<GenericNode<Index,E>> children(GenericNode<Index,E> node) throws InvalidNodeException;
	// retorna verdadeiro se o n� � interno
	public boolean isInternal(GenericNode<Index,E> node) throws InvalidNodeException;
	// retorna verdadeiro se o n� � externo
	public boolean isExternal(GenericNode<Index,E> node) throws InvalidNodeException;
	// retorna verdadeiro se o n� � raiz
	public boolean isRoot(GenericNode<Index,E> node) throws EmptyTreeException;
        //insere no na arvore
        public void insert(GenericNode<Index,E> node_father,GenericNode<Index,E> new_father) throws InvalidNodeException;
        //procura no na arvore
        public List<GenericNode<Index,E>> find(Index index) throws InvalidNodeException;
	
}
