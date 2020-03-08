/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.GenericTree.GenericTreePatternsApplication.DirectoryPattern;

import estruturadedadosavancada.GenericTree.GenericNode;
import estruturadedadosavancada.GenericTree.GenericTreePatternsApplication.MyPatternsGeneric;
import estruturadedadosavancada.InvalidNodeException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matheus Nunes
 */
public class DirectoryPattern<Index, E> extends MyPatternsGeneric<Index, E>{
    

    @Override
    public void validator_insert(GenericNode<Index,E> node_father, GenericNode<Index, E> new_node,GenericNode<Index,E> root_pattern) throws InvalidNodeException {
            List<GenericNode<Index,E>> lista_de_nos = this.validator_find(node_father.index,root_pattern,new ArrayList<>(),root_pattern);  
            if (lista_de_nos.isEmpty()){
                throw new InvalidNodeException("No pai informado nao existente");
            }
            //Inserindo no filho no primeiro no com index igual ao no pai
            lista_de_nos.get(0).children.add(new_node);
            new_node.setFather(lista_de_nos.get(0));
    }

    @Override
    public List<GenericNode<Index, E>> validator_find(Index find_index,GenericNode<Index,E> actual_node,List<GenericNode<Index, E>> lista_de_nos,GenericNode<Index,E> root_pattern) throws InvalidNodeException{
        //Verificando se o no atual possui index igual ao informado
        if (actual_node.index.equals(find_index)) {
            lista_de_nos.add(actual_node);
        }
        //Verificando se o no atual possui algum filho
        if (!actual_node.children.isEmpty()) {
            for (int i = 0; i < actual_node.children.size(); i++) {
                this.validator_find(find_index, actual_node.children.get(i), lista_de_nos,root_pattern);
            }
        }
        //Verificando se a busca foi finalizada ou se o no atual e uma folha
        if (actual_node.index.equals(root_pattern.index)) {
            return lista_de_nos;
        }else{
            return null;
        }
    }

    @Override
    public E validator_replace(GenericNode<Index, E> node, E v,GenericNode<Index,E> root_pattern) throws InvalidNodeException {
        List<GenericNode<Index,E>> lista_de_nos = this.validator_find(node.index,root_pattern,new ArrayList<>(),root_pattern);
        if(lista_de_nos.isEmpty()){
            throw new InvalidNodeException("No nao existente");
        }
        
        lista_de_nos.get(0).setData(v);
        
        return v;    
    }
    

}
