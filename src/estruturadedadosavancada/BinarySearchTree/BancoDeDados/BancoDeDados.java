/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.BancoDeDados;

import estruturadedadosavancada.BinarySearchTree.BinaryNodeSearchTree;
import estruturadedadosavancada.EmptyTreeException;
import estruturadedadosavancada.InvalidNodeException;
import java.util.ArrayList;

/**
 *
 * @author Matheus Nunes
 */
public class BancoDeDados {
    
    private ArrayList<Tabela> bancoDeTabelas;

    public BancoDeDados() {
        this.bancoDeTabelas = new ArrayList<>();
    }

    public String criar_tabela(Tabela tabela) {
        if (!this.bancoDeTabelas.contains(tabela)) {
            this.bancoDeTabelas.add(tabela);
            return "Tabela cadastrada com sucesso";
        } else {
            return "Ja existe uma tabela com o nome informado";
        }
    }

    public String inserir_elemento(String nome_tabela,String chave_primaria, Object dado) {
        if (this.bancoDeTabelas.contains(new Tabela<>(nome_tabela))) {
            Tabela tabelaAtual = this.bancoDeTabelas.get(this.bancoDeTabelas.indexOf(new Tabela<>(nome_tabela)));
            try {
                BinaryNodeSearchTree elemento = new BinaryNodeSearchTree(new Chave(chave_primaria,dado), dado);
                return tabelaAtual.inserirElemento(elemento);
            } catch (InvalidNodeException ex) {
                return "Ja existe elemento com a chave informada na tabela";
            } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ex) {
                return "O elemento a ser inserido nao possui uma coluna com tipo valido";
            }
        }
        return "Nao existe tabela com o nome informado";
    }

    public String atualizar_elemento(String nome_tabela, Object antigo_valor, Object novo_valor) {
        if (this.bancoDeTabelas.contains(new Tabela<>(nome_tabela))) {
            Tabela tabelaAtual = this.bancoDeTabelas.get(this.bancoDeTabelas.indexOf(new Tabela<>(nome_tabela)));
            try {
                tabelaAtual.atualizarElemento(antigo_valor, novo_valor);
                return "Elemento atualizado com sucesso";
            } catch (InvalidNodeException ex) {
                return ex.getMessage();
            }
        } else {
            return "O banco nao´possui tabela como nome informado";
        }
    }

    public String buscar_elemento(String nome_tabela, String chave_busca,String valor) {
        if (this.bancoDeTabelas.contains(new Tabela<>(nome_tabela))) {
            Tabela tabelaAtual = this.bancoDeTabelas.get(this.bancoDeTabelas.indexOf(new Tabela<>(nome_tabela)));
            try {
                Chave chave = new Chave(chave_busca,valor);
                BinaryNodeSearchTree no_encontrado = tabelaAtual.buscarElemento(chave);
                if(no_encontrado == null){
                    return "Nao existe elemento com o indice informado";
                }else{
                    return "Foi encontrado um elemento com identificador " + no_encontrado.getValor().toString();
                }
            } catch (EmptyTreeException| InvalidNodeException ex) {
                return ex.getMessage();
            } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ex) {
                return "O elemento a ser encontrado nao possui uma coluna com tipo valido";
            }
        }
        
        return "Nao existe tabela com o nome de tabela informado";
    }

    public String listarMetadados(){
        StringBuilder construtor = new StringBuilder();
        for(int i = 0;i < this.bancoDeTabelas.size();i++){
            construtor.append("---------------------Tabela de ").append(this.bancoDeTabelas.get(i).toString()).append("------------------------------\n");
            construtor.append(this.bancoDeTabelas.get(i).mostrarColunasChaves());
        }
        
        return construtor.toString();
    }

}
