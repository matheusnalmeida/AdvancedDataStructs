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
import estruturadedadosavancada.EmptyTreeException;
import estruturadedadosavancada.InvalidNodeException;
import java.util.ArrayList;
import java.util.List;
import estruturadedadosavancada.BinarySearchTree_int;
import java.util.Iterator;

public class BinarySearchTree<Index extends Comparable<Index>, E> implements BinarySearchTree_int<Index, E> {

    private int tamanho;
    private BinaryNodeSearchTree<Index, E> root;

    public BinarySearchTree() {
        this.tamanho = 0;
        this.root = null;
    }

    @Override
    public int size() {
        return this.tamanho;
    }

    @Override
    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    @Override
    public Iterable<BinaryNodeSearchTree<Index, E>> nodes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E replace(BinaryNodeSearchTree<Index, E> node, E v) throws InvalidNodeException, EmptyTreeException {
        BinaryNodeSearchTree<Index, E> actual_node = this.find_iterativo(node.getChave());
        if (actual_node == null) {
            throw new InvalidNodeException("No nao existente na arvore");
        }

        node.setValor(v);

        return v;
    }

    @Override
    public BinaryNodeSearchTree<Index, E> root() throws EmptyTreeException {
        if (this.tamanho == 0) {
            throw new EmptyTreeException("A arvore esta vazia");
        }

        return this.root;
    }

    @Override
    public BinaryNodeSearchTree<Index, E> parent(BinaryNodeSearchTree<Index, E> node) throws InvalidNodeException, EmptyTreeException {
        BinaryNodeSearchTree<Index, E> actual_node = this.find_iterativo(node.getChave());
        if (actual_node == null) {
            throw new InvalidNodeException("No nao existente");
        }

        return actual_node.getFather();
    }

    @Override
    public Iterable<BinaryNodeSearchTree<Index, E>> children(BinaryNodeSearchTree<Index, E> node) throws InvalidNodeException, EmptyTreeException {
        if (this.tamanho == 0) {
            throw new EmptyTreeException("Arvore vazia");
        }
        List<BinaryNodeSearchTree<Index, E>> filhos = new ArrayList<>();
        BinaryNodeSearchTree<Index, E> actual_node = this.find_iterativo(node.getChave());
        if (actual_node == null) {
            throw new InvalidNodeException("No nao existente");
        }
        if (actual_node.getEsquerda() != null) {
            filhos.add(actual_node.getEsquerda());
        }
        if (actual_node.getDireita() != null) {
            filhos.add(actual_node.getDireita());
        }

        return filhos;
    }

    @Override
    public boolean isInternal(BinaryNodeSearchTree<Index, E> node) throws InvalidNodeException, EmptyTreeException {
        if (this.isRoot(node)) {
            return false;
        }
        BinaryNodeSearchTree<Index, E> actual_node = this.find_iterativo(node.getChave());
        if (actual_node == null) {
            throw new InvalidNodeException("No nao exstente");
        }

        if (actual_node.getEsquerda() != null || actual_node.getDireita() != null) {
            return true;
        }

        return false;
    }

    @Override
    public Iterator<BinaryNodeSearchTree<Index, E>> iterator() {
        return new BinarySearchTreeIterator<Index,E>(this.root);
    }
    
