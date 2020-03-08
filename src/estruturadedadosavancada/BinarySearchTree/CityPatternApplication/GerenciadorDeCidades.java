/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.CityPatternApplication;

import estruturadedadosavancada.BinarySearchTree.BinaryNodeSearchTree;
import estruturadedadosavancada.BinarySearchTree.BinarySearchTree;
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
public class GerenciadorDeCidades {

    BinarySearchTree<Integer, Cidade> cidades;

    public GerenciadorDeCidades() {
        this.cidades = new BinarySearchTree<>();
    }

    public String cadastrarCidade(Cidade novaCidade) {
        try {
            this.cidades.insert(new BinaryNodeSearchTree<>(novaCidade.getId(), novaCidade));
            return "Cidade " + novaCidade.getNome() + " cadastrada com sucesso";
        } catch (InvalidNodeException ex) {
            return ex.getMessage();
        }
    }

    public String consultaCidadeEspecifica(Cidade cidade) {
        try {
            StringBuilder construtor = new StringBuilder();
            construtor.append("-----------------------------Abaixo seguem as cidades vizinhas a ").append(cidade.getNome()).
                    append("------------------------------\n");
            List<BinaryNodeSearchTree<Integer, Cidade>> cidadesVizinhas = (List<BinaryNodeSearchTree<Integer, Cidade>>) this.cidades.children(new BinaryNodeSearchTree<>(cidade.getId(), cidade));
            if (cidadesVizinhas.isEmpty()) {
                return "A cidade " + cidade.getNome() + "nao possui cidades vizinhas cadastradas";
            }
            construtor.append(cidade.getNome()).append("\n");
            for (int i = 0; i < cidadesVizinhas.size(); i++) {
                construtor.append("|\n");
                construtor.append("|-").append(cidadesVizinhas.get(i).getValor().getNome()).append("\n");
            }
            return construtor.toString();
        } catch (InvalidNodeException | EmptyTreeException ex) {
            return ex.getMessage();
        }

    }

