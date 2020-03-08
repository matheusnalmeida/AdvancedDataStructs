/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.GenericTree.GenericTreePatternsApplication;

import estruturadedadosavancada.GenericTree.GenericNode;
import estruturadedadosavancada.InvalidNodeException;
import java.util.List;

/**
 *
 * @author Matheus Nunes
 */
public abstract class MyPatternsGeneric<Index,E> {
        
        //Insere na arvore
        public abstract void validator_insert(GenericNode<Index,E> node_father,GenericNode<Index,E> new_father,GenericNode<Index,E> root_pattern) throws InvalidNodeException;
        //procura no na arvore
        public abstract List<GenericNode<Index,E>> validator_find(Index find_index,GenericNode<Index,E> actual_node,
                List<GenericNode<Index, E>> lista_de_nos,GenericNode<Index,E> root_pattern) throws InvalidNodeException;
        // Substitui o elemento armazenado em determinado n�
	public abstract E validator_replace(GenericNode<Index,E> node, E v,GenericNode<Index,E> root_pattern) throws InvalidNodeException;

}
