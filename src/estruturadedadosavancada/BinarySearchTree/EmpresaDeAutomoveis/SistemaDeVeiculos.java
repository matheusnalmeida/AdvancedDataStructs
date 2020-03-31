/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.EmpresaDeAutomoveis;

import estruturadedadosavancada.BinarySearchTree.BinaryNodeSearchTree;
import estruturadedadosavancada.BinarySearchTree.BinarySearchTree;
import estruturadedadosavancada.EmptyTreeException;
import estruturadedadosavancada.InvalidNodeException;
import java.util.List;

/**
 *
 * @author Matheus Nunes
 */
public class SistemaDeVeiculos {

    //Arvores para os automoveis de acordo com suas categorias e indexadas pelo chassi disponiveis para venda
    BinarySearchTree<Integer, Produto> automoveisHatchDisponivel;
    BinarySearchTree<Integer, Produto> automoveisSerdanDisponivel;
    BinarySearchTree<Integer, Produto> automoveisSuvDisponivel;
    //Arvores para os automoveis de acordo com suas categorias e indexadas pelo chassi ja vendidas
    BinarySearchTree<Integer, Produto> automoveisHatchVendido;
    BinarySearchTree<Integer, Produto> automoveisSerdanVendido;
    BinarySearchTree<Integer, Produto> automoveisSuvVendido;
    //Arvores para os motocicletas de acordo com suas categorias e indexadas pelo chassi disponiveis para venda
    BinarySearchTree<Integer, Produto> motocicletaScooterDisponivel;
    BinarySearchTree<Integer, Produto> motocicletaNakedDisponivel;
    BinarySearchTree<Integer, Produto> motocicletaSportDisponivel;
    //Arvores para os motocicletas de acordo com suas categorias e indexadas pelo chassi ja vendidas
    BinarySearchTree<Integer, Produto> motocicletaScooterVendido;
    BinarySearchTree<Integer, Produto> motocicletaNakedVendido;
    BinarySearchTree<Integer, Produto> motocicletaSportVendido;
    //Cadastrando compradores
    BinarySearchTree<String, Comprador> compradores;
    //Arvore com todos os produtos indexada pelo chassi
    BinarySearchTree<Integer, Produto> arovre_de_produtos;

    public SistemaDeVeiculos() {
        //Iniciando automoveis
        this.automoveisHatchDisponivel = new BinarySearchTree<>();
        this.automoveisSerdanDisponivel = new BinarySearchTree<>();
        this.automoveisSuvDisponivel = new BinarySearchTree<>();
        this.automoveisHatchVendido = new BinarySearchTree<>();
        this.automoveisSerdanVendido = new BinarySearchTree<>();
        this.automoveisSuvVendido = new BinarySearchTree<>();
        //Iniciando motocicletas
        this.motocicletaScooterDisponivel = new BinarySearchTree<>();
        this.motocicletaNakedDisponivel = new BinarySearchTree<>();
        this.motocicletaSportDisponivel = new BinarySearchTree<>();
        this.motocicletaScooterVendido = new BinarySearchTree<>();
        this.motocicletaNakedVendido = new BinarySearchTree<>();
        this.motocicletaSportVendido = new BinarySearchTree<>();
        //Iniciando Compradores
        this.compradores = new BinarySearchTree<>();
        //Iniciando arvore de produtos
        this.arovre_de_produtos = new BinarySearchTree<>();
    }

