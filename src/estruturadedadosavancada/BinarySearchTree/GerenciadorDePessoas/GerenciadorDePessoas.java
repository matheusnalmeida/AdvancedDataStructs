/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.GerenciadorDePessoas;

import estruturadedadosavancada.BinarySearchTree.BinaryNodeSearchTree;
import estruturadedadosavancada.BinarySearchTree.BinarySearchTree;
import estruturadedadosavancada.EmptyTreeException;
import estruturadedadosavancada.InvalidNodeException;
import java.util.List;

/**
 *
 * @author Matheus Nunes
 */
public class GerenciadorDePessoas {
    
    BinarySearchTree<Integer,Pessoa> arvore_de_pessoas;

    public GerenciadorDePessoas() {
        this.arvore_de_pessoas = new BinarySearchTree<>();
    }
    
    public String inserirPessoa(Pessoa pessoa){
        try {
            BinaryNodeSearchTree<Integer,Pessoa> novo_elemento = new BinaryNodeSearchTree<>(pessoa.getCpf(),pessoa);
            if(this.arvore_de_pessoas.isEmpty()){
                this.arvore_de_pessoas.insert(novo_elemento);
                return "Pessoa " + pessoa.getNome() + " cadastrada com sucesso";
            }            
            BinaryNodeSearchTree<Integer,Pessoa> elemento = this.arvore_de_pessoas.find_iterativo(pessoa.getCpf());
            if(elemento == null){
                this.arvore_de_pessoas.insert(novo_elemento);
                return "Pessoa " + pessoa.getNome() + " cadastrada com sucesso";
            }
            return "Pessoa com cpf " + pessoa.getCpf() + " ja cadastrada";
        } catch (EmptyTreeException|InvalidNodeException ex) {
            return ex.getMessage();
        }
    }
    
    public String consultarPessoa(int cpf){
        try {
            BinaryNodeSearchTree<Integer,Pessoa> elemento = this.arvore_de_pessoas.find_iterativo(cpf);
            if(elemento == null){
                return "Nao ha pessoa cadastrada com o cpf informado";
            }else{
                return "Foi encontrada uma pessoa com o nome de " + elemento.getValor().getNome();
            }
        } catch (EmptyTreeException ex) {
            return "Nao ha pessoas cadastradas";
        }
    }
    
    public String removerPessoa(int cpf){
        boolean removido = this.arvore_de_pessoas.remove(cpf);
        if(!removido){
            return "Nao existe pessoa com o cpf informado";
        }
        return "Pessoa removida com sucesso";
    }
    
    public String listarPessoas(){
        return this.arvore_de_pessoas.printarArvore();
    }
    
    public String listarPessoasEmOrdem(){
        List<BinaryNodeSearchTree<Integer,Pessoa>> lista_pessoas_ordenada = this.arvore_de_pessoas.em_ordem();
        StringBuilder construtor = new StringBuilder();
        if(lista_pessoas_ordenada.isEmpty()){
            return "Nao ha pessoas cadastradas";
        }else{
            for (int i = 0; i < lista_pessoas_ordenada.size(); i++) {
                construtor.append(lista_pessoas_ordenada.get(i).getValor()).append(", ");
            }
            construtor.append("\n");
            return construtor.toString();
        }
    }
}
