/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.GenericTree.GenericTreePatternsApplication.DirectoryPattern;

import estruturadedadosavancada.GenericTree.GenericNode;
import estruturadedadosavancada.GenericTree.GenericTree;
import estruturadedadosavancada.GenericTree.GenericTreePatternsApplication.MyPatternsGeneric;
import estruturadedadosavancada.InvalidNodeException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Matheus Nunes
 */
public class GerenciadorDeArquivos {

    private GenericTree<String, List<Arquivo>> arvore_de_arquivos;

    public GerenciadorDeArquivos(GenericNode<String, List<Arquivo>> diretorio_root) throws InvalidNodeException {
        MyPatternsGeneric<String, List<Arquivo>> meu_modelo = new DirectoryPattern<>();
        this.arvore_de_arquivos = new GenericTree<>(meu_modelo);
        this.arvore_de_arquivos.insert(null, diretorio_root);
    }

    public String cadastrarPasta(GenericNode<String, List<Arquivo>> no_pai, String nome_da_pasta) {
        GenericNode<String, List<Arquivo>> diretorio = new GenericNode<>(nome_da_pasta);
        try {
            this.arvore_de_arquivos.insert(no_pai, diretorio);
            return "Diretorio " + nome_da_pasta + " cadastrado com sucesso";
        } catch (InvalidNodeException ex) {
            return "Nao existe no pai com o nome informado";
        }
    }

    public String cadastrarArquivo(Arquivo arquivo, GenericNode<String, List<Arquivo>> directory) {
        try {
            List<GenericNode<String, List<Arquivo>>> listaDeDiretorios = this.arvore_de_arquivos.find(directory.index);
            GenericNode<String, List<Arquivo>> diretorio_pai = listaDeDiretorios.get(0);
            if (diretorio_pai.getData() == null) {
                diretorio_pai.setData(new ArrayList<>());
                diretorio_pai.getData().add(arquivo);
            } else {
                diretorio_pai.getData().add(arquivo);
            }
            return "Arquivo " + arquivo + " criado com sucesso no diretorio " + directory.index;
        } catch (InvalidNodeException ex) {
            return "Nao existe diretorio com o nome informado";
        }
    }

    public String calculaEspacoTotal(GenericNode<String, List<Arquivo>> diretorio) {
        try {
            List<GenericNode<String, List<Arquivo>>> nos = this.arvore_de_arquivos.find(diretorio.index);
            float espacoTotalOcupado = this.calculaEspacoTotal(nos.get(0), nos.get(0));
            return "O diretorio " + diretorio.index + " possui um total de espaco utilizado de " + espacoTotalOcupado + "K";
        } catch (InvalidNodeException ex) {
            return "Nao existe diretorio com o nome informado";
        }
    }

    private float calculaEspacoTotal(GenericNode<String, List<Arquivo>> diretorioAtual, GenericNode<String, List<Arquivo>> diretorioInicial) {
        float espacoTotalOcupado = 0;
        //Verificando se o diretorio atual possui algum arquivo
        if (diretorioAtual.getData() != null) {
            for (int i = 0; i < diretorioAtual.getData().size(); i++) {
                espacoTotalOcupado += diretorioAtual.getData().get(i).getTamanho();
            }
        }
        //Verificando se o no atual possui algum filho
        if (!diretorioAtual.children.isEmpty()) {
            for (int i = 0; i < diretorioAtual.children.size(); i++) {
                espacoTotalOcupado += calculaEspacoTotal(diretorioAtual.children.get(i), diretorioInicial);
            }
        }
        //Verificando se a busca foi finalizada ou se o no atual e uma folha
        if (diretorioAtual.index.equals(diretorioInicial.index)) {
            return espacoTotalOcupado;
        } else {
            return espacoTotalOcupado;
        }
    }

    public String listarTodosDiretorios() {
        StringBuilder construtor = new StringBuilder();
        Iterator<GenericNode<String, List<Arquivo>>> tree_iterator = this.arvore_de_arquivos.iterator();

        while (tree_iterator.hasNext()) {
            GenericNode<String, List<Arquivo>> no_atual = tree_iterator.next();
            construtor.append("----------------------------").append(no_atual.index).append("----------------------------\n");
            construtor.append("Diretorios: ");
            for (int i = 0; i < no_atual.children.size(); i++) {
                construtor.append(no_atual.children.get(i).index).append(", ");
            }

            construtor.append("\n").append("Arquivos: ");
            if (no_atual.data != null) {
                for (int i = 0; i < no_atual.data.size(); i++) {
                    construtor.append(no_atual.data.get(i).getNome()).append("(").append(no_atual.data.get(i).getTamanho()).
                            append(")").append(", ");
                }
            }
            construtor.append("\n");
        }

        return construtor.toString();
    }

}
