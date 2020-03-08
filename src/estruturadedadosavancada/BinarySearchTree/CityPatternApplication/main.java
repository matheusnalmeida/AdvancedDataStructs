/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.CityPatternApplication;

/**
 *
 * @author Matheus Nunes
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GerenciadorDeCidades gerenciador = new GerenciadorDeCidades();
        Cidade cidade1 = new Cidade(4,"Singapura");
        Cidade cidade2 = new Cidade(3,"Londres");
        Cidade cidade3 = new Cidade(6,"Bangkok");
        Cidade cidade4 = new Cidade(5, "Macau");
        Cidade cidade5 = new Cidade(7, "Paris");
        Cidade cidade6 = new Cidade(1, "Dubai");
        Cidade cidade7 = new Cidade(8, "Phuket");

        //Cadastrando cidade raiz
        System.out.println(gerenciador.cadastrarCidade(cidade1));
        System.out.println(gerenciador.cadastrarCidade(cidade2));
        System.out.println(gerenciador.cadastrarCidade(cidade3));
        System.out.println(gerenciador.cadastrarCidade(cidade4));
        System.out.println(gerenciador.cadastrarCidade(cidade5));
        System.out.println(gerenciador.cadastrarCidade(cidade6));
        System.out.println(gerenciador.cadastrarCidade(cidade7));

        //Consultando cidade especifica
        System.out.println(gerenciador.consultaCidadeEspecifica(cidade1));
        //Consultando todas as cidades
        System.out.println("---------------------------------------Arvore de cidades----------------------------------------------");
        System.out.println(gerenciador.listarTodasCidades());    
    }
        
}