    public String cadastrarMotocicleta(Produto nova_motocicleta) {
        String categoria = nova_motocicleta.getCategoria().getNome();
        try {
            if (this.arovre_de_produtos.isEmpty() || (this.arovre_de_produtos.find_iterativo(nova_motocicleta.getChassi()) == null)) {
                if (categoria.equals("scooter")) {
                    try {
                        //Terao de ser criados dois nos para evitar que as arvores se misturem atrraves das referencias de um no para o outro
                        BinaryNodeSearchTree<Integer, Produto> novo_no = new BinaryNodeSearchTree<>(nova_motocicleta.getChassi(), nova_motocicleta);
                        BinaryNodeSearchTree<Integer, Produto> novo_no_produto = new BinaryNodeSearchTree<>(nova_motocicleta.getChassi(), nova_motocicleta);
                        this.motocicletaScooterDisponivel.insert(novo_no);
                        this.arovre_de_produtos.insert(novo_no_produto);
                        return "Motocicleta cadastrada com sucesso";
                    } catch (InvalidNodeException ex) {
                        return "";
                    }
                } else if (categoria.equals("naked")) {
                    try {
                        //Terao de ser criados dois nos para evitar que as arvores se misturem atrraves das referencias de um no para o outro
                        BinaryNodeSearchTree<Integer, Produto> novo_no = new BinaryNodeSearchTree<>(nova_motocicleta.getChassi(), nova_motocicleta);
                        BinaryNodeSearchTree<Integer, Produto> novo_no_produto = new BinaryNodeSearchTree<>(nova_motocicleta.getChassi(), nova_motocicleta);
                        this.motocicletaNakedDisponivel.insert(novo_no);
                        this.arovre_de_produtos.insert(novo_no_produto);
                        return "Motocicleta cadastrada com sucesso";
                    } catch (InvalidNodeException ex) {
                        return "";
                    }
                } else if (categoria.equals("sport")) {
                    try {
                        //Terao de ser criados dois nos para evitar que as arvores se misturem atrraves das referencias de um no para o outro
                        BinaryNodeSearchTree<Integer, Produto> novo_no = new BinaryNodeSearchTree<>(nova_motocicleta.getChassi(), nova_motocicleta);
                        BinaryNodeSearchTree<Integer, Produto> novo_no_produto = new BinaryNodeSearchTree<>(nova_motocicleta.getChassi(), nova_motocicleta);
                        this.motocicletaSportDisponivel.insert(novo_no);
                        this.arovre_de_produtos.insert(novo_no_produto);
                        return "Motocicleta cadastrada com sucesso";
                    } catch (InvalidNodeException ex) {
                        return "";
                    }
                } else {
                    return "A categoria da motocicleta nao e uma catagoria valida para motocicleta";
                }
            } else {
                return "Ja existe veiculo cadastrado com o chassi informado";
            }
        } catch (EmptyTreeException ex) {
            return "";
        }
    }

    public String cadastrarAutomovel(Produto novo_automovel) {
        String categoria = novo_automovel.getCategoria().getNome();
        try {
            if (this.arovre_de_produtos.isEmpty() || (this.arovre_de_produtos.find_iterativo(novo_automovel.getChassi()) == null)) {
                if (categoria.equals("hatch")) {
                    try {
                        BinaryNodeSearchTree<Integer, Produto> novo_no = new BinaryNodeSearchTree<>(novo_automovel.getChassi(), novo_automovel);
                        BinaryNodeSearchTree<Integer, Produto> novo_no_produto = new BinaryNodeSearchTree<>(novo_automovel.getChassi(), novo_automovel);
                        this.automoveisHatchDisponivel.insert(novo_no);
                        this.arovre_de_produtos.insert(novo_no_produto);
                        return "Automovel cadastrado com sucesso";
                    } catch (InvalidNodeException ex) {
                        return "";
                    }
                } else if (categoria.equals("sedan")) {
                    try {
                        BinaryNodeSearchTree<Integer, Produto> novo_no = new BinaryNodeSearchTree<>(novo_automovel.getChassi(), novo_automovel);
                        BinaryNodeSearchTree<Integer, Produto> novo_no_produto = new BinaryNodeSearchTree<>(novo_automovel.getChassi(), novo_automovel);
                        this.automoveisSerdanDisponivel.insert(novo_no);
                        this.arovre_de_produtos.insert(novo_no_produto);
                        return "Automovel cadastrado com sucesso";
                    } catch (InvalidNodeException ex) {
                        return "";
                    }
                } else if (categoria.equals("suv")) {
                    try {
                        //Verificando se ja existe Automovel cadastrada na arvore de vendas
                        BinaryNodeSearchTree<Integer, Produto> novo_no = new BinaryNodeSearchTree<>(novo_automovel.getChassi(), novo_automovel);
                        BinaryNodeSearchTree<Integer, Produto> novo_no_produto = new BinaryNodeSearchTree<>(novo_automovel.getChassi(), novo_automovel);
                        this.automoveisSuvDisponivel.insert(novo_no);
                        this.arovre_de_produtos.insert(novo_no_produto);
                        return "Automovel cadastrado com sucesso";
                    } catch (InvalidNodeException ex) {
                        return "";
                    }
                } else {
                    return "A categoria do Automovel nao e uma catagoria valida para Automovel";
                }
            } else {
                return "Ja existe veiculo cadastrado com o chassi informado";
            }
        } catch (EmptyTreeException ex) {
            return "";
        }
    }

