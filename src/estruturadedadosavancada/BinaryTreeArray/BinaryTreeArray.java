/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinaryTreeArray;

import estruturadedadosavancada.BinaryTreeVector;
import estruturadedadosavancada.EmptyTreeException;
import estruturadedadosavancada.InvalidNodeException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Matheus Nunes
 */
public class BinaryTreeArray<Index, E> implements BinaryTreeVector<Index, E> {

    private List<BinaryNodeVector<Index, E>> nos;

    public BinaryTreeArray() {
        this.nos = new ArrayList();
    }

    @Override
    public int size() {
        return this.nos.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Iterator<BinaryNodeVector<Index, E>> iterator() {
        return new BinaryTreeIterator<>(this.nos);
    }

    @Override
    public Iterable<BinaryNodeVector<Index, E>> nodes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E replace(BinaryNodeVector<Index, E> node, E v) throws InvalidNodeException,EmptyTreeException {
        List<BinaryNodeVector<Index,E>> nos_encontrados = this.find(node.index);
        nos_encontrados.get(0).setData(v);
        
        return v;
    }

    @Override
    public BinaryNodeVector<Index, E> root() throws EmptyTreeException {
        if (this.isEmpty()) {
            throw new EmptyTreeException("Arvore vazia");
        }
        return this.nos.get(0);
    }

    @Override
    public BinaryNodeVector<Index, E> parent(BinaryNodeVector<Index, E> node) throws InvalidNodeException, EmptyTreeException {
        List<BinaryNodeVector<Index,E>> nos_encontrados = this.find(node.index);
        
        if(this.isRoot(nos_encontrados.get(0))){
            return null;
        }
        
        int posicao_no_encontrado = this.nos.indexOf(nos_encontrados.get(0));
        return this.nos.get(((posicao_no_encontrado+1)/2)-1);        
    }

    @Override
    public Iterable<BinaryNodeVector<Index, E>> children(BinaryNodeVector<Index, E> node) throws InvalidNodeException,EmptyTreeException {
            List<BinaryNodeVector<Index, E>> nos_encontrados = this.find(node.index);
            int posicao_no_pai = this.nos.indexOf(nos_encontrados.get(0));
            ArrayList<BinaryNodeVector<Index,E>> children = new ArrayList<>();
            int posicao_filho_esquerdo = 2* (posicao_no_pai + 1) - 1;
            int posicao_filho_direita = 2* (posicao_no_pai + 1);
            
            if(this.nos.get(posicao_filho_esquerdo) != null){
                children.add(this.nos.get(posicao_filho_esquerdo));
            }
            if(this.nos.get(posicao_filho_direita) != null){
                children.add(this.nos.get(posicao_filho_direita));
            }
            
            return children;
    }

    @Override
    public boolean isInternal(BinaryNodeVector<Index, E> node) throws InvalidNodeException {
        try {
            List<BinaryNodeVector<Index,E>> nos_encontrados = this.find(node.index);
            BinaryNodeVector<Index,E> no_encontrado = nos_encontrados.get(0);
            
            //Verificando se o no escohido e o raiz
            if(no_encontrado.equals(this.nos.get(0))){
                return false;
            }
            int posicao_no_atual = this.nos.indexOf(no_encontrado);
            int posicao_filho_esquerdo = 2* (posicao_no_atual + 1) - 1;
            int posicao_filho_direita = 2* (posicao_no_atual + 1);
            
            if(this.nos.get(posicao_filho_esquerdo) != null || this.nos.get(posicao_filho_direita) != null){
                return true;
            }
     
            return false;
        } catch (EmptyTreeException ex) {
            return false;
        }
    }

    @Override
    public boolean isExternal(BinaryNodeVector<Index, E> node) throws InvalidNodeException {
        try {
            List<BinaryNodeVector<Index,E>> nos_encontrados = this.find(node.index);
            BinaryNodeVector<Index,E> no_encontrado = nos_encontrados.get(0);
            
            //Verificando se o no escohido e o raiz
            if(no_encontrado.equals(this.nos.get(0))){
                return false;
            }
            int posicao_no_atual = this.nos.indexOf(no_encontrado);
            int posicao_filho_esquerdo = 2* (posicao_no_atual + 1) - 1;
            int posicao_filho_direita = 2* (posicao_no_atual + 1);
            
            if(this.nos.get(posicao_filho_esquerdo) == null || this.nos.get(posicao_filho_direita) == null){
                return true;
            }
     
            return false;
        } catch (EmptyTreeException ex) {
            return false;
        }
    }

    @Override
    public boolean isRoot(BinaryNodeVector<Index, E> node) throws EmptyTreeException {
        if(this.nos.isEmpty()){
            throw new EmptyTreeException("Arvore Vazia");
        }
        return node.equals(this.nos.get(0));
    }

    @Override
    public void insert(BinaryNodeVector<Index, E> node_father, BinaryNodeVector<Index, E> new_node) throws InvalidNodeException {
        try{
            List<BinaryNodeVector<Index, E>> nos_encontrados = this.find(node_father.index);
            if(nos_encontrados.isEmpty()){
                throw new InvalidNodeException("No pai nao encontrado");
            }
            int posicao_no_pai = this.nos.indexOf(nos_encontrados.get(0));
            int posicao_filho_esquerdo = 2* (posicao_no_pai + 1) - 1;
            int posicao_filho_direita = 2* (posicao_no_pai + 1);
            if(this.nos.get(posicao_filho_esquerdo) == null){
                this.nos.set(posicao_filho_esquerdo, new_node);
            }else if(this.nos.get(posicao_filho_direita) == null){
                this.nos.set(posicao_filho_direita, new_node);
            }else{
                throw new InvalidNodeException("O no pai informado ja possui dois filhos");
            }            
            this.nos.add(null);
            this.nos.add(null);
        }catch(EmptyTreeException ex){
            //Inserindo primeiro no como raiz
            this.nos.add(new_node);
            this.nos.add(null);
            this.nos.add(null);
        }
    }

    @Override
    public List<BinaryNodeVector<Index, E>> find(Index index) throws InvalidNodeException, EmptyTreeException {
        if (this.nos.isEmpty()) {
            throw new EmptyTreeException("Arvore vazia");
        }
        Queue<BinaryNodeVector<Index,E>>  filaDeNos = new LinkedList();
        filaDeNos.add(this.nos.get(0));
        List<BinaryNodeVector<Index, E>> nosEncontrados = this.find(index, new ArrayList<>(), filaDeNos);
        if (nosEncontrados.isEmpty()) {
            throw new InvalidNodeException("No nao existente");
        }
        
        return nosEncontrados;
    }

    private List<BinaryNodeVector<Index, E>> find(Index index, List<BinaryNodeVector<Index, E>> lista_de_nos, Queue<BinaryNodeVector<Index, E>> filaDeNos) {
        if (!filaDeNos.isEmpty()) {
            BinaryNodeVector<Index, E> actual_node = filaDeNos.poll();
            int actual_position = this.nos.indexOf(actual_node);

            //Verificando se o no atual possui index igual ao informado
            if (actual_node.index.equals(index)) {
                lista_de_nos.add(actual_node);
            }
            //Verificando se o no atual possui no esquerdo e direito
            int posicaoEsquerda = 2 * (actual_position + 1) - 1;
            int posicaoDireita = 2 * (actual_position + 1);
            if (posicaoEsquerda < this.nos.size() && this.nos.get(posicaoEsquerda) != null) {
                filaDeNos.add(this.nos.get(posicaoEsquerda));
            }
            if (posicaoDireita < this.nos.size() && this.nos.get(posicaoDireita) != null) {
                filaDeNos.add(this.nos.get(posicaoDireita));
            }
            
            return find(index,lista_de_nos,filaDeNos);
        }else{
            return lista_de_nos;
        }
    }

}