    @Override
    public boolean isExternal(BinaryNodeSearchTree<Index, E> node) throws InvalidNodeException, EmptyTreeException {
        if (this.isRoot(node)) {
            return false;
        }
        BinaryNodeSearchTree<Index, E> actual_node = this.find_iterativo(node.getChave());
        if (actual_node == null) {
            throw new InvalidNodeException("No nao exstente");
        }

        if (actual_node.getEsquerda() == null && actual_node.getDireita() == null) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isRoot(BinaryNodeSearchTree<Index, E> node) throws EmptyTreeException {
        return this.root().getChave().equals(node.getChave());
    }

    @Override
    public void insert(BinaryNodeSearchTree<Index, E> new_node) throws InvalidNodeException {
        if (this.root == null) {
            this.root = new_node;
            this.tamanho++;
        } else {
            BinaryNodeSearchTree<Index, E> current = this.root;
            while (true) {
                if (new_node.getChave().compareTo(current.getChave()) < 0) {
                    if (current.getEsquerda() == null) {
                        current.setEsquerda(new_node);
                        new_node.setFather(current);
                        this.tamanho++;
                        return;
                    }
                    current = current.getEsquerda();
                } else if (new_node.getChave().compareTo(current.getChave()) > 0) {
                    if (current.getDireita() == null) {
                        current.setDireita(new_node);
                        new_node.setFather(current);
                        this.tamanho++;
                        return;
                    }
                    current = current.getDireita();
                } else {
                    throw new InvalidNodeException("Ja existe no com a chave informada");
                }
            }
        }
    }

    @Override
    public BinaryNodeSearchTree<Index, E> find_iterativo(Index index) throws EmptyTreeException {
        if (this.tamanho == 0) {
            throw new EmptyTreeException("Arvore Vazia");
        }
        BinaryNodeSearchTree<Index, E> current = this.root;
        while (current.getChave().compareTo(index) != 0) {
            if (index.compareTo(current.getChave()) < 0) {
                current = current.getEsquerda();
            } else {
                current = current.getDireita();
            }
            if (current == null) {
                return null;
            }
        }

        return current;
    }

    @Override
    public BinaryNodeSearchTree<Index, E> find_recursivo(Index index) throws EmptyTreeException {
        if (this.tamanho == 0) {
            throw new EmptyTreeException("Arvore Vazia");
        }

        return find_recursivo(this.root, index);
    }

    private BinaryNodeSearchTree<Index, E> find_recursivo(BinaryNodeSearchTree<Index, E> actual_node, Index index_find) {
        if (actual_node == null) {
            return null;
        }
        if (index_find.compareTo(actual_node.getChave()) < 0) {
            return find_recursivo(actual_node.getEsquerda(), index_find);
        } else if (index_find.compareTo(actual_node.getChave()) > 0) {
            return find_recursivo(actual_node.getDireita(), index_find);
        } else {
            return actual_node;
        }
    }

    //Algoritimos de navegacao
    @Override
    public List<BinaryNodeSearchTree<Index, E>> pre_ordem() {
        List<BinaryNodeSearchTree<Index, E>> nos_pre_ordem = new ArrayList<>();
        return this.pre_ordem(this.root, nos_pre_ordem);
    }

    private List<BinaryNodeSearchTree<Index, E>> pre_ordem(BinaryNodeSearchTree<Index, E> current, List<BinaryNodeSearchTree<Index, E>> nos_pre_ordem) {
        if (current != null) {
            nos_pre_ordem.add(current);
            pre_ordem(current.getEsquerda(), nos_pre_ordem);
            pre_ordem(current.getDireita(), nos_pre_ordem);
        }
        return nos_pre_ordem;
    }

    @Override
    public List<BinaryNodeSearchTree<Index, E>> pos_ordem() {
        List<BinaryNodeSearchTree<Index, E>> nos_pos_ordem = new ArrayList<>();
        return this.pos_ordem(this.root, nos_pos_ordem);    
    }

    private List<BinaryNodeSearchTree<Index, E>> pos_ordem(BinaryNodeSearchTree<Index, E> current, List<BinaryNodeSearchTree<Index, E>> nos_pos_ordem) {
        if (current != null) {
            pre_ordem(current.getEsquerda(), nos_pos_ordem);
            pre_ordem(current.getDireita(), nos_pos_ordem);
            nos_pos_ordem.add(current);

        }
        return nos_pos_ordem;
    }

    @Override
    public List<BinaryNodeSearchTree<Index, E>> em_ordem() {
        List<BinaryNodeSearchTree<Index, E>> nos_em_ordem = new ArrayList<>();
        return this.em_ordem(this.root, nos_em_ordem);        }

    private List<BinaryNodeSearchTree<Index, E>> em_ordem(BinaryNodeSearchTree<Index, E> current, List<BinaryNodeSearchTree<Index, E>> nos_em_ordem) {
        if (current != null) {
            pre_ordem(current.getEsquerda(), nos_em_ordem);
            nos_em_ordem.add(current);
            pre_ordem(current.getDireita(), nos_em_ordem);
        }
        return nos_em_ordem;
    }


}