    public String cadastrarComprador(Comprador novo_comprador) {
        BinaryNodeSearchTree<String, Comprador> novo_no = new BinaryNodeSearchTree<>(novo_comprador.getCpf(), novo_comprador);
        try {
            this.compradores.insert(novo_no);
            return "Comprador cadastrado com sucesso";
        } catch (InvalidNodeException ex) {
            return "Ja existe comprador com o cpf informado informado";
        }
    }

    public String venderMotocicleta(Comprador comprador, Produto motocicleta) {
        String categoria = motocicleta.getCategoria().getNome();
        if (categoria.equals("scooter")) {
            try {
                BinaryNodeSearchTree<String, Comprador> comprador_encontrado = this.compradores.find_iterativo(comprador.getCpf());
                if (comprador_encontrado != null) {
                    try {
                        BinaryNodeSearchTree<Integer, Produto> motocicleta_encontrada = this.motocicletaScooterDisponivel.find_iterativo(motocicleta.getChassi());
                        if (motocicleta_encontrada != null) {
                            Produto novo_motocicleta_vendido = new Produto(motocicleta_encontrada.getValor().getNome(),
                                    motocicleta_encontrada.getValor().getAno(), motocicleta_encontrada.getValor().getChassi(), motocicleta_encontrada.getValor().getCategoria());
                            novo_motocicleta_vendido.setComprador(comprador);
                            motocicleta_encontrada.getValor().setComprador(comprador);
                            BinaryNodeSearchTree<Integer, Produto> novo_node = new BinaryNodeSearchTree<>(novo_motocicleta_vendido.getChassi(), novo_motocicleta_vendido);
                            this.motocicletaScooterDisponivel.remove(motocicleta.getChassi());
                            this.motocicletaScooterVendido.insert(novo_node);
                            return comprador_encontrado.getValor().cadastrarMotocicletaScooter(motocicleta_encontrada.getValor());
                        } else {
                            return "Nao existe motocicleta com o numero de chassi informado cadastrado no sistema";
                        }
                    } catch (EmptyTreeException ex) {
                        return "Nao existe motocicleta com o numero de chassi informado cadastrado no sistema";
                    } catch (InvalidNodeException ex) {
                        return "";
                    }
                } else {
                    return "Nao existe comprador com o cpf informado cadastrado no sistema";
                }
            } catch (EmptyTreeException ex) {
                return "Nao existe comprador com o cpf informado cadastrado no sistema";
            }
        } else if (categoria.equals("naked")) {
            try {
                BinaryNodeSearchTree<String, Comprador> comprador_encontrado = this.compradores.find_iterativo(comprador.getCpf());
                if (comprador_encontrado != null) {
                    try {
                        BinaryNodeSearchTree<Integer, Produto> motocicleta_encontrada = this.motocicletaNakedDisponivel.find_iterativo(motocicleta.getChassi());
                        if (motocicleta_encontrada != null) {
                            Produto novo_motocicleta_vendido = new Produto(motocicleta_encontrada.getValor().getNome(),
                                    motocicleta_encontrada.getValor().getAno(), motocicleta_encontrada.getValor().getChassi(), motocicleta_encontrada.getValor().getCategoria());
                            novo_motocicleta_vendido.setComprador(comprador);
                            motocicleta_encontrada.getValor().setComprador(comprador);
                            BinaryNodeSearchTree<Integer, Produto> novo_node = new BinaryNodeSearchTree<>(novo_motocicleta_vendido.getChassi(), novo_motocicleta_vendido);
                            this.motocicletaNakedDisponivel.remove(motocicleta.getChassi());
                            this.motocicletaNakedVendido.insert(novo_node);
                            return comprador_encontrado.getValor().cadastrarMotocicletaNaked(motocicleta_encontrada.getValor());
                        } else {
                            return "Nao existe motocicleta com o numero de chassi informado cadastrado no sistema";
                        }
                    } catch (EmptyTreeException ex) {
                        return "Nao existe motocicleta com o numero de chassi informado cadastrado no sistema";
                    } catch (InvalidNodeException ex) {
                        return "";
                    }
                } else {
                    return "Nao existe comprador com o cpf informado cadastrado no sistema";
                }
            } catch (EmptyTreeException ex) {
                return "Nao existe comprador com o cpf informado cadastrado no sistema";
            }
        } else if (categoria.equals("sport")) {
            try {
                BinaryNodeSearchTree<String, Comprador> comprador_encontrado = this.compradores.find_iterativo(comprador.getCpf());
                if (comprador_encontrado != null) {
                    try {
                        BinaryNodeSearchTree<Integer, Produto> motocicleta_encontrada = this.motocicletaSportDisponivel.find_iterativo(motocicleta.getChassi());
                        if (motocicleta_encontrada != null) {
                            Produto novo_motocicleta_vendido = new Produto(motocicleta_encontrada.getValor().getNome(),
                                    motocicleta_encontrada.getValor().getAno(), motocicleta_encontrada.getValor().getChassi(), motocicleta_encontrada.getValor().getCategoria());
                            novo_motocicleta_vendido.setComprador(comprador);
                            motocicleta_encontrada.getValor().setComprador(comprador);
                            BinaryNodeSearchTree<Integer, Produto> novo_node = new BinaryNodeSearchTree<>(novo_motocicleta_vendido.getChassi(), novo_motocicleta_vendido);
                            this.motocicletaSportDisponivel.remove(motocicleta.getChassi());
                            this.motocicletaSportVendido.insert(novo_node);
                            return comprador_encontrado.getValor().cadastrarMotocicletaSport(motocicleta_encontrada.getValor());
                        } else {
                            return "Nao existe motocicleta com o numero de chassi informado cadastrado no sistema";
                        }
                    } catch (EmptyTreeException ex) {
                        return "Nao existe motocicleta com o numero de chassi informado cadastrado no sistema";
                    } catch (InvalidNodeException ex) {
                        return "";
                    }
                } else {
                    return "Nao existe comprador com o cpf informado cadastrado no sistema";
                }
            } catch (EmptyTreeException ex) {
                return "Nao existe comprador com o cpf informado cadastrado no sistema";
            }
        } else {
            return "A categoria da motocicleta nao e uma ctagoria valida para motocicleta";
        }
    }

