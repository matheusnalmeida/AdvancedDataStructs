/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.GenericTree;

import estruturadedadosavancada.EmptyTreeException;
import estruturadedadosavancada.GenericTree.GenericTreePatternsApplication.MyPatternsGeneric;
import estruturadedadosavancada.InvalidNodeException;
import estruturadedadosavancada.Tree;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Matheus Nunes
 */
public class GenericTree<Index,E> implements Tree<Index, E> {

    private GenericNode<Index,E> root;
    private MyPatternsGeneric<Index, E> pattern;
    private int size;

    public GenericTree(MyPatternsGeneric<Index,E> pattern) {
        this.root = null;
        this.size = 0;
        this.pattern = pattern;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<GenericNode<Index,E>> iterator() {
        return new GenericTreeIterator<>(this.size(),this.root);
    }

    @Override
    public Iterable<GenericNode<Index, E>> nodes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E replace(GenericNode<Index, E> node, E v) throws InvalidNodeException {
        return this.pattern.validator_replace(node, v,this.root);
    }

    @Override
    public GenericNode<Index, E> root() throws EmptyTreeException {
        if(this.root == null){
            throw new EmptyTreeException("Arvore Vazia");
        }
        return this.root;
    }

    @Override
    public GenericNode<Index, E> parent(GenericNode<Index, E> node) throws InvalidNodeException, EmptyTreeException {
        
        if(this.size() == 0){
            throw new EmptyTreeException("Arvore Vazia");
        }
        List<GenericNode<Index,E>> lista_de_nos = this.find(node.index);  
        
        return lista_de_nos.get(0).father;
    }

    @Override
    public Iterable<GenericNode<Index, E>> children(GenericNode<Index, E> node) throws InvalidNodeException {
        List<GenericNode<Index,E>> lista_de_nos = this.find(node.index);  
        
        return lista_de_nos.get(0).children;
    }

    @Override
    public boolean isInternal(GenericNode<Index, E> node) throws InvalidNodeException {
       List<GenericNode<Index,E>> lista_de_nos = this.find(node.index);
       
       GenericNode<Index,E> no_escolhido = lista_de_nos.get(0);
       //Sera o no raiz
       if (no_escolhido.father == null){
           return false;
           
       } 
       //Verificando se e um no folha
       else if(no_escolhido.children.isEmpty()){
           return false;
       }
       
       return true;
    }

    @Override
    public boolean isExternal(GenericNode<Index, E> node) throws InvalidNodeException {
       List<GenericNode<Index,E>> lista_de_nos = this.find(node.index);
       //Verificando se o no existe
       
       GenericNode<Index,E> no_escolhido = lista_de_nos.get(0);
       //Sera o no raiz
       if (no_escolhido.father == null){
           return false;
           
       } 
       //Verificando se e um no interno
       else if(!no_escolhido.children.isEmpty()){
           return false;
       }
       
       return true;    
    }

    @Override
    public boolean isRoot(GenericNode<Index, E> node) throws EmptyTreeException {
        if(this.root == null){
            throw new EmptyTreeException("Arvore vazia");
        }
        return node.index.equals(this.root.index);
    }

    @Override
    public void insert(GenericNode<Index,E> node_father, GenericNode<Index, E> new_node) throws InvalidNodeException{
        if(this.root == null){
            this.root = new_node;
        }else{
            this.pattern.validator_insert(node_father, new_node,this.root);
        }
        this.size++;
    }

    @Override
    public List<GenericNode<Index, E>> find(Index find_index) throws InvalidNodeException {
        if (this.root == null){
            throw new InvalidNodeException("No nao existe");
        }
        List<GenericNode<Index, E>> nos_encontrados =  this.pattern.validator_find(find_index, this.root, new ArrayList<>(),this.root);
        if (nos_encontrados.isEmpty()){
            throw new InvalidNodeException("No nao existe");
        }else{
            return nos_encontrados;
        }
    }

}
