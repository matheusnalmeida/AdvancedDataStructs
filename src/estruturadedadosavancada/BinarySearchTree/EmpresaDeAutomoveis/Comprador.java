/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.EmpresaDeAutomoveis;

import estruturadedadosavancada.BinarySearchTree.BinaryNodeSearchTree;
import estruturadedadosavancada.BinarySearchTree.BinarySearchTree;
import estruturadedadosavancada.InvalidNodeException;
import java.util.List;

/**
 *
 * @author Matheus Nunes
 */
public class Comprador {

    private String nome;
    private String cpf;
    //Arvores para os automoveis comprados divididos por categoria e indexados pro chassi
    BinarySearchTree<Integer, Produto> automoveisHatch;
    BinarySearchTree<Integer, Produto> automoveisSerdan;
    BinarySearchTree<Integer, Produto> automoveisSuv;
    //Arvores para os Motocicleta comprados divididos por categoria e indexados pro chassi
    BinarySearchTree<Integer, Produto> motocicletaScooter;
    BinarySearchTree<Integer, Produto> motocicletaNaked;
    BinarySearchTree<Integer, Produto> motocicletaSport;

    public Comprador(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        //Criando estruturas para automoveis
        this.automoveisHatch = new BinarySearchTree<Integer, Produto>();
        this.automoveisSerdan = new BinarySearchTree<Integer, Produto>();
        this.automoveisSuv = new BinarySearchTree<Integer, Produto>();
        //Criando estruturas para motocicletas
        this.motocicletaScooter = new BinarySearchTree<Integer, Produto>();
        this.motocicletaNaked = new BinarySearchTree<Integer, Produto>();
        this.motocicletaSport = new BinarySearchTree<Integer, Produto>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    //Metodos de cadastro de automoveis
    public String cadastrarAutomoveisHatch(Produto automovel) {
        BinaryNodeSearchTree<Integer, Produto> novo_no = new BinaryNodeSearchTree<>(automovel.getChassi(), automovel);
        try {
            this.automoveisHatch.insert(novo_no);
            return "Automovel vendido com sucesso";
        } catch (InvalidNodeException ex) {
            return "Ja existe o veiculo informado na arvore de automoveis comprados";
        }
    }

    public String cadastrarAutomoveisSerdan(Produto automovel) {
        BinaryNodeSearchTree<Integer, Produto> novo_no = new BinaryNodeSearchTree<>(automovel.getChassi(), automovel);
        try {
            this.automoveisSerdan.insert(novo_no);
            return "Automovel vendido com sucesso";
        } catch (InvalidNodeException ex) {
            return "Ja existe o veiculo informado na arvore de automoveis comprados";
        }
    }

    public String cadastrarAutomoveisSuv(Produto automovel) {
        BinaryNodeSearchTree<Integer, Produto> novo_no = new BinaryNodeSearchTree<>(automovel.getChassi(), automovel);
        try {
            this.automoveisSuv.insert(novo_no);
            return "Automovel vendido com sucesso";
        } catch (InvalidNodeException ex) {
            return "Ja existe o veiculo informado na arvore de automoveis comprados";
        }
    }

    //Metodos de cadastro de Motocicletas
    public String cadastrarMotocicletaScooter(Produto motocicleta) {
        BinaryNodeSearchTree<Integer, Produto> novo_no = new BinaryNodeSearchTree<>(motocicleta.getChassi(), motocicleta);
        try {
            this.motocicletaScooter.insert(novo_no);
            return "Motocicleta vendida com sucesso";
        } catch (InvalidNodeException ex) {
            return "Ja existe o veiculo informado na arvore de motocicletas compradas";
        }
    }

    public String cadastrarMotocicletaNaked(Produto motocicleta) {
        BinaryNodeSearchTree<Integer, Produto> novo_no = new BinaryNodeSearchTree<>(motocicleta.getChassi(), motocicleta);
        try {
            this.motocicletaNaked.insert(novo_no);
            return "Motocicleta vendida com sucesso";
        } catch (InvalidNodeException ex) {
            return "Ja existe o veiculo informado na arvore de motocicletas compradas";
        }
    }

    public String cadastrarMotocicletaSport(Produto motocicleta) {
        BinaryNodeSearchTree<Integer, Produto> novo_no = new BinaryNodeSearchTree<>(motocicleta.getChassi(), motocicleta);
        try {
            this.motocicletaSport.insert(novo_no);
            return "Motocicleta vendida com sucesso";
        } catch (InvalidNodeException ex) {
            return "Ja existe o veiculo informado na arvore de motocicletas compradas";
        }
    }

    public String listarVeiculos() {
        StringBuilder construtor = new StringBuilder();
        //Percorrendo automoveis de cada categoria
        construtor.append("=---------------------------------Automoveis Cadastrados-------------------------------------------\n");
        List<BinaryNodeSearchTree<Integer, Produto>> produtoshatch = this.automoveisHatch.pre_ordem();
        if (!produtoshatch.isEmpty()) {
            construtor.append("Categoria Hatch\n");
            for (int i = 0; i < produtoshatch.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtoshatch.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }
        
        List<BinaryNodeSearchTree<Integer, Produto>> produtosSerdan = this.automoveisSerdan.pre_ordem();
        if (!produtosSerdan.isEmpty()) {
            construtor.append("Categoria Serdan\n");
            for (int i = 0; i < produtosSerdan.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtosSerdan.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }

        List<BinaryNodeSearchTree<Integer, Produto>> produtosSuv = this.automoveisSuv.pre_ordem();
        if (!produtosSuv.isEmpty()) {
            construtor.append("Categoria SUV\n");
            for (int i = 0; i < produtosSuv.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtosSuv.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }
        
        //Percorrendo motocicletas de cada categoria
        construtor.append("=---------------------------------Motocicletas Cadastrados-------------------------------------------\n");
        List<BinaryNodeSearchTree<Integer, Produto>> produtosScooter = this.motocicletaScooter.pre_ordem();
        if (!produtosScooter.isEmpty()) {
            construtor.append("Categoria Scooter\n");
            for (int i = 0; i < produtosScooter.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtosScooter.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }
        
        List<BinaryNodeSearchTree<Integer, Produto>> produtosNaked = this.motocicletaNaked.pre_ordem();
        if (!produtosNaked.isEmpty()) {
            construtor.append("Categoria Naked\n");
            for (int i = 0; i < produtosNaked.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtosNaked.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }

        List<BinaryNodeSearchTree<Integer, Produto>> produtosSport = this.motocicletaSport.pre_ordem();
        if (!produtosSport.isEmpty()) {
            construtor.append("Categoria Sport\n");
            for (int i = 0; i < produtosSport.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtosSport.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }
        
        return construtor.toString();
    }

}