    public String venderAutomovel(Comprador comprador, Produto automovel) {
        String categoria = automovel.getCategoria().getNome();
        if (categoria.equals("hatch")) {
            try {
                BinaryNodeSearchTree<String, Comprador> comprador_encontrado = this.compradores.find_iterativo(comprador.getCpf());
                if (comprador_encontrado != null) {
                    try {
                        BinaryNodeSearchTree<Integer, Produto> automovel_encontrada = this.automoveisHatchDisponivel.find_iterativo(automovel.getChassi());
                        if (automovel_encontrada != null) {
                            Produto novo_automovel_vendido = new Produto(automovel_encontrada.getValor().getNome(),
                                    automovel_encontrada.getValor().getAno(), automovel_encontrada.getValor().getChassi(), automovel_encontrada.getValor().getCategoria());
                            novo_automovel_vendido.setComprador(comprador);
                            automovel_encontrada.getValor().setComprador(comprador);
                            BinaryNodeSearchTree<Integer, Produto> novo_node = new BinaryNodeSearchTree<>(novo_automovel_vendido.getChassi(), novo_automovel_vendido);
                            this.automoveisHatchDisponivel.remove(automovel.getChassi());
                            this.automoveisHatchVendido.insert(novo_node);
                            return comprador_encontrado.getValor().cadastrarAutomoveisHatch(automovel_encontrada.getValor());
                        } else {
                            return "Nao existe Automovel com o numero de chassi informado cadastrado no sistema";
                        }
                    } catch (EmptyTreeException ex) {
                        return "Nao existe motocicleta com o numero de chassi informado cadastrado no sistema";
                    } catch (InvalidNodeException ex) {
                        return "";
                    }
                } else {
                    return "Nao existe comprador com o cpf informado cadastrado no sistema";
                }
            } catch (EmptyTreeException ex) {
                return "Nao existe comprador com o cpf informado cadastrado no sistema";
            }
        } else if (categoria.equals("sedan")) {
            try {
                BinaryNodeSearchTree<String, Comprador> comprador_encontrado = this.compradores.find_iterativo(comprador.getCpf());
                if (comprador_encontrado != null) {
                    try {
                        BinaryNodeSearchTree<Integer, Produto> automovel_encontrada = this.automoveisSerdanDisponivel.find_iterativo(automovel.getChassi());
                        if (automovel_encontrada != null) {
                            Produto novo_automovel_vendido = new Produto(automovel_encontrada.getValor().getNome(),
                                    automovel_encontrada.getValor().getAno(), automovel_encontrada.getValor().getChassi(), automovel_encontrada.getValor().getCategoria());
                            novo_automovel_vendido.setComprador(comprador);
                            automovel_encontrada.getValor().setComprador(comprador);
                            BinaryNodeSearchTree<Integer, Produto> novo_node = new BinaryNodeSearchTree<>(novo_automovel_vendido.getChassi(), novo_automovel_vendido);
                            this.automoveisSerdanDisponivel.remove(automovel.getChassi());
                            this.automoveisSerdanVendido.insert(novo_node);
                            return comprador_encontrado.getValor().cadastrarAutomoveisSerdan(automovel_encontrada.getValor());
                        } else {
                            return "Nao existe Automovel com o numero de chassi informado cadastrado no sistema";
                        }
                    } catch (EmptyTreeException ex) {
                        return "Nao existe motocicleta com o numero de chassi informado cadastrado no sistema";
                    } catch (InvalidNodeException ex) {
                        return "";
                    }
                } else {
                    return "Nao existe comprador com o cpf informado cadastrado no sistema";
                }
            } catch (EmptyTreeException ex) {
                return "Nao existe comprador com o cpf informado cadastrado no sistema";
            }
        } else if (categoria.equals("suv")) {
            try {
                BinaryNodeSearchTree<String, Comprador> comprador_encontrado = this.compradores.find_iterativo(comprador.getCpf());
                if (comprador_encontrado != null) {
                    try {
                        BinaryNodeSearchTree<Integer, Produto> automovel_encontrada = this.automoveisSuvDisponivel.find_iterativo(automovel.getChassi());
                        if (automovel_encontrada != null) {
                            Produto novo_automovel_vendido = new Produto(automovel_encontrada.getValor().getNome(),
                                    automovel_encontrada.getValor().getAno(), automovel_encontrada.getValor().getChassi(), automovel_encontrada.getValor().getCategoria());
                            novo_automovel_vendido.setComprador(comprador);
                            automovel_encontrada.getValor().setComprador(comprador);
                            BinaryNodeSearchTree<Integer, Produto> novo_node = new BinaryNodeSearchTree<>(novo_automovel_vendido.getChassi(), novo_automovel_vendido);
                            this.automoveisSuvDisponivel.remove(automovel.getChassi());
                            this.automoveisSuvVendido.insert(novo_node);
                            return comprador_encontrado.getValor().cadastrarAutomoveisSuv(automovel_encontrada.getValor());
                        } else {
                            return "Nao existe Automovel com o numero de chassi informado cadastrado no sistema";
                        }
                    } catch (EmptyTreeException ex) {
                        return "Nao existe motocicleta com o numero de chassi informado cadastrado no sistema";
                    } catch (InvalidNodeException ex) {
                        return "";
                    }
                } else {
                    return "Nao existe comprador com o cpf informado cadastrado no sistema";
                }
            } catch (EmptyTreeException ex) {
                return "Nao existe comprador com o cpf informado cadastrado no sistema";
            }
        } else {
            return "A categoria da motocicleta nao e uma ctagoria valida para motocicleta";
        }
    }