    public String listarTodasCidades() {
        try {
            int tamanhoDoBuffer = 150;
            StringBuilder construtor = new StringBuilder();
            for (int i = 0; i < tamanhoDoBuffer; i++) {
                construtor.append(" ");
            }

            Iterator<BinaryNodeSearchTree<Integer, Cidade>> iterator = cidades.iterator();
            //Formatando previamente a cidade raiz
            Cidade cidade_nao_formatada = cidades.root().getValor();
            //String nome_formatado = formata_nome(cidade_nao_formatada.getNome());
            //Cidade cidade_formatada = new Cidade(cidade_nao_formatada.getId(), nome_formatado);
            //cidades.root().setValor(cidade_formatada);

            String complete_tree = "";
            Queue<ArrayList<Integer>> filaDePosicoes = new LinkedList<>();
            int quantidadeDeNosNivel = 1;
            
            String nome_formatado_root = formata_nome(cidade_nao_formatada.getNome());
            int meioDaPalavra = ((nome_formatado_root.length()) / 2) - 1;

            int posicaoInicioRaiz = (tamanhoDoBuffer / 2) - ((meioDaPalavra + 1) - 1);
            int posicaoFimRaiz = ((tamanhoDoBuffer / 2) + (nome_formatado_root.length() - (meioDaPalavra + 1)) + 1);
            ArrayList<Integer> posicoes = new ArrayList<>();
            posicoes.add(posicaoInicioRaiz);
            posicoes.add(posicaoFimRaiz);
            filaDePosicoes.add(posicoes);

            while (!filaDePosicoes.isEmpty()) {
                int posicaoDaPalavra = 0;
                //Pegando todos os nos do nivel atual para serem posteriormente inseridos na linha
                ArrayList<BinaryNodeSearchTree<Integer, Cidade>> nos_atuais = new ArrayList<>();
                ArrayList<ArrayList<Integer>> posicoesAtuais = new ArrayList<>();
                for (int i = 0; i < quantidadeDeNosNivel; i++) {
                    BinaryNodeSearchTree<Integer, Cidade> no_atual = iterator.next();

                    nos_atuais.add(no_atual);
                    posicoesAtuais.add(filaDePosicoes.poll());
                }

                for (int i = 0; i < nos_atuais.size(); i++) {
                    if (nos_atuais.get(i).getChave().equals(this.cidades.root().getChave())) {
                        for (int y = posicoesAtuais.get(i).get(0); y < posicoesAtuais.get(i).get(1); y++) {
                            construtor.setCharAt(y, nome_formatado_root.charAt(posicaoDaPalavra++));
                        }
                        posicaoDaPalavra = 0;
                    } else {
                        for (int y = posicoesAtuais.get(i).get(0); y < posicoesAtuais.get(i).get(1); y++) {
                            construtor.setCharAt(y, nos_atuais.get(i).getValor().getNome().charAt(posicaoDaPalavra++));
                        }
                        posicaoDaPalavra = 0;
                    }
                }
                construtor.append("\n");

                quantidadeDeNosNivel = 0;
                for (int i = 0; i < nos_atuais.size(); i++) {
                    List<BinaryNodeSearchTree<Integer, Cidade>> cidadesVizinhas = (List<BinaryNodeSearchTree<Integer, Cidade>>) cidades.children(nos_atuais.get(i));
                    quantidadeDeNosNivel += cidadesVizinhas.size();
                    for (int y = 0; y < cidadesVizinhas.size(); y++) {
                        int tamanhoDaPalavraFilhoAtual = cidadesVizinhas.get(y).getValor().getNome().length();
                        if (nos_atuais.get(i).getEsquerda() != null && nos_atuais.get(i).getEsquerda().equals(cidadesVizinhas.get(y))) {
                            int posicaoFimFilhoEsquerdo = posicoesAtuais.get(i).get(0) - 1;
                            int posicaoInicioFilhoEsquerdo = (posicaoFimFilhoEsquerdo - (tamanhoDaPalavraFilhoAtual));
                            ArrayList<Integer> posicoes_filho = new ArrayList<>();
                            posicoes_filho.add(posicaoInicioFilhoEsquerdo);
                            posicoes_filho.add(posicaoFimFilhoEsquerdo);
                            filaDePosicoes.add(posicoes_filho);
                        }
                        if (nos_atuais.get(i).getDireita() != null && nos_atuais.get(i).getDireita().equals(cidadesVizinhas.get(y))) {
                            int posicaoInicioFilhoDireito = posicoesAtuais.get(i).get(1) + 1;
                            int posicaoFinalFilhoDireito = (posicaoInicioFilhoDireito + tamanhoDaPalavraFilhoAtual);
                            ArrayList<Integer> posicoes_filho = new ArrayList<>();
                            posicoes_filho.add(posicaoInicioFilhoDireito);
                            posicoes_filho.add(posicaoFinalFilhoDireito);
                            filaDePosicoes.add(posicoes_filho);
                        }
                    }
                }

                complete_tree += construtor.toString();
                construtor = new StringBuilder();
                for (int i = 0; i < tamanhoDoBuffer; i++) {
                    construtor.append(" ");
                }
            }
            //cidades.root().setValor(cidade_nao_formatada);

            return complete_tree;
        } catch (EmptyTreeException | InvalidNodeException ex) {
            return ex.getMessage();
        }
    }

    private String formata_nome(String nome) {
        StringBuilder nome_da_cidade_formatado = new StringBuilder();
        //Inserindo espacos antes da palavra
        int quantidade_de_espacos = nome.length();
        for (int i = 0; i < quantidade_de_espacos; i++) {
            nome_da_cidade_formatado.append(" ");
        }
        //Passando palavra para a nova string
        for (int i = 0; i < nome.length(); i++) {
            nome_da_cidade_formatado.append(nome.charAt(i));
        }
        //Inserindo espacos depois
        for (int i = 0; i < quantidade_de_espacos; i++) {
            nome_da_cidade_formatado.append(" ");
        }

        return nome_da_cidade_formatado.toString();
    }

    public int duplica(int a) {
        if (a == 0) {
            return 0;
        } else {
            return duplica(a - 1) + 2;
        }

    }
}
