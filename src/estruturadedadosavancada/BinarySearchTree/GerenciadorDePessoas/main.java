/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.GerenciadorDePessoas;

/**
 *
 * @author Matheus Nunes
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GerenciadorDePessoas gerenciador = new GerenciadorDePessoas();
        Pessoa matheus = new Pessoa(1,"Matheus");
        Pessoa joao = new Pessoa(2,"Joao");
        Pessoa gabriel = new Pessoa(3,"Gabriel");
        Pessoa lucas = new Pessoa(4,"Lucas");
        Pessoa tiago = new Pessoa(5,"Tiago");

        System.out.println("--------------------------------Cadastrando pessoas----------------------------------------");
        System.out.println(gerenciador.inserirPessoa(gabriel));
        System.out.println(gerenciador.inserirPessoa(joao));
        System.out.println(gerenciador.inserirPessoa(lucas));
        System.out.println(gerenciador.inserirPessoa(matheus));
        System.out.println(gerenciador.inserirPessoa(tiago));
        System.out.println("--------------------------------Procurando pessoas----------------------------------------");
        System.out.println(gerenciador.consultarPessoa(3));
        System.out.println(gerenciador.consultarPessoa(6));
        System.out.println("--------------------------------Removendo Pessoas----------------------------------------");
        System.out.println(gerenciador.removerPessoa(3));
        System.out.println("--------------------------------Listando Pessoas----------------------------------------");
        System.out.println(gerenciador.listarPessoas());
        System.out.println("--------------------------------Listando Pessoas Ordendadas Pelo CPF----------------------------------------");
        System.out.println(gerenciador.listarPessoasEmOrdem());
    }
    
}