    public String consultarVeiculoChassi(int chassi) {
        try {
            BinaryNodeSearchTree<Integer, Produto> no_atual = this.arovre_de_produtos.find_iterativo(chassi);
            if (no_atual == null) {
                return "Nao existe veiculo cadastrado com o numero de chassi informado";
            }
            return no_atual.getValor().toString();
        } catch (EmptyTreeException ex) {
            return "Nao ha elementos cadastrados no sistema";
        }
    }

    public String consultarVeiculosCpf(String cpf) {
        try {
            BinaryNodeSearchTree<String, Comprador> no_atual = this.compradores.find_iterativo(cpf);
            if (no_atual == null) {
                return "Nao existe comprador cadastrado com o cpf informado";
            }
            return no_atual.getValor().listarVeiculos();
        } catch (EmptyTreeException ex) {
            return "Nao ha compradores cadastrados no sistema";
        }
    }

    public String listarMotocicletasDisponiveis() {
        StringBuilder construtor = new StringBuilder();
        //Percorrendo motocicletas de cada categoria disponiveis para venda
        construtor.append("=---------------------------------Motocicletas Disponiveis para Venda-------------------------------------------\n");
        List<BinaryNodeSearchTree<Integer, Produto>> produtosScooter = this.motocicletaScooterDisponivel.pre_ordem();
        if (!produtosScooter.isEmpty()) {
            construtor.append("Categoria Scooter\n");
            for (int i = 0; i < produtosScooter.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtosScooter.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }

        List<BinaryNodeSearchTree<Integer, Produto>> produtosNaked = this.motocicletaNakedDisponivel.pre_ordem();
        if (!produtosNaked.isEmpty()) {
            construtor.append("Categoria Naked\n");
            for (int i = 0; i < produtosNaked.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtosNaked.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }

        List<BinaryNodeSearchTree<Integer, Produto>> produtosSport = this.motocicletaSportDisponivel.pre_ordem();
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

    public String listarMotocicletasVendidas() {
        StringBuilder construtor = new StringBuilder();
        //Percorrendo motocicletas de cada categoria disponiveis para venda
        construtor.append("=---------------------------------Motocicletas Ja Vendidas-------------------------------------------\n");
        List<BinaryNodeSearchTree<Integer, Produto>> produtosScooter = this.motocicletaScooterVendido.pre_ordem();
        if (!produtosScooter.isEmpty()) {
            construtor.append("Categoria Scooter\n");
            for (int i = 0; i < produtosScooter.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtosScooter.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }

        List<BinaryNodeSearchTree<Integer, Produto>> produtosNaked = this.motocicletaNakedVendido.pre_ordem();
        if (!produtosNaked.isEmpty()) {
            construtor.append("Categoria Naked\n");
            for (int i = 0; i < produtosNaked.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtosNaked.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }

        List<BinaryNodeSearchTree<Integer, Produto>> produtosSport = this.motocicletaSportVendido.pre_ordem();
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

    public String listarAutomoveisDisponiveis() {
        StringBuilder construtor = new StringBuilder();
        //Percorrendo automoveis de cada categoria
        construtor.append("=---------------------------------Automoveis Disponiveis para Venda-------------------------------------------\n");
        List<BinaryNodeSearchTree<Integer, Produto>> produtoshatch = this.automoveisHatchDisponivel.pre_ordem();
        if (!produtoshatch.isEmpty()) {
            construtor.append("Categoria Hatch\n");
            for (int i = 0; i < produtoshatch.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtoshatch.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }

        List<BinaryNodeSearchTree<Integer, Produto>> produtosSerdan = this.automoveisSerdanDisponivel.pre_ordem();
        if (!produtosSerdan.isEmpty()) {
            construtor.append("Categoria Serdan\n");
            for (int i = 0; i < produtosSerdan.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtosSerdan.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }

        List<BinaryNodeSearchTree<Integer, Produto>> produtosSuv = this.automoveisSuvDisponivel.pre_ordem();
        if (!produtosSuv.isEmpty()) {
            construtor.append("Categoria SUV\n");
            for (int i = 0; i < produtosSuv.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtosSuv.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }

        return construtor.toString();
    }

    public String listarAutomoveisVendidas() {
        StringBuilder construtor = new StringBuilder();
        //Percorrendo automoveis de cada categoria
        construtor.append("=---------------------------------Automoveis Vendidos-------------------------------------------\n");
        List<BinaryNodeSearchTree<Integer, Produto>> produtoshatch = this.automoveisHatchVendido.pre_ordem();
        if (!produtoshatch.isEmpty()) {
            construtor.append("Categoria Hatch\n");
            for (int i = 0; i < produtoshatch.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtoshatch.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }

        List<BinaryNodeSearchTree<Integer, Produto>> produtosSerdan = this.automoveisSerdanVendido.pre_ordem();
        if (!produtosSerdan.isEmpty()) {
            construtor.append("Categoria Serdan\n");
            for (int i = 0; i < produtosSerdan.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtosSerdan.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }

        List<BinaryNodeSearchTree<Integer, Produto>> produtosSuv = this.automoveisSuvVendido.pre_ordem();
        if (!produtosSuv.isEmpty()) {
            construtor.append("Categoria SUV\n");
            for (int i = 0; i < produtosSuv.size(); i++) {
                construtor.append("-----------------------------------------------------------------------------\n");
                construtor.append(produtosSuv.get(i).getValor()).append("\n");
                construtor.append("-----------------------------------------------------------------------------\n");
            }
        }

        return construtor.toString();
    }

}
